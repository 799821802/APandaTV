package apandatv.app;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

import apandatv.base.BaseActivity;

/**
 * Created by lenovo on 2017/7/27.
 */

public class App extends Application {


    public static BaseActivity context = null;


    @Override
    public void onCreate() {
        super.onCreate();
    }
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

}
