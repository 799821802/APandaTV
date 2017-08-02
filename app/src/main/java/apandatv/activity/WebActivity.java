package apandatv.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;
import apandatv.widget.cache.ACache;
import butterknife.BindView;

//
public class WebActivity extends BaseActivity {

    private WebSettings settings;
    private String stringurl;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void init() {
        settings =webview.getSettings();

        if(stringurl == null){


//            stringurl = getIntent().getStringExtra(Keys.WEBKEY);

        }else{


            ACache aCache = ACache.get(this);
            stringurl = aCache.getAsString("cache_url");

        }


        //      可以与什么交互
        settings.setJavaScriptEnabled(true);
//        将图片控制到适合webview的大小
        settings.setUseWideViewPort(true);

//        缩放至屏幕大小
        settings.setLoadWithOverviewMode(true);
        webview.loadUrl(stringurl);
    }



}
