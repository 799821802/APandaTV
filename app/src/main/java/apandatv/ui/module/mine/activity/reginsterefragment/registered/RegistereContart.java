package apandatv.ui.module.mine.activity.reginsterefragment.registered;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;

/**
 * Created by Administrator on 2017/8/1.
 */

public class RegistereContart {

    interface View extends BaseView<Presenter> {

    }
//
    interface Presenter extends BasePresenter {
    ArrayList<Fragment> getFragment();

    }


}
