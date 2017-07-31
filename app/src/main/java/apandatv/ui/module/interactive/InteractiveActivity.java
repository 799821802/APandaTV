package apandatv.ui.module.interactive;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseActivity;
import apandatv.model.entity.MyInteractiveBean;
import apandatv.ui.module.interactive.adapter.InteractiveAdapter;
import apandatv.utils.LogUtils;
import apandatv.widget.view.CustomDialog;
import butterknife.BindView;
import butterknife.OnClick;

//互动
public class InteractiveActivity extends BaseActivity implements PullToRefreshListener, InteractiveContract.View {


    @BindView(R.id.yuanchuan_image)
    ImageView yuanchuanImage;
    @BindView(R.id.cehua_pullto)
    PullToRefreshRecyclerView cehuaPullto;
    private InteractiveAdapter adapter;
    private List<MyInteractiveBean.InteractiveBean> list;
    private InteractiveContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interactive;
    }

    @Override
    protected void init() {

        new InteractivePresenter(this);

        list = new ArrayList<>();
        adapter = new InteractiveAdapter(this, list);
        cehuaPullto.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        cehuaPullto.setLayoutManager(manager);

        cehuaPullto.setLoadingMoreEnabled(true);
        cehuaPullto.setPullRefreshEnabled(true);
        cehuaPullto.setPullToRefreshListener(this);
        presenter.start();

    }


    @OnClick(R.id.yuanchuan_image)
    public void onViewClicked() {

        this.finish();
    }

    @Override
    public void onRefresh() {

        cehuaPullto.postDelayed(new Runnable() {
            @Override
            public void run() {

                list.clear();
                presenter.start();
                adapter.notifyDataSetChanged();
                cehuaPullto.setRefreshComplete();
            }
        },1000);
    }

    @Override
    public void onLoadMore() {

        cehuaPullto.setLoadMoreComplete();
    }

    @Override
    public void getData(MyInteractiveBean myInteractiveBean) {

        list.addAll(myInteractiveBean.getInteractive());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getMessage(String msg) {
        LogUtils.e("TAG",msg);
    }

    @Override
    public void toWebview() {

    }

    @Override
    public void showProgress() {

        CustomDialog.getInsent().show(this);
    }

    @Override
    public void dimissProgress() {

        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void setPresenter(InteractiveContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
