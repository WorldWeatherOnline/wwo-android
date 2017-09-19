
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NearestArea {

  @SerializedName("areaName")
  @Expose
  public List<AreaName> areaName = null;
  @SerializedName("country")
  @Expose
  public List<Country> country = null;
  @SerializedName("region")
  @Expose
  public List<Region> region = null;
  @SerializedName("latitude")
  @Expose
  public String latitude;
  @SerializedName("longitude")
  @Expose
  public String longitude;
  @SerializedName("population")
  @Expose
  public String population;
  @SerializedName("weatherUrl")
  @Expose
  public List<WeatherUrl> weatherUrl = null;
  private int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "NearestArea{" +
        newLineWithTab(count + 1) + "areaName=" + areaName +
        newLineWithTab(count + 1) + "country=" + country + "," +
        newLineWithTab(count + 1) + "region=" + region + "," +
        newLineWithTab(count + 1) + "latitude='" + latitude + "\'," +
        newLineWithTab(count + 1) + "longitude='" + longitude + "\'," +
        newLineWithTab(count + 1) + "population='" + population + "\'," +
        newLineWithTab(count + 1) + "weatherUrl=" + weatherUrl + "," +
        newLineWithTab(count) + "}" + newLineWithTab(count - 1);
  }
}
