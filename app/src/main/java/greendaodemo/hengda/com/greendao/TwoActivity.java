package greendaodemo.hengda.com.greendao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import greendaodemo.hengda.com.greendao.entity.Student;
import greendaodemo.hengda.com.greendao.util.DaoUtils;

/**
 * Created by Administrator on 2017/3/24.
 */

public class TwoActivity extends AppCompatActivity {

    private static final String TAG = TwoActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void query(View view) {
        List<Student> students = DaoUtils.getInstance().queryAllStudent();
        for (Student student : students) {
            Log.d(TAG, "student:" + student);
        }
    }
}
