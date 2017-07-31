package apandatv.ui.module.pandalive;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.PandaLiveTextBean;

/**
 * Created by Administrator on 2017/7/29.
 *
 */

public class PandaLiveContrrat {

    interface View extends BaseView<Presenter> {



        void getData(PandaLiveTextBean pandaLiveTextBean);//网络请求成功



    }

    interface Presenter extends BasePresenter {
            ArrayList<Fragment> getFragment();

    }


}
