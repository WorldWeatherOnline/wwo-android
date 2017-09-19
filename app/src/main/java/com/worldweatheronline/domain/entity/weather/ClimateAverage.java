
package com.worldweatheronline.domain.entity.weather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClimateAverage {

    @SerializedName("month")
    @Expose
    public List<Month> month = null;

}
