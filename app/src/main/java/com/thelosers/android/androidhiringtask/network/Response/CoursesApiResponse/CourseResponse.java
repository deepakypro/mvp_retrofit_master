package com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseResponse {
  @SerializedName("data")
  @Expose
  private Data data;

  public void setData(Data data){
    this.data = data;
  }
  public Data getData(){
    return this.data;
  }
}


