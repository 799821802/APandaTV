package apandatv.ui.module.home;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaHome;
import apandatv.ui.module.home.adapter.HomeAdapter;
import apandatv.utils.LogUtils;
import apandatv.widget.view.CustomDialog;
import butterknife.BindView;

/**
 * 首页
 * Created by lenovo on 2017/7/27.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View, XRecyclerView.LoadingListener {

    @BindView(R.id.home_xrecyclerview)
    XRecyclerView homeXrecyclerview;
    private HomeContract.Presenter presenter;
    private List<Object> lists;
    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init(View view) {

        lists = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeXrecyclerview.setLayoutManager(manager);
        homeXrecyclerview.setPullRefreshEnabled(true);
        homeXrecyclerview.setLoadingMoreEnabled(false);
        homeXrecyclerview.setLoadingListener(this);
        homeAdapter = new HomeAdapter(getContext(),lists);
        homeXrecyclerview.setAdapter(homeAdapter);
    }

    @Override
    protected void loadData() {

        presenter.start();
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
    public void setPresenter(HomeContract.Presenter presenter) {

        this.presenter = presenter;
    }


    @Override
    public void showHomeListData(PandaHome pandaHome) {

        lists.clear();
        lists.add(pandaHome.getData().getBigImg());
        lists.add(pandaHome.getData().getArea());
        lists.add(pandaHome.getData().getPandaeye());
        lists.add(pandaHome.getData().getPandalive());
        lists.add(pandaHome.getData().getWalllive());
        homeAdapter.notifyDataSetChanged();
        homeXrecyclerview.refreshComplete();
    }

    @Override
    public void showMessage(String msg) {
        LogUtils.e("TAG",msg);
    }

    @Override
    public void playVideo() {

//        Intent intent = new Intent();
    }

    @Override
    public void loadWebView() {


    }

    @Override
    public void onRefresh() {

        homeXrecyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.start();
                homeXrecyclerview.refreshComplete();
            }
        },1000);

    }

    @Override
    public void onLoadMore() {

    }
}
