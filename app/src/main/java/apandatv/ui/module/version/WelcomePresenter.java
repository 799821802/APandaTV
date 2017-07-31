package apandatv.ui.module.version;

import android.app.ProgressDialog;
import android.util.Log;

import java.io.File;

import apandatv.app.App;
import apandatv.model.biz.IPandaHomeModel;
import apandatv.model.biz.PandaHomeModelImpl;
import apandatv.model.entity.UpDateLoading;
import apandatv.net.HttpFactroy;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/30.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View view;

    private IPandaHomeModel homeModel;
    public WelcomePresenter(WelcomeContract.View view){
        this.view = view;
        view.setPresenter(this);
        this.homeModel = new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        homeModel.loadVersion(new MyNetCallback<UpDateLoading>() {
            @Override
            public void onSuccess(UpDateLoading upDateLoading) {
                view.getVersion(upDateLoading);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void loadNewVersionProgress(String vsinurl) {
        final String uri = vsinurl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(App.context);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file =  HttpFactroy.create().download(uri,pd);
                    sleep(3000);
                    view.installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc", "下载失败");
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
