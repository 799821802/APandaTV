package apandatv.model.biz.loginandregin;

import java.util.HashMap;
import java.util.Map;

import apandatv.config.Urls;
import apandatv.model.entity.LoginBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ReginsModelImpl implements ReginsModel {


    @Override
    public void getLogin(String username, String password, MyNetCallback<LoginBean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("service", "client_transaction");
        map.put("from", "https://reg.cntv.cn/login/login.action");
        iHttp.post(Urls.LOGIN, map, callback);



    }
}
