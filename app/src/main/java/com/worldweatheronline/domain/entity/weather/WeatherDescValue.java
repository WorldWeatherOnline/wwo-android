
package com.worldweatheronline.domain.entity.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDescValue {

  @SerializedName("value")
  @Expose
  public String value;
}
