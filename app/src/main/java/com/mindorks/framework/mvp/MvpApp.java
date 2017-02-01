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

package com.mindorks.framework.mvp;

import android.app.Application;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.di.component.ApplicationComponent;
import com.mindorks.framework.mvp.di.component.DaggerApplicationComponent;
import com.mindorks.framework.mvp.di.module.ApplicationModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by janisharali on 27/01/17.
 */

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Inject
    OkHttpClient mOkHttpClient;

    private ApplicationComponent mApplicationComponent;

    public static MvpApp get(Context context) {
        return (MvpApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AndroidNetworking.initialize(getApplicationContext(), mOkHttpClient);
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
