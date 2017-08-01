package apandatv.net;


import android.app.ProgressDialog;
import android.widget.ImageView;

import java.io.File;
import java.util.Map;

import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/7/27.
 */

public interface IHttp {

    <T> void get(String url, MyNetCallback<T> callback);
    <T> void get(String url, Map<String, String> params, MyNetCallback<T> callback);

    //get请求  带有请求头headers
    <T> void get(String url, Map<String, String> params, Map<String, String> headers, MyNetCallback<T> callback);

    <T> void post(String url, Map<String, String> params, MyNetCallback<T> callback);

    void loadImage(String url, ImageView imageView);//加载图片
    void upload();//上传
    File download(String uri, ProgressDialog pd) throws Exception;//下载


}
