package apandatv.ui.module.livechina;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.LiveChinaBean;

/**
 * Created by lenovo on 2017/7/28.
 */

public interface LiveChinaContract {

    interface View extends BaseView<Presenter> {

        void getLivechina(LiveChinaBean liveChinaBean);
        void getMessage(String msg);
        void playVideo();
        void loadWebView();
        void showPop();
    }
    interface Presenter extends BasePresenter {

    }
}
