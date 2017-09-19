package com.worldweatheronline;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class WeatherApiActivity extends Activity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    App.instance().apiService().weather("Paris").enqueue(
        new Callback<com.worldweatheronline.domain.weather.Api>() {
          @Override public void onResponse(Call<com.worldweatheronline.domain.weather.Api> call,
              Response<com.worldweatheronline.domain.weather.Api> response) {
            Log.e("response", response.body().toString());
          }

          @Override
          public void onFailure(Call<com.worldweatheronline.domain.weather.Api> call, Throwable t) {

          }
        });
  }
}
