package apandatv.model.biz.pandalivebiz;

import apandatv.config.Urls;
import apandatv.model.entity.PandaLiveLive;
import apandatv.model.entity.PandaLiveLook;
import apandatv.model.entity.PandaLiveMore;
import apandatv.model.entity.PandaLiveOther;
import apandatv.model.entity.PandaLiveTextBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveModeLImpl implements PandaLiveModel {

    //    熊猫 直播  首页 地址
    @Override
    public void getPandaLive(MyNetCallback<PandaLiveTextBean> callback) {

        iHttp.get(Urls.PANDALIVE, null, callback);

    }

    //    熊猫直播中的   直播的  地址
    @Override
    public void getPandaLiveLive(MyNetCallback<PandaLiveLive> callback) {

        iHttp.get(Urls.PANDALIVE_Live_Live, null, callback);

    }

    @Override
    public void getPandaLiveMore(MyNetCallback<PandaLiveMore> callback) {
        iHttp.get(Urls.PANDALIVEMore, null, callback);
    }

    @Override
    public void getOandaLiveLook(MyNetCallback<PandaLiveLook> callback) {
        iHttp.get(Urls.PANDALIVELook, null, callback);


    }

    @Override
    public void getOtherLive(String string, MyNetCallback<PandaLiveOther> callback) {

        iHttp.get(string, null, callback);

    }


}
