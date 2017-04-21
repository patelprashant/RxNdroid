package com.practice.android.rxndroid;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.android.rxndroid.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataItemRvAdapter extends RecyclerView.Adapter<DataItemRvAdapter.ViewHolder> {
    private final Context mContext;
    private final List<DataItem> mItems;

    public DataItemRvAdapter(Context mContext, List<DataItem> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from( mContext )
                .inflate( R.layout.menu_list_item3, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataItem item = mItems.get( position );
        try {
            String imageFile = item.getImage();
            InputStream inputStream = mContext.getAssets().open( imageFile );
            Drawable d = Drawable.createFromStream( inputStream, null );
            holder.menuImageName.setImageDrawable( d );
            holder.menuItemName.setText( item.getItemName() );
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( mContext, item.getItemName() + " selected", Toast.LENGTH_SHORT )
                        .show();
            }
        } );


        holder.itemView.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText( mContext, item.getItemName() + " long clicked", Toast.LENGTH_SHORT )
                        .show();
                return false;
            }
        } );

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView menuItemName;
        public final ImageView menuImageName;
        public ViewHolder(View itemView) {
            super( itemView );
            menuItemName = (TextView) itemView.findViewById( R.id.menuItemNameText );
            menuImageName = (ImageView) itemView.findViewById( R.id.menuImageView );
        }
    }

}
