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

//                startActivityForResult(new Intent(PersonalcenterActivity.this, LoginActivity.class),0);



                break;
//            跳到登录
            case R.id.linear1:
                startActivityForResult(new Intent(PersonalcenterActivity.this, LoginActivity.class),0);
                break;
            case R.id.linear2:

                break;
            case R.id.linear3:
                break;
            case R.id.linear4:
                Intent intent = new Intent(PersonalcenterActivity.this,SetupActivity.class);
                startActivity(intent);


                break;
        }
    }

//    跳转回传
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1000:
                String result_value = data.getStringExtra("userid");
                dianjilogin.setText("央视网友"+result_value);
                break;
            case 2000:
                String name = data.getStringExtra("name");
                dianjilogin.setText(name);
                break;
            case 3000:
                dianjilogin.setText("点击登录");
                break;
        }
    }



}
