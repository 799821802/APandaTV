package apandatv.model.biz;


import apandatv.config.Urls;
import apandatv.model.entity.ChinaItemBean;
import apandatv.model.entity.LiveChinaBean;
import apandatv.net.callback.MyNetCallback;

/**
 * 业务处理实现类
 * Created by lenovo on 2017/7/27.
 */

public class ChinaLiveModelImpl implements IChinaLiveModel {



    @Override
    public void loadLiveChina(MyNetCallback<LiveChinaBean> callback) {
        iHttp.get(Urls.LIVECHINA,null,callback);
    }

    @Override
    public void LoadChinaItem(String url,MyNetCallback<ChinaItemBean> callback) {

        iHttp.get(url,null,callback);
    }
}
