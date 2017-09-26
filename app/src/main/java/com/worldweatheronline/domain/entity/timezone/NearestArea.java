
package com.worldweatheronline.domain.entity.timezone;

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
}
