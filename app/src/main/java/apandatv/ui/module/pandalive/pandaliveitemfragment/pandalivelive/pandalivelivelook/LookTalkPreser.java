package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivelook;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;
import apandatv.model.entity.PandaLiveLook;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LookTalkPreser implements LookTalkContral.Presenter {

    private LookTalkContral.View view;
    private PandaLiveModel pandaLiveModel;

    public LookTalkPreser(LookTalkContral.View view){
        this.view=view;
        view.setPresenter(this);
        pandaLiveModel = new PandaLiveModeLImpl();
    }




    @Override
    public void start() {

        pandaLiveModel.getOandaLiveLook(new MyNetCallback<PandaLiveLook>() {
            @Override
            public void onSuccess(PandaLiveLook pandaLiveLook) {

                view.getData(pandaLiveLook);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }
}
