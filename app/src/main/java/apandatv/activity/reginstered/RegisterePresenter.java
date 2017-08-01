package apandatv.activity.reginstered;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class RegisterePresenter implements RegistereContart.Presenter {

    private RegistereContart.View view;

    public RegisterePresenter(RegistereContart.View view) {

        this.view = view;
        view.setPresenter(this);


    }


    @Override
    public void start() {

    }
}
