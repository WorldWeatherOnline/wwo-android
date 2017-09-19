
package com.worldweatheronline.domain.entity.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astronomy {

    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("sunset")
    @Expose
    public String sunset;
    @SerializedName("moonrise")
    @Expose
    public String moonrise;
    @SerializedName("moonset")
    @Expose
    public String moonset;

}
