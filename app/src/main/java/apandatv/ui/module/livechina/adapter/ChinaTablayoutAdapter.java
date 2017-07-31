package apandatv.ui.module.livechina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import apandatv.model.entity.LiveChinaBean;

/**
 * Created by lenovo on 2017/7/31.
 */

public class ChinaTablayoutAdapter extends FragmentPagerAdapter {

    private List<Fragment> fargmet_array;
    private List<LiveChinaBean.TablistBean> tablistBeen_array;

    public ChinaTablayoutAdapter(FragmentManager fm, List<Fragment> fargmet_array,List<LiveChinaBean.TablistBean> tablistBeen_array) {
        super(fm);
        this.fargmet_array = fargmet_array;
        this.tablistBeen_array = tablistBeen_array;
    }


    @Override
    public Fragment getItem(int position) {
        return fargmet_array.get(position);
    }

    @Override
    public int getCount() {
        return fargmet_array.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablistBeen_array.get(position).getTitle();
    }


}
