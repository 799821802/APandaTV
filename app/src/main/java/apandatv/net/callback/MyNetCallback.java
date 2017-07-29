package apandatv.net.callback;

/**
 * Created by lenovo on 2017/7/27.
 */

public interface MyNetCallback<T> {

    //成功
    void onSuccess(T t);
    //失败
    void onError(int errorCode, String errorMsg);

}
