package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import android.util.Log;
import android.view.View;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;

/**
 * Created by Administrator on 2017/7/29.
 * 熊猫直播中的其他fragment
 */

public class PandaliveOtherFragment extends BaseFragment {

    String id;

    public PandaliveOtherFragment(String id) {
            this.id = id;

        Log.e("TAG","这些ID"+id);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.pandaliveother;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }
}
