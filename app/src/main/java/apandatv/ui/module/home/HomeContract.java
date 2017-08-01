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
        void playVideo();//跳转播放
        void loadWebView();//跳转至webview
        MyHistroyDao getGreendao();
        List<MyHistroy> selectGreendao();//查询数据局
        void insertGreendao(MyHistroy myHistroy);//插入数据
    }

    interface Presenter extends BasePresenter {


    }
}
