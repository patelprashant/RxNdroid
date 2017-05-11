package com.practice.android.rxndroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.android.rxndroid.model.Product;

import java.text.NumberFormat;

public class ItemFragment extends Fragment{

    private Product mProduct;
    private static final String PRODUCT_KEY = "product_key";

    public static ItemFragment newInstance(Product prouduct) {
        
        Bundle args = new Bundle();
        args.putParcelable( PRODUCT_KEY, prouduct );
        
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments( args );
        return fragment;
    }

    public ItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate( R.layout.fragment_sample7, container, false );

        Bundle args = getArguments();
        if (args == null) throw new AssertionError();

        mProduct = args.getParcelable( PRODUCT_KEY );
        if (mProduct == null) throw new AssertionError();

        TextView nameText = (TextView) rootView.findViewById( R.id.nameText );
        TextView descriptionText = (TextView) rootView.findViewById( R.id.descriptionText );
        TextView priceText = (TextView) rootView.findViewById( R.id.priceText );
        ImageView imageView = (ImageView) rootView.findViewById( R.id.imageView );

        nameText.setText( mProduct.getName() );
        descriptionText.setText( mProduct.getDescription() );

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        String price = numberFormat.format( mProduct.getPrice() );
        priceText.setText( price );

        String productId = mProduct.getProductId();
        int imageResource = getActivity().getResources().getIdentifier( productId, "drawable", getActivity().getPackageName() );
        imageView.setImageResource( imageResource );


        return rootView;
    }
}
