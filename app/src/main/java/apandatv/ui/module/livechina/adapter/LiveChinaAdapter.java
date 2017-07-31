package apandatv.ui.module.livechina.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.biz.IChinaLiveModel;
import apandatv.model.entity.ChinaItemBean;

/**
 * Created by lenovo on 2017/7/30.
 */

public class LiveChinaAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ChinaItemBean.LiveBean> list;

    public LiveChinaAdapter(Context context, List<ChinaItemBean.LiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.livechina_fragment_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final MyHolder holder1 = (MyHolder) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.content.setText(list.get(position).getBrief());
        IChinaLiveModel.iHttp.loadImage(list.get(position).getImage(),holder1.imag);

        holder1.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder1.down.setVisibility(View.GONE);
                holder1.up.setVisibility(View.VISIBLE);
                holder1.content.setVisibility(View.VISIBLE);
            }
        });

        holder1.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder1.down.setVisibility(View.VISIBLE);
                holder1.up.setVisibility(View.GONE);
                holder1.content.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        private ImageView imag, down, up;
        private TextView title, content;

        public MyHolder(View itemView) {
            super(itemView);

            imag = (ImageView) itemView.findViewById(R.id.china_live_image);
            down = (ImageView) itemView.findViewById(R.id.china_live_detail_down);
            up = (ImageView) itemView.findViewById(R.id.china_live_detail_up);
            title = (TextView) itemView.findViewById(R.id.china_live_id);
            content = (TextView) itemView.findViewById(R.id.china_live_content);

        }
    }
}
