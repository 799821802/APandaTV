package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;
import apandatv.model.entity.PandaLiveLive;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveLivePresenter implements PandaLiveLiveContract.Presenter {

    PandaLiveLiveContract.View pandalive;

    private PandaLiveModel pandaLiveModel;


    public PandaLiveLivePresenter(PandaLiveLiveContract.View pandalive) {

        this.pandalive = pandalive;

        pandalive.setPresenter(this);

        pandaLiveModel = new PandaLiveModeLImpl();

    }


    @Override
    public void start() {


        pandaLiveModel.getPandaLiveLive(new MyNetCallback<PandaLiveLive>() {
            @Override
            public void onSuccess(PandaLiveLive liveLive) {

                pandalive.getdata(liveLive);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }
}
