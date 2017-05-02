package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Sample5Activity extends AppCompatActivity {
    public static final String FRAGMENT_TAG = "blank_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample5 );

    }

    public void addClickHandler(View view) {
        //Add fragment with code
        Bundle arguments = new Bundle();
        arguments.putString( BlankFragment.MESSAGE_KEY, "Passed as an argument" );

        BlankFragment fragment = new BlankFragment();
        fragment.setArguments( arguments );

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack( null )
                .add( R.id.fragment_container, fragment, FRAGMENT_TAG )
                .commit();
    }

    public void removeClickHandler(View view) {
        BlankFragment fragment = (BlankFragment) getSupportFragmentManager()
                .findFragmentByTag( FRAGMENT_TAG );

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove( fragment )
                    .commit();
        }
    }
}
