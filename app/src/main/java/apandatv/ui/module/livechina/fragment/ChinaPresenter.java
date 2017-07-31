package apandatv.ui.module.livechina.fragment;

import apandatv.model.biz.ChinaLiveModelImpl;
import apandatv.model.biz.IChinaLiveModel;
import apandatv.model.entity.ChinaItemBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/30.
 */

public class ChinaPresenter implements ChinaContract.Presenter {

    private ChinaContract.View view;
    private IChinaLiveModel model;
    private String url;

    public ChinaPresenter(String url,ChinaContract.View view){
        view.setPresenter(this);
        this.view = view;
        this.url = url;
        model = new ChinaLiveModelImpl();
    }
    @Override
    public void start() {

//        view.showProgress();
        model.LoadChinaItem(url, new MyNetCallback<ChinaItemBean>() {
            @Override
            public void onSuccess(ChinaItemBean chinaItemBean) {
                view.showData(chinaItemBean);
//                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                view.showMessage(errorMsg);
//                view.dimissProgress();
            }
        });
    }
}
