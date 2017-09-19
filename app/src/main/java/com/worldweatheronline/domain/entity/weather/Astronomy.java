
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astronomy {

  @SerializedName("sunrise")
  @Expose
  public String sunrise;
  @SerializedName("sunset")
  @Expose
  public String sunset;
  @SerializedName("moonrise")
  @Expose
  public String moonrise;
  @SerializedName("moonset")
  @Expose
  public String moonset;

  private static int count = 5;

  @Override public String toString() {
    return newLineWithTab(count) + "Astronomy{" +
        newLineWithTab(count + 2) + "sunrise='" + sunrise + "'," +
        newLineWithTab(count + 2) + "sunset='" + sunset + "'," +
        newLineWithTab(count + 2) + "moonrise='" + moonrise + "'," +
        newLineWithTab(count + 2) + "moonset='" + moonset + "'" +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count-1);
  }
}
