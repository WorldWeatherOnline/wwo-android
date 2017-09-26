
package com.worldweatheronline.domain.entity.timezone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {

  @SerializedName("request")
  @Expose
  public List<Request> request = null;
  @SerializedName("nearest_area")
  @Expose
  public List<NearestArea> nearestArea = null;
  @SerializedName("time_zone")
  @Expose
  public List<TimeZone> timeZone = null;
}
