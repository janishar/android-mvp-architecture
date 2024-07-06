package ${packageName}.${folderName};


import com.mindorks.framework.mvp.ui.base.BasePresenter;
import com.mindorks.framework.mvp.utils.rx.SchedulerProvider;
import com.mindorks.framework.mvp.data.DataManager;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

public class ${className}Presenter <V extends ${className}MvpView> extends BasePresenter<V> implements ${className}MvpPresenter<V> {

	private static final String TAG = "${className}Presenter";
	
    @Inject
    public ${className}Presenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}