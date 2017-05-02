package com.practice.android.rxndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sample5Activity extends AppCompatActivity {
    private BlankFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample5 );

        //Add fragment with code
        fragment = new BlankFragment();
    }

    public void addClickHandler(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add( R.id.fragment_container, fragment )
                .commit();
    }

    public void removeClickHandler(View view) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove( fragment )
                    .commit();
        }
    }
}
