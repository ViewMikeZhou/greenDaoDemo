package greendaodemo.hengda.com.greendao;

import android.app.Application;

import greendaodemo.hengda.com.greendao.util.DaoUtils;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaoUtils.init(this);
    }
}
