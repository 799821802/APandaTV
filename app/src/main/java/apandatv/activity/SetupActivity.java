package apandatv.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.app.App;
import apandatv.base.BaseActivity;
import apandatv.utils.CleanMessageUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/1.
 * 设置
 */

public class SetupActivity extends BaseActivity {
    @BindView(R.id.person_set_image)
    ImageView personSetImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_qita)
    TextView tvQita;
    @BindView(R.id.pe_set_push_view)
    CheckBox peSetPushView;
    @BindView(R.id.pe_set_play_view)
    CheckBox peSetPlayView;
    @BindView(R.id.tv_M)
    TextView tvM;
    @BindView(R.id.set_cache_size_tv)
    TextView setCacheSizeTv;
    @BindView(R.id.personal_set_delete_cache_layout)
    RelativeLayout personalSetDeleteCacheLayout;
    @BindView(R.id.personal_set_fankui_layout)
    RelativeLayout personalSetFankuiLayout;
    @BindView(R.id.personal_set_udpate_layout)
    RelativeLayout personalSetUdpateLayout;
    @BindView(R.id.personal_set_ping_layout)
    RelativeLayout personalSetPingLayout;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.personal_set_about_layout)
    RelativeLayout personalSetAboutLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setup;
    }

    @Override
    protected void init() {

    }



    @OnClick({R.id.person_set_image, R.id.toolbar, R.id.tv_qita, R.id.pe_set_push_view, R.id.pe_set_play_view, R.id.tv_M, R.id.set_cache_size_tv, R.id.personal_set_delete_cache_layout, R.id.personal_set_fankui_layout, R.id.personal_set_udpate_layout, R.id.personal_set_ping_layout, R.id.textView, R.id.personal_set_about_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_set_image:

                SetupActivity.this.finish();

                break;
            case R.id.toolbar:
                break;
            case R.id.tv_qita:
                break;
            case R.id.pe_set_push_view:
                break;
            case R.id.pe_set_play_view:
                break;
            case R.id.tv_M:
                break;
            case R.id.set_cache_size_tv:

                onClickCleanCache();

                break;
            case R.id.personal_set_delete_cache_layout:
                break;
            case R.id.personal_set_fankui_layout:
                break;
            case R.id.personal_set_udpate_layout:
                break;
            case R.id.personal_set_ping_layout:
                break;
            case R.id.textView:
                Intent intent = new Intent(SetupActivity.this,PersonAboutActivity.class);
                startActivity(intent);

                break;
            case R.id.personal_set_about_layout:
                break;
        }
    }
    private void onClickCleanCache() {
        getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CleanMessageUtil.clearAllCache(App.context);
                tvM.setText("0.00MB");
            }
        }).show();
    }

    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }
}
