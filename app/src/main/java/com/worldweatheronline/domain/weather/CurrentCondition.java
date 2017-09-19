
package com.worldweatheronline.domain.weather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentCondition {

    @SerializedName("observation_time")
    @Expose
    public String observationTime;
    @SerializedName("temp_C")
    @Expose
    public String tempC;
    @SerializedName("temp_F")
    @Expose
    public String tempF;
    @SerializedName("weatherCode")
    @Expose
    public String weatherCode;
    @SerializedName("weatherIconUrl")
    @Expose
    public List<WeatherIconUrl> weatherIconUrl = null;
    @SerializedName("weatherDesc")
    @Expose
    public List<WeatherDesc> weatherDesc = null;
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
    @SerializedName("FeelsLikeC")
    @Expose
    public String feelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    public String feelsLikeF;

}
