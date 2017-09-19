package com.worldweatheronline.domain.rest;


import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

  private ApiService mApiService;

  public RestClient() {
  }

  public ApiService apiService() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder httpClient =
        new OkHttpClient.Builder();
    httpClient.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
            .addQueryParameter("key", "5e29c2f7d3f843ca8e052610171709")
            .addQueryParameter("format", "json")
            .addQueryParameter("includelocation", "yes")
            .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
            .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
      }
    });
// add your other interceptors …

// add logging as last interceptor
    httpClient.addInterceptor(logging);  // <-- this is the important line!
    Retrofit restAdapter = new Retrofit.Builder()
        .baseUrl(
            "http://api.worldweatheronline.com/premium/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();
    mApiService = restAdapter.create(ApiService.class);
    return mApiService;
  }

}