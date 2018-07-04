package com.thelosers.android.androidhiringtask.Utils;

import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MiscUtils {

  public static void setImageToPicasso(ImageView imageToPicasso,  String id) {
    Picasso.get()
        .load(id)
        .fit()

        .networkPolicy(NetworkPolicy.OFFLINE)
        .into(imageToPicasso, new Callback() {
          @Override
          public void onSuccess() {

          }

          @Override
          public void onError(Exception e) {

            e.printStackTrace();
//            Picasso.get(context)
//                .load(id)
//                .fit()
//
//                .into(imageToPicasso, new Callback() {
//                  @Override
//                  public void onSuccess() {
//
//                  }
//
//                  @Override
//                  public void onError() {
//                    Log.v("Picasso", "Could not fetch image");
//                  }
//                });
          }


        });

  }
}
