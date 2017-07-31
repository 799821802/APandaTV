package apandatv.model.biz;

import apandatv.model.entity.ChinaItemBean;
import apandatv.model.entity.LiveChinaBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/30.
 */

public interface IChinaLiveModel extends BaseModel{

    void loadLiveChina(MyNetCallback<LiveChinaBean> callback);
    void LoadChinaItem(String url ,MyNetCallback<ChinaItemBean> callback);
}
