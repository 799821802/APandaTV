package apandatv.ui.module.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;

import apandatv.base.BaseActivity;
import apandatv.ui.module.mine.adapter.CollectionAdapter;
import apandatv.ui.module.mine.fragment.CollcetionLiveFragment;
import apandatv.ui.module.mine.fragment.CollectionLookFragment;
import apandatv.widget.view.MyViewPager;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/8/1.
 */

public class CollectionActivity extends BaseActivity {

    @BindView(R.id.collection_return)
    ImageView collectionReturn;
    @BindView(R.id.collection_bianji)
    TextView collectionBianji;
    @BindView(R.id.shoutoolbar)
    Toolbar shoutoolbar;
    @BindView(R.id.collection_tablayout)
    TabLayout collectionTablayout;
    @BindView(R.id.collection_viewpager)
    MyViewPager collectionViewpager;


    private CollcetionLiveFragment live_fragment;
    private CollectionLookFragment look_fragment;
    ArrayList<Fragment> arrayList;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void init() {

        arrayList = new ArrayList<>();
        live_fragment = new CollcetionLiveFragment();
        look_fragment = new CollectionLookFragment();
        arrayList.add(live_fragment);
        arrayList.add(look_fragment);

        CollectionAdapter adapter = new CollectionAdapter(getSupportFragmentManager(),arrayList);
        collectionViewpager.setAdapter(adapter);
        collectionTablayout.setupWithViewPager(collectionViewpager);
        collectionTablayout.setTabMode(TabLayout.MODE_FIXED);


    }

    @OnClick({R.id.collection_return, R.id.collection_bianji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collection_return:

                finish();
                break;
            case R.id.collection_bianji:


                break;
        }
    }
}
