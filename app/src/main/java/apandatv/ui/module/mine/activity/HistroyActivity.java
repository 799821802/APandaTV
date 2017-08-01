package apandatv.ui.module.mine.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.ArrayList;

import apandatv.base.BaseActivity;
import apandatv.model.db.dbhistroy.MyHistroy;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/8/1.
 */

public class HistroyActivity extends BaseActivity {

    @BindView(R.id.histroy_retturn)
    ImageView histroyRetturn;
    @BindView(R.id.tv_bianji)
    TextView tvBianji;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.all_button)
    TextView allButton;
    @BindView(R.id.delete_button)
    TextView deleteButton;
    @BindView(R.id.all_delete_linear)
    LinearLayout allDeleteLinear;
    @BindView(R.id.historical_recycler)
    RecyclerView historicalRecycler;

    private ArrayList<MyHistroy> his_list = new ArrayList<>();

    private int number;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_histroy;
    }

    @Override
    protected void init() {

    }

    @OnClick({R.id.histroy_retturn, R.id.tv_bianji, R.id.all_button, R.id.delete_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.histroy_retturn:

                finish();
                break;
            case R.id.tv_bianji:

                if (tvBianji.getText().equals("编辑")) {

                    tvBianji.setText("取消");
                    allDeleteLinear.setVisibility(View.VISIBLE);
                    for (int i = 0; i < his_list.size(); i++) {
                        his_list.get(i).setFlg(true);
                    }
//                    handler.sendEmptyMessage(300);
                } else if (tvBianji.getText().equals("取消")) {

                    tvBianji.setText("编辑");
                    allDeleteLinear.setVisibility(View.GONE);
                    for (int i = 0; i < his_list.size(); i++) {
                        his_list.get(i).setFlg(false);
                    }
//                    handler.sendEmptyMessage(300);
                }
                break;
            case R.id.all_button:

                if (allButton.getText().equals("全选")) {
                    allButton.setText("取消全选");
                    if (tvBianji.getText().equals("取消")) {
                        for (int i = 0; i < his_list.size(); i++) {
                            his_list.get(i).setFlg_bulen(true);
                        }
                        number = his_list.size();
                        deleteButton.setText("删除" + number);
//                        handler.sendEmptyMessage(300);
                    }
                } else {
                    for (int i = 0; i < his_list.size(); i++) {
                        his_list.get(i).setFlg_bulen(false);
                    }
                    number = 0;
                    deleteButton.setText("删除");
                    allButton.setText("全选");
//                    handler.sendEmptyMessage(300);
                }
                break;
            case R.id.delete_button:
                break;
        }
    }
}
