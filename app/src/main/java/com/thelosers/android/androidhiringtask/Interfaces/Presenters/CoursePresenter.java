package com.thelosers.android.androidhiringtask.Interfaces.Presenters;

import com.thelosers.android.androidhiringtask.Interfaces.CoursePresenterInterface;

import com.thelosers.android.androidhiringtask.network.CallbackWrapper;
import com.thelosers.android.androidhiringtask.network.NetworkClient;
import com.thelosers.android.androidhiringtask.network.NetworkInterface;
import com.thelosers.android.androidhiringtask.network.Response.BaseView;
import com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse.CourseResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CoursePresenter implements CoursePresenterInterface {

  BaseView mvi;
  private String TAG = CoursePresenter.class.getSimpleName();

  public CoursePresenter(BaseView mvi) {
    this.mvi = mvi;
    this.mvi.showLoading();
  }

  private Observable<CourseResponse> getCoursesObservable() {
    return NetworkClient.getRetrofit().create(NetworkInterface.class)
        .getSourceResponse()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override
  public void getCourseDetails() {
    getCoursesObservable().subscribeWith(new CallbackWrapper<CourseResponse>(mvi) {
      @Override
      protected void onSuccess(CourseResponse courseResponse) {
        //Handle your logic here
        mvi.hideLoading();
        mvi.onGetCourseData(courseResponse);
      }
    });
  }


}

