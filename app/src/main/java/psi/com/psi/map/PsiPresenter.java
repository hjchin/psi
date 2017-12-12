package psi.com.psi.map;

import java.util.HashMap;
import java.util.Map;

import psi.com.psi.data.HttpClientInterface;
import psi.com.psi.data.PsiApi;
import psi.com.psi.data.psi.PsiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HJ Chin on 11/12/2017.
 */

public class PsiPresenter {

    private HttpClientInterface httpClient;
    private PsiView view;

    public PsiPresenter(HttpClientInterface httpClient, PsiView view){
        this.httpClient = httpClient;
        this.view = view;
    }

    public void loadPsi(){

        PsiApi psiApi = httpClient.getClient().create(PsiApi.class);
        Map<String, String> query = new HashMap<String, String>();
        Call<PsiResponse> call = psiApi.getPsi(query);

        call.enqueue(new Callback<PsiResponse>() {
            @Override
            public void onResponse(Call<PsiResponse> call, Response<PsiResponse> response) {
                view.showPsi(response.body());
            }

            @Override
            public void onFailure(Call<PsiResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }

}
