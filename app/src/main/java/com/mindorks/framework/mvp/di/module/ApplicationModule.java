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

package com.mindorks.framework.mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.mindorks.framework.mvp.BuildConfig;
import com.mindorks.framework.mvp.R;
import com.mindorks.framework.mvp.data.AppDataManager;
import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.data.local.AppPreferencesHelper;
import com.mindorks.framework.mvp.data.local.PreferencesHelper;
import com.mindorks.framework.mvp.data.local.db.AppDbHelper;
import com.mindorks.framework.mvp.data.local.db.DbHelper;
import com.mindorks.framework.mvp.data.local.db.DbOpenHelper;
import com.mindorks.framework.mvp.data.remote.ApiHeader;
import com.mindorks.framework.mvp.data.remote.ApiHelper;
import com.mindorks.framework.mvp.data.remote.AppApiHelper;
import com.mindorks.framework.mvp.di.ApiInfo;
import com.mindorks.framework.mvp.di.ApplicationContext;
import com.mindorks.framework.mvp.di.DatabaseInfo;
import com.mindorks.framework.mvp.di.PreferenceInfo;
import com.mindorks.framework.mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    /**
     * We are providing the AppDataManager by constructing it, because we want the Dependency
     * graph to provide the interfaces for these classes for loose binding to its implementation.
     */
    @Provides
    @Singleton
    DataManager provideDataManager(DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        return new AppDataManager(dbHelper, preferencesHelper, apiHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbOpenHelper dbOpenHelper) {
        return new AppDbHelper(dbOpenHelper);
    }

    @Provides
    @Singleton
    DbOpenHelper provideDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        return new DbOpenHelper(context, name);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(
            @ApplicationContext Context context,
            @PreferenceInfo String prefFileName) {
        return new AppPreferencesHelper(context, prefFileName);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(ApiHeader apiHeader) {
        return new AppApiHelper(apiHeader);
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(@ApiInfo String apiKey, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        return new ApiHeader(apiKey, dbHelper, preferencesHelper);
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
