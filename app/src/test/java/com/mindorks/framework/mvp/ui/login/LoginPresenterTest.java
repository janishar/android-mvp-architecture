package com.mindorks.framework.mvp.ui.login;

import com.mindorks.framework.mvp.data.DataManager;
import com.mindorks.framework.mvp.data.network.model.LoginRequest;
import com.mindorks.framework.mvp.data.network.model.LoginResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by amitshekhar on 02/02/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class LoginPresenterTest {

    @Mock
    LoginMvpView mMockLoginMvpView;
    @Mock
    DataManager mMockDataManager;
    private LoginPresenter<LoginMvpView> mLoginPresenter;

    @BeforeClass
    public static void onlyOnce() throws Exception {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {
                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable)
                            throws Exception {
                        return Schedulers.trampoline();
                    }
                });
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mLoginPresenter = new LoginPresenter<>(mMockDataManager);
        mLoginPresenter.onAttach(mMockLoginMvpView);
    }

    @Test
    public void testServerLoginSuccess() {

        String email = "dummy@gmail.com";
        String password = "password";

        LoginResponse loginResponse = new LoginResponse();

        doReturn(Observable.just(loginResponse))
                .when(mMockDataManager)
                .doServerLoginApiCall(new LoginRequest
                        .ServerLoginRequest(email, password));

        mLoginPresenter.onServerLoginClick(email, password);

        verify(mMockLoginMvpView).showLoading();
        verify(mMockLoginMvpView).hideLoading();
        verify(mMockLoginMvpView).openMainActivity();
    }


    @After
    public void tearDown() throws Exception {
        mLoginPresenter.onDetach();
        RxAndroidPlugins.reset();
    }

}