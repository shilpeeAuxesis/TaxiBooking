package com.taxibooking.ui.faq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.taxibooking.R;
import com.taxibooking.ui.history.HistoryModel;

import java.util.List;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.MyHolder> {
    Context mContext;
    List<FAQModel> modelList;

    public FAQAdapter(Context mContext, List<FAQModel> modelList) {
        this.mContext = mContext;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_faq, parent, false);
        return new MyHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
       // String name = modelList.get(position).getHeader().toLowerCase();
      //  String mName = name.substring(0, 1).toUpperCase() + name.substring(1);
        holder.tvHeader.setText(modelList.get(position).getHeader().toLowerCase());
        holder.tvContent.setText(modelList.get(position).getmSubTittle());
    }
    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvHeader,tvContent;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeader);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
