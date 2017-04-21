package com.practice.android.rxndroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practice.android.rxndroid.R;
import com.practice.android.rxndroid.SampleActivityWithName;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    private Context context;
    private List<SampleActivityWithName> samples;

    public SampleAdapter(Context context, List<SampleActivityWithName> samples) {
        this.context = context;
        this.samples = samples;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.sample_list_item1, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.nameDisplay.setText(samples.get(position).mSampleName);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent sampleIntent = new Intent(context, samples.get(position).mSampleActivityClass);
                context.startActivities(new Intent[]{sampleIntent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameDisplay;

        public ViewHolder(View itemView) {
            super(itemView);
            nameDisplay = (TextView) itemView.findViewById(R.id.name_display);
        }
    }
}
