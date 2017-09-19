
package com.worldweatheronline.domain.ski;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("query")
    @Expose
    public String query;
    @SerializedName("type")
    @Expose
    public String type;

}
