package apandatv.ui.module.interactive;

import apandatv.model.biz.interactivebiz.InteractiveModel;
import apandatv.model.biz.interactivebiz.InteractiveModelImpl;
import apandatv.model.entity.MyInteractiveBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/31.
 */

public class InteractivePresenter implements InteractiveContract.Presenter{

    private InteractiveContract.View view;
    private InteractiveModel model;
    public InteractivePresenter(InteractiveContract.View view){

        model = new InteractiveModelImpl();
        view.setPresenter(this);
        this.view = view;
    }

    @Override
    public void start() {

        view.showProgress();
        model.getInteractive(new MyNetCallback<MyInteractiveBean>() {
            @Override
            public void onSuccess(MyInteractiveBean myInteractiveBean) {
                view.getData(myInteractiveBean);
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
