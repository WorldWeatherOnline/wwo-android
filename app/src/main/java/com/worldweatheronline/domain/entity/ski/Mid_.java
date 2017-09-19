
package com.worldweatheronline.domain.entity.ski;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mid_ {

    @SerializedName("maxtempC")
    @Expose
    public String maxtempC;
    @SerializedName("maxtempF")
    @Expose
    public String maxtempF;
    @SerializedName("mintempC")
    @Expose
    public String mintempC;
    @SerializedName("mintempF")
    @Expose
    public String mintempF;

}
