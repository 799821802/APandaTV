package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class PhoneContart {
    interface View extends BaseView<Presenter> {

        void  getImag(Bitmap bitmap);

    }
    //
    interface Presenter extends BasePresenter {

        void getGraphicvalidation();//获取图形验证码

//        jsonid  手机号  图形验证码
        void  getphonevalition(String jsonid,String phonenumber,String imagtion);//获取手机验证码

//     手机  注册 按钮

        void  getphoneRe();


    }


}
