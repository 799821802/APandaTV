package apandatv.model.biz;

import apandatv.net.HttpFactroy;
import apandatv.net.IHttp;

/**
 * Created by lenovo on 2017/7/27.
 */

public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();
}
