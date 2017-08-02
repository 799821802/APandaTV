package apandatv.activity;

import android.content.Intent;
import android.view.GestureDetector;
import android.widget.RelativeLayout;

import com.jiyun.apandatv.R;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;

import apandatv.base.BaseActivity;
import apandatv.config.Keys;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.widget.view.CustomDialog;
import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

//import com.umeng.socialize.ShareAction;
//import com.umeng.socialize.UMShareAPI;
//import com.umeng.socialize.UMShareListener;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//import com.umeng.socialize.media.UMImage;

/**
 * Created by lenovo on 2017/8/1.
 */

public class VideoplayerActivity extends BaseActivity implements VideoPlayContract.View{

    @BindView(R.id.activity_report)
    RelativeLayout activityReport;
    private int k;
    private boolean ym=false;
    //手势
    private GestureDetector gestureDetector;
    //jicao..............
    @BindView(R.id.jc_video)
    JCVideoPlayerStandard jcVideo;
    private String video_title,img,pid;
    private VideoPlayContract.Presenter presenter;

    private ArrayList<VideoPlayerBean.VideoBean.Chapters4Bean> biaoqing_array = new ArrayList();
    private ArrayList<VideoPlayerBean.VideoBean.ChaptersBean> gaoqing_array = new ArrayList();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_videoplay;

    }

    @Override
    protected void init() {

        Intent intent = getIntent();
        video_title = intent.getStringExtra(Keys.VIDEO_TITLE);
        img = intent.getStringExtra(Keys.VIDEO_IMG);
        pid = intent.getStringExtra(Keys.VIDEO_PID);
        new VideoPlayPresenter(pid,this);

        play();
        presenter.showPid(pid);
        presenter.start();
    }

    private void play() {
        jcVideo.setUp(s
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "====");

    }


    @Override
    public void videoShare() {

    }

    @Override
    public void videoCollection() {

    }

    String s = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
    @Override
    public void getVideoBean(final VideoPlayerBean videoPlayerBean) {

//        LogUtils.e("TAG",videoPlayerBean.getVideo().getChapters3().size()+"-=-=-=-=-=-=-=");
//        biaoqing_array.addAll(videoPlayerBean.getVideo().getChapters4());
////        jcVideo.setUp(biaoqing_array.get(0).getUrl()
//                jcVideo.setUp(s
//                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "====");
//        HttpFactroy.create().loadImage(video_title,jcVideo.thumbImageView);
////             高清地址
//        List<VideoPlayerBean.VideoBean.ChaptersBean> chapters = videoPlayerBean.getVideo().getChapters();
//        gaoqing_array.addAll(chapters);
//
//        jcVideo.setMonitor(new JCVideoPlayerStandard.imgClickon() {
//            @Override
//            public void Share(View view) {
//                share();
//            }
//
//            @Override
//            public void CollectionMonitor(CompoundButton compoundButton, boolean b) {
//                boolean checked = compoundButton.isChecked();
//
//                if(checked == true) {
//                    Toast.makeText(VideoplayerActivity.this, "已添加至收藏", Toast.LENGTH_SHORT).show();
//
//
//                }else{
//                    Toast.makeText(VideoplayerActivity.this, "已取消至收藏", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void WatchthelistMonitor(View view) {
//
//                ToastManager.show("列表");
//            }
//
//            @Override
//            public void setgq() {
//                jcVideo.setUp(gaoqing_array.get(0).getUrl()
//                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoPlayerBean.getTitle());
//                Glide.with(VideoplayerActivity.this)
//                        .load(gaoqing_array.get(0).getImage())
//                        .into(jcVideo.thumbImageView);
//            }
//
//            @Override
//            public void setbq() {
//
//            }
//        });
    }

    @Override
    public void showProgress() {

        CustomDialog.getInsent().show(this);
    }

    @Override
    public void dimissProgress() {

        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void setPresenter(VideoPlayContract.Presenter presenter) {

        this.presenter = presenter;
    }

    private void share() {

//        UMImage image = new UMImage(VideoplayerActivity.this, img);
//
//        new ShareAction(VideoplayerActivity.this).withText(video_title + "!" + Urls.TV_Url + pid)
//                .withMedia(image)
//                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
//                .setCallback(new UMShareListener() {
//                    @Override
//                    public void onStart(SHARE_MEDIA share_media) {
//                        Log.e("TAG", "onStart");
//                    }
//
//                    @Override
//                    public void onResult(SHARE_MEDIA share_media) {
//
//                        Log.e("TAG", "onResult");
//
//                    }
//
//                    @Override
//                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
//
//                        Log.e("TAG", "onError");
//                    }
//
//                    @Override
//                    public void onCancel(SHARE_MEDIA share_media) {
//
//                        Log.e("TAG", "onCancel");
//                    }
//                }).open();
    }

    @Override
    public void onBackPressed() {
        if (jcVideo.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        jcVideo.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        jcVideo.clearSavedProgress(this, "");
    }

    //需回调此方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        UMShareAPI.get(VideoplayerActivity.this).onActivityResult(requestCode, resultCode, data);

    }
}
