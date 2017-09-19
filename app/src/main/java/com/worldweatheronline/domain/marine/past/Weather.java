
package com.worldweatheronline.domain.marine.past;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("astronomy")
    @Expose
    public List<Astronomy> astronomy = null;
    @SerializedName("maxtempC")
    @Expose
    public String maxtempC;
    @SerializedName("maxtempF")
    @Expose
    public String maxtempF;
    @SerializedName("mintempC")
    @Expose
    public String mintempC;
    @SerializedName("mintempF")
    @Expose
    public String mintempF;
    @SerializedName("hourly")
    @Expose
    public List<Hourly> hourly = null;

}
