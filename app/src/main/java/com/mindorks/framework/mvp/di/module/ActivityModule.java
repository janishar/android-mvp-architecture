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

import android.app.Activity;
import android.content.Context;

import com.mindorks.framework.mvp.di.ActivityContext;
import com.mindorks.framework.mvp.di.PerActivity;
import com.mindorks.framework.mvp.ui.about.AboutMvpPresenter;
import com.mindorks.framework.mvp.ui.about.AboutMvpView;
import com.mindorks.framework.mvp.ui.about.AboutPresenter;
import com.mindorks.framework.mvp.ui.login.LoginMvpPresenter;
import com.mindorks.framework.mvp.ui.login.LoginMvpView;
import com.mindorks.framework.mvp.ui.login.LoginPresenter;
import com.mindorks.framework.mvp.ui.main.MainMvpPresenter;
import com.mindorks.framework.mvp.ui.main.MainMvpView;
import com.mindorks.framework.mvp.ui.main.MainPresenter;
import com.mindorks.framework.mvp.ui.splash.SplashMvpPresenter;
import com.mindorks.framework.mvp.ui.splash.SplashMvpView;
import com.mindorks.framework.mvp.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
}
