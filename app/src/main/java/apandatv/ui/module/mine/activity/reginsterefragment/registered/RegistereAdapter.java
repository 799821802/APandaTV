package apandatv.ui.module.mine.activity.reginsterefragment.registered;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/1.
 */

public class RegistereAdapter extends FragmentPagerAdapter {

    String[] arr = {"手机注册","邮箱注册"};
    ArrayList<Fragment> fragment;
    public RegistereAdapter(FragmentManager fm, ArrayList<Fragment> fragment) {
        super(fm);
        this.fragment=fragment;

    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
