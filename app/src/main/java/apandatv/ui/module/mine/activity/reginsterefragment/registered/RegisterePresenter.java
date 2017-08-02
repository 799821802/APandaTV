package apandatv.ui.module.mine.activity.reginsterefragment.registered;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import apandatv.ui.module.mine.activity.reginsterefragment.email.EmailRegistrationFragment;
import apandatv.ui.module.mine.activity.reginsterefragment.phone.PhoneRegistrationFragment;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class RegisterePresenter implements RegistereContart.Presenter {

    private RegistereContart.View view;

    public RegisterePresenter(RegistereContart.View view) {

        this.view = view;
        view.setPresenter(this);


    }


    @Override
    public void start() {




    }

    @Override
    public ArrayList<Fragment> getFragment() {

        ArrayList<Fragment> arrayList = new ArrayList<>();

        EmailRegistrationFragment emailRegistrationFragment = new EmailRegistrationFragment();
        PhoneRegistrationFragment phoneRegistrationFragment = new PhoneRegistrationFragment();

        arrayList.add(phoneRegistrationFragment);
        arrayList.add(emailRegistrationFragment);

        return arrayList;
    }
}
