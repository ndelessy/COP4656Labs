package edu.mdc.north.cop4656.cop4656labs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ViewHolder> {
    private List<Thing> mDataset;


    public ThingsAdapter(List<Thing> mDataset) {
        this.mDataset = mDataset;
    }

    // CreateS new views (invoked by the layout manager)
    @NonNull
    @Override
    public ThingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.thing_row_layout, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ThingsAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.setText(mDataset.get(position).getName());
        holder.attributeTextView.setText(mDataset.get(position).getAttribute());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // all the views for a data item are provided in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView attributeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView2);
            attributeTextView = (TextView) itemView.findViewById(R.id.attributeTextView2);
        }
    }
}
