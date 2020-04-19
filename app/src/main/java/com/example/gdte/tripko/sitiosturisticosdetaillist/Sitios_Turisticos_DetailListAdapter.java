package com.example.gdte.tripko.sitiosturisticosdetaillist;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.gdte.tripko.R;
import com.example.gdte.tripko.data.Sitios_TuristicosDetailItem;

import java.util.ArrayList;
import java.util.List;

public class Sitios_Turisticos_DetailListAdapter
        extends RecyclerView.Adapter<Sitios_Turisticos_DetailListAdapter.ViewHolder> {


    private List<Sitios_TuristicosDetailItem> itemList;
    private final View.OnClickListener clickListener;


    public Sitios_Turisticos_DetailListAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }


    public void addItem(Sitios_TuristicosDetailItem item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItems(List<Sitios_TuristicosDetailItem> items) {
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void setItems(List<Sitios_TuristicosDetailItem> items) {
        itemList = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_sitios__turisticos__detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.titleView.setText(itemList.get(position).title);
        loadImageFromURL(holder.imageView, itemList.get(position).image);

        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleView;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            titleView = view.findViewById(R.id.title1);
            imageView = view.findViewById(R.id.imageView2);
        }
    }

    /**
     * Load an image from an URL
     *
     * @param imageView image where it's saved
     * @param imageUrl  image's URL
     */
    private void loadImageFromURL(ImageView imageView, String imageUrl) {
        RequestManager reqManager = Glide.with(imageView.getContext());
        RequestBuilder reqBuilder = reqManager.load(imageUrl);
        RequestOptions reqOptions = new RequestOptions();
        reqBuilder.into(imageView);
    }
}
