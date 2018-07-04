package com.thelosers.android.androidhiringtask.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.thelosers.android.androidhiringtask.R;
import com.thelosers.android.androidhiringtask.Utils.MiscUtils;
import com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse.Courses;

import java.util.List;

public class CoursesRecyclerAdapter extends
    RecyclerView.Adapter<CoursesRecyclerAdapter.MyViewHolder> {

  private String mImageUrl = "https://neetprep.com";
  private List<Courses> horizontalList;
  private Context context;

  public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView mCourseImageview;
    TextView mCourseName, mCoursePrice, mCourseDescription, mCoursePackage;

    public MyViewHolder(View view) {
      super(view);
      mCourseImageview = view.findViewById(R.id.course_picture);
      mCourseDescription = view.findViewById(R.id.course_desciption);
      mCourseName = view.findViewById(R.id.course_name);
      mCoursePrice = view.findViewById(R.id.course_price);
      mCoursePackage = view.findViewById(R.id.course_package);

    }
  }

  public CoursesRecyclerAdapter(Context context,
      List<Courses> horizontalList) {
    this.context = context;
    this.horizontalList = horizontalList;
  }

  @Override
  public CoursesRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    View itemView = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.course_recycler_cardview, parent, false);
    return new CoursesRecyclerAdapter.MyViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(final CoursesRecyclerAdapter.MyViewHolder holder,
      final int position) {
    final Courses mItem = horizontalList
        .get(position);

    holder.mCourseName.setAllCaps(true);
    holder.mCourseName.setText(mItem.getName() + "");

    holder.mCoursePrice.setText("₹ " + mItem.getFee() + "");
    if(mItem.getDescription()==null){
      holder.mCourseDescription.setText("");
    }else {
      holder.mCourseDescription.setText(mItem.getDescription() + "");

    }

    holder.mCoursePackage.setAllCaps(true);
    holder.mCoursePackage.setText(mItem.getPackage() + "");

    Log.d("TAG",mImageUrl + mItem.getImage());
//    MiscUtils.setImageToPicasso(holder.mCourseImageview, mImageUrl + mItem.getImage());

    Glide.with(context)
        .load( mImageUrl + mItem.getImage())
        .into(holder.mCourseImageview);

  }

  @Override
  public int getItemCount() {
    return horizontalList.size();
  }
}



