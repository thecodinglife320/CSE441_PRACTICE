package com.hfad.listviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CountryViewHolder> {

    private List<Country> countries;

    public CustomAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.flag.setImageResource(countries.get(position).getFlag());
        holder.thuDo.setText(countries.get(position).getThuDo());
        holder.tenNuoc.setText(countries.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        ImageView flag;
        TextView tenNuoc, thuDo;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            tenNuoc = itemView.findViewById(R.id.ten_nuoc);
            thuDo = itemView.findViewById(R.id.ten_thu_do);
        }
    }
}