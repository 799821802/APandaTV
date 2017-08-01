package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivemorelive;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaLiveMore;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MoreEyeLiveFragment extends BaseFragment implements MoreEyeLiveContrat.View {

    @BindView(R.id.multiviewlivefargment)
    RecyclerView multiviewlivefargment;
    Unbinder unbinder;
    private MoreEyeLiveContrat.Presenter presenter;

    @Override
    protected int getLayoutId() {
        new MoreEyeLivePresenter(this);
        return R.layout.multiviewlivefargment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        presenter.start();

    }

    @Override
    public void getData(PandaLiveMore pandaLiveMore) {
        PandaLiveMore pandamore = pandaLiveMore;

        final List<PandaLiveMore.ListBean> list = pandamore.getList();

        MoreLookAdapter moreLookAdapter = new MoreLookAdapter(getActivity(), list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(App.context, 3);

        multiviewlivefargment.setLayoutManager(gridLayoutManager);

        multiviewlivefargment.setAdapter(moreLookAdapter);


        moreLookAdapter.setMoreLookOnclick(new MoreLookAdapter.MoreLookOnclick() {
            @Override
            public void getMoreLookOnclick(View view, int postion) {

                Toast.makeText(App.context, list.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(MoreEyeLiveContrat.Presenter presenter) {
        this.presenter = presenter;
    }



}
