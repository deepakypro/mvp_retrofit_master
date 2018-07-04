package com.thelosers.android.androidhiringtask.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkClient {

  public static final String BASE_URL="https://neetprep.com/graphql/";
  public static Retrofit retrofit;

  public void NetworkClient() {

  }

  public static Retrofit getRetrofit() {

    if (retrofit == null) {



      OkHttpClient.Builder client = new OkHttpClient.Builder();
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      client.addInterceptor(loggingInterceptor);
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      OkHttpClient okHttpClient = builder.build();

      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(okHttpClient)
          .build();

    }

    return retrofit;
  }
}
