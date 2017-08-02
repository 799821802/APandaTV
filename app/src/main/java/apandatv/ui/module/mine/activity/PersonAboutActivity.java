package apandatv.ui.module.mine.activity;

import android.view.View;
import android.widget.ImageView;

import com.jiyun.apandatv.R;

import apandatv.base.BaseActivity;

public class PersonAboutActivity extends BaseActivity implements View.OnClickListener {

    private ImageView personabout_image;

//activity_person_about
    @Override
    protected int getLayoutId() {
        return R.layout.activity_person_about;
    }

    @Override
    protected void init() {
        personabout_image = (ImageView) findViewById(R.id.personabout_image);
        personabout_image.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        this.finish();
    }
}
