package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivemorelive;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;
import apandatv.model.entity.PandaLiveMore;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MoreEyeLivePresenter implements MoreEyeLiveContrat.Presenter {

    private MoreEyeLiveContrat.View view;
    private PandaLiveModel pandaLiveModel;


    public MoreEyeLivePresenter( MoreEyeLiveContrat.View view){
        this.view = view;
        view.setPresenter(this);
        pandaLiveModel = new PandaLiveModeLImpl();

    }


    @Override
    public void start() {


        pandaLiveModel.getPandaLiveMore(new MyNetCallback<PandaLiveMore>() {
            @Override
            public void onSuccess(PandaLiveMore pandaLiveMore) {
                view.getData(pandaLiveMore);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });



    }
}
