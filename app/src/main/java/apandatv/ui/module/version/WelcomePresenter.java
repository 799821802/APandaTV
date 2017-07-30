package apandatv.ui.module.version;

import apandatv.model.biz.IPandaHomeModel;
import apandatv.model.biz.PandaHomeModelImpl;
import apandatv.model.entity.UpDateLoading;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/30.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View view;

    private IPandaHomeModel homeModel;
    public WelcomePresenter(WelcomeContract.View view){
        this.view = view;
        view.setPresenter(this);
        this.homeModel = new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        homeModel.loadVersion(new MyNetCallback<UpDateLoading>() {
            @Override
            public void onSuccess(UpDateLoading upDateLoading) {
                view.getVersion(upDateLoading);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
