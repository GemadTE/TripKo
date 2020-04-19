package com.example.gdte.tripko.entretenimiento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.EntretenimientoItem;

import java.util.ArrayList;
import java.util.List;

public class EntretenimientoAdapter
        extends RecyclerView.Adapter<EntretenimientoAdapter.ViewHolder> {

    private List<EntretenimientoItem> itemList;
    private final View.OnClickListener clickListener;

    public EntretenimientoAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void addItem(EntretenimientoItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<EntretenimientoItem> items) {
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<EntretenimientoItem> items) {
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
                .inflate(R.layout.entretenimiento_list_content, parent, false);
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
            titleButton = view.findViewById(R.id.entretenimientoButton);
        }
    }
}
