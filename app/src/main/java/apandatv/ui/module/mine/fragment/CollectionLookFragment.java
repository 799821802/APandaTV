package apandatv.ui.module.mine.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiyun.apandatv.R;

import apandatv.base.BaseFragment;
import butterknife.BindView;

/**
 * Created by lenovo on 2017/8/1.
 */

public class CollectionLookFragment extends BaseFragment {


    @BindView(R.id.collectionlook_recycler)
    RecyclerView collectionlookRecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.collectionlook_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }
}
