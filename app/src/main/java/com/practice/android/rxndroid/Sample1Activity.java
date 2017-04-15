package com.practice.android.rxndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Sample1Activity extends AppCompatActivity {
    RecyclerView mColorListView;
    myStringAdapter mStringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);

        configureLayout();
    }

    private void configureLayout() {
        mColorListView = (RecyclerView) findViewById(R.id.color_list);
        mStringAdapter = new myStringAdapter(this, getColorList());
        mColorListView.setLayoutManager(new LinearLayoutManager(this));
        mColorListView.setAdapter(mStringAdapter);
    }

    private static List<String> getColorList() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Cyan");
        colors.add("Megenta");
        colors.add("Yellow");
        colors.add("Black");
        colors.add("White");

        return colors;
    }
}
