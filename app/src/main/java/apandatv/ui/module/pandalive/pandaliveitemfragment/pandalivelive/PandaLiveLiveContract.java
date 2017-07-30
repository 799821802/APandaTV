package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaLiveLive;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveLiveContract   {

    interface View extends BaseView<Presenter> {


                void getdata(PandaLiveLive liveLive);


    }

    interface Presenter extends BasePresenter {



    }
}
