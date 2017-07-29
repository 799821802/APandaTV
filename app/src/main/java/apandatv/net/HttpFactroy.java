package apandatv.net;

/**
 *
 * Created by lenovo on 2017/7/27.
 */

public class HttpFactroy {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
}
