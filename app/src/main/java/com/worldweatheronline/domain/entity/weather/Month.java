
package com.worldweatheronline.domain.entity.weather;

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

}
