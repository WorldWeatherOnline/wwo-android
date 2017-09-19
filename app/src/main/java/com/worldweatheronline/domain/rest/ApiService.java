package com.worldweatheronline.domain.rest;

import com.worldweatheronline.domain.entity.weather.past.Api;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

  //    http://api.worldweatheronline.com/premium/v1/weather.ashx?key=API_KEY&q=London&format=json&includelocation=yes
  @FormUrlEncoded
  @POST("weather.ashx")
  Call<com.worldweatheronline.domain.entity.weather.Api> weather(@Field("q") String location);

  //  http://api.worldweatheronline.com/premium/v1/marine.ashx?key=API_KEY&q=31.50,-12.50&format=json&includelocation=yes
  @FormUrlEncoded
  @POST("marine.ashx")
  Call<com.worldweatheronline.domain.entity.marine.Api> marine(@Field("q") String latLon);

  //  http://api.worldweatheronline.com/premium/v1/tz.ashx?key=API_KEY&q=Paris&format=json&includelocation=yes
  @FormUrlEncoded
  @POST("tz.ashx")
  Call<com.worldweatheronline.domain.entity.timezone.Api> timezone(@Field("q") String location);

  //  http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=API_KEY&q=Paris&format=json&includelocation=yes&date=2017-08-15&enddate=2017-09-10
  @FormUrlEncoded
  @POST("past-weather.ashx")
  Call<Api> pastWeather(
      @Field("q") String location,
      @Field("date") String startDate,
      @Field("enddate") String endDate
  );

  //  http://api.worldweatheronline.com/premium/v1/past-marine.ashx?key=API_KEY&q=31.50,-12.50&format=json&includelocation=yes&date=2017-08-15&enddate=2017-09-10
  @FormUrlEncoded
  @POST("send_request_to_driver.php")
  Call<com.worldweatheronline.domain.entity.marine.past.Api> pastMarineWeather(
      @Field("q") String latLon,
      @Field("date") String startDate,
      @Field("enddate") String endDate
  );

  //  http://api.worldweatheronline.com/premium/v1/ski.ashx?key=API_KEY&q=52.233,-90.75&format=json&includelocation=yes
  @FormUrlEncoded
  @POST("ski.ashx")
  Call<com.worldweatheronline.domain.entity.ski.Api> skiWeather(@Field("q") String latLon);
}
