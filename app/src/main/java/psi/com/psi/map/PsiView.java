package psi.com.psi.map;

import psi.com.psi.data.psi.PsiResponse;

/**
 * Created by HJ Chin on 11/12/2017.
 */

interface PsiView {

    void showPsi(PsiResponse result);
    void showError(String message);
}
