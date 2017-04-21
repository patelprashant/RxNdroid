package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.practice.android.rxndroid.adapter.DataItemAdapter;
import com.practice.android.rxndroid.model.DataItem;
import com.practice.android.rxndroid.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample2Activity extends AppCompatActivity {
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });

//        for (DataItem item : dataItemList) {
//            itemNames.add(item.getItemName());
//        }
//        Collections.sort(itemNames);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_activated_1, itemNames);

        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
    }
}
