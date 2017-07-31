package apandatv.model.biz.interactivebiz;

import apandatv.config.Urls;
import apandatv.model.entity.MyInteractiveBean;
import apandatv.net.callback.MyNetCallback;

import static apandatv.model.biz.BaseModel.iHttp;

/**
 * Created by lenovo on 2017/7/31.
 */

public class InteractiveModelImpl implements InteractiveModel {
    @Override
    public void getInteractive(MyNetCallback<MyInteractiveBean> callback) {
        iHttp.get(Urls.INTERACTIVE,null,callback);
    }
}
