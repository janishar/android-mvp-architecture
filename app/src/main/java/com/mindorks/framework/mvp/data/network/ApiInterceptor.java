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

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by janisharali on 28/01/17.
 */

@Singleton
public class ApiInterceptor implements Interceptor {

    private static final String TAG = "ApiInterceptor";

    private ApiHeader mApiHeader;

    @Inject
    public ApiInterceptor(final ApiHeader header) {
        mApiHeader = header;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        final Request.Builder builder = request.newBuilder();
        String apiAuthType = request.header(ApiHeader.API_AUTH_TYPE);
        if (apiAuthType == null) {
            apiAuthType = ApiHeader.PROTECTED_API;
        }

        switch (apiAuthType) {
            case ApiHeader.PROTECTED_API:
                builder.addHeader(ApiHeader.HEADER_PARAM_ACCESS_TOKEN, mApiHeader.getAccessToken());
                builder.addHeader(ApiHeader.HEADER_PARAM_USER_ID, String.valueOf(mApiHeader.getUserId()));
            case ApiHeader.PUBLIC_API:
            default:
                builder.addHeader(ApiHeader.HEADER_PARAM_API_KEY, mApiHeader.getApiKey());
        }

        return chain.proceed(builder.build());
    }
}
