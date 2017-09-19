
package com.worldweatheronline.domain.entity.ski;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astronomy {

    @SerializedName("moonrise")
    @Expose
    public String moonrise;
    @SerializedName("moonset")
    @Expose
    public String moonset;
    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("sunset")
    @Expose
    public String sunset;

}
