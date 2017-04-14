package com.practice.android.rxndroid;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setupSampleList();
    }

    private void setupSampleList() {
        RecyclerView sampleList = (RecyclerView) findViewById(R.id.sample_list);
        sampleList.setHasFixedSize(true);
        sampleList.setLayoutManager(new LinearLayoutManager(this));
        sampleList.setAdapter(new SampleAdapter(this, getSampleList()));
    }

    private static List<SampleActivityWithName> getSampleList() {
        List<SampleActivityWithName> sampleActivityWithNames = new ArrayList<>();

        sampleActivityWithNames.add(new SampleActivityWithName(Sample1Activity.class, "Sample: 1 Simple List"));

        return sampleActivityWithNames;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.app_titile);
        }
    }
}
