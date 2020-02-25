package com.taxibooking.ui.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taxibooking.R;
import com.taxibooking.ui.adapter.VehicleAdapter;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyHolder> {
    Context mContext;
    List<HistoryModel> modelList;

    public HistoryAdapter(Context mContext, List<HistoryModel> modelList) {
        this.mContext = mContext;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_history, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String name = modelList.get(position).getStatus().toLowerCase();
        String mName = name.substring(0, 1).toUpperCase() + name.substring(1);
        holder.tvStatus.setText(mName);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvStatus;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
