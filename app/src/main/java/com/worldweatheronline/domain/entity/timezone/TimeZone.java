
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeZone {

  @SerializedName("localtime")
  @Expose
  public String localtime;
  @SerializedName("utcOffset")
  @Expose
  public String utcOffset;
  private int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "TimeZone{" +
        newLineWithTab(count + 1) + "localtime='" + localtime + "\'," +
        newLineWithTab(count + 1) + "utcOffset='" + utcOffset + "\'" +
        newLineWithTab(count) + "}" + newLineWithTab(count - 1);
  }
}
