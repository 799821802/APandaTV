package apandatv.model.biz.reginemail;

import android.os.Bundle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import apandatv.config.Urls;
import apandatv.model.entity.Register;
import apandatv.net.OkHttpUtils;
import apandatv.net.callback.MyNetCallback;

import static apandatv.model.biz.BaseModel.iHttp;

/**
 * Created by Administrator on 2017/8/1.
 */

public class EmialModelImap implements EmialModel{
    @Override
    public void loadImgCode(MyNetCallback<Bundle> callback) {
        OkHttpUtils.getInstance().loadImgCode(Urls.IMGCODE,callback);
    }

    @Override
    public void register(String mailAdd, String passWd, String verificationCode, String cookie, MyNetCallback<Register> callback) {

        String addons = null;
        String userAgent = null;
        try {
            addons = URLEncoder.encode("iPanda.Android", "UTF-8");
            userAgent = URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,String> params = new HashMap<>();
        params.put("mailAdd",mailAdd);
        params.put("passWd",passWd);
        params.put("verificationCode",verificationCode);
        params.put("addons", addons);

        Map<String,String> headers = new HashMap<>();
        headers.put("Referer",addons);
        headers.put("User-Agent",userAgent);
        headers.put("Cookie",cookie);

        iHttp.get(Urls.EMAILREGISTER,params,headers,callback);
    }
}
