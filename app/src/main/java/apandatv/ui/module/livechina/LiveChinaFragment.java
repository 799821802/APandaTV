package apandatv.ui.module.livechina;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseFragment;
import apandatv.model.entity.LiveChinaBean;
import apandatv.ui.module.livechina.adapter.ChageGridViewAdapter;
import apandatv.ui.module.livechina.adapter.ChinaTablayoutAdapter;
import apandatv.ui.module.livechina.adapter.MoreGridViewAdapter;
import apandatv.ui.module.livechina.fragment.ChinaFragment;
import apandatv.utils.LogUtils;
import apandatv.widget.manager.ToastManager;
import apandatv.widget.view.CustomDialog;
import apandatv.widget.view.MyViewPager;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * 直播中国
 * Created by lenovo on 2017/7/27.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View, View.OnClickListener {

    @BindView(R.id.livechina_tablayout)
    TabLayout livechinaTablayout;
    @BindView(R.id.livechina_add)
    ImageView livechinaAdd;
    @BindView(R.id.livechina_tablayoutlin)
    LinearLayout livechinaTablayoutlin;
    @BindView(R.id.livechina_myviewpager)
    MyViewPager livechinaMyviewpager;
    @BindView(R.id.livechina_fragment)
    LinearLayout livechinaFragment;
    private LiveChinaContract.Presenter presenter;
    private List<LiveChinaBean.TablistBean> tablist;
    private List<LiveChinaBean.AlllistBean> alllist;
    private List<Fragment> fragmentlist;
    private ChinaTablayoutAdapter adapter;
    //弹出 Popwindow  动画
    private PopupWindow pop;
    private TextView tuodong;
    private ImageView delectpop;
    private GridView moreGridview, changeGridview;
    private TextView edit_text;
    private ChageGridViewAdapter chagegridViewadapter;
    private MoreGridViewAdapter moregridViewadapter;

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
        adapter.notifyDataSetChanged();

        livechinaTablayout.setupWithViewPager(livechinaMyviewpager);
        livechinaTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    public void getLivechina(LiveChinaBean liveChinaBean) {

        // tablayout
        tablist.addAll(liveChinaBean.getTablist());
        // popwindow
        alllist.addAll(liveChinaBean.getAlllist());
        LogUtils.e("TAG", alllist.size() + "");
//        Fragment  数量
        for (int i = 0; i < tablist.size(); i++) {
            ChinaFragment chinafragment = new ChinaFragment(tablist.get(i).getUrl());
            fragmentlist.add(chinafragment);
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

        final View popview = getActivity().getLayoutInflater().inflate(R.layout.popwindow_grid, null);
        pop = new PopupWindow(popview, RecyclerView.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        pop.showAtLocation(livechinaFragment, Gravity.NO_GRAVITY, 0, 0);

        moreGridview = (GridView) popview.findViewById(R.id.more_gridview);
        changeGridview = (GridView) popview.findViewById(R.id.change_gridview);
        delectpop = (ImageView) popview.findViewById(R.id.livechina_delectpop);
        tuodong = (TextView) popview.findViewById(R.id.tuodong);
        edit_text= (TextView) popview.findViewById(R.id.edtix_button);
        delectpop.setOnClickListener(this);
        edit_text.setOnClickListener(this);

        chagegridViewadapter = new ChageGridViewAdapter(getActivity(),tablist);
        changeGridview.setAdapter(chagegridViewadapter);

        moregridViewadapter = new MoreGridViewAdapter(getActivity(),alllist);
        moreGridview.setAdapter(moregridViewadapter);
    }

    @Override
    public void setOnChageGridItem() {

        tuodong.setVisibility(View.VISIBLE);
        changeGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (tablist.size() > 4) {
                    LiveChinaBean.AlllistBean down_array = new LiveChinaBean.AlllistBean();
                    down_array.setTitle(tablist.get(position).getTitle());
                    down_array.setOrder(tablist.get(position).getOrder());
                    down_array.setType(tablist.get(position).getType());
                    down_array.setUrl(tablist.get(position).getUrl());
                    alllist.add(down_array);
                    tablist.remove(position);
                    chagegridViewadapter.notifyDataSetChanged();
                    moregridViewadapter.notifyDataSetChanged();
                }else{
                    ToastManager.show("栏目区，不能少于四个频道");
                }

            }
        });
    }

    @Override
    public void setOnMoreGridItem() {

        tuodong.setVisibility(View.GONE);
        moreGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LiveChinaBean.TablistBean UP_array = new LiveChinaBean.TablistBean();
                UP_array.setTitle(alllist.get(position).getTitle());
                UP_array.setOrder(alllist.get(position).getOrder());
                UP_array.setFlg(true);
                UP_array.setType(alllist.get(position).getType());
                UP_array.setUrl(alllist.get(position).getUrl());
                tablist.add(UP_array);
                alllist.remove(position);
                moregridViewadapter.notifyDataSetChanged();
                chagegridViewadapter.notifyDataSetChanged();

            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.livechina_delectpop:

                pop.dismiss();
                adapter.notifyDataSetChanged();
                break;
            case R.id.edtix_button:

                if ("编辑".equals(edit_text.getText())) {
                    for (int i = 0; i < tablist.size(); i++) {
                        tablist.get(i).setFlg(true);
                    }
                    edit_text.setText("完成");

                    setOnChageGridItem();
                    setOnMoreGridItem();

                } else {
                    edit_text.setText("编辑");
                    changeGridview.setEnabled(false);
                    moreGridview.setEnabled(false);
                    for (int i = 0; i < tablist.size(); i++) {
                        tablist.get(i).setFlg(false);
                    }
//                        重新 NEW  Fragment
                    fragmentlist.clear();
                    for (int i = 0; i < tablist.size(); i++) {
                        ChinaFragment chinafragment = new ChinaFragment(tablist.get(i).getUrl());
                        fragmentlist.add(chinafragment);
                    }
                    chagegridViewadapter.notifyDataSetChanged();
                    moregridViewadapter.notifyDataSetChanged();
                }
        }
    }
}
