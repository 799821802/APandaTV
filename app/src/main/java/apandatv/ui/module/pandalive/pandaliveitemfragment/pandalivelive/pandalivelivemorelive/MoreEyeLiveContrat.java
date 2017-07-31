package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivemorelive;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaLiveMore;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MoreEyeLiveContrat  {
    interface View extends BaseView<Presenter> {

        void getData(PandaLiveMore pandaLiveMore);//网络请求成功


    }

    interface Presenter extends BasePresenter {



    }

}
