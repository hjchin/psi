package psi.com.psi.data;

import java.util.Map;

import psi.com.psi.data.psi.Psi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by HJ Chin on 11/12/2017.
 */

public interface PsiApi {

    @Headers("api-key: AlFPsCUi6nf1eYUsGPyNqAAL6hpStdV4")
    @GET("environment/psi")
    Call<Psi> getPsi(@QueryMap Map<String, String> options);
}
