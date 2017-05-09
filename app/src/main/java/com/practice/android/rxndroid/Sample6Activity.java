package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.practice.android.rxndroid.model.Person;

public class Sample6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample6 );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
//                        .setAction( "Action", null ).show();
                showDialog();
            }
        } );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }

    private void showDialog() {
        Person p = new Person( "Prashant", "Patel", 25 );

        DataEntryDialog dialog = DataEntryDialog.newInstance( p );
        dialog.show( getFragmentManager(), "DIALOG_FRAGMENT" );
    }

}
