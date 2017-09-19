
package com.worldweatheronline.domain.entity.timezone;

import static com.worldweatheronline.domain.entity.Constants.newLineWithTab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldweatheronline.domain.entity.Constants;

public class Request {

  @SerializedName("type")
  @Expose
  public String type;
  @SerializedName("query")
  @Expose
  public String query;
  private static final int depth = 2;

  @Override public String toString() {
    return newLineWithTab(depth) + "Request{" +
        newLineWithTab(depth + 1) + "type='" + type + "\'," +
        newLineWithTab(depth + 1) + "query='" + query + "\'," +
        newLineWithTab(depth) + "}" + newLineWithTab(depth - 1);
  }
}
