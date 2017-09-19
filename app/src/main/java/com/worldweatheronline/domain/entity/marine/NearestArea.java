
package com.worldweatheronline.domain.entity.marine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearestArea {

    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("distance_miles")
    @Expose
    public String distanceMiles;

}
