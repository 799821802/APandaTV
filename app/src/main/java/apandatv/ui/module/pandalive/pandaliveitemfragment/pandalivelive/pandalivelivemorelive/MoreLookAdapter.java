package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivemorelive;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.PandaLiveMore;

/**
 * Created by Administrator on 2017/7/31.
 */

public class MoreLookAdapter extends RecyclerView.Adapter {
 private    MoreLookOnclick moreLookOnclick;

    public interface MoreLookOnclick {
        void getMoreLookOnclick(View view,int postion);
    }


    public void setMoreLookOnclick( MoreLookOnclick moreLookOnclick){
        this.moreLookOnclick=moreLookOnclick;
    }


    FragmentActivity activity;
    List<PandaLiveMore.ListBean> list;
    public MoreLookAdapter(FragmentActivity activity, List<PandaLiveMore.ListBean> list) {

        this.activity=activity;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.multiviterecycleitem,null);

        return new My_View(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        My_View my_view = (My_View) holder;

        my_view.textView.setText(list.get(position).getTitle());
        Glide.with(activity).load(list.get(position).getImage()).into(my_view.imageView);


        my_view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreLookOnclick.getMoreLookOnclick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class My_View extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public My_View(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_morelive_img);
            textView = (TextView) itemView.findViewById(R.id.item_morelive_title);



        }
    }

}
