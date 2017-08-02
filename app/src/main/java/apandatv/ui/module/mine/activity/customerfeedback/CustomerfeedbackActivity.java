package apandatv.ui.module.mine.activity.customerfeedback;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/2.
 * 用户反馈
 */

public class CustomerfeedbackActivity extends BaseActivity {
    @BindView(R.id.user_retturn)
    ImageView userRetturn;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.user_tablayout)
    TabLayout userTablayout;
    @BindView(R.id.user_viewpage)
    ViewPager userViewpage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customerfeedback;
    }

    @Override
    protected void init() {

    }


    @OnClick(R.id.user_retturn)
    public void onViewClicked() {
    }
}
