package apandatv.config;

/**
 * 接口地址
 * Created by lenovo on 2017/7/27.
 */

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页
    public static final String PANDAHOME = BASEURL + "PAGE14501749764071042/index.json";

    public static final String HOMEPANDAEYELIST = BASEURL + "shipinliebieye/xiongmaoguancha/index.json";
    //熊猫直播 中的 直播 页面的地址
    public static final String PANDALIVE_Live_Live = BASEURL + "PAGE14501769230331752/index.json";
    //  熊猫直播 首页地址
    public static final String PANDALIVE = "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json";
    //    熊猫直播 多视角 直播
    public static final String PANDALIVEMore = "http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json";
    // 熊猫 直播  边看边聊
    public static final String PANDALIVELook = "http://newcomment.cntv.cn/comment/list?app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1";
    // 熊猫 直播  其他页面
    public static final String PANDALIVEOTHR = " http://api.cntv.cn/video/videolistById?";
    // 熊猫播报 页面
    public static final String PANDAEYE = "http://www.ipanda.com/kehuduan/PAGE14503485387528442/index.json";

    //    http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda
    public static final String PANDAEYEXrecy = "http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda";

    //列表
    public static final String PAGELIST = BASEURL + "PAGE14501786751053212/index.json";

    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";
    //版本
    public static final String UPDATE = "http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";
    //直播中国
    public static final String LIVECHINA = BASEURL + "PAGE14501775094142282/index.json";
    //原创互动
    public static final String INTERACTIVE = BASEURL + "PAGE14501767715521482/index.json";

//  http://reg.cntv.cn/simple/verificationCode.action  登录 图形验证 地址

    public static final String LOGINiMAGE = "http://reg.cntv.cn/simple/verificationCode.action";

    //    登录
    public static final String LOGIN = "   https://reg.cntv.cn/login/login.action";

    public static final String ROLLVIDEO =
            "http://www.ipanda.com/kehuduan/xmwh/index.json ";
}
