package apandatv.ui.module.pandaculture;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.RollVideoBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface PandaCultureContract {
    interface View extends BaseView<Presenter> {
      void showRollVideoBean(RollVideoBean rollVideoBean);
      void setError(String msg);
      void setlbo();
    }

    interface Presenter extends BasePresenter {

    }
}
