package apandatv.ui.module.mine.activity.reginsterefragment.email;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import apandatv.config.Keys;
import apandatv.model.biz.reginemail.EmialModel;
import apandatv.model.biz.reginemail.EmialModelImap;
import apandatv.model.entity.Register;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class EmailPresenter implements EmailContart.Presenter{

    private EmailContart.View mineView;
    private EmialModel emialModel;
    private String jsessionid;
    public EmailPresenter(EmailContart.View view){

        this.mineView=view;
        view.setPresenter(this);
        this.emialModel = new EmialModelImap();


    }


    @Override
    public void start() {
        emialModel.loadImgCode(new MyNetCallback<Bundle>() {
            @Override
            public void onSuccess(Bundle bundle) {
                jsessionid = bundle.getString(Keys.JSESSIONID);
                byte[] byteArray = bundle.getByteArray(Keys.IMGCODE);
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                mineView.showImgCode(bitmap);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }

    @Override
    public boolean checkEmail(String emailAddress) {
        if(emailAddress == null || "".equals(emailAddress)){
            mineView.showEmailTips("邮箱不能为空");
            return false;
        }
        String regEx = "/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/";
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAddress);
        // 字符串是否与正则表达式相匹配
        boolean matches = matcher.matches();
        if(!matches){
            mineView.showEmailTips("邮箱格式不正确");
            return false;
        }

        return true;

    }

    @Override
    public boolean checkPwd(String pwd) {
        return true;
    }

    @Override
    public boolean checkImgCode(String imgCode) {
        return true;
    }

    @Override
    public void register(String mailAdd, String passWd, String verificationCode) {
        if(!checkPwd(passWd))
            return;
        if(!checkImgCode(verificationCode))
            return;
        emialModel.register(mailAdd, passWd, verificationCode, jsessionid, new MyNetCallback<Register>() {
            @Override
            public void onSuccess(Register register) {

                String msg = register.getMsg();
                if("success".equals(msg)){
                    mineView.toLogin();
                }

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                mineView.showMessage(errorMsg);
            }
        });
    }
}
