package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivelook;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaLiveLook;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LookTalkContral {
    interface View extends BaseView<Presenter> {


        void  getData(PandaLiveLook pandaLiveLook);

    }

    interface Presenter extends BasePresenter {



    }



}
