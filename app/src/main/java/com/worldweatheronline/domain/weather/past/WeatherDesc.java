
package com.worldweatheronline.domain.weather.past;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDesc {

    @SerializedName("value")
    @Expose
    public String value;

}
