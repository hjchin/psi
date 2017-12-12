
package psi.com.psi.data.psi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoEightHourMax {

    @SerializedName("west")
    @Expose
    public Double west;
    @SerializedName("national")
    @Expose
    public Double national;
    @SerializedName("east")
    @Expose
    public Double east;
    @SerializedName("central")
    @Expose
    public Double central;
    @SerializedName("south")
    @Expose
    public Double south;
    @SerializedName("north")
    @Expose
    public Double north;

}
