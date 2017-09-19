
package com.worldweatheronline.domain.entity.timezone;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

  @Override public String toString() {
    return "NearestArea{" +
        "areaName=" + areaName +
        ", country=" + country +
        ", region=" + region +
        ", latitude='" + latitude + '\'' +
        ", longitude='" + longitude + '\'' +
        ", population='" + population + '\'' +
        ", weatherUrl=" + weatherUrl +
        '}';
  }
}
