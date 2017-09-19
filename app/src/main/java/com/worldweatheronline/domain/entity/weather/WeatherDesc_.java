
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDesc_ {

  @SerializedName("value")
  @Expose
  public String value;

  private static int count = 8;

  @Override public String toString() {
    return newLineWithTab(count) + "WeatherDesc_{" +
        newLineWithTab(count + 2) + "value='" + value + "'," +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count-1);
  }
}
