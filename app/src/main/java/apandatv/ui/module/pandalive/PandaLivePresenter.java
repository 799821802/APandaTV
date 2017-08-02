package apandatv.ui.module.pandalive;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import apandatv.model.biz.pandalivebiz.PandaLiveModeLImpl;
import apandatv.model.biz.pandalivebiz.PandaLiveModel;
import apandatv.model.entity.PandaLiveTextBean;
import apandatv.net.callback.MyNetCallback;
import apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.PandaLiveLiveFragment;
import apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother.PandaliveOtherFragment;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLivePresenter implements PandaLiveContrrat.Presenter {

    private PandaLiveContrrat.View pandaliveview;

    private PandaLiveModel pandaLiveModel;
    private ArrayList<Fragment> arraylist_fragment;
    private PandaLiveLiveFragment pandaLiveLiveFragment;
    private PandaliveOtherFragment pandaliveOtherFragment;



    public PandaLivePresenter(PandaLiveContrrat.View pandaliveview) {
        this.pandaliveview = pandaliveview;
        pandaliveview.setPresenter(this);
        this.pandaLiveModel = new PandaLiveModeLImpl();

    }


    @Override
    public void start() {


        pandaliveview.showProgress();
        pandaLiveModel.getPandaLive(new MyNetCallback<PandaLiveTextBean>() {
            @Override
            public void onSuccess(PandaLiveTextBean pandaLiveTextBean) {
                pandaliveview.getData(pandaLiveTextBean);
                pandaliveview.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandaliveview.dimissProgress();
            }
        });




    }


    @Override
    public ArrayList<Fragment> getFragment() {
        arraylist_fragment = new ArrayList<>();

        pandaLiveLiveFragment = new PandaLiveLiveFragment();


        String[] IDs = {"VSET100167216881", "VSET100332640004", "VSET100272959126", "VSET100340574858",
                "VSET100284428835", "VSET100237714751", "VSET100167308855", "VSET100219009515"};

        arraylist_fragment.add(pandaLiveLiveFragment);
        for (int i = 0; i < 8; i++) {
            pandaliveOtherFragment = new PandaliveOtherFragment(IDs[i]);
            arraylist_fragment.add(pandaliveOtherFragment);

        }

        return arraylist_fragment;
    }


}
