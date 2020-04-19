package com.example.gdte.tripko.sitiosturisticos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.Sitios_TuristicosItem;

import java.util.ArrayList;
import java.util.List;

public class Sitios_TuristicosAdapter
extends  RecyclerView.Adapter<Sitios_TuristicosAdapter.ViewHolder>{

    private List<Sitios_TuristicosItem> itemList;
    private final View.OnClickListener clickListener;


    public Sitios_TuristicosAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void addItem(Sitios_TuristicosItem item){
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<Sitios_TuristicosItem> items){
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<Sitios_TuristicosItem> items){
        itemList = items;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sitios_turisticos_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        holder.titleButton.setText(itemList.get(position).title);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Button titleButton;

        ViewHolder(View view) {
            super(view);
            titleButton = view.findViewById(R.id.sitioTuristicoButton);
        }
    }
}
