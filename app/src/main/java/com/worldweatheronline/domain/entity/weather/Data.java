
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

  @SerializedName("request")
  @Expose
  public List<Request> request = null;
  @SerializedName("current_condition")
  @Expose
  public List<CurrentCondition> currentCondition = null;
  @SerializedName("weather")
  @Expose
  public List<Weather> weather = null;
  @SerializedName("ClimateAverages")
  @Expose
  public List<ClimateAverage> climateAverages = null;

  private static int count = 0;

  @Override public String toString() {
    return "Data{" +
        newLineWithTab(count + 1) + "request=" + request + "," +
        newLineWithTab(count + 1) + "currentCondition=" + currentCondition + "," +
        newLineWithTab(count + 1) + "weather=" + weather + "," +
        newLineWithTab(count + 1) + "climateAverages=" + climateAverages + "," +
        newLineWithTab(count) + "}";
  }
}
