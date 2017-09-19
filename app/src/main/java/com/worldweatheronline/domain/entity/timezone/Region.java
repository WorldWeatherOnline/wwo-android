
package com.worldweatheronline.domain.entity.timezone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region {

  @SerializedName("value")
  @Expose
  public String value;

  @Override public String toString() {
    return "\t\nRegion{" +
        "\t\t\nvalue='" + value + '\'' +
        "\t\n}";
  }
}
