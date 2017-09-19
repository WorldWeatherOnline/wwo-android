
package com.worldweatheronline.domain.timezone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

  @SerializedName("data")
  @Expose
  public Data data;

  @Override public String toString() {
    return "Api{" +
        "data=" + data +
        '}';
  }
}
