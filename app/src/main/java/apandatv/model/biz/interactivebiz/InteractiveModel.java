package apandatv.model.biz.interactivebiz;

import apandatv.model.entity.MyInteractiveBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/31.
 */

public interface InteractiveModel {

    void getInteractive(MyNetCallback<MyInteractiveBean> callback);
}
