package apandatv.ui.module.pandaeye;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import apandatv.model.entity.PandaEyeXre;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaEyeAdapter extends RecyclerView.Adapter {

    private PandaEyeOnclick pandaEyeOnclick;
    public interface PandaEyeOnclick{
        void getPandaOnclick(View view,int postion);
    }

    public void  setPandaEyeOnclick(PandaEyeOnclick pandaEyeOnclick){
        this.pandaEyeOnclick=pandaEyeOnclick;
    }



    FragmentActivity activity;
    ArrayList<PandaEyeXre.ListBean> arrayList;
    public PandaEyeAdapter(FragmentActivity activity, ArrayList<PandaEyeXre.ListBean> arrayList) {
        this.activity=activity;
        this.arrayList=arrayList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

View view = LayoutInflater.from(activity).inflate(R.layout.pandaeyerecycelitem,null);
        return new My_View(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        My_View my_view = (My_View) holder;

        my_view.title.setText(arrayList.get(position).getTitle());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        long lcc_time = Long.valueOf(arrayList.get(position).getFocus_date());
        sdf.format(new Date(lcc_time * 1000L));
        my_view.data.setText(sdf.format(new Date(lcc_time * 1000L)));
        Glide.with(activity).load(arrayList.get(position).getPicurl()).into(my_view.imageView);


        my_view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pandaEyeOnclick.getPandaOnclick(v,position);

            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class My_View extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title,data;

        public My_View(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_pandalive_pullto_img_eye);
            title = (TextView) itemView.findViewById(R.id.item_pandalive_pullto_title_eye);
            data = (TextView) itemView.findViewById(R.id.item_pandabroadcast_pullto_time_eye);

        }
    }
}
