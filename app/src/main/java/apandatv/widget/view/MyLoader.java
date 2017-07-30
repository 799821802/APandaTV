package apandatv.widget.view;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 *自定义MyLoader类
 * Created by lenovo on 2017/7/29.
 */

public class MyLoader extends ImageLoader{


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
