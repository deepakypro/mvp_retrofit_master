package com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {

  @SerializedName("courses")
  @Expose
  private List<Courses> courses;

  public void setCourses(List<Courses> courses){
    this.courses = courses;
  }
  public List<Courses> getCourses(){
    return this.courses;
  }
}
