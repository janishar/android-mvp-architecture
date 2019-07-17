package ${packageName}.${folderName};

import android.os.Bundle;
import javax.inject.Inject;
import butterknife.ButterKnife;
import com.mindorks.framework.mvp.ui.base.BaseActivity;
import android.content.Intent;
import android.content.Context;
import com.mindorks.framework.mvp.R;
public class ${className}Activity extends BaseActivity implements ${className}MvpView {

	@Inject
    ${className}Presenter<${className}MvpView> mPresenter;
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutName});

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(${className}Activity.this);
    }

    public static Intent getStartIntent(Context context) {
            Intent intent = new Intent(context, ${className}Activity.class);
            return intent;
        }
	
	@Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}