package apandatv.model.biz.videoplaybiz;

import apandatv.model.biz.BaseModel;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/8/1.
 */

public interface VideoPlayModel extends BaseModel {

    void getVideoPlay(String pid,MyNetCallback<VideoPlayerBean> callback);
}
