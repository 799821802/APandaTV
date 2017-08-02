package apandatv.ui.module.playvideo;

import apandatv.base.BasePresenter;
import apandatv.base.BaseView;
import apandatv.model.db.dbcollection.MyCollection;
import apandatv.model.db.dbcollection.MyCollectionDao;
import apandatv.model.entity.VideoPlayerBean;

/**
 * Created by lenovo on 2017/8/1.
 */

public interface VideoPlayContract {

    interface View extends BaseView<Presenter> {

        void videoShare();//视频分享
        void videoCollection();//视频收藏
        void getVideoBean(VideoPlayerBean videoPlayerBean);
        MyCollectionDao getGreendao();
        void insertGreendao(MyCollection myCollection);
        void deleteGreendao(MyCollection myCollection);

    }
    interface Presenter extends BasePresenter {

        void showPid(String pid);

    }
}
