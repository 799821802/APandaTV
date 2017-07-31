package apandatv.ui.module.version;

import android.content.Context;

import java.io.File;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.entity.UpDateLoading;

/**
 * Created by lenovo on 2017/7/30.
 */

public interface WelcomeContract {

    interface View extends BaseView<Presenter>{

        void getVersion(UpDateLoading upDateLoading);//获取版本
        void toMain();//跳转Mainactivity
        void showDialogUpdate();//显示对话框，提示更新确定或取消
        void getShowDialog();//显示进度条
        void installApk(File file);//安装
        String getAppVersionName(Context context);//获取版本名字

    }

    interface Presenter extends BasePresenter{

        void loadNewVersionProgress(String vsinurl);
    }
}
