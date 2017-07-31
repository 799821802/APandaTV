package apandatv.model.biz.pandalivebiz;

import apandatv.model.biz.BaseModel;
import apandatv.model.entity.PandaLiveLive;
import apandatv.model.entity.PandaLiveLook;
import apandatv.model.entity.PandaLiveMore;
import apandatv.model.entity.PandaLiveOther;
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

//  熊猫直播 中 直播页面 中 多视角直播
void getPandaLiveMore(MyNetCallback<PandaLiveMore> callback);

//    熊猫直播 中 直播页面 边看边聊

    void getOandaLiveLook(MyNetCallback<PandaLiveLook> callback );

//  熊猫 直播 中 其他八个页面网络请求

    void  getOtherLive(String string,MyNetCallback<PandaLiveOther> callback);



}
