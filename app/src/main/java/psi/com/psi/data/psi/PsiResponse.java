
package psi.com.psi.data.psi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PsiResponse {

    @SerializedName("region_metadata")
    @Expose
    public List<RegionMetadata> regionMetadata = null;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;
    @SerializedName("api_info")
    @Expose
    public ApiInfo apiInfo;

}