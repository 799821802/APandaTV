package apandatv.ui.module.pandalive.pandaliveadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import apandatv.model.entity.PandaLiveTextBean;
import apandatv.utils.LogUtils;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveTablayadapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arraylist_fragment;
    List<PandaLiveTextBean.TablistBean> tablist;
    public PandaLiveTablayadapter(FragmentManager fm, ArrayList<Fragment> arraylist_fragment, List<PandaLiveTextBean.TablistBean> tablist) {
        super(fm);
        this.arraylist_fragment=arraylist_fragment;
        this.tablist = tablist;

        LogUtils.e("TAG","熊猫直播中的Tablayout的数量是"+tablist.size());
    }

    @Override
    public Fragment getItem(int position) {
        return arraylist_fragment.get(position);
    }

    @Override
    public int getCount() {
        return arraylist_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position).getTitle();
    }
}
