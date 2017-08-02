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

import apandatv.model.biz.IPandaHomeModel;
import apandatv.model.entity.HomeCctvBean;

/**
 * Created by lenovo on 2017/7/29.
 */

public class HomeCctvAdapter extends RecyclerView.Adapter {


    public interface CCTV_live_Onclick{
        void  get_cctv_live(View view,int cctv_postion);
    }
    private CCTV_live_Onclick cctv_live_onclick;

    public void set_China_live_click(CCTV_live_Onclick cctv_live_onclick){
        this.cctv_live_onclick=cctv_live_onclick;
    }

    private Context context;
    private List<HomeCctvBean.ListBean> listBeen;

    public HomeCctvAdapter(Context context, List<HomeCctvBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.homecctv_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(listBeen.get(position).getTitle());
        IPandaHomeModel.iHttp.loadImage(listBeen.get(position).getImage(),holder1.img);

    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.homecctv_item_img);
            title = (TextView) itemView.findViewById(R.id.homecctv_item_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cctv_live_onclick.get_cctv_live(v,getAdapterPosition());
                }
            });
        }
    }
}
