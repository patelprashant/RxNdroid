package com.practice.android.rxndroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.practice.android.rxndroid.model.DataItem;
import com.practice.android.rxndroid.sample.SampleDataProvider;

public class Sample3DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample3_detail );

        String itemId = getIntent().getExtras().getString( DataItemRvAdapter.ITEM_ID_KEY );
        DataItem item = SampleDataProvider.dataItemMap.get( itemId );
        Toast.makeText( this, "Received item : " + item.getItemName(), Toast.LENGTH_SHORT ).show();
    }
}
