package apandatv.activity.reginstered.reginstere_fragment.email;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class EmailRegistrationFragment extends BaseFragment implements EmailContart.View {

    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.hint_emamil)
    TextView hintEmamil;
    @BindView(R.id.edit_passwrok)
    EditText editPasswrok;
    @BindView(R.id.hint_passwork)
    TextView hintPasswork;
    @BindView(R.id.edit_again_password)
    EditText editAgainPassword;
    @BindView(R.id.hint_again_passord)
    TextView hintAgainPassord;
    @BindView(R.id.edit_yanzhengma)
    EditText editYanzhengma;
    @BindView(R.id.personal_reg_imgcheck)
    ImageView personalRegImgcheck;
    @BindView(R.id.hint_yanzhengma)
    TextView hintYanzhengma;
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
    private EmailContart.Presenter emailContar;

    @Override
    protected int getLayoutId() {
        new EmailPresenter(this);
        return R.layout.emailfragmnet;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        emailContar.start();
    }

    @Override
    public void showEmailTips(String msg) {
        hintEmamil.setVisibility(View.VISIBLE);
        hintEmamil.setText(msg);
    }

    @Override
    public void hideEmailTips() {
        hintEmamil.setVisibility(View.GONE);
    }

    @Override
    public void showPwdTips(String msg) {

    }

    @Override
    public void hidePwdTips() {

    }

    @Override
    public void showImgCode(Bitmap bitmap) {
        personalRegImgcheck.setImageBitmap(bitmap);

    }

    @Override
    public void toLogin() {

    }

    @Override
    public void showMessage(String string) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(EmailContart.Presenter presenter) {
        this.emailContar = presenter;
    }


    @OnClick({R.id.btn_register, R.id.personal_reg_imgcheck})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_register:
                emailContar.register(editEmail.getText().toString().trim(),
                        editPasswrok.getText().toString().trim(),
                        editYanzhengma.getText().toString().trim());
                break;
            case R.id.personal_reg_imgcheck:
                emailContar.start();
                break;

        }

    }

}
