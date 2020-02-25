package com.taxibooking.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taxibooking.R;
import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    private static final String TAG = "HistoryFragment";
    private HistoryViewModel slideshowViewModel;
    RecyclerView recyclerViewHistory;
    List<HistoryModel> list = new ArrayList<>();
    HistoryAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerViewHistory =root.findViewById(R.id.recyclerViewHistory);
        list.clear();
        for (int i = 0; i <5 ; i++) {
            HistoryModel model =new HistoryModel();
            model.setStatus("Confirmed");
            list.add(model);
        }

        mAdapter = new HistoryAdapter(getActivity(), list);
        recyclerViewHistory.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewHistory.setLayoutManager(mLayoutManager);
        recyclerViewHistory.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHistory.setAdapter(mAdapter);

        return root;
    }
}