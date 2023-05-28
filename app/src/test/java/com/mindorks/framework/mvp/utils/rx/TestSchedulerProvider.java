package com.mindorks.framework.mvp.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by hrskrs on 5/8/2017.
 */
public class TestSchedulerProvider implements SchedulerProvider {

    private final TestScheduler mTestScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        this.mTestScheduler = testScheduler;
    }

    @Override
    public Scheduler ui() {
        return getTestScheduler();
    }

    @Override
    public Scheduler computation() {
        return getTestScheduler();
    }

    @Override
    public Scheduler io() {
        return getTestScheduler();
    }

    private Scheduler getTestScheduler() {
        return mTestScheduler;
    }
}
