package apandatv.ui.module.pandalive.pandaliveitemfragment.pandalivelive.pandalivelivelook;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import apandatv.model.entity.PandaLiveLook;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LookTalkAdapter extends RecyclerView.Adapter {
    FragmentActivity activity;
    List<PandaLiveLook.DataBean.ContentBean> content;

    public LookTalkAdapter(FragmentActivity activity, List<PandaLiveLook.DataBean.ContentBean> content) {
        this.activity = activity;
        this.content = content;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.lookandtalkitem, null);

        return new My_View(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        My_View my_view = (My_View) holder;

        my_view.titlename.setText(content.get(position).getAuthor());
        my_view.titlecontent.setText(content.get(position).getMessage());
        my_view.titlelouceng.setText(String.valueOf(187061+position));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时");
        long lcc_time = Long.valueOf(content.get(position).getDateline());
        sdf.format(new Date(lcc_time * 1000L));
        my_view.titledata.setText(sdf.format(new Date(lcc_time * 1000L)));

    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    class My_View extends RecyclerView.ViewHolder {
        private TextView titlename, titlecontent, titlelouceng, titledata;

        public My_View(View itemView) {
            super(itemView);

            titlename = (TextView) itemView.findViewById(R.id.watch_item_netfriends);
            titlecontent = (TextView) itemView.findViewById(R.id.watch_item_content);
            titlelouceng = (TextView) itemView.findViewById(R.id.watch_item_numlou);
            titledata = (TextView) itemView.findViewById(R.id.watch_item_time);
        }
    }
}
