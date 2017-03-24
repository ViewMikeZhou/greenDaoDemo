package greendaodemo.hengda.com.greendao.util;

import android.content.Context;

import org.greenrobot.greendao.query.DeleteQuery;

import java.util.List;

import greendaodemo.hengda.com.greendao.entity.Student;
import greendaodemo.hengda.com.greendao.entity.User;
import greendaodemo.hengda.com.greendao.gen.DaoManager;
import greendaodemo.hengda.com.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2017/3/24.
 */

public class DaoUtils {
    private static DaoUtils instance ;
    private static DaoSession session ;
    private static DaoManager mDaoManager;

    private DaoUtils(){

    }
    public  static DaoUtils getInstance(){
        if (instance== null){
            synchronized (DaoUtils.class){
                if (instance == null) {
                    instance = new DaoUtils() ;
                    session = mDaoManager.getDaoSession();
                }
            }
        }
        return instance ;
    }
    public  static  synchronized  void init(Context context){
        if (mDaoManager == null ){
            mDaoManager = new DaoManager();
        }
        mDaoManager.init(context);
    }


    public void insertUser(User user){
        session.insert(user);
    }
    public  List<User> queryAllUser(){
        List<User> users = session.loadAll(User.class);
        return users;
    }
    public  List<Student> queryAllStudent(){
        List<Student> Students = session.loadAll(Student.class);
        return Students;
    }
    public void insertOrReplace(int key){

    }
    public void deleteAllUser(){
        DeleteQuery<User> userDeleteQuery = session.queryBuilder(User.class).buildDelete();
        userDeleteQuery.executeDeleteWithoutDetachingEntities();
    }
    public void insertStudent(Student s){
        session.insert(s);
    }
}
