package apandatv.ui.module.livechina;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseFragment;
import apandatv.model.entity.LiveChinaBean;
import apandatv.ui.module.livechina.adapter.ChinaTablayoutAdapter;
import apandatv.ui.module.livechina.adapter.MoreGridViewAdapter;
import apandatv.ui.module.livechina.fragment.ChinaFragment;
import apandatv.ui.module.livechina.mygridview.MyGridAdapter;
import apandatv.utils.LogUtils;
import apandatv.widget.view.CustomDialog;
import apandatv.widget.view.MyViewPager;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * 直播中国
 * Created by lenovo on 2017/7/27.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View {

    @BindView(R.id.livechina_tablayout)
    TabLayout livechinaTablayout;
    @BindView(R.id.livechina_add)
    ImageView livechinaAdd;
    @BindView(R.id.livechina_tablayoutlin)
    LinearLayout livechinaTablayoutlin;
    @BindView(R.id.livechina_myviewpager)
    MyViewPager livechinaMyviewpager;
    private LiveChinaContract.Presenter presenter;
    private List<LiveChinaBean.TablistBean> tablist;
    private List<LiveChinaBean.AlllistBean> alllist;
    private List<Fragment> fragmentlist;
    private ChinaTablayoutAdapter adapter;

    //弹出 Popwindow  动画
    private ImageView dele_imag;
    private GridView gridView, more_gridView;
    private TextView enit_text;
    private MyGridAdapter gridView_adapter;
    private MoreGridViewAdapter more_gridView_adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {

        tablist = new ArrayList<>();
        alllist = new ArrayList<>();
        fragmentlist = new ArrayList<>();
    }

    @Override
    protected void loadData() {

        new LiveChinaPresenter(this);
        presenter.start();

        adapter = new ChinaTablayoutAdapter(getFragmentManager(), fragmentlist, tablist);
        livechinaMyviewpager.setAdapter(adapter);

        livechinaTablayout.setupWithViewPager(livechinaMyviewpager);
        livechinaTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        livechinaTablayout.setTabTextColors(R.color.colorPrimaryDark,R.color.black);

    }

    @Override
    public void getLivechina(LiveChinaBean liveChinaBean) {

        // tablayout
        tablist.addAll(liveChinaBean.getTablist());
        // popwindow
        alllist.addAll(liveChinaBean.getAlllist());
        LogUtils.e("TAG",alllist.size()+"");
//        Fragment  数量
        for (int i = 0; i < tablist.size(); i++) {
            ChinaFragment path_fragment = new ChinaFragment(tablist.get(i).getUrl());
            fragmentlist.add(path_fragment);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void getMessage(String msg) {

        LogUtils.e("TAG", msg);
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    public void showPop() {

    }

    @Override
    public void showProgress() {

        CustomDialog.getInsent().show(getContext());
    }

    @Override
    public void dimissProgress() {

        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @OnClick(R.id.livechina_add)
    public void onViewClicked() {

        showPop();
    }
}
