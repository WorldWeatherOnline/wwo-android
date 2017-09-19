
package com.worldweatheronline.domain.entity.timezone;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    public List<Request> request = null;
    @SerializedName("nearest_area")
    @Expose
    public List<NearestArea> nearestArea = null;
    @SerializedName("time_zone")
    @Expose
    public List<TimeZone> timeZone = null;

    @Override public String toString() {
        return "Data{" +
            "request=" + request +
            ", nearestArea=" + nearestArea +
            ", timeZone=" + timeZone +
            '}';
    }
}
