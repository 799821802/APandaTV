package apandatv.model.biz.pandaculturebiz;

import apandatv.model.entity.RollVideoBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by ASUS on 2017/7/31.
 */

public interface PandaCultureModel {
   void  getRollVideoBean(MyNetCallback<RollVideoBean> callBack);
}
