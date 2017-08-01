package apandatv.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import apandatv.app.App;
import apandatv.config.Keys;
import apandatv.net.callback.MyNetCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp网络请求工具类
 * Created by lenovo on 2017/7/27.
 */

public class OkHttpUtils implements IHttp {

    private OkHttpClient okHttpClient;
    //构造函数私有化
    private OkHttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkHttpUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static OkHttpUtils getInstance(){
        if(okHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }


//    生成的

    @Override
    public <T> void get(String url, MyNetCallback<T> callback) {



    }

    //    发送get请求
    @Override
    public <T> void get(String url, Map<String, String> params, final MyNetCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });

    }

    //发送get请求，带有请求头
    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> headers, final MyNetCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if(headers != null && headers.size() > 0){
            Set<String> keys = headers.keySet();
            for (String key : keys){
                String value = headers.get(key);
                builder.addHeader(key,value);
            }
        }
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    //发送post请求
    @Override
    public <T> void post(String url, Map<String, String> params, final MyNetCallback<T> callback) {

        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

//    短信验证码 的网络请求

public void getImage(String url, Callback callback ){

    Request request = new Request.Builder().url(url).build();

    okHttpClient.newCall(request).enqueue(callback);



}
//    本地存储 Cook 值的
    public void saveCookie(String value){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = cookie.edit();
        edit.putString("Cookie",value);
        edit.commit();
    }
//  读取本地存储
    public String getCookie() {
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String string = cookie.getString("Cookie", null);
        return string;
    }

    @Override
    public void loadImage(String url, ImageView imageView) {

        Glide.with(App.context).load(url).into(imageView);

    }

    @Override
    public void upload() {


    }

    @Override
    public File download(String uri,ProgressDialog pd) throws Exception{

        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = null;
                url = new URL(uri);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                //获取到文件的大小
                pd.setMax(conn.getContentLength());
                InputStream is = conn.getInputStream();
                long time = System.currentTimeMillis();//当前时间的毫秒数
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
                if (!file.exists())
                    file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                BufferedInputStream bis = new BufferedInputStream(is);
                byte[] buffer = new byte[1024];
                int len;
                int total = 0;

                while ((len = bis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                     total += len;
                    //获取当前下载量
                    pd.setProgress(total);
                }
                fos.close();
                bis.close();
                is.close();
            return file;

        } else {
            return null;
        }
    }


    public void loadImgCode(String url,final MyNetCallback<Bundle> callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                Headers headers = response.headers();
                String jsessionId =  headers.get("Set-Cookie");
//                for (int i = 0; i < headers.size(); i++){
//                    String name = headers.name(i);
//                    headers.get("Set-Cookie")
//                    MyLog.d("abc","name = "+name);
//                    if(name != null && name.contains("JSESSIONID") && !name.contains(";")){
//                        jsessionId = headers.get(name);
//                        break;
//                    }
//                }
                final Bundle bundle = new Bundle();
                bundle.putString(Keys.JSESSIONID,jsessionId);
                bundle.putByteArray(Keys.IMGCODE,bytes);

                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(bundle);
                    }
                });

            }
        });
    }









//    自动解析json至回调中的JavaBean

    private <T> T getGeneric(String jsonData,MyNetCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);

//        ACache aCache = ACache.get(App.context);
//        aCache.put(t.getClass().getSimpleName(), (Serializable) t);

        return t;
    }
}
