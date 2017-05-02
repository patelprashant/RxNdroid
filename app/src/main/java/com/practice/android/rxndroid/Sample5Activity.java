package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.android.rxndroid.utils.ScreenUtility;

public class Sample5Activity extends AppCompatActivity {
    public static final String FRAGMENT_TAG = "blank_fragment";
    private TextView mOut;
    private boolean mUseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample5 );

        mOut = (TextView) findViewById( R.id.measure_text );

    }

    public void addClickHandler(View view) {
        //Add fragment with code
//        Bundle arguments = new Bundle();
//        arguments.putString( BlankFragment.MESSAGE_KEY, "Passed as an argument" );

//        BlankFragment fragment = new BlankFragment();
//        fragment.setArguments( arguments );

        BlankFragment fragment = BlankFragment.newInstance( "Passed to factory method" );
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

    public void onMeasureBtnClick(View view) {
        ScreenUtility su = new ScreenUtility( this );
        mOut.setText( String.format( "Width: %s, Height: %s", su.getDpWidth(), su.getDpHeight() ) );

        // detect width to use fragment
        if (su.getDpWidth() >= 820) {
            mUseFragment = true;
        } else {
            mUseFragment = false;
        }

        Toast.makeText( this, "Using Fragment-" + mUseFragment, Toast.LENGTH_SHORT ).show();

    }
}
