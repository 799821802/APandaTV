package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivelook;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaLiveLook;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LookTalkFragment extends BaseFragment implements LookTalkContral.View {

    @BindView(R.id.watchchat_pulltorefresh)
    XRecyclerView watchchatPulltorefresh;
    Unbinder unbinder;
    private LookTalkContral.Presenter preser;
    private ArrayList<PandaLiveLook.DataBean.ContentBean> arrarcont = new ArrayList<>();
    private LookTalkAdapter lookTalkAdapter;

    @Override
    protected int getLayoutId() {

        new LookTalkPreser(this);
        return R.layout.lookandtalk;

    }

    @Override
    protected void init(View view) {

        lookTalkAdapter = new LookTalkAdapter(getActivity(), arrarcont);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.context);
        watchchatPulltorefresh.setLayoutManager(linearLayoutManager);
        watchchatPulltorefresh.setAdapter(lookTalkAdapter);

        watchchatPulltorefresh.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {



            }
        });


    }

    @Override
    protected void loadData() {
        preser.start();
    }

    @Override
    public void getData(PandaLiveLook pandaLiveLook) {

        PandaLiveLook.DataBean data = pandaLiveLook.getData();

        List<PandaLiveLook.DataBean.ContentBean> content = data.getContent();
        arrarcont.addAll(content);
        lookTalkAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(LookTalkContral.Presenter preser) {
        this.preser = preser;
    }


}
