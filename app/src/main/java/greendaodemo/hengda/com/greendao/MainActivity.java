package greendaodemo.hengda.com.greendao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import greendaodemo.hengda.com.greendao.entity.Student;
import greendaodemo.hengda.com.greendao.entity.User;
import greendaodemo.hengda.com.greendao.util.DaoUtils;
import greendaodemo.hengda.com.greendao.util.StatusBarCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DaoUtils mDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarCompat.compat(this);
        mDao = DaoUtils.getInstance();
    }

    public void insert(View view) {
        User user = new User() ;
        user.setAge(11);
        user.setName("张三");
        User user1 = new User() ;
        user1.setAge(12);
        user1.setName("李四");
        Student s = new Student();
        s.setName("小明");

        mDao.insertUser(user);
        mDao.insertUser(user1);
        mDao.insertStudent(s);
    }

    public void delete(View view) {
        mDao.deleteAllUser();
    }

    public void updata(View view) {
        startActivity(new Intent(this,TwoActivity.class));
    }

    public void query(View view) {
        List<?> objects = mDao.queryAllUser();
        for (Object object : objects) {
            Log.e(TAG, object.toString());
        }
        List<Student> students = mDao.queryAllStudent();
        for (Student student : students) {
            Log.e(TAG, student.toString());
        }
    }
}
