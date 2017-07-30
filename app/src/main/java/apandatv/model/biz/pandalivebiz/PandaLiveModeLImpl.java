package apandatv.model.biz.pandalivebiz;

import apandatv.config.Urls;
import apandatv.model.entity.PandaLiveLive;
import apandatv.model.entity.PandaLiveTextBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveModeLImpl implements PandaLiveModel {

//    熊猫 直播  首页 地址
    @Override
    public void getPandaLive(MyNetCallback<PandaLiveTextBean> callback) {

        iHttp.get(Urls.PANDALIVE,null,callback);

    }

//    熊猫直播中的   直播的  地址
    @Override
    public void getPandaLiveLive(MyNetCallback<PandaLiveLive> callback) {

        iHttp.get(Urls.PANDALIVE_Live_Live,null,callback);

    }
}
