package apandatv.ui.module.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jiyun.apandatv.R;

import java.util.List;

import apandatv.model.db.dbcollection.MyCollection;
import apandatv.net.HttpFactroy;

/**
 * Created by lenovo on 2017/8/1.
 */

public class CollectionAdapter extends  RecyclerView.Adapter {

    private Context content;
    private List<MyCollection> collection_array;

    public CollectionAdapter(Context content, List<MyCollection> collection_array) {

        this.content = content;
        this.collection_array = collection_array;

    }
    public interface Onclick {

        void get_Onclick(View view, int postion);
    }

    private Onclick oclick;

    public void set_Onclick(Onclick oclick) {
        this.oclick = oclick;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(content).inflate(R.layout.historical_list_item, null);
        return new CollectionAdapter.My_Viwe(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final CollectionAdapter.My_Viwe my_view = (CollectionAdapter.My_Viwe) holder;

        my_view.title.setText(collection_array.get(position).getName());
        my_view.data.setText(collection_array.get(position).getData());


        if (collection_array.get(position).isFlg() == true) {


            my_view.radioButton.setVisibility(View.VISIBLE);

        } else  {

            my_view.radioButton.setVisibility(View.GONE);
        }

        if (collection_array.get(position).isFlg_bulen() ) {
            my_view.radioButton.setChecked(true);
        }else{
            my_view.radioButton.setChecked(false);
        }

        HttpFactroy.create().loadImage(collection_array.get(position).getImagpath(),my_view.imageView);

        my_view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oclick.get_Onclick(v, position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return collection_array.size();
    }

    class My_Viwe extends RecyclerView.ViewHolder {
        private RadioButton radioButton;
        private ImageView imageView;
        private TextView title, data;

        public My_Viwe(View itemView) {
            super(itemView);

            radioButton = (RadioButton) itemView.findViewById(R.id.original_radio);
            imageView = (ImageView) itemView.findViewById(R.id.OriginalNews_item_img);
            title = (TextView) itemView.findViewById(R.id.OriginalNews_item_title);
            data = (TextView) itemView.findViewById(R.id.OriginalNews_item_time);
        }
    }
}
