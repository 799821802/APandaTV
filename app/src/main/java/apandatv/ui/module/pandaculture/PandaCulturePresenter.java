package apandatv.ui.module.pandaculture;

import apandatv.model.biz.pandaculturebiz.PandaCultureModel;
import apandatv.model.biz.pandaculturebiz.PandaCultureModellmp;
import apandatv.model.entity.RollVideoBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class PandaCulturePresenter implements PandaCultureContract.Presenter {
    private PandaCultureContract.View view;
    private PandaCultureModel model;

    public PandaCulturePresenter(PandaCultureContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        model = new PandaCultureModellmp();
    }

    @Override
    public void start() {
        model.getRollVideoBean(new MyNetCallback<RollVideoBean>() {
            @Override
            public void onSuccess(RollVideoBean rollVideoBean) {
                view.showRollVideoBean(rollVideoBean);
                view.setlbo();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }


        });
    }
}
