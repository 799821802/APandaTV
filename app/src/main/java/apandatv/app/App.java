package apandatv.app;

import android.app.Application;

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
}
