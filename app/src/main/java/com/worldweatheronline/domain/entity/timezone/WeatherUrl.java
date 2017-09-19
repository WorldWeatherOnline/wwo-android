
package com.worldweatheronline.domain.entity.timezone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherUrl {

  @SerializedName("value")
  @Expose
  public String value;

  @Override public String toString() {
    return "\n\tWeatherUrl{" +
        "\n\t\tvalue='" + value + '\'' +
        "\n\t}";
  }
}
