package apandatv.ui.module.mine.activity.reginsterefragment.email;

import android.graphics.Bitmap;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class EmailContart {
    interface View extends BaseView<Presenter> {
        void showEmailTips(String msg);
        void hideEmailTips();
        void showPwdTips(String msg);
        void hidePwdTips();
        void showImgCode(Bitmap bitmap);
        void toLogin();
        void showMessage(String string);

    }

    interface Presenter extends BasePresenter {
        boolean checkEmail(String emailAddress);
        boolean checkPwd(String pwd);
        boolean checkImgCode(String imgCode);
        void register(String mailAdd,String passWd,String verificationCode);
    }
}
