package com.mindorks.framework.mvp.data.network;

import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import io.reactivex.Observable;

/**
 * Created on 20/02/17.
 */

public interface LoginApiHelper {

    Observable<Object> doGoogleLogin(LoginRequest.GoogleLoginRequest request);

    Observable<Object> doFacebookLogin(LoginRequest.FacebookLoginRequest request);

    Observable<Object> doServerLogin(LoginRequest.ServerLoginRequest request);

    Observable<Object> doLogout();

}
