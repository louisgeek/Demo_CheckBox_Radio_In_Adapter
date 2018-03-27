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

public class MySecondaryBaseAdapter extends BaseAdapter {
    private static final String TAG = "MySecondaryBaseAdapter";
    private List<MyBean> mMyBeanList;

    public MySecondaryBaseAdapter(List<MyBean> myBeanList) {
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
        myViewHolder.rg.setOnCheckedChangeListener(null);
        myViewHolder.rg.clearCheck();
        if ("1".equals(myBean.selectedRb)) {
            myViewHolder.rg.check(R.id.id_rb);
        } else if ("2".equals(myBean.selectedRb)) {
            myViewHolder.rg.check(R.id.id_rb2);
        }
        myViewHolder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG, "onCheckedChanged: checkedId:" + checkedId);

                myBean.selectedRb = null;
                myBean.title = "new_未选_" + position;
                if (R.id.id_rb == checkedId) {
                    myBean.selectedRb = "1";
                    myBean.title = "new_111111_" + position;
                } else if (R.id.id_rb2 == checkedId) {
                    myBean.selectedRb = "2";
                    myBean.title = "new_222222_" + position;
                }
            }
        });
        //  RadioGroup +  RadioButton


        //  CheckBox
        myViewHolder.cb.setOnCheckedChangeListener(null);
        myViewHolder.cb.setChecked(myBean.isChecked);
        myViewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: buttonView:" + buttonView);
                myBean.isChecked = isChecked;
            }
        });
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
