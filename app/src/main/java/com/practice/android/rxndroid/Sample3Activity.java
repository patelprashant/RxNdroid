package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.practice.android.rxndroid.model.DataItem;
import com.practice.android.rxndroid.sample.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample3Activity extends AppCompatActivity {

    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();
    RecyclerView menuListView;
    DataItemRvAdapter dataItemRvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample3);
        setupActionBar();

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });

        menuListView = (RecyclerView) findViewById(R.id.menu_list_rv);
        dataItemRvAdapter = new DataItemRvAdapter(this, dataItemList);
        menuListView.setLayoutManager(new LinearLayoutManager(this));
        menuListView.setAdapter(dataItemRvAdapter);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.sample3_title);
        }
    }
}
