package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import apandatv.app.App;
import apandatv.config.Urls;
import apandatv.model.biz.loginandregin.ReginsModel;
import apandatv.model.biz.loginandregin.ReginsModelImpl;
import apandatv.net.OkHttpUtils;
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
    @Override
    public void getphonevalition(String jsonid, String phonenumber, String imagtion) {
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";

        OkHttpClient client = new OkHttpClient();

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

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getphoneRe() {

    }


}
