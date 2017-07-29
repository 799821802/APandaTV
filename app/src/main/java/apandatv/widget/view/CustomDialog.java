package apandatv.widget.view;

import android.app.Dialog;
import android.content.Context;

import com.jiyun.apandatv.R;



/**
 * 自定义dialog
 * Created by lenovo on 2017/7/27.
 */

public class CustomDialog {


    private static CustomDialog showDialog;

    private CustomDialog() {
    }

    private Dialog loadDialog;

    public static CustomDialog getInsent() {
        if (showDialog == null) {
            synchronized (CustomDialog.class) {
                if (showDialog == null) {
                    showDialog = new CustomDialog();
                }
            }
        }
        return showDialog;
    }

    public CustomDialog show(Context context) {

        loadDialog = new Dialog(context, R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);

        loadDialog.setContentView(R.layout.progressdialog_item);
        loadDialog.show();

        return this;
    }

    public CustomDialog dismiss() {

        loadDialog.dismiss();
        return this;
    }


}
