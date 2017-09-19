
package com.worldweatheronline.domain.ski;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearestArea {

    @SerializedName("areaName")
    @Expose
    public List<AreaName> areaName = null;
    @SerializedName("country")
    @Expose
    public List<Country> country = null;
    @SerializedName("distance_miles")
    @Expose
    public String distanceMiles;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("region")
    @Expose
    public List<Region> region = null;

}
