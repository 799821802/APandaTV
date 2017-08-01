package apandatv.ui.module.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/1.
 */

public class CollectionAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> arrayList;
    String[]  arr = {"直播","精彩看点"};
    public CollectionAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.arrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return arr[position];

    }
}
