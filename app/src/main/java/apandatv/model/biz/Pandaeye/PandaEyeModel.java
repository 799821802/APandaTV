package apandatv.model.biz.Pandaeye;

import apandatv.model.biz.BaseModel;
import apandatv.model.entity.PandaEye;
import apandatv.model.entity.PandaEyeXre;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface PandaEyeModel extends BaseModel {

    void  getPandaEye(MyNetCallback<PandaEye> pandaEyeMyNetCallback);
    void  getPandaEyeXre(MyNetCallback<PandaEyeXre> pandaEyeMyNetCallback);

}
