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

import apandatv.model.entity.HomeGuangChinaBean;
import apandatv.net.HttpFactroy;

/**
 * Created by lenovo on 2017/7/28.
 */

public class HomeGuangChinaAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<HomeGuangChinaBean.ListBean> listbean;

    public HomeGuangChinaAdapter(Context context,List<HomeGuangChinaBean.ListBean> listbean) {
        this.context = context;
        this.listbean = listbean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_pandaeye_item, null);


        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MyHolder myHolder = (MyHolder) holder;

        myHolder.title.setText(listbean.get(position).getTitle());
        myHolder.data.setText(listbean.get(position).getDaytime());
        myHolder.time.setText(listbean.get(position).getVideoLength());
        HttpFactroy.create().loadImage(listbean.get(position).getImage(),myHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return listbean.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, data, time;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.look_down_image);

            title = (TextView) itemView.findViewById(R.id.look_down_title);
            data = (TextView) itemView.findViewById(R.id.look_down_data);
            time = (TextView) itemView.findViewById(R.id.movie_time);


        }
    }
}
