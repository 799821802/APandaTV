package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaLiveOther;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveOtherContract {
    interface View extends BaseView<Presenter> {

        void getData(PandaLiveOther pandaLiveOther);

    }

    interface Presenter extends BasePresenter {

   void getOtherData(String url);


    }
}
