
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
  private int count = 0;

  @Override public String toString() {
    return newLineWithTab(count) + "Data{" +
        newLineWithTab(count + 1) + "request=" + request + "," +
        newLineWithTab(count + 1) + "nearestArea=" + nearestArea + "," +
        newLineWithTab(count + 1) + "timeZone=" + timeZone + "," +
        newLineWithTab(count) + "}" + newLineWithTab(count - 1);
  }
}
