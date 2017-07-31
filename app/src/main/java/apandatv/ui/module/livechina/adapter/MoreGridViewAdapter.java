package apandatv.ui.module.livechina.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.LiveChinaBean;

/**
 * Created by lenovo on 2017/7/31.
 */

public class MoreGridViewAdapter extends BaseAdapter {
    FragmentActivity activity;
    List<LiveChinaBean.AlllistBean> alllistBeen_aray;
    public MoreGridViewAdapter(FragmentActivity activity, List<LiveChinaBean.AlllistBean> alllistBeen_aray) {
        this.activity=activity;
        this.alllistBeen_aray = alllistBeen_aray;
    }

    @Override
    public int getCount() {
        return alllistBeen_aray.size();
    }

    @Override
    public Object getItem(int position) {
        return alllistBeen_aray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        My_view my_view = null;
        if(convertView==null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.gridview_item,null);

            my_view= new My_view();

            my_view.content = (TextView) convertView.findViewById(R.id.gridview_item_content);


            convertView.setTag(my_view);

        }else{
            my_view= (My_view) convertView.getTag();
        }

        my_view.content.setText(alllistBeen_aray.get(position).getTitle());


        return convertView;
    }
    class My_view{
        private TextView content;

    }

}
