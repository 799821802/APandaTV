package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import apandatv.app.App;
import apandatv.config.Urls;
import apandatv.model.biz.loginandregin.ReginsModel;
import apandatv.model.biz.loginandregin.ReginsModelImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

    @Override
    public void getGraphicvalidation() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Urls.LOGINiMAGE).build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                Headers headers = response.headers();

                String jsonId = headers.get("Set-Cookie");



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
}
