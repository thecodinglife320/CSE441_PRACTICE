package com.example.calendarnotes;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calendarnotes.databinding.WorkItemBinding;

import java.util.List;

public class WorkListChieuAd extends RecyclerView.Adapter<WorkListChieuAd.ViewHolder> {
    private List<String> workList;
    public WorkListChieuAd(List<String> workList) {
        this.workList = workList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorkItemBinding binding = WorkItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(workList.get(position));
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }
    public void addWork(String work) {
        workList.add(work);
        notifyItemInserted(workList.size()-1);
    }
    static public class ViewHolder extends RecyclerView.ViewHolder {
        private WorkItemBinding binding;
        public ViewHolder(WorkItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(String work) {
            binding.getRoot().setText(work);
        }
    }
}
