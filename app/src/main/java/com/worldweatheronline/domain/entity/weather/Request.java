
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

  @SerializedName("type")
  @Expose
  public String type;
  @SerializedName("query")
  @Expose
  public String query;
  private static int count = 2;

  @Override public String toString() {
    return newLineWithTab(count) + "Request{" +
        newLineWithTab(count + 2) + "type='" + type + "'," +
        newLineWithTab(count + 2) + "query='" + query + "'," +
        newLineWithTab(count + 1) + "}" + newLineWithTab(count-1);
  }


}
