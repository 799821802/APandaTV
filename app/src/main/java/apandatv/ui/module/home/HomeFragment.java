package apandatv.ui.module.home;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseFragment;
import apandatv.config.Keys;
import apandatv.model.db.dbhistroy.DaoMaster;
import apandatv.model.db.dbhistroy.DaoSession;
import apandatv.model.db.dbhistroy.MyHistroy;
import apandatv.model.db.dbhistroy.MyHistroyDao;
import apandatv.model.entity.HomeCctvBean;
import apandatv.model.entity.HomeGuangChinaBean;
import apandatv.model.entity.HomePandaeyeBean;
import apandatv.model.entity.PandaHome;
import apandatv.ui.module.home.adapter.HomeAdapter;
import apandatv.ui.module.interactive.InteractiveActivity;
import apandatv.ui.module.mine.activity.WebActivity;
import apandatv.ui.module.playvideo.VideoplayerActivity;
import apandatv.utils.LogUtils;
import apandatv.widget.manager.ToastManager;
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
        lists.add(pandaHome.getData().getChinalive());
        lists.add(pandaHome.getData().getInteractive());
        lists.add(pandaHome.getData().getCctv());
        lists.add(pandaHome.getData().getList().get(0));
        homeAdapter.notifyDataSetChanged();
        homeXrecyclerview.refreshComplete();

        setOnListener();
    }

    private void setOnListener() {

        homeAdapter.setOnIntemListener(new HomeAdapter.OnXRecyClickListener() {

            @Override
            public void getOnRatatiClick(int position, List<PandaHome.DataBean.BigImgBean> bigImgs) {

                String pid = bigImgs.get(position).getPid();
                String img = bigImgs.get(position).getImage();
                String title = bigImgs.get(position).getTitle();
                String time = bigImgs.get(position).getOrder();
                LogUtils.e("TAG","======="+pid+img+title+time);
                insertGreendao(new MyHistroy(null,img,title,time,pid));
                if(!"".equals(bigImgs.get(position).getPid())){
                    Intent intent = new Intent(getContext(),VideoplayerActivity.class);
                    intent.putExtra(Keys.VIDEO_IMG,img);
                    intent.putExtra(Keys.VIDEO_PID,pid);
                    intent.putExtra(Keys.VIDEO_TITLE,title);
                    startActivity(intent);
                }

            }


            @Override
            public void getOnwonderfulClick(PandaHome.DataBean.AreaBean.ListscrollBean home_data) {

                insertGreendao(new MyHistroy(null,home_data.getImage(),home_data.getTitle(),home_data.getOrder(),home_data.getPid()));
                Intent intent = new Intent(getContext(), VideoplayerActivity.class);
                intent.putExtra(Keys.VIDEO_IMG,home_data.getImage());
                intent.putExtra(Keys.VIDEO_PID,home_data.getPid());
                Log.e("tag===home_data.getPid()",home_data.getPid());
                intent.putExtra(Keys.VIDEO_TITLE,home_data.getTitle());

                startActivity(intent);
            }

            @Override
            public void getOnpandaneyeClick(View look_view, PandaHome.DataBean.PandaeyeBean.ItemsBean itemsBean) {
                ToastManager.show("3");

                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra(Keys.WEBKEY,itemsBean.getUrl());
                startActivity(intent);

            }

            @Override
            public void getOnPandaneyesecondClick(View look_view, PandaHome.DataBean.PandaeyeBean.ItemsBean second_itemsBean) {
                ToastManager.show("4");
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra(Keys.WEBKEY,second_itemsBean.getUrl());
                startActivity(intent);
            }

            @Override
            public void getOnPandaneyedownClick(HomePandaeyeBean.ListBean look_down_text) {
                ToastManager.show("5");
                String pid =  look_down_text.getPid();
                String img = look_down_text.getImage();
                String title = look_down_text.getTitle();
                String time =look_down_text.getOrder();
                insertGreendao(new MyHistroy(null,img,title,time,pid));
                Intent intent = new Intent(getContext(), VideoplayerActivity.class);
                intent.putExtra(Keys.VIDEO_IMG,img);
                intent.putExtra(Keys.VIDEO_PID,pid);
                intent.putExtra(Keys.VIDEO_TITLE,title);
                startActivity(intent);
            }

            @Override
            public void getOnPandaliveClick(PandaHome.DataBean.PandaliveBean.ListBean pandalivebean) {
//                ToastManager.show("熊猫直播");
            }

            @Override
            public void getOnWallliveClick(PandaHome.DataBean.WallliveBean.ListBeanX listBeanX) {
//                ToastManager.show("长城直播");
            }

            @Override
            public void getOnchinaliveClick(PandaHome.DataBean.ChinaliveBean.ListBeanXX listBeanXX) {
//                ToastManager.show("直播中国");
            }

            @Override
            public void getSpecialPlanningClick(View v, PandaHome.DataBean.InteractiveBean.InteractiveoneBean interactiveoneBean) {
                ToastManager.show("原创互动");
                startActivity(new Intent(getContext(), InteractiveActivity.class));
            }

            @Override
            public void getOnCctvLiveClick(HomeCctvBean.ListBean listBean) {
                ToastManager.show("cctv");
                String pid = listBean.getPid();
                String img = listBean.getImage();
                String title = listBean.getTitle();
                String time =listBean.getOrder();
                insertGreendao(new MyHistroy(null,img,title,time,pid));
//                Intent intent = new Intent(getContext(), VideoplayerActivity.class);
//                intent.putExtra(Keys.VIDEO_IMG,img);
//                intent.putExtra(Keys.VIDEO_PID,pid);
//                intent.putExtra(Keys.VIDEO_TITLE,title);
//                startActivity(intent);
            }

            @Override
            public void getOnGongyingClick(HomeGuangChinaBean.ListBean listBean) {
                ToastManager.show("光影中国");

                String pid = listBean.getPid();
                String img = listBean.getImage();
                String title = listBean.getTitle();
                String time =listBean.getOrder();
                insertGreendao(new MyHistroy(null,img,title,time,pid));
                Intent intent = new Intent(getContext(), VideoplayerActivity.class);
                intent.putExtra(Keys.VIDEO_IMG,img);
                intent.putExtra(Keys.VIDEO_PID,pid);
                intent.putExtra(Keys.VIDEO_TITLE,title);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showMessage(String msg) {
        LogUtils.e("TAG",msg);
    }

    @Override
    public void playVideo() {


    }

    @Override
    public void loadWebView() {


    }

    @Override
    public MyHistroyDao getGreendao() {

        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), "Histrogry.dp", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        MyHistroyDao histroyGreeDao = session.getMyHistroyDao();
        return histroyGreeDao;

    }

    @Override
    public List<MyHistroy> selectGreendao() {

        MyHistroyDao histroyDao = getGreendao();
        List<MyHistroy> list = histroyDao.queryBuilder().list();
        return list;
    }

    @Override
    public void insertGreendao(MyHistroy myHistroy) {

        MyHistroyDao greendao = getGreendao();
        greendao.insert(myHistroy);

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
