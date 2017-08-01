package apandatv.activity.reginstered;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/8/1.
 * 注册
 *
 */
//
public class RegisteredActivity extends BaseActivity implements RegistereContart.View {
   private RegistereContart.Presenter presenter;

    @Override
    protected int getLayoutId() {
        new RegisterePresenter(this);
        return R.layout.activity_registered;
    }

    @Override
    protected void init() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(RegistereContart.Presenter presenter) {
        this.presenter=presenter;
    }
}
