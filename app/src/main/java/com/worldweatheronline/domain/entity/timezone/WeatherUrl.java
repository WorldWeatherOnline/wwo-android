
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherUrl {

  @SerializedName("value")
  @Expose
  public String value;
  private int depth = 4;

  @Override public String toString() {
    return newLineWithTab(depth) + "WeatherUrl{" +
        newLineWithTab(depth + 1) + "value='" + value + '\'' +
        newLineWithTab(depth) + "}" + newLineWithTab(depth - 1);
  }
}
