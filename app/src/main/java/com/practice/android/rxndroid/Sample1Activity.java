package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.practice.android.rxndroid.adapter.myStringAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class Sample1Activity extends AppCompatActivity {
    RecyclerView mColorListView;
    myStringAdapter mStringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);

        setupActionBar();
        configureLayout();
        createObservable();
    }

    private void createObservable(){
        Observable<List<String>> listObservable = Observable.just(getColorList());

        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> colors) {
                mStringAdapter.setStrings(colors);
            }
        });
    }

    private void configureLayout() {
        mColorListView = (RecyclerView) findViewById(R.id.color_list);
        mStringAdapter = new myStringAdapter(this);
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

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.sample1_title);
        }
    }
}
