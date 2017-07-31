package apandatv.model.biz.pandalivebiz;

import apandatv.model.biz.BaseModel;
import apandatv.model.entity.PandaLiveLive;
import apandatv.model.entity.PandaLiveTextBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface PandaLiveModel extends BaseModel {

//    熊猫直播 直播 页面
    void  getPandaLive(MyNetCallback<PandaLiveTextBean> callback);

//    熊猫直播 中 直播页面
void  getPandaLiveLive(MyNetCallback<PandaLiveLive> callback);


}
