package apandatv.ui.module.version;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.jiyun.apandatv.R;

import java.io.File;

import apandatv.activity.MainActivity;
import apandatv.app.App;
import apandatv.base.BaseActivity;
import apandatv.model.entity.UpDateLoading;

/**
 * Created by lenovo on 2017/7/30.
 */

public class WelcomeActivity extends BaseActivity implements WelcomeContract.View{

    private static int versionCode;
    private String vsinurl;
    private WelcomeContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {

        new WelcomePresenter(this);
        getAppVersionName(App.context);
        presenter.start();
    }

    @Override
    public void getVersion(UpDateLoading upDateLoading) {
        String versionsNum = upDateLoading.getData().getVersionsNum();
        vsinurl = upDateLoading.getData().getVersionsUrl();
        int versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            getShowDialog();
        } else {
            Toast.makeText(this, "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void toMain() {

        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
    @Override
    public void showDialogUpdate() {
        // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置提示框的标题
        builder.setTitle("版本升级").
                // 设置提示框的图标
                        setIcon(R.mipmap.ic_launcher).
                // 设置要显示的信息
                        setMessage("发现新版本！请及时更新").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "选择确定哦", 0).show();
                        dialog.dismiss();
                        presenter.loadNewVersionProgress(vsinurl);
//                        loadNewVersionProgress();//下载最新的版本程序

                    }
                }).
                // 设置取消按钮,null是什么都不做，并关闭对话框
                        setNegativeButton("取消",null);
        // 生产对话框
        AlertDialog  alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();
    }

    @Override
    public void getShowDialog() {
        new AlertDialog.Builder(this).setTitle("版本升级")//设置对话框标题

                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        dialog.dismiss();
                        showDialogUpdate();
                        dialog.dismiss();
                        toMain();

                    }
                }).setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {//添加返回按钮

            @Override
            public void onClick(DialogInterface dialog, int which) {//响应事件

                dialog.dismiss();
                toMain();
            }
        }).show();//在按键响应事件中显示此对话框
    }

    @Override
    public void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @Override
    public String getAppVersionName(Context context) {

        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
            Log.i("aaa", versionCode + "");
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.i("aaa", versionName);
        }
        return versionName;
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void setPresenter(WelcomeContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
