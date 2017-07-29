package apandatv.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.HomePandaeyeBean;
import apandatv.net.HttpFactroy;

/**
 * Created by lenovo on 2017/7/28.
 */

public class HomePandaeyeAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<HomePandaeyeBean.ListBean> look_down_array;

    public HomePandaeyeAdapter(Context context, List<HomePandaeyeBean.ListBean> look_down_array) {
        this.context = context;
        this.look_down_array = look_down_array;
    }

     interface PandaeyeBack {
        void  getOnclick(View view, int lok_down_postion);
    }

    private PandaeyeBack pandaeyeBack;

    public void setOnItemClick(PandaeyeBack pandaeyeBack) {
        this.pandaeyeBack = pandaeyeBack;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_pandaeye_item, null);


        return new My_View(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        My_View my_view = (My_View) holder;

        my_view.title.setText(look_down_array.get(position).getTitle());
        my_view.data.setText(look_down_array.get(position).getDaytime());
        my_view.time.setText(look_down_array.get(position).getVideoLength());
        HttpFactroy.create().loadImage(look_down_array.get(position).getImage(),my_view.imageView);

//        Glide.with(activity).load(look_down_array.get(position).getImage()).placeholder(R.mipmap.umeng_socialize_share_pic).into(my_view.imageView);

        my_view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              pandaeyeBack.getOnclick(v,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return look_down_array.size();
    }

    class My_View extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, data, time;

        public My_View(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.look_down_image);

            title = (TextView) itemView.findViewById(R.id.look_down_title);
            data = (TextView) itemView.findViewById(R.id.look_down_data);
            time = (TextView) itemView.findViewById(R.id.movie_time);


        }
    }
}
