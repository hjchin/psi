package psi.com.psi.map;

import psi.com.psi.data.psi.Psi;

/**
 * Created by HJ Chin on 11/12/2017.
 */

interface PsiView {

    void showPsi(Psi result);
    void showError(String message);
}
