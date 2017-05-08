package com.mindorks.framework.mvp.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by hrskrs on 5/8/2017.
 */

public class TestSchedulerProvider implements SchedulerProvider{

  private final TestScheduler testScheduler;

  public TestSchedulerProvider(TestScheduler testScheduler) {
    this.testScheduler = testScheduler;
  }

  @Override
  public Scheduler ui() {
    return testScheduler;
  }

  @Override
  public Scheduler computation() {
    return testScheduler;
  }

  @Override
  public Scheduler io() {
    return testScheduler;
  }
}
