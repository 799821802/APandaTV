package apandatv.model.biz;


import apandatv.config.Urls;
import apandatv.model.entity.PandaHome;
import apandatv.model.entity.UpDateLoading;
import apandatv.net.callback.MyNetCallback;

/**
 * 首页业务处理实现类
 * Created by lenovo on 2017/7/27.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {


    @Override
    public void loadHomeList(MyNetCallback<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }

    @Override
    public void loadVersion(MyNetCallback<UpDateLoading> callback) {
        iHttp.get(Urls.UPDATE,null,callback);
    }

}
