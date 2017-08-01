package apandatv.ui.module.mine.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/8/1.
 */

public class CollectionActivity extends BaseActivity {


    @BindView(R.id.collection_all_button)
    TextView collectionAllButton;
    @BindView(R.id.collection_delete_button)
    TextView collectionDeleteButton;
    @BindView(R.id.all_delete_linear)
    LinearLayout allDeleteLinear;
    @BindView(R.id.collection_return)
    ImageView collectionReturn;
    @BindView(R.id.collection_bianji)
    TextView collectionBianji;
    @BindView(R.id.shoutoolbar)
    Toolbar shoutoolbar;
    @BindView(R.id.collection_live)
    TextView collectionLive;
    @BindView(R.id.collection_what)
    TextView collectionWhat;
    @BindView(R.id.live_bottom_blue)
    TextView liveBottomBlue;
    @BindView(R.id.what_bottom_blue)
    TextView whatBottomBlue;
    @BindView(R.id.collection_buttom_blue)
    LinearLayout collectionButtomBlue;
    @BindView(R.id.collection_live_img)
    ImageView collectionLiveImg;
    @BindView(R.id.collection_what_recycler)
    RecyclerView collectionWhatRecycler;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_collection;
    }

    @Override
    protected void init() {


    }

    @OnClick({R.id.collection_all_button, R.id.collection_delete_button, R.id.collection_return, R.id.collection_bianji, R.id.collection_live, R.id.collection_what})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collection_all_button:



                break;
            case R.id.collection_delete_button:
                break;
            case R.id.collection_return:

                finish();
                break;
            case R.id.collection_bianji:

                allDeleteLinear.setVisibility(View.VISIBLE);

                break;
            case R.id.collection_live:

                collectionBianji.setVisibility(View.GONE);
                liveBottomBlue.setVisibility(View.VISIBLE);
                whatBottomBlue.setVisibility(View.GONE);
                collectionWhatRecycler.setVisibility(View.GONE);
                break;
            case R.id.collection_what:

                collectionBianji.setVisibility(View.VISIBLE);
                whatBottomBlue.setVisibility(View.VISIBLE);
                liveBottomBlue.setVisibility(View.GONE);
                collectionLiveImg.setVisibility(View.GONE);
                collectionWhatRecycler.setVisibility(View.VISIBLE);
                break;
        }
    }
}
