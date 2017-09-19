
package com.worldweatheronline.domain.entity.timezone;

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
        return "\n\tTimeZone{" +
            "\n\t\tlocaltime='" + localtime + '\'' +
            "\n\t\t, utcOffset='" + utcOffset + '\'' +
            "\n\t}";
    }
}
