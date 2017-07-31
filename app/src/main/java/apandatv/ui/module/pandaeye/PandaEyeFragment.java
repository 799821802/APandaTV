package apandatv.ui.module.pandaeye;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaEye;
import apandatv.model.entity.PandaEyeXre;
import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 熊猫观察
 * Created by lenovo on 2017/7/27.
 */

public class PandaEyeFragment extends BaseFragment implements PandaEyeContrat.View {
    @BindView(R.id.xrecycle_pandeeyae)
    XRecyclerView xrecyclePandeeyae;
    Unbinder unbinder;


    ImageView pandaBroadcastTopviewImg;

    TextView pandaBroadcastTopviewTitle;

    private ArrayList<PandaEyeXre.ListBean> arrayList = new ArrayList<>();
    private  PandaEyeAdapter pandaEyeAdapter;

    private PandaEyeContrat.Presenter presenter;

    @Override
    protected int getLayoutId() {

        new PandaEyePresenter(this);
        return R.layout.pandaeye_fragment;

    }

    @Override
    protected void init(View view) {

        View heandview = LayoutInflater.from(App.context).inflate(R.layout.pandaheadeye, null);

        pandaBroadcastTopviewImg = (ImageView) heandview.findViewById(R.id.panda_broadcast_topview_img);
        pandaBroadcastTopviewTitle = (TextView) heandview.findViewById(R.id.panda_broadcast_topview_title);

        xrecyclePandeeyae.addHeaderView(heandview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.context);
        xrecyclePandeeyae.setLayoutManager(linearLayoutManager);

        pandaEyeAdapter = new PandaEyeAdapter(getActivity(),arrayList);

        xrecyclePandeeyae.setAdapter(pandaEyeAdapter);


    }

    @Override
    protected void loadData() {

        presenter.start();
        presenter.getXrecY();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(PandaEyeContrat.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void getData(PandaEye pandaEye) {

        Glide.with(App.context).load(pandaEye.getData().getBigImg().get(0).getImage()).into(pandaBroadcastTopviewImg);

        pandaBroadcastTopviewTitle.setText(pandaEye.getData().getBigImg().get(0).getTitle());



    }

    @Override
    public void getxData(PandaEyeXre pandaEyeXre) {

        List<PandaEyeXre.ListBean> list = pandaEyeXre.getList();

        arrayList.addAll(list);

        pandaEyeAdapter.notifyDataSetChanged();

    }


}
