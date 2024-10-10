package com.example.dssinhvien;

import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {

    private List<SinhVien> items;

    public SinhVienAdapter(List<SinhVien> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView fullname;
        public TextView gpa;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            fullname = itemView.findViewById(R.id.name);
            gpa = itemView.findViewById(R.id.gpa);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SinhVien item = items.get(position);
        holder.id.setText(item.id);
        holder.fullname.setText(String.valueOf(item.full_name));
        holder.gpa.setText(String.valueOf(item.gqa));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
