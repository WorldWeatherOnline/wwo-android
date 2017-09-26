
package com.worldweatheronline.domain.entity.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ClimateAverage {

  @SerializedName("month")
  @Expose
  public List<Month> month = null;
}
