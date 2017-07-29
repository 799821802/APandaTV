package apandatv.ui.module.home;


import apandatv.model.biz.IPandaHomeModel;
import apandatv.model.biz.PandaHomeModelImpl;
import apandatv.model.entity.PandaHome;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/27.
 */

public class HomePresenter implements HomeContract.Presenter  {
    private HomeContract.View homeView;
    private IPandaHomeModel homeModel;
    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        homeView.setPresenter(this);
        this.homeModel = new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        homeView.showProgress();
        homeModel.loadHomeList(new MyNetCallback<PandaHome>() {
            @Override
            public void onSuccess(PandaHome pandaHome) {
                homeView.showHomeListData(pandaHome);
                homeView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeView.showMessage(errorMsg);
                homeView.dimissProgress();
            }
        });
    }
}
