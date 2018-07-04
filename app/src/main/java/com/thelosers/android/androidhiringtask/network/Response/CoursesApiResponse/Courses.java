package com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Courses {

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("image")
  @Expose
  private String image;

  @SerializedName("fee")
  @Expose
  private String fee;

  @SerializedName("description")
  @Expose
  private String description;

  @SerializedName("package")
  @Expose
  private String package1;

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
  public void setImage(String image){
    this.image = image;
  }
  public String getImage(){
    return this.image;
  }
  public void setFee(String fee){
    this.fee = fee;
  }
  public String getFee(){
    return this.fee;
  }
  public void setDescription(String description){
    this.description = description;
  }
  public String getDescription(){
    return this.description;
  }
  public void setPackage(String package1){
    this.package1 = package1;
  }
  public String getPackage(){
    return this.package1;
  }
}
