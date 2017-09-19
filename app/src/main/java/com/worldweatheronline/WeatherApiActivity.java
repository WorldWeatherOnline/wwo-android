package com.worldweatheronline;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.worldweatheronline.domain.rest.RestClient;
import com.worldweatheronline.domain.timezone.Api;
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

    RestClient restClient = new RestClient();
    restClient.getApiService().timezone("Paris").enqueue(new Callback<Api>() {
      @Override public void onResponse(Call<Api> call, Response<Api> response) {
        Log.e("response",response.body().toString());
      }

      @Override public void onFailure(Call<Api> call, Throwable t) {

      }
    });
  }
}
