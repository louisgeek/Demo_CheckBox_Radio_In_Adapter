package com.louisgeek.demo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by classichu on 2018/3/26.
 */
public class MyThirdaryBaseAdapter extends BaseAdapter {
    private static final String TAG = "MyThirdaryBaseAdapter";
    private List<MyBean> mMyBeanList;

    public MyThirdaryBaseAdapter(List<MyBean> myBeanList) {
        mMyBeanList = myBeanList;
    }


    @Override
    public int getCount() {
        return mMyBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMyBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyViewHolder myViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_checkable, parent, false);
            myViewHolder = new MyViewHolder();
            myViewHolder.tv = convertView.findViewById(R.id.id_tv);
            myViewHolder.cb = convertView.findViewById(R.id.id_cb);
            myViewHolder.rg = convertView.findViewById(R.id.id_rg);
            myViewHolder.rb = convertView.findViewById(R.id.id_rb);
            myViewHolder.rb2 = convertView.findViewById(R.id.id_rb2);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        final MyBean myBean = mMyBeanList.get(position);
        myViewHolder.tv.setText(myBean.title);


        //  RadioGroup +  RadioButton
        //采用  MyPrimaryBaseAdapter 或者 MySecondaryBaseAdapter  的方法
        //  RadioGroup +  RadioButton


        //  CheckBox
        myViewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: buttonView:" + buttonView);
                myBean.isChecked = isChecked;
            }
        });
        //此方法不推荐，setChecked 必须在setOnCheckedChangeListener之后
        myViewHolder.cb.setChecked(myBean.isChecked);
        //  CheckBox
        return convertView;
    }

    class MyViewHolder {
        private TextView tv;
        private CheckBox cb;
        private RadioGroup rg;
        private RadioButton rb;
        private RadioButton rb2;
    }

}
