
package psi.com.psi.data.psi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("timestamp")
    @Expose
    public String timestamp;
    @SerializedName("update_timestamp")
    @Expose
    public String updateTimestamp;
    @SerializedName("readings")
    @Expose
    public Readings readings;

}
