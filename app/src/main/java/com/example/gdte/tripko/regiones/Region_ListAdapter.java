package com.example.gdte.tripko.regiones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.RegionItem;

import java.util.ArrayList;
import java.util.List;

public class Region_ListAdapter
extends RecyclerView.Adapter<Region_ListAdapter.ViewHolder> {

    private List<RegionItem> regionItems;
    private final View.OnClickListener clickListener;


    public Region_ListAdapter(View.OnClickListener listener) {

        regionItems = new ArrayList();
        clickListener = listener;
    }

    public void addItem(RegionItem item){
        regionItems.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<RegionItem> items){
        regionItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<RegionItem> items){
        regionItems = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return regionItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.regiones_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(regionItems.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(regionItems.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.regionTextView);
        }
    }
}
