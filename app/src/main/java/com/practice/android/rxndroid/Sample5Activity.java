package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Sample5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample5 );

    }

    public void addClickHandler(View view) {
        //Add fragment with code
        BlankFragment fragment = new BlankFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add( R.id.fragment_container, fragment )
                .commit();
    }

    public void removeClickHandler(View view) {
        BlankFragment fragment = (BlankFragment) getSupportFragmentManager()
                .findFragmentById( R.id.fragment_container );

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove( fragment )
                    .commit();
        }
    }
}
