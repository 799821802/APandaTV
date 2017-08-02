package apandatv.activity.reginstered.reginstere_fragment.registered;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;

import apandatv.base.BaseActivity;
import apandatv.widget.view.MyViewViewPage;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/1.
 * 注册
 */
//
public class RegisteredActivity extends BaseActivity implements RegistereContart.View {
    @BindView(R.id.regist_image)
    ImageView registImage;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.regist_tablayout)
    TabLayout registTablayout;

    @BindView(R.id.framelayout_register_content)
    MyViewViewPage framelayoutRegisterContent;

    private RegistereContart.Presenter presenter;


    @Override
    protected int getLayoutId() {
        new RegisterePresenter(this);
        return R.layout.activity_registered;
    }

    @Override
    protected void init() {

        ArrayList<Fragment> fragment = presenter.getFragment();

        RegistereAdapter registereAdapter = new RegistereAdapter(getSupportFragmentManager(), fragment);

        framelayoutRegisterContent.setAdapter(registereAdapter);

        registTablayout.setupWithViewPager(framelayoutRegisterContent);

        registTablayout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(RegistereContart.Presenter presenter) {
        this.presenter = presenter;
    }




    @OnClick(R.id.regist_image)
    public void onViewClicked() {

                RegisteredActivity.this.finish();

    }
}
