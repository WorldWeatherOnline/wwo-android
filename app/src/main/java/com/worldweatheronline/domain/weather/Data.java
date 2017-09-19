
package com.worldweatheronline.domain.weather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    public List<Request> request = null;
    @SerializedName("current_condition")
    @Expose
    public List<CurrentCondition> currentCondition = null;
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = null;
    @SerializedName("ClimateAverages")
    @Expose
    public List<ClimateAverage> climateAverages = null;

}
