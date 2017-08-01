package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.view.View;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class PhoneRegistrationFragment extends BaseFragment implements PhoneContart.View{

    private PhoneContart.Presenter presenter;


    @Override
    protected int getLayoutId() {

        new PhonePresenter(this);
        return R.layout.phonefragment;

    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(PhoneContart.Presenter presenter) {
this.presenter = presenter;
    }
}
