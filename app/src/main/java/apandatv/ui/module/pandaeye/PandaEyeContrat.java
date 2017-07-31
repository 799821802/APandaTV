package apandatv.ui.module.pandaeye;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaEye;
import apandatv.model.entity.PandaEyeXre;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaEyeContrat {

    interface View extends BaseView<Presenter> {

        void getData(PandaEye pandaEye);
        void getxData(PandaEyeXre pandaEyeXre);


    }

    interface Presenter extends BasePresenter {

        void getXrecY();


    }



}
