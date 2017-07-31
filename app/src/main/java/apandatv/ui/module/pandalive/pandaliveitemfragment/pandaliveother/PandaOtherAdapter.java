package apandatv.ui.module.pandalive.pandaliveitemfragment.pandaliveother;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.PandaLiveOther;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaOtherAdapter extends RecyclerView.Adapter {
    FragmentActivity activity;
    List<PandaLiveOther.VideoBean> video;
    public PandaOtherAdapter(FragmentActivity activity, List<PandaLiveOther.VideoBean> video) {
        this.activity=activity;
        this.video=video;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.pandaliveotheritem,null);


        return new My_View(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        My_View my_view = (My_View) holder;

        my_view.time.setText(video.get(position).getLen());

        my_view.title.setText(video.get(position).getT());

        my_view.data.setText(video.get(position).getPtime());

        Glide.with(activity).load(video.get(position).getImg()).into(my_view.imageView);

    }

    @Override
    public int getItemCount() {
        return video.size();
    }


    class My_View extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView time,title,data;
        public My_View(View itemView) {
            super(itemView);


            imageView = (ImageView) itemView.findViewById(R.id.item_pandalive_pullto_img);
            time = (TextView) itemView.findViewById(R.id.item_pandalive_pullto_video_time);
            title = (TextView) itemView.findViewById(R.id.item_pandalive_pullto_title);
            data = (TextView) itemView.findViewById(R.id.item_pandabroadcast_pullto_time);


        }
    }
}
