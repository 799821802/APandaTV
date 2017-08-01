package apandatv.activity.reginstered.reginstere_fragment.registered;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import apandatv.activity.reginstered.reginstere_fragment.email.EmailRegistrationFragment;
import apandatv.activity.reginstered.reginstere_fragment.phone.PhoneRegistrationFragment;

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
