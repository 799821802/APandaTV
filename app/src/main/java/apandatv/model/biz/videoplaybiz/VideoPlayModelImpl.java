package apandatv.model.biz.videoplaybiz;

import java.util.HashMap;
import java.util.Map;

import apandatv.config.Urls;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/8/1.
 */

public class VideoPlayModelImpl implements VideoPlayModel {
    @Override
    public void getVideoPlay(String pid,MyNetCallback<VideoPlayerBean> callback) {


        Map<String,String> map = new HashMap<>();
        map.put("pid",pid);
        iHttp.get(Urls.TV_Url,map,callback);

    }
}
