package apandatv.ui.module.mine.activity;

import android.content.Intent;
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

import apandatv.ui.module.playvideo.VideoplayerActivity;
import apandatv.app.App;
import apandatv.base.BaseActivity;
import apandatv.config.Keys;
import apandatv.model.db.dbhistroy.DaoMaster;
import apandatv.model.db.dbhistroy.DaoSession;
import apandatv.model.db.dbhistroy.MyHistroy;
import apandatv.model.db.dbhistroy.MyHistroyDao;
import apandatv.ui.module.mine.adapter.HistoricalAdapter;
import butterknife.BindView;
import butterknife.OnClick;

import static com.jiyun.apandatv.R.id.all_button;

/**
 * Created by lenovo on 2017/8/1.
 * 历史记录
 */

public class HistroyActivity extends BaseActivity {

    @BindView(R.id.histroy_retturn)
    ImageView histroyRetturn;
    @BindView(R.id.tv_bianji)
    TextView tvBianji;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(all_button)
    TextView allButton;
    @BindView(R.id.delete_button)
    TextView deleteButton;
    @BindView(R.id.all_delete_linear)
    LinearLayout allDeleteLinear;
    @BindView(R.id.historical_recycler)
    RecyclerView historicalRecycler;

    private ArrayList<MyHistroy> his_list = new ArrayList<>();

    private int number;
    private List<MyHistroy> list;
    private HistoricalAdapter h_adapter;
    private MyHistroyDao greedao;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 300:
                    h_adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_histroy;
    }

    @Override
    protected void init() {

        greedao = getGreendao();
        list = greedao.queryBuilder().list();
        his_list.addAll(list);

//        MyHistroy myHistroy = new MyHistroy(100l,"","熊猫宝宝首次独立度夏 靠冰块消暑","2017-07-24 10:00","");
//        his_list.add(myHistroy);
        historicalRecycler.setLayoutManager(new LinearLayoutManager(App.context));
        h_adapter = new HistoricalAdapter(App.context, his_list);
        historicalRecycler.setAdapter(h_adapter);

        h_adapter.set_Onclick(new HistoricalAdapter.Onclick() {
            @Override
            public void get_Onclick(View view, int postion) {

                if (tvBianji.getText().equals("取消")) {
                    if (his_list.get(postion).isFlg_bulen() == false) {
                        his_list.get(postion).setFlg_bulen(true);
                        number++;
                        deleteButton.setText("删除" + number);
                    } else {
                        number--;
                        deleteButton.setText("删除" + number);
                        his_list.get(postion).setFlg_bulen(false);
                    }
                    if (number == 0) {
                        deleteButton.setText("删除");
                    }
                }else{
                    Intent inten = new Intent(HistroyActivity.this,VideoplayerActivity.class);
                    inten.putExtra(Keys.VIDEO_PID, his_list.get(postion).getMoviepath());
                    inten.putExtra(Keys.VIDEO_TITLE, his_list.get(postion).getName());
                    inten.putExtra(Keys.VIDEO_IMG, his_list.get(postion).getImagpath());
                    startActivity(inten);
                }
                handler.sendEmptyMessage(300);
            }
        });
    }

    @OnClick({R.id.histroy_retturn, R.id.tv_bianji, all_button, R.id.delete_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.histroy_retturn:

                finish();
                break;
            case R.id.tv_bianji:

                bianji();

                break;
            case all_button:

                all_button();

                break;
            case R.id.delete_button:

                delete_button();

                break;
        }
    }

    private void delete_button() {

        if (tvBianji.getText().equals("取消")) {
            for (int i = his_list.size() - 1; i >= 0; i--) {
                if (his_list.get(i).isFlg_bulen()) {

                    greedao.delete(his_list.get(i));
                    his_list.remove(i);
                }
            }
            number = 0;
            handler.sendEmptyMessage(300);
            deleteButton.setText("删除");

            if (his_list.size() == 0) {
                allDeleteLinear.setVisibility(View.GONE);

                tvBianji.setVisibility(View.GONE);
//                hisImageWu.setVisibility(View.VISIBLE);
            }
        }
    }
    private void bianji() {

        if (tvBianji.getText().equals("编辑")) {
            tvBianji.setText("取消");
            allDeleteLinear.setVisibility(View.VISIBLE);
            for (int i = 0; i < his_list.size(); i++) {
                his_list.get(i).setFlg(true);
            }
        } else if (tvBianji.getText().equals("取消")) {

            tvBianji.setText("编辑");
            allDeleteLinear.setVisibility(View.GONE);
            for (int i = 0; i < his_list.size(); i++) {
                his_list.get(i).setFlg(false);
            }
        }
        handler.sendEmptyMessage(300);
    }

    private void all_button() {
        if (allButton.getText().equals("全选")) {
            allButton.setText("取消全选");
            if (tvBianji.getText().equals("取消")) {
                for (int i = 0; i < his_list.size(); i++) {
                    his_list.get(i).setFlg_bulen(true);
                }
                number = his_list.size();
                deleteButton.setText("删除" + number);
            }
        } else {
            for (int i = 0; i < his_list.size(); i++) {
                his_list.get(i).setFlg_bulen(false);
            }
            number = 0;
            deleteButton.setText("删除");
            allButton.setText("全选");
        }
         handler.sendEmptyMessage(300);
    }


    private MyHistroyDao getGreendao() {
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this, "Histrogry.dp", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        MyHistroyDao histroyGreeDao = session.getMyHistroyDao();
        return histroyGreeDao;
    }
}
