package apandatv.ui.module.mine.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;
import java.util.List;

import apandatv.app.App;
import apandatv.base.BaseActivity;
import apandatv.model.db.dbcollection.DaoMaster;
import apandatv.model.db.dbcollection.DaoSession;
import apandatv.model.db.dbcollection.MyCollection;
import apandatv.model.db.dbcollection.MyCollectionDao;
import apandatv.ui.module.mine.adapter.CollectionAdapter;
import apandatv.ui.module.mine.adapter.HistoricalAdapter;
import butterknife.BindView;
import butterknife.OnClick;

import static com.jiyun.apandatv.R.id.collection_bianji;

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
    @BindView(collection_bianji)
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

    private List<MyCollection> collection_list = new ArrayList<>();
    private int number;
    private List<MyCollection> list;
    private CollectionAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 300:
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    protected int getLayoutId() {

        return R.layout.activity_collection;
    }

    @Override
    protected void init() {

        list = selectGreendao();
//        MyCollection myCollection = new MyCollection(100l,"","熊猫宝宝首次独立度夏 靠冰块消暑","2017-07-24 10:00","");
//        list.add(myCollection);
        collectionWhatRecycler.setLayoutManager(new LinearLayoutManager(App.context));
        adapter = new CollectionAdapter(App.context, list);
        collectionWhatRecycler.setAdapter(adapter);

        adapter.set_Onclick(new HistoricalAdapter.Onclick() {
            @Override
            public void get_Onclick(View view, int postion) {

                if (collectionBianji.getText().equals("取消")) {
                    if (collection_list.get(postion).isFlg_bulen() == false) {
                        collection_list.get(postion).setFlg_bulen(true);
                        number++;
                        collectionDeleteButton.setText("删除" + number);
                    } else {
                        number--;
                        collectionDeleteButton.setText("删除" + number);
                        collection_list.get(postion).setFlg_bulen(false);
                    }
                    if (number == 0) {
                        collectionDeleteButton.setText("删除");
                    }
                }else{
//                    Intent inten = new Intent(HistroyActivity.this,VideoplayerActivity.class);
//                    inten.putExtra("pid", his_list.get(postion).getMoviepath());
//                    inten.putExtra("video_title", his_list.get(postion).getName());
//                    inten.putExtra("video_imag", his_list.get(postion).getImagpath());
//                    startActivity(inten);
                }
                handler.sendEmptyMessage(300);
            }
        });
    }

    @OnClick({R.id.collection_all_button, R.id.collection_delete_button, R.id.collection_return, collection_bianji, R.id.collection_live, R.id.collection_what})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.collection_all_button:

                all_button();

                break;
            case R.id.collection_delete_button:

                delete_button();

                break;
            case R.id.collection_return:

                finish();

                break;
            case collection_bianji:

                bianji();

                break;
            case R.id.collection_live:

                collectionLive.setTextColor(getResources().getColor(R.color.cctv_tab_sel));
                collectionWhat.setTextColor(getResources().getColor(R.color.radio_black));
                collectionBianji.setVisibility(View.GONE);
                liveBottomBlue.setVisibility(View.VISIBLE);
                collectionLiveImg.setVisibility(View.VISIBLE);
                collectionWhatRecycler.setVisibility(View.GONE);
                break;
            case R.id.collection_what:

                collectionLive.setTextColor(getResources().getColor(R.color.radio_black));
                collectionWhat.setTextColor(getResources().getColor(R.color.cctv_tab_sel));
                collectionBianji.setVisibility(View.VISIBLE);
                whatBottomBlue.setVisibility(View.VISIBLE);
                collectionLiveImg.setVisibility(View.GONE);
                collectionWhatRecycler.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void bianji() {
        if (collectionBianji.getText().equals("编辑")) {
            collectionBianji.setText("取消");
            allDeleteLinear.setVisibility(View.VISIBLE);
            for (int i = 0; i < collection_list.size(); i++) {
                collection_list.get(i).setFlg(true);
            }
        } else if (collectionBianji.getText().equals("取消")) {

            collectionBianji.setText("编辑");
            allDeleteLinear.setVisibility(View.GONE);
            for (int i = 0; i < collection_list.size(); i++) {
                collection_list.get(i).setFlg(false);
            }
        }
        handler.sendEmptyMessage(300);
    }

    private void all_button() {
        if (collectionAllButton.getText().equals("全选")) {
            collectionAllButton.setText("取消全选");
            if (collectionBianji.getText().equals("取消")) {
                for (int i = 0; i < collection_list.size(); i++) {
                    collection_list.get(i).setFlg_bulen(true);
                }
                number = collection_list.size();
                collectionDeleteButton.setText("删除" + number);
            }
        } else {
            for (int i = 0; i < collection_list.size(); i++) {
                collection_list.get(i).setFlg_bulen(false);
            }
            number = 0;
            collectionDeleteButton.setText("删除");
            collectionAllButton.setText("全选");
        }
        handler.sendEmptyMessage(300);
    }

    private void delete_button() {

        if (collectionBianji.getText().equals("取消")) {
            for (int i = collection_list.size() - 1; i >= 0; i--) {
                if (collection_list.get(i).isFlg_bulen()) {

//                    greedao.delete(his_list.get(i));
                    collection_list.remove(i);
                }
            }
            number = 0;
            handler.sendEmptyMessage(300);
            collectionDeleteButton.setText("删除");

            if (collection_list.size() == 0) {
                allDeleteLinear.setVisibility(View.GONE);

                collectionBianji.setVisibility(View.GONE);
            }
        }
    }

    //查询收藏数据库
    private List<MyCollection> selectGreendao(){
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(App.context,"Collection.db",null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        MyCollectionDao myCollectionDao = daoSession.getMyCollectionDao();
        List<MyCollection> list = myCollectionDao.queryBuilder().list();

        return list;
    }
}
