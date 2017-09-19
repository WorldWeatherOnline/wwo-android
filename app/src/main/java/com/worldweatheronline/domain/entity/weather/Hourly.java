
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly {

  @SerializedName("time")
  @Expose
  public String time;
  @SerializedName("tempC")
  @Expose
  public String tempC;
  @SerializedName("tempF")
  @Expose
  public String tempF;
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
  @SerializedName("weatherCode")
  @Expose
  public String weatherCode;
  @SerializedName("weatherIconUrl")
  @Expose
  public List<WeatherIconUrl_> weatherIconUrl = null;
  @SerializedName("weatherDesc")
  @Expose
  public List<WeatherDesc_> weatherDesc = null;
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
  @SerializedName("HeatIndexC")
  @Expose
  public String heatIndexC;
  @SerializedName("HeatIndexF")
  @Expose
  public String heatIndexF;
  @SerializedName("DewPointC")
  @Expose
  public String dewPointC;
  @SerializedName("DewPointF")
  @Expose
  public String dewPointF;
  @SerializedName("WindChillC")
  @Expose
  public String windChillC;
  @SerializedName("WindChillF")
  @Expose
  public String windChillF;
  @SerializedName("WindGustMiles")
  @Expose
  public String windGustMiles;
  @SerializedName("WindGustKmph")
  @Expose
  public String windGustKmph;
  @SerializedName("FeelsLikeC")
  @Expose
  public String feelsLikeC;
  @SerializedName("FeelsLikeF")
  @Expose
  public String feelsLikeF;
  @SerializedName("chanceofrain")
  @Expose
  public String chanceofrain;
  @SerializedName("chanceofremdry")
  @Expose
  public String chanceofremdry;
  @SerializedName("chanceofwindy")
  @Expose
  public String chanceofwindy;
  @SerializedName("chanceofovercast")
  @Expose
  public String chanceofovercast;
  @SerializedName("chanceofsunshine")
  @Expose
  public String chanceofsunshine;
  @SerializedName("chanceoffrost")
  @Expose
  public String chanceoffrost;
  @SerializedName("chanceofhightemp")
  @Expose
  public String chanceofhightemp;
  @SerializedName("chanceoffog")
  @Expose
  public String chanceoffog;
  @SerializedName("chanceofsnow")
  @Expose
  public String chanceofsnow;
  @SerializedName("chanceofthunder")
  @Expose
  public String chanceofthunder;

  private static int count = 5;

  @Override public String toString() {
    return newLineWithTab(count) + "Hourly{" +
        newLineWithTab(count + 2) + "time='" + time + "'," +
        newLineWithTab(count + 2) + "tempC='" + tempC + "'," +
        newLineWithTab(count + 2) + "tempF='" + tempF + "'," +
        newLineWithTab(count + 2) + "windspeedMiles='" + windspeedMiles + "'," +
        newLineWithTab(count + 2) + "windspeedKmph='" + windspeedKmph + "'," +
        newLineWithTab(count + 2) + "winddirDegree='" + winddirDegree + "'," +
        newLineWithTab(count + 2) + "winddir16Point='" + winddir16Point + "'," +
        newLineWithTab(count + 2) + "weatherCode='" + weatherCode + "'," +
        newLineWithTab(count + 2) + "weatherIconUrl=" + weatherIconUrl +
        newLineWithTab(count + 2) + "weatherDesc=" + weatherDesc +
        newLineWithTab(count + 2) + "precipMM='" + precipMM + "'," +
        newLineWithTab(count + 2) + "humidity='" + humidity + "'," +
        newLineWithTab(count + 2) + "visibility='" + visibility + "'," +
        newLineWithTab(count + 2) + "pressure='" + pressure + "'," +
        newLineWithTab(count + 2) + "cloudcover='" + cloudcover + "'," +
        newLineWithTab(count + 2) + "heatIndexC='" + heatIndexC + "'," +
        newLineWithTab(count + 2) + "heatIndexF='" + heatIndexF + "'," +
        newLineWithTab(count + 2) + "dewPointC='" + dewPointC + "'," +
        newLineWithTab(count + 2) + "dewPointF='" + dewPointF + "'," +
        newLineWithTab(count + 2) + "windChillC='" + windChillC + "'," +
        newLineWithTab(count + 2) + "windChillF='" + windChillF + "'," +
        newLineWithTab(count + 2) + "windGustMiles='" + windGustMiles + "'," +
        newLineWithTab(count + 2) + "windGustKmph='" + windGustKmph + "'," +
        newLineWithTab(count + 2) + "feelsLikeC='" + feelsLikeC + "'," +
        newLineWithTab(count + 2) + "feelsLikeF='" + feelsLikeF + "'," +
        newLineWithTab(count + 2) + "chanceofrain='" + chanceofrain + "'," +
        newLineWithTab(count + 2) + "chanceofremdry='" + chanceofremdry + "'," +
        newLineWithTab(count + 2) + "chanceofwindy='" + chanceofwindy + "'," +
        newLineWithTab(count + 2) + "chanceofovercast='" + chanceofovercast + "'," +
        newLineWithTab(count + 2) + "chanceofsunshine='" + chanceofsunshine + "'," +
        newLineWithTab(count + 2) + "chanceoffrost='" + chanceoffrost + "'," +
        newLineWithTab(count + 2) + "chanceofhightemp='" + chanceofhightemp + "'," +
        newLineWithTab(count + 2) + "chanceoffog='" + chanceoffog + "'," +
        newLineWithTab(count + 2) + "chanceofsnow='" + chanceofsnow + "'," +
        newLineWithTab(count + 2) + "chanceofthunder='" + chanceofthunder + "'," +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count - 1);
  }
}
