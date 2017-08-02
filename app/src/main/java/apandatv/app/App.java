package apandatv.app;

import android.app.Application;

//import com.umeng.message.IUmengRegisterCallback;
//import com.umeng.message.PushAgent;
//import com.umeng.socialize.PlatformConfig;

import apandatv.base.BaseActivity;


/**
 * Created by lenovo on 2017/7/27.
 */

public class App extends Application {


    public static BaseActivity context = null;


    @Override
    public void onCreate() {
        super.onCreate();
//        CrashHandler.getInstance().init(this);//初始化全局异常管理
//        PushAgent mPushAgent = PushAgent.getInstance(this);
////注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回device token
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//
//            }
//        });



    }
    {
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

}
