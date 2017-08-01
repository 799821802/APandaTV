package apandatv.ui.module.home;


import java.util.List;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.db.dbhistroy.MyHistroy;
import apandatv.model.db.dbhistroy.MyHistroyDao;
import apandatv.model.entity.PandaHome;

/**
 * Created by lenovo on 2017/7/27.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void showHomeListData(PandaHome pandaHome);
        void showMessage(String msg);
        void playVideo();
        void loadWebView();
        MyHistroyDao getGreendao();
        List<MyHistroy> selectGreendao();
    }

    interface Presenter extends BasePresenter {


    }
}
