package apandatv.model.biz.loginandregin;

import android.graphics.drawable.Drawable;

import apandatv.model.biz.BaseModel;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface  ReginsModel extends BaseModel {

//获取图形验证的方法
    void getGraphicvalidation(MyNetCallback<Drawable> myNetCallback);

}
