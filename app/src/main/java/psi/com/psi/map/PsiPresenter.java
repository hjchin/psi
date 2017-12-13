package psi.com.psi.map;

import java.util.HashMap;
import java.util.Map;

import psi.com.psi.data.HttpClientInterface;
import psi.com.psi.data.PsiApi;
import psi.com.psi.data.psi.Psi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HJ Chin on 11/12/2017.
 */

class PsiPresenter {

    private final PsiView view;
    private final PsiModel model;

    public PsiPresenter(PsiModel model, PsiView view){
        this.model = model;
        this.view = view;
    }

    public void loadPsi(){

        model.getPsi(new PsiModel.Callback(){

            @Override
            public void onResponse(Psi Psi) {
                view.showPsi(Psi);
            }

            @Override
            public void onErrorResponse(String message) {
                view.showError(message);
            }
        });
    }

}
