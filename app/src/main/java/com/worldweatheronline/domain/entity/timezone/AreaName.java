
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldweatheronline.domain.entity.Constants;

public class AreaName {

  @SerializedName("value")
  @Expose
  public String value;
  private static final int count = 4;

  @Override public String toString() {
    return newLineWithTab(count) + "AreaName{" +
        newLineWithTab(count + 1) + "value='" + value + '\'' +
        newLineWithTab(count) + "}" + newLineWithTab(count - 1);
  }
}
