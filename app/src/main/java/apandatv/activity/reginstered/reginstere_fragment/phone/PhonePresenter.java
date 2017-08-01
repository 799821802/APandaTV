package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import apandatv.app.App;
import apandatv.config.Urls;
import apandatv.model.biz.loginandregin.ReginsModel;
import apandatv.model.biz.loginandregin.ReginsModelImpl;
import apandatv.net.OkHttpUtils;
import apandatv.utils.LogUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class PhonePresenter implements PhoneContart.Presenter {

    private PhoneContart.View view;

    private ReginsModel reginsModel;


    public PhonePresenter(PhoneContart.View view) {

        this.view = view;
        view.setPresenter(this);
        this.reginsModel = new ReginsModelImpl();


    }


    @Override
    public void start() {

    }

//    获取验证码 的 图片
    @Override
    public void getGraphicvalidation() {

        OkHttpUtils.getInstance().getImage(Urls.LOGINiMAGE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();

                String jsonId = headers.get("Set-Cookie");
//                存入本地存储
                OkHttpUtils.getInstance().saveCookie(jsonId);

                final byte[] bytes = response.body().bytes();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

                        Bitmap bitmap = BitmapFactory.decodeStream(byteArrayInputStream);

                        view.getImag(bitmap);
                    }
                });



            }
        });

    }

//    获取手机验证
OkHttpClient client;
    @Override
    public void getphonevalition(String jsonid, String phonenumber, String imagtion) {
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";

        client  = new OkHttpClient();

                RequestBody body = new FormBody.Builder()
                .add("method", "getRequestVerifiCodeM")
                .add("mobile", phonenumber)
                .add("verfiCodeType", "1")
                .add("verificationCode", imagtion)
                .build();

        try {

            Request request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", jsonid)
                    .post(body).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtils.e("TAG","返回手机验证码失败"+e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    LogUtils.e("TAG","手机注册 返回 手机验证码"+response.body().string());

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getphoneRe(String phone,String yanzhen,String passad) {
        try {
            RequestBody     body = new FormBody.Builder()
                    .add("method", "saveMobileRegisterM")
                    .add("mobile", phone)
                    .add("verfiCode", yanzhen)
                    .add("passWd", URLEncoder.encode(passad, "UTF-8"))
                    .add("verfiCodeType", "1")
                    .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .build();

            Request request = new Request.Builder()
                    .url("https://reg.cntv.cn/regist/mobileRegist.do")
                    .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("TAG", e.getMessage().toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String loginSate = response.body().string();

                    Log.e("TAG", "注册状态：：" + loginSate);
                    Toast.makeText(App.context, "注册成功", Toast.LENGTH_SHORT).show();

                }
            });

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


}
