package apandatv.base;

/**
 * Created by lenovo on 2017/7/27.
 */

public interface BaseView<T> {

    void showProgress();//显示dialog
    void dimissProgress();//隐藏dialog
    void setPresenter(T t);

}
