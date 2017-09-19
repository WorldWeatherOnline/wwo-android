package com.worldweatheronline;

import android.app.Application;
import com.worldweatheronline.domain.rest.ApiService;
import com.worldweatheronline.domain.rest.RestClient;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep,2017 18:03
 */

public final class App extends Application {

  private static App instance;
  private final ApiService apiService = new RestClient().apiService();


  @Override public void onCreate() {
    super.onCreate();
    instance = this;

  }

  public static App instance() {
    return instance;
  }

  public ApiService apiService() {
    return apiService;
  }
}
