package apandatv.widget.manager;

import android.widget.Toast;

import apandatv.app.App;


/**
 * Toast管理类
 *Created by lenovo on 2017/7/27.
 */

public class ToastManager {

    public static void show(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_LONG).show();
    }
}
