
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClimateAverage {

  @SerializedName("month")
  @Expose
  public List<Month> month = null;

  private static int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "ClimateAverage{" +
        newLineWithTab(count + 1) + "month=" + month +
        newLineWithTab(2) + "}";
  }
}
