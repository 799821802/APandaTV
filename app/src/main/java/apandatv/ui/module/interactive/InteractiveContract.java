package apandatv.ui.module.interactive;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.MyInteractiveBean;

/**
 * Created by lenovo on 2017/7/31.
 */

public interface InteractiveContract {

    interface View extends BaseView<Presenter>{

        void getData(MyInteractiveBean myInteractiveBean);
        void getMessage(String msg);
        void toWebview();

    }
    interface Presenter extends BasePresenter{


    }
}
