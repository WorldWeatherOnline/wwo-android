
package com.worldweatheronline.domain.marine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("data")
    @Expose
    public Data data;

}
