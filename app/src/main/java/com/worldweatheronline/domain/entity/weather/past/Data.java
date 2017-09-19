
package com.worldweatheronline.domain.entity.weather.past;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    public List<Request> request = null;
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = null;

}
