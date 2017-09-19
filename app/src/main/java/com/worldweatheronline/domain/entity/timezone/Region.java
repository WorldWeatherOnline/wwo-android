
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldweatheronline.domain.entity.Constants;

public class Region {

  @SerializedName("value")
  @Expose
  public String value;
  private int depth = 4;

  @Override public String toString() {
    return newLineWithTab(depth) + "Region{" +
        newLineWithTab(depth + 1) + "value='" + value + '\'' +
        newLineWithTab(depth) + "}" + newLineWithTab(depth - 1);
  }
}
