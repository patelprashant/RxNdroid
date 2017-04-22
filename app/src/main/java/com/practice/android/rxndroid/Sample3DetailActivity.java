package com.practice.android.rxndroid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.android.rxndroid.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class Sample3DetailActivity extends AppCompatActivity {

    private TextView tvName, tvDescription, tvPrice;
    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sample3_detail );
        setupActionBar();

//        String itemId = getIntent().getExtras().getString( DataItemRvAdapter.ITEM_ID_KEY );
//        DataItem item = SampleDataProvider.dataItemMap.get( itemId );

        DataItem item = getIntent().getExtras().getParcelable( DataItemRvAdapter.ITEM_KEY );

        if (item == null) {
//            Toast.makeText( this, "Received item : " + item.getItemName(), Toast.LENGTH_SHORT ).show();
            throw new AssertionError( "Null Data Item received..!!" );
        }

        tvName = (TextView) findViewById( R.id.tvItemName );
        tvPrice = (TextView) findViewById( R.id.tvPrice );
        tvDescription = (TextView) findViewById( R.id.tvDescription );
        itemImage = (ImageView) findViewById( R.id.itemImage );

        tvName.setText( item.getItemName() );

        NumberFormat nf = NumberFormat.getCurrencyInstance( Locale.getDefault() );
        tvPrice.setText( nf.format( item.getPrice() ) );

        tvDescription.setText( item.getDescription() );

        InputStream inputStream = null;
        try {
            inputStream = getAssets().open( item.getImage() );
            Drawable d = Drawable.createFromStream( inputStream, null );
            itemImage.setImageDrawable( d );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.menu_detail_title);
        }
    }
}
