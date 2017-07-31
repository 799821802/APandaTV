package apandatv.model.biz.Pandaeye;

import apandatv.config.Urls;
import apandatv.model.entity.PandaEye;
import apandatv.model.entity.PandaEyeXre;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaEyeModelImpl implements PandaEyeModel {


    @Override
    public void getPandaEye(MyNetCallback<PandaEye> pandaEyeMyNetCallback) {
        iHttp.get(Urls.PANDAEYE, null, pandaEyeMyNetCallback);
    }

    @Override
    public void getPandaEyeXre(MyNetCallback<PandaEyeXre> pandaEyeMyNetCallback) {
        iHttp.get(Urls.PANDAEYEXrecy, null, pandaEyeMyNetCallback);
    }
}
