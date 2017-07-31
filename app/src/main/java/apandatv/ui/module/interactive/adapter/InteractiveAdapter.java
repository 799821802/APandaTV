package apandatv.ui.module.interactive.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.activity.WebActivity;
import apandatv.model.entity.MyInteractiveBean;

/**
 * Created by lenovo on 2017/7/15.
 * /qqqq
 */

public class InteractiveAdapter extends BaseAdapter<MyInteractiveBean.InteractiveBean> {


    public InteractiveAdapter(Context context, List datas) {
        super(context, R.layout.interactive_item, datas);
    }


    @Override
    public void convert(ViewHolder holder, final MyInteractiveBean.InteractiveBean interactiveBean) {

        holder.setText(R.id.cehua_item_tv,interactiveBean.getTitle());
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.cehua_item_img);
        Glide.with(context).load(interactiveBean.getImage()).into(img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,interactiveBean.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,WebActivity.class);
                intent.putExtra("url",interactiveBean.getUrl());
                context.startActivity(intent);
            }
        });
    }
}
