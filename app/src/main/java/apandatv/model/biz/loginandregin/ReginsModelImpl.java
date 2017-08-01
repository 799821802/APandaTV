package apandatv.model.biz.loginandregin;

import android.graphics.drawable.Drawable;

import apandatv.config.Urls;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ReginsModelImpl implements ReginsModel {


    @Override
    public void getGraphicvalidation(MyNetCallback<Drawable> myNetCallback) {

        iHttp.get(Urls.LOGINiMAGE, null, myNetCallback);

    }
}
