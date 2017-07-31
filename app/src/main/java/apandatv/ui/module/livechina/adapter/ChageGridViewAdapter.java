package apandatv.ui.module.livechina.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.entity.LiveChinaBean;

/**
 * Created by Administrator on 2017/7/17.
 */
public class ChageGridViewAdapter extends BaseAdapter {

    private FragmentActivity activity;
    private List<LiveChinaBean.TablistBean> tablistBeen_array;

    public ChageGridViewAdapter(FragmentActivity activity, List<LiveChinaBean.TablistBean> tablistBeen_array) {
        this.activity = activity;
        this.tablistBeen_array = tablistBeen_array;
    }

    @Override
    public int getCount() {
        return tablistBeen_array.size();
    }

    @Override
    public Object getItem(int position) {
        return tablistBeen_array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        My_view my_view = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.gridview_item, null);

            my_view = new My_view();

            my_view.content = (TextView) convertView.findViewById(R.id.gridview_item_content);
            my_view.delete = (ImageView) convertView.findViewById(R.id.gridview_item_delete_gary);

            convertView.setTag(my_view);

        } else {
            my_view = (My_view) convertView.getTag();
        }

        my_view.content.setText(tablistBeen_array.get(position).getTitle());

        if (tablistBeen_array.get(position).getFlg() == true) {

            my_view.delete.setVisibility(View.VISIBLE);

        } else {

            my_view.delete.setVisibility(View.GONE);

        }
        return convertView;
    }
    public void swap(int i, int j) {
        if (j < i) {
            LiveChinaBean.TablistBean tablistBean = tablistBeen_array.get(i);

            tablistBeen_array.add(j,tablistBean);
            tablistBeen_array.remove(i + 1);
        } else if (i < j) {
            LiveChinaBean.TablistBean tablistBean = tablistBeen_array.get(i);
            tablistBeen_array.add(j + 1, tablistBean);
            tablistBeen_array.remove(i);
        }
    }
    class My_view {
        private TextView content;
        private ImageView delete;
    }

}
