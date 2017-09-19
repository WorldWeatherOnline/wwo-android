
package com.worldweatheronline.domain.ski;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly {

    @SerializedName("bottom")
    @Expose
    public List<Bottom_> bottom = null;
    @SerializedName("chanceoffog")
    @Expose
    public String chanceoffog;
    @SerializedName("chanceoffrost")
    @Expose
    public String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    public String chanceofhightemp;
    @SerializedName("chanceofovercast")
    @Expose
    public String chanceofovercast;
    @SerializedName("chanceofrain")
    @Expose
    public String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    public String chanceofremdry;
    @SerializedName("chanceofsnow")
    @Expose
    public String chanceofsnow;
    @SerializedName("chanceofsunshine")
    @Expose
    public String chanceofsunshine;
    @SerializedName("chanceofthunder")
    @Expose
    public String chanceofthunder;
    @SerializedName("chanceofwindy")
    @Expose
    public String chanceofwindy;
    @SerializedName("cloudcover")
    @Expose
    public String cloudcover;
    @SerializedName("freezeLevel")
    @Expose
    public String freezeLevel;
    @SerializedName("humidity")
    @Expose
    public String humidity;
    @SerializedName("mid")
    @Expose
    public List<Mid> mid = null;
    @SerializedName("precipMM")
    @Expose
    public String precipMM;
    @SerializedName("pressure")
    @Expose
    public String pressure;
    @SerializedName("snowfall_cm")
    @Expose
    public String snowfallCm;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("top")
    @Expose
    public List<Top> top = null;
    @SerializedName("visibility")
    @Expose
    public String visibility;

}
