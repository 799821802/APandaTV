package apandatv.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaEye  implements Parcelable{

    /**
     * data : {"bigImg":[{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg","title":"旅日大熊猫\u201c仙女\u201d成功产下2017首胎海外熊猫幼仔","url":"http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml","id":"ARTIBdwYiZE71cob9CQLUz79170612","type":"5","stype":"","pid":"","vid":"","order":"1"}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda"}
     */

    private DataBean data;

    protected PandaEye(Parcel in) {
    }

    public static final Creator<PandaEye> CREATOR = new Creator<PandaEye>() {
        @Override
        public PandaEye createFromParcel(Parcel in) {
            return new PandaEye(in);
        }

        @Override
        public PandaEye[] newArray(int size) {
            return new PandaEye[size];
        }
    };

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class DataBean  implements Parcelable{
        /**
         * bigImg : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg","title":"旅日大熊猫\u201c仙女\u201d成功产下2017首胎海外熊猫幼仔","url":"http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml","id":"ARTIBdwYiZE71cob9CQLUz79170612","type":"5","stype":"","pid":"","vid":"","order":"1"}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        protected DataBean(Parcel in) {
            listurl = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(listurl);
        }

        public static class BigImgBean  implements Parcelable{
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg
             * title : 旅日大熊猫“仙女”成功产下2017首胎海外熊猫幼仔
             * url : http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml
             * id : ARTIBdwYiZE71cob9CQLUz79170612
             * type : 5
             * stype :
             * pid :
             * vid :
             * order : 1
             */

            private String image;
            private String title;
            private String url;
            private String id;
            private String type;
            private String stype;
            private String pid;
            private String vid;
            private String order;

            protected BigImgBean(Parcel in) {
                image = in.readString();
                title = in.readString();
                url = in.readString();
                id = in.readString();
                type = in.readString();
                stype = in.readString();
                pid = in.readString();
                vid = in.readString();
                order = in.readString();
            }

            public static final Creator<BigImgBean> CREATOR = new Creator<BigImgBean>() {
                @Override
                public BigImgBean createFromParcel(Parcel in) {
                    return new BigImgBean(in);
                }

                @Override
                public BigImgBean[] newArray(int size) {
                    return new BigImgBean[size];
                }
            };

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(image);
                dest.writeString(title);
                dest.writeString(url);
                dest.writeString(id);
                dest.writeString(type);
                dest.writeString(stype);
                dest.writeString(pid);
                dest.writeString(vid);
                dest.writeString(order);
            }
        }
    }
}
