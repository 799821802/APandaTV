package apandatv.ui.module.mine.activity.reginsterefragment.phone;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;
import apandatv.net.OkHttpUtils;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class PhoneRegistrationFragment extends BaseFragment implements PhoneContart.View {

    @BindView(R.id.edit_phone)
    EditText editPhone;

    @BindView(R.id.hint_phone)
    TextView hintPhone;

    @BindView(R.id.edit_imgyanzhengma)
    EditText editImgyanzhengma;

    @BindView(R.id.personal_reg_imgcheck)
    ImageView personalRegImgcheck;
    @BindView(R.id.hint_imagecheck)
    TextView hintImagecheck;
    @BindView(R.id.edit_phoneyanzhengma)
    EditText editPhoneyanzhengma;
    @BindView(R.id.personal_reg_phonecheck)
    TextView personalRegPhonecheck;
    @BindView(R.id.hint_phonecheck)
    TextView hintPhonecheck;
    @BindView(R.id.edit_inputpasswrod)
    EditText editInputpasswrod;
    @BindView(R.id.hint_password)
    TextView hintPassword;
    @BindView(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @BindView(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @BindView(R.id.hint_xieyi)
    TextView hintXieyi;
    @BindView(R.id.btn_register)
    TextView btnRegister;
    Unbinder unbinder;
    Unbinder unbinder1;
    private PhoneContart.Presenter presenter;


    @Override
    protected int getLayoutId() {

        new PhonePresenter(this);
        return R.layout.phonefragment;

    }

    String phonenum;
    String imageun;

    @Override
    protected void init(View view) {


    }

    @Override
    protected void loadData() {

        presenter.getGraphicvalidation();

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

    @Override
    public void getImag(Bitmap bitmap) {

        personalRegImgcheck.setImageBitmap(bitmap);

    }


    @OnClick({R.id.edit_phone, R.id.hint_phone, R.id.edit_imgyanzhengma, R.id.personal_reg_imgcheck, R.id.hint_imagecheck, R.id.edit_phoneyanzhengma, R.id.personal_reg_phonecheck, R.id.hint_phonecheck, R.id.edit_inputpasswrod, R.id.hint_password, R.id.xieyi_check, R.id.personal_reg_xieyi_view, R.id.hint_xieyi, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit_phone:

                break;
            case R.id.hint_phone:

                break;
            case R.id.edit_imgyanzhengma:

                break;
            case R.id.personal_reg_imgcheck:
                presenter.getGraphicvalidation();
                break;
            case R.id.hint_imagecheck:
                break;
            case R.id.edit_phoneyanzhengma:
                break;
//            点击获取 手机验证功
            case R.id.personal_reg_phonecheck:
//手机号码
                phonenum = editPhone.getText().toString().trim();
//        图形验证码
                imageun = editImgyanzhengma.getText().toString().trim();

                String cookie = OkHttpUtils.getInstance().getCookie();
                presenter.getphonevalition(cookie, phonenum, imageun);

                break;
            case R.id.hint_phonecheck:
                break;
            case R.id.edit_inputpasswrod:
                break;
            case R.id.hint_password:
                break;
            case R.id.xieyi_check:
                break;
            case R.id.personal_reg_xieyi_view:
                break;
            case R.id.hint_xieyi:
                break;
            case R.id.btn_register:
//手机号码
                phonenum = editPhone.getText().toString().trim();
//        手机验证码
                String trim = editPhoneyanzhengma.getText().toString().trim();
//                手机密码
                String trim1 = editInputpasswrod.getText().toString().trim();

                presenter.getphoneRe(phonenum,trim,trim1);

                break;
        }
    }
}
