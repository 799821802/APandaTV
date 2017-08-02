package apandatv.model.biz.pandaculturebiz;

import apandatv.config.Urls;
import apandatv.model.entity.RollVideoBean;
import apandatv.net.callback.MyNetCallback;

import static apandatv.model.biz.BaseModel.iHttp;

/**
 * Created by ASUS on 2017/7/31.
 */

public class PandaCultureModellmp implements PandaCultureModel{



    @Override
    public void getRollVideoBean(MyNetCallback<RollVideoBean> callBack) {
        iHttp.get(Urls.ROLLVIDEO,null,callBack);
    }
}
