package apandatv.ui.module.pandalive.pandaliveadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaLiveLiveTablayAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arrfragment;
    ArrayList<String> tablearray;
    public PandaLiveLiveTablayAdapter(FragmentManager fm, ArrayList<Fragment> arrfragment, ArrayList<String> tablearray) {
        super(fm);
        this.arrfragment = arrfragment;
        this.tablearray =tablearray;
    }

    @Override
    public Fragment getItem(int position) {
        return arrfragment.get(position);
    }

    @Override
    public int getCount() {
        return arrfragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablearray.get(position);
    }
}
