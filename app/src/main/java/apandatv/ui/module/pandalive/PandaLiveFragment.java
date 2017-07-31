package apandatv.ui.module.pandalive;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jiyun.apandatv.R;

import java.util.ArrayList;

import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaLiveTextBean;
import apandatv.ui.module.pandalive.pandaliveadapter.PandaLiveTablayadapter;
import apandatv.widget.view.MyViewViewPage;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 熊猫直播
 * Created by lenovo on 2017/7/27.
 */

public class PandaLiveFragment extends BaseFragment implements PandaLiveContrrat.View {
    @BindView(R.id.live_fragment_tablayout)
    TabLayout liveFragmentTablayout;

    @BindView(R.id.live_fragment_viewpager)
    MyViewViewPage liveFragmentViewpager;

    Unbinder unbinder;
    private PandaLiveContrrat.Presenter presenter;

    private ArrayList<PandaLiveTextBean.TablistBean> aray_table = new ArrayList();

    private PandaLiveTablayadapter pan_daapter;
    ArrayList<Fragment> fragment;


    @Override
    protected int getLayoutId() {
        new PandaLivePresenter(this);
        return R.layout.pandalive_fragment;

    }

    @Override
    protected void init(View view) {

        fragment = presenter.getFragment();


    }
    @Override
    protected void loadData() {
        presenter.start();

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(PandaLiveContrrat.Presenter presenter) {this.presenter = presenter;}


    //    获取数据
    @Override
    public void getData(PandaLiveTextBean pandaLiveTextBean) {


        aray_table.addAll(pandaLiveTextBean.getTablist());


        pan_daapter = new PandaLiveTablayadapter(getFragmentManager(), fragment, aray_table);
        liveFragmentViewpager.setAdapter(pan_daapter);
        liveFragmentViewpager.setOffscreenPageLimit(9);
        liveFragmentTablayout.setupWithViewPager(liveFragmentViewpager);
        liveFragmentTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);




    }


}


