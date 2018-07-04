package com.thelosers.android.androidhiringtask.network;


import com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse.CourseResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NetworkInterface {



  @GET("?query={courses{name, image, fee, description, package}}")
  Observable<CourseResponse> getSourceResponse();

}
