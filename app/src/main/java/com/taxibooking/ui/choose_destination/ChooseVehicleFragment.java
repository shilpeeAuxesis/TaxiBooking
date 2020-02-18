package com.taxibooking.ui.choose_destination;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taxibooking.R;
import com.taxibooking.ui.adapter.VehicleAdapter;
import com.taxibooking.ui.choose_destination.choose_model.VehicleModel;

import java.util.ArrayList;
import java.util.List;

public class ChooseVehicleFragment extends Fragment {
    private static final String TAG = "ChooseVehicleFragment";
    RecyclerView recyclerView;
    VehicleAdapter adapter;
    List<VehicleModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_choose_vehicle, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        for (int i = 0; i <10 ; i++) {
            VehicleModel model = new VehicleModel();
            model.setVehicleName("Hatchback");
            list.add(model);
        }

        adapter = new VehicleAdapter(getActivity(),getActivity(), list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }

}
