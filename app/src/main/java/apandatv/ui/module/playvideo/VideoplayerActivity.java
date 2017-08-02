package apandatv.ui.module.playvideo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.view.GestureDetector;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import apandatv.base.BaseActivity;
import apandatv.config.Keys;
import apandatv.model.db.dbcollection.DaoMaster;
import apandatv.model.db.dbcollection.DaoSession;
import apandatv.model.db.dbcollection.MyCollection;
import apandatv.model.db.dbcollection.MyCollectionDao;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.widget.manager.ToastManager;
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
    private String url;

    private List<VideoPlayerBean.VideoBean.Chapters2Bean> biaoqing_array = new ArrayList<>();
    private ArrayList<VideoPlayerBean.VideoBean.ChaptersBean> gaoqing_array = new ArrayList();
    @Override
    protected int getLayoutId() {
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        new VideoPlayPresenter(this);
        return R.layout.activity_videoplay;

    }

    @Override
    protected void init() {

        Intent intent = getIntent();
        video_title = intent.getStringExtra(Keys.VIDEO_TITLE);
        img = intent.getStringExtra(Keys.VIDEO_IMG);
        pid = intent.getStringExtra(Keys.VIDEO_PID);

        presenter.showPid(pid);
        presenter.start();

    }



    @Override
    public void videoShare() {

    }

    @Override
    public void videoCollection() {

    }
//    String s = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
    @Override
    public void getVideoBean(final VideoPlayerBean videoPlayerBean) {

        biaoqing_array.addAll(videoPlayerBean.getVideo().getChapters2());
        url = biaoqing_array.get(0).getUrl();
        jcVideo.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,video_title);
        jcVideo.startVideo();
//             高清地址
        List<VideoPlayerBean.VideoBean.ChaptersBean> chapters = videoPlayerBean.getVideo().getChapters();
        gaoqing_array.addAll(chapters);

        jcVideo.setMonitor(new JCVideoPlayerStandard.imgClickon() {
            @Override
            public void Share(View view) {
                share();
            }

            @Override
            public void CollectionMonitor(CompoundButton compoundButton, boolean b) {
                boolean checked = compoundButton.isChecked();

                if(checked == true) {

                    Toast.makeText(VideoplayerActivity.this, "已添加至收藏", Toast.LENGTH_SHORT).show();
                    insertGreendao(new MyCollection(null,img,video_title,"",pid));


                }else{
                    Toast.makeText(VideoplayerActivity.this, "已取消至收藏", Toast.LENGTH_SHORT).show();
                    deleteGreendao(new MyCollection(null,img,video_title,"",pid));
                }

            }

            @Override
            public void WatchthelistMonitor(View view) {

                ToastManager.show("列表");
            }

            @Override
            public void setgq() {
                jcVideo.setUp(gaoqing_array.get(0).getUrl()
                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoPlayerBean.getTitle());
                Glide.with(VideoplayerActivity.this)
                        .load(gaoqing_array.get(0).getImage())
                        .into(jcVideo.thumbImageView);
            }

            @Override
            public void setbq() {

            }
        });
    }

    @Override
    public MyCollectionDao getGreendao() {

        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this,"Collection.db",null);
        SQLiteDatabase database =  helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        MyCollectionDao collectionDao = session.getMyCollectionDao();
        return collectionDao;
    }

    @Override
    public void insertGreendao(MyCollection myCollection) {

        MyCollectionDao myCollectionDao = getGreendao();
        myCollectionDao.insert(myCollection);

    }

    @Override
    public void deleteGreendao(MyCollection myCollection) {
        MyCollectionDao myCollectionDao = getGreendao();
        myCollectionDao.delete(myCollection);
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
    protected void onResume() {
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
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
