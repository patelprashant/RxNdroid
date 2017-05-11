package com.practice.android.rxndroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.practice.android.rxndroid.model.Product;
import com.practice.android.rxndroid.sample.SampleDataViewPager;

import java.util.List;


public class Sample7Activity extends AppCompatActivity {

    private final List<Product> products = SampleDataViewPager.productList;
    private final int numPages = products.size();
    private ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample7 );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        mPager = (ViewPager) findViewById( R.id.pager );
        PagerAdapter pagerAdapter = new ViewPagerAdapter( getSupportFragmentManager() );
        mPager.setAdapter( pagerAdapter );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            return ItemFragment.newInstance( products.get( position ) );
        }

        @Override
        public int getCount() {
            return numPages;
        }
    }
}