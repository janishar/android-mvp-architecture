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

package com.mindorks.framework.mvp.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mindorks.framework.mvp.data.local.PreferencesHelper;
import com.mindorks.framework.mvp.data.local.db.DbHelper;

import javax.inject.Inject;

/**
 * Created by janisharali on 07/01/17.
 */

public class ApiHeader {

    @Expose
    @SerializedName("api_key")
    private String mApiKey;

    @Expose
    @SerializedName("user_id")
    private Long mUserId;

    @Expose
    @SerializedName("access_token")
    private String mAccessToken;

    @Inject
    public ApiHeader(String apiKey, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        mApiKey = apiKey;
        mAccessToken = preferencesHelper.getAccessToken();
    }


    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }
}
