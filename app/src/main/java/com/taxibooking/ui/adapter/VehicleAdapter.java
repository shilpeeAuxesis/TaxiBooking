package com.taxibooking.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.taxibooking.R;
import com.taxibooking.ui.choose_destination.choose_model.VehicleModel;
import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyHolder> {
    private List<VehicleModel> arrayList;
    Context mContext;
    Activity mActivity;
    BottomSheetDialog dialog_1;
    LinearLayout lLayCancelBooking;

    public VehicleAdapter(Context mContext, Activity mActivity, List<VehicleModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_vehicle, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        if (position==arrayList.size()-1){
            holder.btnConfirmVehicle.setVisibility(View.VISIBLE);
            holder.rLayoutM.setVisibility(View.GONE);
            holder.btnConfirmVehicle.setOnClickListener(v -> {
                getConfirmVehicle();
            });
        }else {
            holder.btnConfirmVehicle.setVisibility(View.GONE);
            holder.rLayoutM.setVisibility(View.VISIBLE);
            String name = arrayList.get(position).getVehicleName().toLowerCase();
            String mName = name.substring(0, 1).toUpperCase() + name.substring(1);
            holder.tvVehicleName.setText(mName);
            /* holder.tvSubTittle.setText(arrayList.get(position).getmLocation());*/

            holder.lLayoutH.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  getConfirmVehicle();
                    Toast.makeText(mContext, arrayList.get(position).getVehicleName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void getConfirmVehicle() {
        View view = mActivity.getLayoutInflater().inflate(R.layout.bottom_sheet_confirm_vehicle, null);
        dialog_1 = new BottomSheetDialog(mActivity);
        dialog_1.setContentView(view);
        lLayCancelBooking =dialog_1.findViewById(R.id.lLayCancelBooking);
        lLayCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "Cancelled", Toast.LENGTH_SHORT).show();
                NavController navController = Navigation.findNavController(mActivity, R.id.nav_host_fragment);
                navController.navigateUp();
                dialog_1.dismiss();
                //navController.navigateUp(R.id.action_nav_choose_destination_to_chooseVehicleFragment);
            }
        });

      /*  lLayPayment = dialog_1.findViewById(R.id.lLayPayment);
        lLayCoupon = dialog_1.findViewById(R.id.lLayCoupon);
        btnChooseVehicle = dialog_1.findViewById(R.id.btnChooseVehicle);
        *//*lLayRemove = dialog_1.findViewById(R.id.lLayRemove);
        btnCancel = dialog_1.findViewById(R.id.btnCancel);
     *//*
        lLayCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        btnChooseVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_choose_destination_to_chooseVehicleFragment);
                dialog_1.dismiss();
            }
        });
       */
        dialog_1.show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvVehicleName, tvAmount;
        LinearLayout lLayoutH;
        ImageView ivCar;
        Button btnConfirmVehicle;
        RelativeLayout rLayoutM;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            lLayoutH = itemView.findViewById(R.id.lLayoutH);
            tvVehicleName = itemView.findViewById(R.id.tvVehicleName);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            ivCar = itemView.findViewById(R.id.ivCar);
            btnConfirmVehicle = itemView.findViewById(R.id.btnConfirmVehicle);
            rLayoutM = itemView.findViewById(R.id.rLayoutM);
        }
    }
}
