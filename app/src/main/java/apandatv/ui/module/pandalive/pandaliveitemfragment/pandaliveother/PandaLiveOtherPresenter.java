package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;
import apandatv.model.entity.PandaLiveOther;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveOtherPresenter implements PandaLiveOtherContract.Presenter {
    private PandaLiveOtherContract.View pandaliveview;

    private PandaLiveModel pandaLiveModel;

    public PandaLiveOtherPresenter(PandaLiveOtherContract.View pandaliveview) {
        this.pandaliveview = pandaliveview;
        pandaliveview.setPresenter(this);
        this.pandaLiveModel = new PandaLiveModeLImpl();

    }


    @Override
    public void start() {

    }

    @Override
    public void getOtherData(String url) {


        pandaLiveModel.getOtherLive(url, new MyNetCallback<PandaLiveOther>() {
            @Override
            public void onSuccess(PandaLiveOther pandaLiveLook) {
                    pandaliveview.getData(pandaLiveLook);



            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });



    }

}
