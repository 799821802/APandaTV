package apandatv.ui.module.livechina.fragment;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.ChinaItemBean;

/**
 * Created by lenovo on 2017/7/30.
 */

public interface ChinaContract {

    interface View extends BaseView<Presenter> {

        void showData(ChinaItemBean chinaItemBean);
        void showMessage(String msg);

    }


    interface Presenter extends BasePresenter{

    }
}