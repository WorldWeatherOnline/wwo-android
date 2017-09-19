
package com.worldweatheronline.domain.entity.weather;

import static com.worldweatheronline.domain.entity.Constants.NEW_LINE;
import static com.worldweatheronline.domain.entity.Constants.TAB;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month {

  @SerializedName("index")
  @Expose
  public String index;
  @SerializedName("name")
  @Expose
  public String name;
  @SerializedName("avgMinTemp")
  @Expose
  public String avgMinTemp;
  @SerializedName("avgMinTemp_F")
  @Expose
  public String avgMinTempF;
  @SerializedName("absMaxTemp")
  @Expose
  public String absMaxTemp;
  @SerializedName("absMaxTemp_F")
  @Expose
  public String absMaxTempF;
  @SerializedName("avgDailyRainfall")
  @Expose
  public String avgDailyRainfall;

  @Override public String toString() {
    return NEW_LINE + TAB + "Month{" +
        NEW_LINE + TAB + TAB + "index='" + index +  "'," +
        NEW_LINE + TAB + TAB + "name='" + name +  "'," +
        NEW_LINE + TAB + TAB + "avgMinTemp='" + avgMinTemp +  "'," +
        NEW_LINE + TAB + TAB + "avgMinTempF='" + avgMinTempF +  "'," +
        NEW_LINE + TAB + TAB + "absMaxTemp='" + absMaxTemp +  "'," +
        NEW_LINE + TAB + TAB + "absMaxTempF='" + absMaxTempF +  "'," +
        NEW_LINE + TAB + TAB + "avgDailyRainfall='" + avgDailyRainfall +  "'," +
        NEW_LINE + TAB + "}";
  }
}
