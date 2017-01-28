/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.framework.mvp.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mindorks.framework.mvp.BuildConfig;
import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;
import com.mindorks.framework.mvp.data.network.model.LogoutResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by janisharali on 28/01/17.
 */

public interface ApiCall {

    String HEADER_PARAM_SEPARATOR = ":";

    String ENDPOINT_GOOGLE_LOGIN = "588d14f4100000a9072d2943";
    String ENDPOINT_FACEBOOK_LOGIN = "588d15d3100000ae072d2944";
    String ENDPOINT_SERVER_LOGIN = "588d15f5100000a8072d2945";
    String ENDPOINT_LOGOUT = "588d161c100000a9072d2946";

    @POST(ENDPOINT_GOOGLE_LOGIN)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PUBLIC_API)
    Observable<LoginResponse> doGoogleLogin(@Body LoginRequest.GoogleLoginRequest request);

    @POST(ENDPOINT_FACEBOOK_LOGIN)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PUBLIC_API)
    Observable<LoginResponse> doFacebookLogin(@Body LoginRequest.FacebookLoginRequest request);

    @POST(ENDPOINT_SERVER_LOGIN)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PUBLIC_API)
    Observable<LoginResponse> doServerLogin(@Body LoginRequest.ServerLoginRequest request);

    @POST(ENDPOINT_LOGOUT)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PROTECTED_API)
    Observable<LogoutResponse> doLogout();

    class Factory {

        private static final int NETWORK_CALL_TIMEOUT = 60;

        public static ApiCall create(ApiInterceptor apiInterceptor) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.addInterceptor(apiInterceptor);

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            logging.setLevel(
                    BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

            builder.addInterceptor(logging);

            builder.readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);

            builder.writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);

            OkHttpClient httpClient = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(ApiCall.class);
        }
    }
}
