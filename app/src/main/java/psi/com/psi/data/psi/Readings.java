
package psi.com.psi.data.psi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Readings {

    @SerializedName("o3_sub_index")
    @Expose
    public O3SubIndex o3SubIndex;
    @SerializedName("pm10_twenty_four_hourly")
    @Expose
    public Pm10TwentyFourHourly pm10TwentyFourHourly;
    @SerializedName("pm10_sub_index")
    @Expose
    public Pm10SubIndex pm10SubIndex;
    @SerializedName("co_sub_index")
    @Expose
    public CoSubIndex coSubIndex;
    @SerializedName("pm25_twenty_four_hourly")
    @Expose
    public Pm25TwentyFourHourly pm25TwentyFourHourly;
    @SerializedName("so2_sub_index")
    @Expose
    public So2SubIndex so2SubIndex;
    @SerializedName("co_eight_hour_max")
    @Expose
    public CoEightHourMax coEightHourMax;
    @SerializedName("no2_one_hour_max")
    @Expose
    public No2OneHourMax no2OneHourMax;
    @SerializedName("so2_twenty_four_hourly")
    @Expose
    public So2TwentyFourHourly so2TwentyFourHourly;
    @SerializedName("pm25_sub_index")
    @Expose
    public Pm25SubIndex pm25SubIndex;
    @SerializedName("psi_twenty_four_hourly")
    @Expose
    public PsiTwentyFourHourly psiTwentyFourHourly;
    @SerializedName("o3_eight_hour_max")
    @Expose
    public O3EightHourMax o3EightHourMax;

}
