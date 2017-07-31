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
}
