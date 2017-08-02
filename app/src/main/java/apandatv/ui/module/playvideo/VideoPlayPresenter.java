package apandatv.ui.module.playvideo;

import apandatv.model.biz.videoplaybiz.VideoPlayModel;
import apandatv.model.biz.videoplaybiz.VideoPlayModelImpl;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.net.callback.MyNetCallback;
import apandatv.utils.LogUtils;

/**
 * Created by lenovo on 2017/8/1.
 */

public class VideoPlayPresenter implements VideoPlayContract.Presenter{

    private VideoPlayContract.View view;
    private VideoPlayModel model;


    public VideoPlayPresenter(VideoPlayContract.View view){

        this.view = view;
        this.view.setPresenter(this);
        model = new VideoPlayModelImpl();


    }

    @Override
    public void start() {



    }


    @Override
    public void showPid(String pid) {
        model.getVideoPlay(pid, new MyNetCallback<VideoPlayerBean>() {
            @Override
            public void onSuccess(VideoPlayerBean videoPlayerBean) {

                LogUtils.e("TAG",videoPlayerBean.toString());
                view.getVideoBean(videoPlayerBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                LogUtils.e("TAG",errorMsg);
            }
        });
    }
}
