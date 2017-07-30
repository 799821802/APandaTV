package apandatv.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.apandatv.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import apandatv.model.biz.IPandaHomeModel;
import apandatv.model.entity.HomeCctvBean;
import apandatv.model.entity.HomeGuangChinaBean;
import apandatv.model.entity.HomePandaeyeBean;
import apandatv.model.entity.PandaHome;
import apandatv.net.HttpFactroy;
import apandatv.net.callback.MyNetCallback;
import apandatv.utils.LogUtils;
import apandatv.widget.view.MyLoader;

/**
 * Created by lenovo on 2017/7/28.
 */

public class HomeAdapter extends RecyclerView.Adapter{

    private List<Object> datas;
    private LayoutInflater inflater;
    public static final int ITEMCOUNT = 9;//加载9种不同类型的item
    public static final int BIGIMG = 0;//轮播图
    public static final int AREA = 1;//精彩推荐
    public static final int PANDAEYE = 2;//熊猫观察
    public static final int PANDALIVE = 3;//熊猫直播
    public static final int WALLLIVE = 4;//长城直播
    public static final int CHINALIVE = 5;//直播中国
    public static final int INTERACTIVE = 6;//特别策划
    public static final int CCTV = 7;//CCTV
    public static final int LIST = 8;//光影中国
    private Context context;
    private List<HomePandaeyeBean.ListBean> Look_Down_Array = new ArrayList();
    List<HomeCctvBean.ListBean> cctv_list = new ArrayList();
    private List<HomeGuangChinaBean.ListBean> guangyinglist = new ArrayList<>();
    public HomeAdapter(Context context, List<Object> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = datas.get(position);
        if (position == 0) {
            return BIGIMG;
        } else if (obj instanceof PandaHome.DataBean.AreaBean) {
            return AREA;
        } else if (obj instanceof PandaHome.DataBean.PandaeyeBean) {
            return PANDAEYE;
        } else if (obj instanceof PandaHome.DataBean.PandaliveBean) {
            return PANDALIVE;
        } else if (obj instanceof PandaHome.DataBean.WallliveBean) {
            return WALLLIVE;
        } else if (obj instanceof PandaHome.DataBean.ChinaliveBean) {
            return CHINALIVE;
        } else if (obj instanceof PandaHome.DataBean.InteractiveBean) {
            return INTERACTIVE;
        } else if (obj instanceof PandaHome.DataBean.CctvBean) {
            return CCTV;
        } else if (obj instanceof PandaHome.DataBean.ListBeanXXX) {
            return LIST;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BIGIMG:
                View bigimgView = inflater.inflate(R.layout.home_bigimg, null);
                return new BigimgHolder(bigimgView);
            case AREA:
                View areaView = inflater.inflate(R.layout.home_area, null);
                return new AreaHolder(areaView);
            case PANDAEYE:

                View pandaeyeview = inflater.inflate(R.layout.home_pandaeye, null);
                return new PandaeyeHolder(pandaeyeview);

            case PANDALIVE:

                View pandalive = inflater.inflate(R.layout.home_pandalive,null);
                return new PandaLiveHolder(pandalive);

            case WALLLIVE:

                View walllive = inflater.inflate(R.layout.home_walllive,null);
                return new WallLiveHolder(walllive);

            case CHINALIVE:

                View livechina = inflater.inflate(R.layout.home_livechina,null);
                return new LiveChinaHolder(livechina);

            case INTERACTIVE:

                View interactive = inflater.inflate(R.layout.home_interactive,null);
                return new InteractiveHolder(interactive);

            case CCTV:

                View cctv = inflater.inflate(R.layout.home_cctv,null);
                return new CCTVHolder(cctv);

            case LIST:

                View list = inflater.inflate(R.layout.home_guangyingchina,null);
                return new ChinalistHolder(list);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case BIGIMG:
                BigimgHolder bigimgHolder = (BigimgHolder) holder;
                List<PandaHome.DataBean.BigImgBean> bigImgs = (List<PandaHome.DataBean.BigImgBean>) datas.get(position);
                loadBigImg(bigimgHolder,bigImgs);
                break;
            case AREA:
                AreaHolder areaHolder = (AreaHolder) holder;
                PandaHome.DataBean.AreaBean areaBean = (PandaHome.DataBean.AreaBean) datas.get(position);
                loadArea(areaHolder,areaBean);
                break;
            case PANDAEYE:

                PandaeyeHolder pandaeyeHolder = (PandaeyeHolder) holder;
                PandaHome.DataBean.PandaeyeBean pandaeyeBean = (PandaHome.DataBean.PandaeyeBean) datas.get(position);
                loadPandaeye(pandaeyeHolder,pandaeyeBean);
                break;
            case PANDALIVE:

                PandaLiveHolder pandaLiveHolder = (PandaLiveHolder) holder;
                PandaHome.DataBean.PandaliveBean pandaliveBean = (PandaHome.DataBean.PandaliveBean) datas.get(position);
                loadPandaLive(pandaLiveHolder,pandaliveBean);
                break;
            case WALLLIVE:

                WallLiveHolder wallLiveHolder = (WallLiveHolder) holder;
                PandaHome.DataBean.WallliveBean wallliveBean = (PandaHome.DataBean.WallliveBean) datas.get(position);
                loadWallLive(wallLiveHolder,wallliveBean);
                break;
            case CHINALIVE:

                LiveChinaHolder liveChinaHolder = (LiveChinaHolder) holder;
                PandaHome.DataBean.ChinaliveBean chinaliveBean = (PandaHome.DataBean.ChinaliveBean) datas.get(position);
                loadLiveChina(liveChinaHolder,chinaliveBean);
                break;

            case INTERACTIVE:

                InteractiveHolder interactiveHolder = (InteractiveHolder) holder;
                PandaHome.DataBean.InteractiveBean interactiveBean = (PandaHome.DataBean.InteractiveBean) datas.get(position);
                LoadInteractive(interactiveHolder,interactiveBean);
                break;

            case CCTV:

                CCTVHolder cctvHolder = (CCTVHolder) holder;
                PandaHome.DataBean.CctvBean cctvBean = (PandaHome.DataBean.CctvBean) datas.get(position);
                LoadCCTV(cctvHolder,cctvBean);

                break;

            case LIST:

                ChinalistHolder chinalistHolder = (ChinalistHolder) holder;
                PandaHome.DataBean.ListBeanXXX listBeanXXXes = (PandaHome.DataBean.ListBeanXXX) datas.get(position);
                LoadGuangyingChina(chinalistHolder,listBeanXXXes);
                break;
        }
    }

    //viewpager
    private void loadBigImg(BigimgHolder holder, List<PandaHome.DataBean.BigImgBean> bigImgs){
        Banner banner = holder.banner;
        List<String> imgs = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (PandaHome.DataBean.BigImgBean imgBean : bigImgs){

            imgs.add(imgBean.getImage());
            LogUtils.e("TAG",imgBean.getTitle());
            titles.add(imgBean.getTitle());
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setBannerAnimation(Transformer.Accordion);
        banner.setImageLoader(new MyLoader());
        banner.setImages(imgs);
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.start();
    }

    //精彩推荐
    private void loadArea(AreaHolder holder,PandaHome.DataBean.AreaBean areaBean){
        List<PandaHome.DataBean.AreaBean.ListscrollBean> areas = areaBean.getListscroll();
        ImageView areaIcon = holder.areaIcon;
        HttpFactroy.create().loadImage(areaBean.getImage(),areaIcon);
        RecyclerView recyclerView = holder.recyclerView;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new HomeAreaAdapter(context,areas));
    }

    //熊猫观察
    private void loadPandaeye(PandaeyeHolder holder,PandaHome.DataBean.PandaeyeBean pandaeyeBean){

        List<PandaHome.DataBean.PandaeyeBean.ItemsBean> pandaeye = pandaeyeBean.getItems();
        holder.broad_title_one.setText(pandaeyeBean.getItems().get(0).getBrief());
        holder.broad_title_two.setText(pandaeyeBean.getItems().get(1).getBrief());
        holder.broad_content_one.setText(pandaeyeBean.getItems().get(0).getTitle());
        holder.broad_content_two.setText(pandaeyeBean.getItems().get(1).getTitle());
        RecyclerView recyclerView = holder.look_down_recycle;
        HttpFactroy.create().loadImage(pandaeyeBean.getPandaeyelogo(),holder.broad_imag);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        final HomePandaeyeAdapter adapter = new HomePandaeyeAdapter(context,Look_Down_Array);
        recyclerView.setAdapter(adapter);
        IPandaHomeModel.iHttp.get(pandaeyeBean.getPandaeyelist(), null, new MyNetCallback<HomePandaeyeBean>() {
            @Override
            public void onSuccess(HomePandaeyeBean pandaliveBean) {

                List<HomePandaeyeBean.ListBean> list = pandaliveBean.getList();
                Look_Down_Array.clear();
                Look_Down_Array.addAll(list);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
    //熊猫直播
   private void loadPandaLive(PandaLiveHolder holder, PandaHome.DataBean.PandaliveBean pandaliveBean){

       RecyclerView recyclerView = holder.live_show_recy;
       recyclerView.setLayoutManager( new GridLayoutManager(context, 3));
       HomePandaLiveAdapter adapter = new HomePandaLiveAdapter(context, pandaliveBean.getList());
       LogUtils.e("TAG",pandaliveBean.getList().toString());
       recyclerView.setAdapter(adapter);
       adapter.notifyDataSetChanged();

   }
    //长城直播
    private void loadWallLive(WallLiveHolder holder, PandaHome.DataBean.WallliveBean wallliveBean){

        RecyclerView recyclerView = holder.live_show_recy;
        recyclerView.setLayoutManager( new GridLayoutManager(context, 3));
        HomeWallLiveAdapter adapter = new HomeWallLiveAdapter(context, wallliveBean.getList());
        LogUtils.e("TAG",wallliveBean.getList().toString());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    //直播中国
    private void loadLiveChina(LiveChinaHolder holder, PandaHome.DataBean.ChinaliveBean chinaliveBean){

        RecyclerView recyclerView = holder.live_show_recy;
        recyclerView.setLayoutManager( new GridLayoutManager(context, 3));
        HomeLiveChinaAdapter adapter = new HomeLiveChinaAdapter(context, chinaliveBean.getList());
        LogUtils.e("TAG",chinaliveBean.getList().toString());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    //特别策划
    private void LoadInteractive(InteractiveHolder holder,PandaHome.DataBean.InteractiveBean interactiveBean){

       ImageView interactiveimg = holder.img;
        TextView title = holder.title;
        List<PandaHome.DataBean.InteractiveBean.InteractiveoneBean> interactiveone = interactiveBean.getInteractiveone();
        for (int i=0;i<interactiveone.size();i++){
           String img = interactiveone.get(i).getImage();
            IPandaHomeModel.iHttp.loadImage(img,interactiveimg);
            title.setText(interactiveone.get(i).getTitle());
        }
    }

    //cctv
    private void LoadCCTV(CCTVHolder holder,PandaHome.DataBean.CctvBean cctvBean){

        RecyclerView recyclerView =  holder.live_show_recy;
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        final HomeCctvAdapter adapter = new HomeCctvAdapter(context,cctv_list);
        recyclerView.setAdapter(adapter);
        IPandaHomeModel.iHttp.get(cctvBean.getListurl(), null, new MyNetCallback<HomeCctvBean>() {
            @Override
            public void onSuccess(HomeCctvBean homeCctvBean) {

                cctv_list.clear();
                cctv_list.addAll(homeCctvBean.getList());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
    //光影中国
    private void LoadGuangyingChina(ChinalistHolder chinalistHolder,PandaHome.DataBean.ListBeanXXX list){

        RecyclerView recyclerView = chinalistHolder.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        final HomeGuangChinaAdapter adapter = new HomeGuangChinaAdapter(context,guangyinglist);
        recyclerView.setAdapter(adapter);

        IPandaHomeModel.iHttp.get(list.getListUrl(), null, new MyNetCallback<HomeGuangChinaBean>() {
                @Override
                public void onSuccess(HomeGuangChinaBean homeGuangChinaBean) {
                    guangyinglist.clear();
                    guangyinglist.addAll(homeGuangChinaBean.getList());
                    adapter.notifyDataSetChanged();
                }
                @Override
                public void onError(int errorCode, String errorMsg) {

                }
            });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //viewpager
    class BigimgHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public BigimgHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.home_viewpager);

        }
    }
    //精彩推荐
    class AreaHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ImageView areaIcon;
        public AreaHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.areaRecyclerView);
            areaIcon = (ImageView) itemView.findViewById(R.id.areaIcon);
        }
    }
    //熊猫观察
    class PandaeyeHolder extends RecyclerView.ViewHolder {
        private RecyclerView look_down_recycle;
        private TextView broad_content_two, broad_content_one, broad_title_two, broad_title_one;
        private ImageView broad_imag;
        public PandaeyeHolder(View itemView) {
            super(itemView);
            broad_imag = (ImageView) itemView.findViewById(R.id.broad_image);
            broad_title_one = (TextView) itemView.findViewById(R.id.panda_broadcast_text_one);
            broad_title_two = (TextView) itemView.findViewById(R.id.panda_broadcast_text_two);
            broad_content_one = (TextView) itemView.findViewById(R.id.panda_broadcast_content_one);
            broad_content_two = (TextView) itemView.findViewById(R.id.panda_broadcast_content_two);
            look_down_recycle = (RecyclerView) itemView.findViewById(R.id.home_panda_look_two_recycle);
        }
    }
    //熊猫直播
    class PandaLiveHolder extends RecyclerView.ViewHolder{

        private RecyclerView live_show_recy;

        public PandaLiveHolder(View itemView) {
            super(itemView);
            live_show_recy = (RecyclerView) itemView.findViewById(R.id.home_live_show_recycle);
        }
    }
    //长城直播
    class WallLiveHolder extends RecyclerView.ViewHolder{

        private RecyclerView live_show_recy;

        public WallLiveHolder(View itemView) {
            super(itemView);
            live_show_recy = (RecyclerView) itemView.findViewById(R.id.home_walllive_show_recycle);
        }
    }
    //直播中国
    class LiveChinaHolder extends RecyclerView.ViewHolder{

        private RecyclerView live_show_recy;

        public LiveChinaHolder(View itemView) {
            super(itemView);
            live_show_recy = (RecyclerView) itemView.findViewById(R.id.home_livechina_show_recycle);
        }
    }

    //特别策划
    class InteractiveHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        public InteractiveHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.home_interactive_img);
            title = (TextView) itemView.findViewById(R.id.home_interactive_title);
        }
    }
    //CCTV
    class CCTVHolder extends RecyclerView.ViewHolder{

        private RecyclerView live_show_recy;

        public CCTVHolder(View itemView) {
            super(itemView);
            live_show_recy = (RecyclerView) itemView.findViewById(R.id.home_cctv_show_recycle);
        }
    }
    //光影中国
    class ChinalistHolder extends RecyclerView.ViewHolder{

        private RecyclerView recyclerView;
        public ChinalistHolder(View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.home_guangyingchina_recycle);
        }
    }
}
