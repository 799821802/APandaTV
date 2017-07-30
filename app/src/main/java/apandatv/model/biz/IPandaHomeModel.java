package apandatv.model.biz;

import apandatv.model.entity.PandaHome;
import apandatv.model.entity.UpDateLoading;
import apandatv.net.callback.MyNetCallback;

/**
 * 首页业务处理接口
 *Created by lenovo on 2017/7/27.
 */

public interface IPandaHomeModel extends BaseModel {

    void loadHomeList(MyNetCallback<PandaHome> callback);
    void loadVersion(MyNetCallback<UpDateLoading> callback);
}
