package apandatv.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.apandatv.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.ArrayList;
import java.util.Map;

import apandatv.activity.reginstered.reginstere_fragment.registered.RegisteredActivity;
import apandatv.base.BaseActivity;
import apandatv.model.biz.loginandregin.ReginsModelImpl;
import apandatv.model.entity.LoginBean;
import apandatv.net.callback.MyNetCallback;
import apandatv.utils.LogUtils;
import butterknife.BindView;
import butterknife.OnClick;
//import butterknife.BindView;
//import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/1.
 * 登录界面
 */

public class LoginActivity extends BaseActivity {

//    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    @BindView(R.id.personal_image)
    ImageView personalImage;
    @BindView(R.id.tv_toRegist)
    TextView tvToRegist;
    @BindView(R.id.llweixinlogin)
    LinearLayout llweixinlogin;
    @BindView(R.id.llqqlogin)
    LinearLayout llqqlogin;
    @BindView(R.id.llsinalogin)
    LinearLayout llsinalogin;
    @BindView(R.id.edit_account)
    EditText editAccount;
    @BindView(R.id.hint_account)
    TextView hintAccount;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.hint_password)
    TextView hintPassword;
    @BindView(R.id.personal_login_forget_pwd)
    TextView personalLoginForgetPwd;
    @BindView(R.id.loding_btn)
    TextView lodingBtn;
    @BindView(R.id.login_in_layout)
    LinearLayout loginInLayout;

    private String phonenumber;
    private String password;
    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    private SHARE_MEDIA[] list = {SHARE_MEDIA.QQ, SHARE_MEDIA.SINA};
    private ProgressDialog dialog;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        initPlatforms();
    }


    @OnClick({R.id.personal_image, R.id.tv_toRegist, R.id.llweixinlogin, R.id.llqqlogin, R.id.llsinalogin, R.id.edit_account, R.id.hint_account, R.id.edit_password, R.id.hint_password, R.id.personal_login_forget_pwd, R.id.loding_btn, R.id.login_in_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_image:

           LoginActivity.this.finish();

                break;
//            跳到注册
            case R.id.tv_toRegist:
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);

                break;
            case R.id.llweixinlogin:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Log.e("TAG", share_media.toString());
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        String uid = map.get("uid");
                        String name = map.get("name");
                        String gender = map.get("gender");
                        String iconurl = map.get("iconurl");
                        Log.e("TAG", "uid:" + uid + "," + "name:" + name + "," + "gender:" + gender + "," + "iconurl:" + iconurl);

                        Intent intent=new Intent();
                        intent.putExtra("name",name);
                        setResult(2000,intent);
                        finish();

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Log.e("TAG", throwable.toString());
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Log.e("TAG", "取消分享");
                    }
                });
                break;
            case R.id.llqqlogin:
                UMShareAPI.get(LoginActivity.this).doOauthVerify(LoginActivity.this, platforms.get(0).mPlatform, authListener);
                break;
            case R.id.llsinalogin:
                break;
            case R.id.edit_account:
                break;
            case R.id.hint_account:
                break;
            case R.id.edit_password:
                break;
            case R.id.hint_password:
                break;
            case R.id.personal_login_forget_pwd:
                break;
            case R.id.loding_btn:

                phonenumber = editAccount.getText().toString().trim();
                password = hintAccount.getText().toString().trim();

                ReginsModelImpl reginsModel = new ReginsModelImpl();

                reginsModel.getLogin(phonenumber, password, new MyNetCallback<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        String errMsg = loginBean.getErrMsg();
                        LogUtils.e("TAg","看看登录返回的结果"+errMsg);

                        if (errMsg.equals("成功")) {
                            Intent intent1 =new Intent();
                            intent1.putExtra("userid",loginBean.getUser_seq_id());
                            setResult(1000,intent1);
                            finish();
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {
                        Toast.makeText(LoginActivity.this, "登录失败++++++", Toast.LENGTH_SHORT).show();

                    }

                });
                break;
            case R.id.login_in_layout:
                break;

        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            SocializeUtils.safeShowDialog(dialog);
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    private void initPlatforms() {
        platforms.clear();
        for (SHARE_MEDIA e : list) {
            if (!e.toString().equals(SHARE_MEDIA.GENERIC.toString())) {
                platforms.add(e.toSnsPlatform());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
