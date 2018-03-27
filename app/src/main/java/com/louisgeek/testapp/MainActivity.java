package com.louisgeek.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView id_lv = findViewById(R.id.id_lv);

        List<MyBean> myBeanList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            MyBean myBean = new MyBean();
            myBean.title = "未选" + i;
            if (i % 3 == 0) {
                myBean.isChecked = true;
                myBean.selectedRb = "1";
                myBean.title = "1111111_" + i;
            } else if (i % 5 == 0) {
                myBean.selectedRb = "2";
                myBean.title = "2222222_" + i;
            }
            myBeanList.add(myBean);
        }
        MyPrimaryBaseAdapter myBaseAdapter = new MyPrimaryBaseAdapter(myBeanList);
        MySecondaryBaseAdapter mySecondaryBaseAdapter = new MySecondaryBaseAdapter(myBeanList);
        MyThirdaryBaseAdapter myThirdaryBaseAdapter = new MyThirdaryBaseAdapter(myBeanList);
        // id_lv.setAdapter(myBaseAdapter);
//        id_lv.setAdapter(mySecondaryBaseAdapter);
        id_lv.setAdapter(myThirdaryBaseAdapter);

    }
}
