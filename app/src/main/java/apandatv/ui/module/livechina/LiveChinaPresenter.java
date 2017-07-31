package apandatv.ui.module.livechina;

import apandatv.model.biz.ChinaLiveModelImpl;
import apandatv.model.biz.IChinaLiveModel;
import apandatv.model.entity.LiveChinaBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/28.
 */

public class LiveChinaPresenter implements LiveChinaContract.Presenter {


    private LiveChinaContract.View view;
    private IChinaLiveModel model;
    public LiveChinaPresenter(LiveChinaContract.View view){

        this.view = view;
        model = new ChinaLiveModelImpl();
        view.setPresenter(this);

    }

    @Override
    public void start() {

        view.showProgress();
        model.loadLiveChina(new MyNetCallback<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                view.getLivechina(liveChinaBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                view.getMessage(errorMsg);
                view.dimissProgress();
            }
        });
    }
}
