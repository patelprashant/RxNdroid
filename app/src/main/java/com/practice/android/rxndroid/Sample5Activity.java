package com.practice.android.rxndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sample5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample5 );

        //Add fragment with code
        BlankFragment fragment = new BlankFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add( R.id.fragment_container, fragment )
                .commit();
    }
}
