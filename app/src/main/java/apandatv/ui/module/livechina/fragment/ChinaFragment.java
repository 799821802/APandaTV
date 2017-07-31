package apandatv.ui.module.livechina.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;
import java.util.ArrayList;
import java.util.List;
import apandatv.base.BaseFragment;
import apandatv.model.entity.ChinaItemBean;
import apandatv.ui.module.livechina.adapter.LiveChinaAdapter;
import apandatv.utils.LogUtils;
import apandatv.widget.view.CustomDialog;
import butterknife.BindView;

/**
 * Created by lenovo on 2017/7/30.
 */

public class ChinaFragment extends BaseFragment implements ChinaContract.View{


    private ChinaContract.Presenter presenter;
    @BindView(R.id.chinafragment_xrecycle)
    XRecyclerView chinafragmentXrecycle;
    private String url;
    private List<ChinaItemBean.LiveBean> chinaitemlist;
    private LiveChinaAdapter adapter;

    public ChinaFragment(String url) {
        this.url = url;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.china_fragment;
    }

    @Override
    protected void init(View view) {

        chinaitemlist = new ArrayList<>();
        setAdapter();
    }

    @Override
    protected void loadData() {

        new ChinaPresenter(url,this);
        presenter.start();

    }

    @Override
    public void showData(ChinaItemBean chinaItemBean) {

        chinaitemlist.addAll(chinaItemBean.getLive());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showMessage(String msg) {

        LogUtils.e("TAG",msg);
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
    public void setPresenter(ChinaContract.Presenter presenter) {

        this.presenter = presenter;
    }

    private void setAdapter() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        chinafragmentXrecycle.setLayoutManager(layoutManager);
        adapter = new LiveChinaAdapter(getActivity(), chinaitemlist);
        chinafragmentXrecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        chinafragmentXrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                adapter.notifyDataSetChanged();
                chinafragmentXrecycle.refreshComplete();
            }
            @Override
            public void onLoadMore() {

            }
        });
        chinafragmentXrecycle.setLoadingMoreEnabled(false);
    }
}
