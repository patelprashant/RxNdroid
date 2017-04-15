package com.practice.android.rxndroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class myStringAdapter extends RecyclerView.Adapter<myStringAdapter.ViewHolder> {

    private final Context mContext;
    private final List<String> mStrings;

    public myStringAdapter(Context mContext, List<String> mStrings) {
        this.mContext = mContext;
        this.mStrings = mStrings;
    }


    public void setStrings(List<String> newStrings){
        mStrings.clear();
        mStrings.addAll(newStrings);
//        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.string_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mColorDisplay.setText(mStrings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mColorDisplay;

        public ViewHolder(View itemView) {
            super(itemView);
            mColorDisplay = (TextView) itemView.findViewById(R.id.color_display);
        }
    }
}
