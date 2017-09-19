
package com.worldweatheronline.domain.entity.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("query")
    @Expose
    public String query;

}
