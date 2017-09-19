
package com.worldweatheronline.domain.marine.past;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    public List<Request> request = null;
    @SerializedName("nearest_area")
    @Expose
    public List<NearestArea> nearestArea = null;
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = null;

}
