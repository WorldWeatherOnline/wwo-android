
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentCondition {

  @SerializedName("observation_time")
  @Expose
  public String observationTime;
  @SerializedName("temp_C")
  @Expose
  public String tempC;
  @SerializedName("temp_F")
  @Expose
  public String tempF;
  @SerializedName("weatherCode")
  @Expose
  public String weatherCode;
  @SerializedName("weatherIconUrl")
  @Expose
  public List<WeatherIconUrl> weatherIconUrl = null;
  @SerializedName("weatherDesc")
  @Expose
  public List<WeatherDesc> weatherDesc = null;
  @SerializedName("windspeedMiles")
  @Expose
  public String windspeedMiles;
  @SerializedName("windspeedKmph")
  @Expose
  public String windspeedKmph;
  @SerializedName("winddirDegree")
  @Expose
  public String winddirDegree;
  @SerializedName("winddir16Point")
  @Expose
  public String winddir16Point;
  @SerializedName("precipMM")
  @Expose
  public String precipMM;
  @SerializedName("humidity")
  @Expose
  public String humidity;
  @SerializedName("visibility")
  @Expose
  public String visibility;
  @SerializedName("pressure")
  @Expose
  public String pressure;
  @SerializedName("cloudcover")
  @Expose
  public String cloudcover;
  @SerializedName("FeelsLikeC")
  @Expose
  public String feelsLikeC;
  @SerializedName("FeelsLikeF")
  @Expose
  public String feelsLikeF;

  private static int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "CurrentCondition{" +
        newLineWithTab(count + 2) + "observationTime='" + observationTime + "'," +
        newLineWithTab(count + 2) + "tempC='" + tempC + "'," +
        newLineWithTab(count + 2) + "tempF='" + tempF + "'," +
        newLineWithTab(count + 2) + "weatherCode='" + weatherCode + "'," +
        newLineWithTab(count + 2) + "weatherIconUrl=" + weatherIconUrl +
        newLineWithTab(count + 2) + "weatherDesc=" + weatherDesc +
        newLineWithTab(count + 2) + "windspeedMiles='" + windspeedMiles + "'," +
        newLineWithTab(count + 2) + "windspeedKmph='" + windspeedKmph + "'," +
        newLineWithTab(count + 2) + "winddirDegree='" + winddirDegree + "'," +
        newLineWithTab(count + 2) + "winddir16Point='" + winddir16Point + "'," +
        newLineWithTab(count + 2) + "precipMM='" + precipMM + "'," +
        newLineWithTab(count + 2) + "humidity='" + humidity + "'," +
        newLineWithTab(count + 2) + "visibility='" + visibility + "'," +
        newLineWithTab(count + 2) + "pressure='" + pressure + "'," +
        newLineWithTab(count + 2) + "cloudcover='" + cloudcover + "'," +
        newLineWithTab(count + 2) + "feelsLikeC='" + feelsLikeC + "'," +
        newLineWithTab(count + 2) + "feelsLikeF='" + feelsLikeF + "'," +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count-1);
  }
}
