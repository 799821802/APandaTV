package apandatv.model.biz.reginemail;

import android.os.Bundle;

import apandatv.model.entity.Register;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface EmialModel {
    void loadImgCode(MyNetCallback<Bundle> callback);
    void register(String mailAdd,String passWd,String verificationCode,String cookie,MyNetCallback<Register> callback);

}
