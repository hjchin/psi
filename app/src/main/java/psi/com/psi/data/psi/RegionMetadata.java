
package psi.com.psi.data.psi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionMetadata {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("label_location")
    @Expose
    public LabelLocation labelLocation;

}
