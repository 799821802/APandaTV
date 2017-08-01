package apandatv.activity.reginstered.reginstere_fragment.phone;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/8/1.
 */
//
public class PhonePresenter implements PhoneContart.Presenter {

    private PhoneContart.View view;

//    private

    public PhonePresenter(PhoneContart.View view){

        this.view=view;
        view.setPresenter(this);



    }




    @Override
    public void start() {

    }

    @Override
    public Bitmap getGraphicvalidation() {








        return null;
    }
}
