package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseFragment;
import apandatv.model.entity.PandaLiveLive;
import apandatv.ui.module.pandalive.pandaliveadapter.PandaLiveLiveTablayAdapter;
import apandatv.widget.view.MyViewViewPage;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.\
 * 熊猫直播中的直播
 */

public class PandaLiveLiveFragment extends BaseFragment implements PandaLiveLiveContract.View {

    //   直播中 的 图片
    @BindView(R.id.live_top_img)
    ImageView liveTopImg;
    //    正在直播
    @BindView(R.id.radio_title)
    TextView radioTitle;

    //    内容
    @BindView(R.id.tv_visibility)
    TextView tvVisibility;
    //    直播tablayout
    @BindView(R.id.live_center_tablayout)
    TabLayout liveCenterTablayout;
    //自定义的 ViewPage
    @BindView(R.id.live_bottom_viewpager)
    MyViewViewPage liveBottomViewpager;
    Unbinder unbinder;


    @BindView(R.id.live_center_blue_img_down)
    ImageView liveCenterBlueImgDown;

    @BindView(R.id.live_center_blue_img_up)
    ImageView liveCenterBlueImgUp;

    private PandaLiveLiveContract.Presenter presenter;
    private ArrayList<String>  tablearray = new ArrayList<>();
    private ArrayList<PandaLiveLive.LiveBean> arraylist = new ArrayList<>();


    ArrayList<Fragment> fragment;
    @Override
    protected int getLayoutId() {
        new PandaLiveLivePresenter(this);
        return R.layout.pandalivelive;
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
    public void setPresenter(PandaLiveLiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getdata(PandaLiveLive liveLive) {

        List<PandaLiveLive.LiveBean> live = liveLive.getLive();
        arraylist.addAll(live);


        Glide.with(App.context).load(live.get(0).getImage()).into(liveTopImg);
        radioTitle.setText(live.get(0).getTitle());
        tvVisibility.setText(live.get(0).getBrief());

        tablearray.add(liveLive.getBookmark().getMultiple().get(0).getTitle());
        tablearray.add(liveLive.getBookmark().getWatchTalk().get(0).getTitle());

        PandaLiveLiveTablayAdapter pandaLiveLiveTablayAdapter = new PandaLiveLiveTablayAdapter(getChildFragmentManager(),fragment,tablearray);
        liveBottomViewpager.setAdapter(pandaLiveLiveTablayAdapter);
        liveBottomViewpager.setOffscreenPageLimit(2);
        liveCenterTablayout.setupWithViewPager(liveBottomViewpager);
        liveCenterTablayout.setTabMode(TabLayout.MODE_FIXED);

    }


    @OnClick({R.id.live_center_blue_img_down, R.id.live_center_blue_img_up,R.id.panda_live_tv_imag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.live_center_blue_img_down:
                liveCenterBlueImgDown.setVisibility(View.GONE);
                tvVisibility.setVisibility(View.VISIBLE);
                liveCenterBlueImgUp.setVisibility(View.VISIBLE);

                break;
            case R.id.live_center_blue_img_up:
                liveCenterBlueImgDown.setVisibility(View.VISIBLE);
                liveCenterBlueImgUp.setVisibility(View.GONE);
                tvVisibility.setVisibility(View.GONE);
                break;

            case R.id.panda_live_tv_imag:

                Toast.makeText(App.context, arraylist.get(0).getTitle(), Toast.LENGTH_SHORT).show();

                break;


        }
    }
}
