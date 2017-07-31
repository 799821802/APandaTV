package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseFragment;
import apandatv.config.Urls;
import apandatv.model.entity.PandaLiveOther;
import apandatv.utils.LogUtils;
import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/29.
 * 熊猫直播中的其他fragment
 */

public class PandaliveOtherFragment extends BaseFragment implements PandaLiveOtherContract.View {

    @BindView(R.id.pandalive_more_xrecycle)
    XRecyclerView pandaliveMoreXrecycle;

    private PandaLiveOtherContract.Presenter presenter;
    String id;
    String string = "&n=7&serviceId=panda&o=desc&of=time&p=";
    int page = 1;
    private List<PandaLiveOther.VideoBean> video = new ArrayList<>();
    private PandaOtherAdapter pandaOtherAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case  300:

                    pandaOtherAdapter.notifyDataSetChanged();
                    break;
            }

        }
    };


    public  PandaliveOtherFragment(String id) {

        this.id = id;

    }

    @Override
    protected int getLayoutId() {
        new PandaLiveOtherPresenter(this);
        return R.layout.pandaliveother;
    }

    @Override
    protected void init(View view) {

        LogUtils.e("TAG","刚开始的数据"+video.size());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.context);
        pandaliveMoreXrecycle.setLayoutManager(linearLayoutManager);
        pandaOtherAdapter = new PandaOtherAdapter(getActivity(), video);
        pandaliveMoreXrecycle.setAdapter(pandaOtherAdapter);
        pandaliveMoreXrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

                page++;

                presenter.getOtherData(Urls.PANDALIVEOTHR + "vsid=" + id + string + page);

                handler.sendEmptyMessage(300);
                pandaliveMoreXrecycle.refreshComplete();

            }
        });

    }

    @Override
    protected void loadData() {

        presenter.getOtherData(Urls.PANDALIVEOTHR + "vsid=" + id + string + page);

    }
    @Override
    public void getData(PandaLiveOther pandaLiveOther) {


        video.addAll(pandaLiveOther.getVideo());
        LogUtils.e("TAG","请求返回的 数据"+video.size());

        handler.sendEmptyMessage(300);

    }

    @Override
    public void showProgress() {
    }

    @Override
    public void dimissProgress() {
    }


    @Override
    public void setPresenter(PandaLiveOtherContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
