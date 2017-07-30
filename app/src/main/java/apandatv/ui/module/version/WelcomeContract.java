package apandatv.ui.module.version;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.UpDateLoading;

/**
 * Created by lenovo on 2017/7/30.
 */

public interface WelcomeContract {

    interface View extends BaseView<Presenter>{

        void getVersion(UpDateLoading upDateLoading);
        void toMain();

    }

    interface Presenter extends BasePresenter{

    }
}
