package com.example.gdte.tripko.gastronomialist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.GastronomiaItem;

import java.util.ArrayList;
import java.util.List;

public class GastronomiaListAdapter
extends RecyclerView.Adapter<GastronomiaListAdapter.ViewHolder> {

    private List<GastronomiaItem> gastronomiaItems;
    private final View.OnClickListener clickListener;


    public GastronomiaListAdapter(View.OnClickListener listener) {

        gastronomiaItems = new ArrayList();
        clickListener = listener;
    }

    public void addItem(GastronomiaItem item){
        gastronomiaItems.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<GastronomiaItem> items){
        gastronomiaItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<GastronomiaItem> items){
        gastronomiaItems = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return gastronomiaItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gastronomia_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(gastronomiaItems.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.contentView.setText(gastronomiaItems.get(position).content);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Button contentView;

        ViewHolder(View view) {
            super(view);
            contentView = view.findViewById(R.id.restauranteButton);
        }
    }
}
