package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveOtherPresenter implements PandaLiveOtherContract.Presenter  {
    private PandaLiveOtherContract.View pandaliveview;

    private PandaLiveModel pandaLiveModel;

    public PandaLiveOtherPresenter(PandaLiveOtherContract.View pandaliveview) {
        this.pandaliveview = pandaliveview;
//        pandaliveview.setPresenter(this);
        this.pandaLiveModel = new PandaLiveModeLImpl();

    }


    @Override
    public void start() {

    }
}
