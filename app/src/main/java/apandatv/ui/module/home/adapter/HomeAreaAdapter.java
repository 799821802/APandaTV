package apandatv.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.PandaHome;
import apandatv.net.HttpFactroy;


/**
 * Created by lenovo on 2017/7/28.
 */

public class HomeAreaAdapter extends Adapter {

    private Context context;
    private List<PandaHome.DataBean.AreaBean.ListscrollBean> datas;
    private LayoutInflater inflater;
    public HomeAreaAdapter(Context context, List<PandaHome.DataBean.AreaBean.ListscrollBean> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_area_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Holder h = (Holder) holder;
        HttpFactroy.create().loadImage(datas.get(position).getImage(),h.img);
        h.titleTv.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView titleTv;
        public Holder(View itemView) {

            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.areaImg);
            titleTv = (TextView) itemView.findViewById(R.id.areaTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wonder_onclick.Wonder_getOnclick(v,getPosition());
                }
            });
        }
    }

    //     精彩推荐的  监听接口
    public interface Wonder_Onclick {
        void Wonder_getOnclick(View view, int postion);
    }
    private Wonder_Onclick wonder_onclick;
    public void Wonder_setOnclick(Wonder_Onclick wonder_onclick) {
        this.wonder_onclick = wonder_onclick;
    }

}
