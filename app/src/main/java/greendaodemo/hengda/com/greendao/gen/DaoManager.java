package greendaodemo.hengda.com.greendao.gen;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/24.
 */

public class DaoManager {

    private DaoSession session;
    private static DaoMaster sMaster;
    private Context mContext;
    private static final String DB_NAME = "person.db";

    public void init(Context context) {
        this.mContext = context;
    }

    public DaoSession getDaoSession() {
        if (sMaster == null) {
            synchronized (DaoManager.class) {
                if (sMaster == null) {
                    DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, DB_NAME);
                    sMaster = new DaoMaster(helper.getWritableDb());
                    session = sMaster.newSession();
                }
            }
        }
        return session;
    }
}
