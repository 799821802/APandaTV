package apandatv.model.biz.loginandregin;

import apandatv.model.biz.BaseModel;
import apandatv.model.entity.LoginBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface  ReginsModel extends BaseModel {

    void getLogin(String username, String password, MyNetCallback<LoginBean> callback);


}
