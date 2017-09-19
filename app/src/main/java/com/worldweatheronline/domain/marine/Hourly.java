
package com.worldweatheronline.domain.marine;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly {

    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("tempC")
    @Expose
    public String tempC;
    @SerializedName("tempF")
    @Expose
    public String tempF;
    @SerializedName("windspeedMiles")
    @Expose
    public String windspeedMiles;
    @SerializedName("windspeedKmph")
    @Expose
    public String windspeedKmph;
    @SerializedName("winddirDegree")
    @Expose
    public String winddirDegree;
    @SerializedName("winddir16Point")
    @Expose
    public String winddir16Point;
    @SerializedName("weatherCode")
    @Expose
    public String weatherCode;
    @SerializedName("weatherIconUrl")
    @Expose
    public List<WeatherIconUrl> weatherIconUrl = null;
    @SerializedName("weatherDesc")
    @Expose
    public List<WeatherDesc> weatherDesc = null;
    @SerializedName("precipMM")
    @Expose
    public String precipMM;
    @SerializedName("humidity")
    @Expose
    public String humidity;
    @SerializedName("visibility")
    @Expose
    public String visibility;
    @SerializedName("pressure")
    @Expose
    public String pressure;
    @SerializedName("cloudcover")
    @Expose
    public String cloudcover;
    @SerializedName("HeatIndexC")
    @Expose
    public String heatIndexC;
    @SerializedName("HeatIndexF")
    @Expose
    public String heatIndexF;
    @SerializedName("DewPointC")
    @Expose
    public String dewPointC;
    @SerializedName("DewPointF")
    @Expose
    public String dewPointF;
    @SerializedName("WindChillC")
    @Expose
    public String windChillC;
    @SerializedName("WindChillF")
    @Expose
    public String windChillF;
    @SerializedName("WindGustMiles")
    @Expose
    public String windGustMiles;
    @SerializedName("WindGustKmph")
    @Expose
    public String windGustKmph;
    @SerializedName("FeelsLikeC")
    @Expose
    public String feelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    public String feelsLikeF;
    @SerializedName("sigHeight_m")
    @Expose
    public String sigHeightM;
    @SerializedName("swellHeight_m")
    @Expose
    public String swellHeightM;
    @SerializedName("swellHeight_ft")
    @Expose
    public String swellHeightFt;
    @SerializedName("swellDir")
    @Expose
    public String swellDir;
    @SerializedName("swellDir16Point")
    @Expose
    public String swellDir16Point;
    @SerializedName("swellPeriod_secs")
    @Expose
    public String swellPeriodSecs;
    @SerializedName("waterTemp_C")
    @Expose
    public String waterTempC;
    @SerializedName("waterTemp_F")
    @Expose
    public String waterTempF;

}
