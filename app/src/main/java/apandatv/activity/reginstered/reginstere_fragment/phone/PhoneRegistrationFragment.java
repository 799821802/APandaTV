package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;
import butterknife.BindView;
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
}
