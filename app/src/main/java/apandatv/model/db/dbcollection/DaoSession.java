package apandatv.model.db.dbcollection;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import apandatv.model.db.dbcollection.MyCollection;

import apandatv.model.db.dbcollection.MyCollectionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myCollectionDaoConfig;

    private final MyCollectionDao myCollectionDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myCollectionDaoConfig = daoConfigMap.get(MyCollectionDao.class).clone();
        myCollectionDaoConfig.initIdentityScope(type);

        myCollectionDao = new MyCollectionDao(myCollectionDaoConfig, this);

        registerDao(MyCollection.class, myCollectionDao);
    }
    
    public void clear() {
        myCollectionDaoConfig.getIdentityScope().clear();
    }

    public MyCollectionDao getMyCollectionDao() {
        return myCollectionDao;
    }

}
