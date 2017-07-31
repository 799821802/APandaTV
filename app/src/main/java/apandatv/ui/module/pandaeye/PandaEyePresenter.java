package apandatv.ui.module.pandaeye;

import apandatv.model.biz.Pandaeye.PandaEyeModel;
import apandatv.model.biz.Pandaeye.PandaEyeModelImpl;
import apandatv.model.entity.PandaEye;
import apandatv.model.entity.PandaEyeXre;
import apandatv.net.callback.MyNetCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PandaEyePresenter implements PandaEyeContrat.Presenter {
        private PandaEyeContrat.View view;

        private PandaEyeModel pandaEyeModel;
    public  PandaEyePresenter(PandaEyeContrat.View view){

        this.view=view;
        view.setPresenter(this);

      this.  pandaEyeModel = new PandaEyeModelImpl();

    }

    @Override
    public void start() {

        pandaEyeModel.getPandaEye(new MyNetCallback<PandaEye>() {
            @Override
            public void onSuccess(PandaEye pandaEye) {

                view.getData(pandaEye);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }

    @Override
    public void getXrecY() {

        pandaEyeModel.getPandaEyeXre(new MyNetCallback<PandaEyeXre>() {
            @Override
            public void onSuccess(PandaEyeXre pandaEyeXre) {
                view.getxData(pandaEyeXre);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }
}
