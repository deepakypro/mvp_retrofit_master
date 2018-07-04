package com.thelosers.android.androidhiringtask.network;


import android.util.Log;

import com.thelosers.android.androidhiringtask.network.Response.BaseView;
import io.reactivex.observers.DisposableObserver;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.HttpException;


public abstract class CallbackWrapper<T> extends DisposableObserver<T> {

  private BaseView view;

  public CallbackWrapper(BaseView view) {
    this.view = view;
  }

  @Override
  public void onNext(T t) {
    onSuccess(t);
  }

  @Override
  public void onError(Throwable t) {
    if (t instanceof HttpException) {
      ResponseBody responseBody = ((HttpException) t).response().errorBody();
      view.onUnknownError(getErrorMessage(responseBody));
      Log.d("OncPmplete","OnComplete"+getErrorMessage(responseBody));
    } else if (t instanceof SocketTimeoutException) {
      view.onTimeout();
    } else if (t instanceof IOException) {
      view.onNetworkError();
    } else {
      view.onUnknownError(t.getMessage());
    }
  }

  @Override
  public void onComplete() {

    Log.d("OncPmplete","OnComplete");
  }

  protected abstract void onSuccess(T t);

  private String getErrorMessage(ResponseBody responseBody) {
    try {
      JSONObject jsonObject = new JSONObject(responseBody.string());
      return jsonObject.getString("message");
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}