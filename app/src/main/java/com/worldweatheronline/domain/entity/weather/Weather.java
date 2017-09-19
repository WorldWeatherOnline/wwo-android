
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

  @SerializedName("date")
  @Expose
  public String date;
  @SerializedName("astronomy")
  @Expose
  public List<Astronomy> astronomy = null;
  @SerializedName("maxtempC")
  @Expose
  public String maxtempC;
  @SerializedName("maxtempF")
  @Expose
  public String maxtempF;
  @SerializedName("mintempC")
  @Expose
  public String mintempC;
  @SerializedName("mintempF")
  @Expose
  public String mintempF;
  @SerializedName("totalSnow_cm")
  @Expose
  public String totalSnowCm;
  @SerializedName("sunHour")
  @Expose
  public String sunHour;
  @SerializedName("uvIndex")
  @Expose
  public String uvIndex;
  @SerializedName("hourly")
  @Expose
  public List<Hourly> hourly = null;

  private static int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "Weather{" +
        newLineWithTab(count + 2) + "date='" + date + "'," +
        newLineWithTab(count + 2) + "astronomy=" + astronomy +
        newLineWithTab(count + 2) + "maxtempC='" + maxtempC + "'," +
        newLineWithTab(count + 2) + "maxtempF='" + maxtempF + "'," +
        newLineWithTab(count + 2) + "mintempC='" + mintempC + "'," +
        newLineWithTab(count + 2) + "mintempF='" + mintempF + "'," +
        newLineWithTab(count + 2) + "totalSnowCm='" + totalSnowCm + "'," +
        newLineWithTab(count + 2) + "sunHour='" + sunHour + "'," +
        newLineWithTab(count + 2) + "uvIndex='" + uvIndex + "'," +
        newLineWithTab(count + 2) + "hourly=" + hourly +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count);
  }
}
