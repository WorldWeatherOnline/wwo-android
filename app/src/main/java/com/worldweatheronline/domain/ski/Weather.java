
package com.worldweatheronline.domain.ski;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("astronomy")
    @Expose
    public List<Astronomy> astronomy = null;
    @SerializedName("bottom")
    @Expose
    public List<Bottom> bottom = null;
    @SerializedName("chanceofsnow")
    @Expose
    public String chanceofsnow;
    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = null;
    @SerializedName("mid")
    @Expose
    public List<Mid_> mid = null;
    @SerializedName("top")
    @Expose
    public List<Top_> top = null;
    @SerializedName("totalSnowfall_cm")
    @Expose
    public String totalSnowfallCm;

}
