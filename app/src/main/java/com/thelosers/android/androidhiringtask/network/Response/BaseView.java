package com.thelosers.android.androidhiringtask.network.Response;

public interface BaseView {
  void showLoading(String message);

  void showLoading();

  void hideLoading();

  void onUnknownError(String error);

  void onTimeout();



  void onGetCourseData(Object t);
  void onNetworkError();

  boolean isNetworkConnected();

  void onConnectionError();
}
