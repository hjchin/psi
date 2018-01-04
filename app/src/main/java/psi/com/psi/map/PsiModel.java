package psi.com.psi.map;

import java.util.HashMap;
import java.util.Map;

import psi.com.psi.data.HttpClientInterface;
import psi.com.psi.data.PsiApi;
import psi.com.psi.data.psi.Psi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by HJ Chin on 13/12/2017.
 */

public class PsiModel {

    interface Callback{
        void onResponse(Psi Psi);
        void onErrorResponse(String message);
    }

    private Psi PsiData;
    private HttpClientInterface httpClient;

    PsiModel(HttpClientInterface httpClient){
        this.httpClient = httpClient;
    }

    public void getPsi(final Callback callback){

        PsiApi psiApi = httpClient.getClient().create(PsiApi.class);
        Map<String, String> query = new HashMap<String, String>();
        Call<Psi> call = psiApi.getPsi(query);

        call.enqueue(new retrofit2.Callback<Psi>() {
            @Override
            public void onResponse(Call<Psi> call, Response<Psi> response) {
                PsiData = response.body();
                callback.onResponse(PsiData);
            }

            @Override
            public void onFailure(Call<Psi> call, Throwable t) {
                callback.onErrorResponse(t.getMessage());
            }
        });
    }


}
