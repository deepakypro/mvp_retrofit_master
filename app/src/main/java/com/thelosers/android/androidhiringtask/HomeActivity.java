package com.thelosers.android.androidhiringtask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.thelosers.android.androidhiringtask.Adapter.CoursesRecyclerAdapter;
import com.thelosers.android.androidhiringtask.Interfaces.Presenters.CoursePresenter;
import com.thelosers.android.androidhiringtask.network.Response.BaseView;
import com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse.CourseResponse;
import com.thelosers.android.androidhiringtask.network.Response.CoursesApiResponse.Courses;
import java.util.ArrayList;
import java.util.List;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class HomeActivity extends AppCompatActivity implements BaseView {

  @BindView(R.id.course_recycler_view)
  RecyclerView mCourseRecyclerView;

  Unbinder mUnbinder;

  List<Courses> mCourseResponses = new ArrayList<>();
  @BindView(R.id.progress_bar)
  ProgressBar mProgressBar;
  private CoursePresenter mCoursePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    mUnbinder = ButterKnife.bind(this);
    setupRecyclerView();
    setupMVP();
  }

  private void setupMVP() {
    mCoursePresenter = new CoursePresenter(this);
    mCoursePresenter.getCourseDetails();
  }

  private void setupRecyclerView() {
    LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(getApplicationContext(),
        LinearLayoutManager.VERTICAL, false);

    //mEditorChoiceTrending.setLayoutManager(horizontalLayoutManagaer);
    mCourseRecyclerView.setLayoutManager(horizontalLayoutManagaer);
    //mEditorChoiceTrending.setHasFixedSize(true);
    mCourseRecyclerView.setHasFixedSize(true);

  }


  @Override
  protected void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }

  @Override
  public void showLoading(String message) {

  }

  @Override
  public void showLoading() {
    mProgressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    mProgressBar.setVisibility(View.INVISIBLE);

  }

  @Override
  public void onUnknownError(String error) {
    mProgressBar.setVisibility(View.INVISIBLE);
    Toast.makeText(getApplicationContext(),"Error !!",Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onTimeout() {
    mProgressBar.setVisibility(View.INVISIBLE);
  }

  @Override
  public void onGetCourseData(Object t) {

    CourseResponse mCourseResponse = (CourseResponse) t;
    mCourseResponses = mCourseResponse.getData().getCourses();
    CoursesRecyclerAdapter mCoursesRecyclerAdapter = new CoursesRecyclerAdapter(
        getApplicationContext(), mCourseResponses);

    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mCoursesRecyclerAdapter);
    ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);

    mCourseRecyclerView.setAdapter(scaleAdapter);
  }

  @Override
  public void onNetworkError() {

  }

  @Override
  public boolean isNetworkConnected() {
    return false;
  }

  @Override
  public void onConnectionError() {

  }
}
