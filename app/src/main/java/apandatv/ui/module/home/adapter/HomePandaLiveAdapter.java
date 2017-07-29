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
import apandatv.model.entity.PandaHome;

/**
 * Created by lenovo on 2017/7/28.
 */

public class HomePandaLiveAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<PandaHome.DataBean.PandaliveBean.ListBean> list;

    public HomePandaLiveAdapter(Context context, List<PandaHome.DataBean.PandaliveBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_pandalive_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder holder1 = (ViewHolder) holder;
        holder1.textView.setText(list.get(position).getTitle());
        IPandaHomeModel.iHttp.loadImage(list.get(position).getImage(),holder1.imag);
//        int number=Integer.parseInt(list.get(position).getOrder());
//        if(number==1||number==4||number==7) {
//            ViewGroup.LayoutParams lp=my_view.yuan.getLayoutParams();
//            lp.height=40;
//            lp.width=40;
//            my_view.yuan.setLayoutParams(lp);
//        }
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imag;
        private TextView textView;
        private ImageView  yuan;

        public ViewHolder(View itemView) {
            super(itemView);

            imag = (ImageView) itemView.findViewById(R.id.live_show_image);
            textView = (TextView) itemView.findViewById(R.id.live_show_text);
            yuan = (ImageView) itemView.findViewById(R.id.live_red_yuan);
        }
    }
}
