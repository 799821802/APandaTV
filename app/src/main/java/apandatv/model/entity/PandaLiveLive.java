package apandatv.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaLiveLive implements Parcelable {

    /**
     * live : [{"title":"成都基地高清精切线路","brief":"翻身、吃饭、睡觉、喝奶、打闹、攀爬\u2026\u2026这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg","id":"ipanda","isshow":"true","url":"http://live.ipanda.com/stream/"}]
     * bookmark : {"multiple":[{"title":"多视角直播","url":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json","order":"1"}],"watchTalk":[{"title":"边看边聊","url":"zhiboye_chat","order":"1"}]}
     */

    private BookmarkBean bookmark;
    private List<LiveBean> live;

    protected PandaLiveLive(Parcel in) {
    }

    public static final Creator<PandaLiveLive> CREATOR = new Creator<PandaLiveLive>() {
        @Override
        public PandaLiveLive createFromParcel(Parcel in) {
            return new PandaLiveLive(in);
        }

        @Override
        public PandaLiveLive[] newArray(int size) {
            return new PandaLiveLive[size];
        }
    };

    public BookmarkBean getBookmark() {
        return bookmark;
    }

    public void setBookmark(BookmarkBean bookmark) {
        this.bookmark = bookmark;
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class BookmarkBean implements Parcelable {
        private List<MultipleBean> multiple;
        private List<WatchTalkBean> watchTalk;

        protected BookmarkBean(Parcel in) {
        }

        public static final Creator<BookmarkBean> CREATOR = new Creator<BookmarkBean>() {
            @Override
            public BookmarkBean createFromParcel(Parcel in) {
                return new BookmarkBean(in);
            }

            @Override
            public BookmarkBean[] newArray(int size) {
                return new BookmarkBean[size];
            }
        };

        public List<MultipleBean> getMultiple() {
            return multiple;
        }

        public void setMultiple(List<MultipleBean> multiple) {
            this.multiple = multiple;
        }

        public List<WatchTalkBean> getWatchTalk() {
            return watchTalk;
        }

        public void setWatchTalk(List<WatchTalkBean> watchTalk) {
            this.watchTalk = watchTalk;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        public static class MultipleBean {
            /**
             * title : 多视角直播
             * url : http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
             * order : 1
             */

            private String title;
            private String url;
            private String order;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }

        public static class WatchTalkBean {
            /**
             * title : 边看边聊
             * url : zhiboye_chat
             * order : 1
             */

            private String title;
            private String url;
            private String order;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }

    public static class LiveBean implements Parcelable {
        /**
         * title : 成都基地高清精切线路
         * brief : 翻身、吃饭、睡觉、喝奶、打闹、攀爬……这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg
         * id : ipanda
         * isshow : true
         * url : http://live.ipanda.com/stream/
         */

        private String title;
        private String brief;
        private String image;
        private String id;
        private String isshow;
        private String url;

        protected LiveBean(Parcel in) {
            title = in.readString();
            brief = in.readString();
            image = in.readString();
            id = in.readString();
            isshow = in.readString();
            url = in.readString();
        }

        public static final Creator<LiveBean> CREATOR = new Creator<LiveBean>() {
            @Override
            public LiveBean createFromParcel(Parcel in) {
                return new LiveBean(in);
            }

            @Override
            public LiveBean[] newArray(int size) {
                return new LiveBean[size];
            }
        };

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsshow() {
            return isshow;
        }

        public void setIsshow(String isshow) {
            this.isshow = isshow;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(brief);
            dest.writeString(image);
            dest.writeString(id);
            dest.writeString(isshow);
            dest.writeString(url);
        }
    }
}
