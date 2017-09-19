
package com.worldweatheronline.domain.timezone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeZone {

    @SerializedName("localtime")
    @Expose
    public String localtime;
    @SerializedName("utcOffset")
    @Expose
    public String utcOffset;

    @Override public String toString() {
        return "TimeZone{" +
            "localtime='" + localtime + '\'' +
            ", utcOffset='" + utcOffset + '\'' +
            '}';
    }
}
