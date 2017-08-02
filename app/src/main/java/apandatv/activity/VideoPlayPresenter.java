package apandatv.activity;

import apandatv.model.biz.videoplaybiz.VideoPlayModel;
import apandatv.model.biz.videoplaybiz.VideoPlayModelImpl;
import apandatv.model.entity.VideoPlayerBean;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by lenovo on 2017/8/1.
 */

public class VideoPlayPresenter implements VideoPlayContract.Presenter{

    private VideoPlayContract.View view;
    private VideoPlayModel model;
    String pid;

    public VideoPlayPresenter(String pid,VideoPlayContract.View view){

        this.view = view;
        view.setPresenter(this);
        model = new VideoPlayModelImpl();
        this.pid = pid;

    }

    @Override
    public void start() {

//        view.showProgress();
//       model.getVideoPlay(pid,new MyNetCallback<VideoPlayerBean>() {
//           @Override
//           public void onSuccess(VideoPlayerBean videoPlayerBean) {
//               view.getVideoBean(videoPlayerBean);
////               view.dimissProgress();
//           }
//
//           @Override
//           public void onError(int errorCode, String errorMsg) {
//
////               view.dimissProgress();
//           }
//       });
    }

    @Override
    public void showPid(String pid) {
        model.getVideoPlay(pid, new MyNetCallback<VideoPlayerBean>() {
            @Override
            public void onSuccess(VideoPlayerBean videoPlayerBean) {
                view.getVideoBean(videoPlayerBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
