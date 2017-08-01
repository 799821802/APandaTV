package apandatv.activity;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;
import apandatv.ui.module.home.HomeFragment;
import apandatv.ui.module.home.HomePresenter;
import apandatv.ui.module.interactive.InteractiveActivity;
import apandatv.ui.module.livechina.LiveChinaFragment;
import apandatv.ui.module.pandaculture.PandaCultureFragment;
import apandatv.ui.module.pandaeye.PandaEyeFragment;
import apandatv.ui.module.pandalive.PandaLiveFragment;
import apandatv.widget.manager.ToastManager;
import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homePage)
    RadioButton homePage;
    @BindView(R.id.homePandaLive)
    RadioButton homePandaLive;
    @BindView(R.id.homeRollVideo)
    RadioButton homeRollVideo;
    @BindView(R.id.homePandaBroadcast)
    RadioButton homePandaBroadcast;
    @BindView(R.id.homeLiveChina)
    RadioButton homeLiveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;

    public static final int HOMETYPE = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        HomeFragment homeFragment = (HomeFragment) changeFragment(HomeFragment.class,R.id.container,true,null,false);
        homePage.setBackgroundColor(getResources().getColor(R.color.hui));
        homePandaLive.setBackgroundColor(getResources().getColor(R.color.white));
        homeRollVideo.setBackgroundColor(getResources().getColor(R.color.white));
        homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.white));
        homeLiveChina.setBackgroundColor(getResources().getColor(R.color.white));
        new HomePresenter(homeFragment);
    }

    @OnClick({R.id.iconImg, R.id.personImg, R.id.titleTv, R.id.hudongImg, R.id.homePage, R.id.homePandaLive, R.id.homeRollVideo, R.id.homePandaBroadcast, R.id.homeLiveChina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iconImg:
                break;
            case R.id.personImg:

                startActivity(new Intent(this,PersonalcenterActivity.class));
                break;
            case R.id.titleTv:
                break;
            case R.id.hudongImg:

                startActivity(new Intent(this, InteractiveActivity.class));
                break;
            case R.id.homePage:
                showTitle(R.string.home_page,HOMETYPE);
                changeFragment(HomeFragment.class,R.id.container,true,null,false);

                homePage.setBackgroundColor(getResources().getColor(R.color.hui));
                homePandaLive.setBackgroundColor(getResources().getColor(R.color.white));
                homeRollVideo.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.white));
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.homePandaLive:
                showTitle(R.string.panda_live,0);
                changeFragment(PandaLiveFragment.class,R.id.container,true,null,false);

                homePage.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaLive.setBackgroundColor(getResources().getColor(R.color.hui));
                homeRollVideo.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.white));
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.homeRollVideo:
                showTitle(R.string.rolling_video,0);
                changeFragment(PandaCultureFragment.class,R.id.container,true,null,false);

                homePage.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaLive.setBackgroundColor(getResources().getColor(R.color.white));
                homeRollVideo.setBackgroundColor(getResources().getColor(R.color.hui));
                homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.white));
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.homePandaBroadcast:
                showTitle(R.string.panda_broadcast,0);
                changeFragment(PandaEyeFragment.class,R.id.container,true,null,false);

                homePage.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaLive.setBackgroundColor(getResources().getColor(R.color.white));
                homeRollVideo.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.hui));
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.homeLiveChina:
                showTitle(R.string.live_china,0);
                changeFragment(LiveChinaFragment.class,R.id.container,true,null,false);

                homePage.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaLive.setBackgroundColor(getResources().getColor(R.color.white));
                homeRollVideo.setBackgroundColor(getResources().getColor(R.color.white));
                homePandaBroadcast.setBackgroundColor(getResources().getColor(R.color.white));
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.hui));

                break;
        }
    }

    //显示隐藏标题栏中的标题
    private void showTitle(int title,int type){
        if(type == HOMETYPE){
            titleTv.setVisibility(View.GONE);
            iconImg.setVisibility(View.VISIBLE);
            hudongImg.setVisibility(View.VISIBLE);
        }else {
            titleTv.setVisibility(View.VISIBLE);
            titleTv.setText(title);
            iconImg.setVisibility(View.GONE);
            hudongImg.setVisibility(View.GONE);
        }
    }

    private long lastTime;
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTime < 2000){
            finish();
        }else {
            ToastManager.show("再按一次退出应用");
            lastTime = System.currentTimeMillis();
        }
    }
}
