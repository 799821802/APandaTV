package apandatv.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/1.
 * 个人中心
 */

public class PersonalcenterActivity extends BaseActivity {

//返回按钮
    @BindView(R.id.personal_image)
    ImageView personalImage;

    @BindView(R.id.user_headimg)
    ImageView userHeadimg;
    @BindView(R.id.dianjilogin)
    TextView dianjilogin;

//    点击登录
    @BindView(R.id.linear1)
    LinearLayout linear1;
//    观看历史
    @BindView(R.id.linear2)
    LinearLayout linear2;
//    观看收藏
    @BindView(R.id.linear3)
    LinearLayout linear3;
//    设置
    @BindView(R.id.linear4)
    LinearLayout linear4;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personalcenter;
    }

    @Override
    protected void init() {

    }



    @OnClick({R.id.personal_image, R.id.user_headimg, R.id.dianjilogin, R.id.linear1, R.id.linear2, R.id.linear3, R.id.linear4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_image:
                break;
            case R.id.user_headimg:
                break;
            case R.id.dianjilogin:
                break;
//            跳到登录
            case R.id.linear1:
                Intent intent = new Intent(PersonalcenterActivity.this,LoginActivity.class);
                startActivity(intent);

                break;
            case R.id.linear2:
                break;
            case R.id.linear3:
                break;
            case R.id.linear4:
                break;
        }
    }
}
