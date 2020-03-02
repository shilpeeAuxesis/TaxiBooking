package com.taxibooking.ui.faq;

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

public class FAQFragment extends Fragment {
    private static final String TAG = "FAQFragment";
    private FAQViewModel shareViewModel;
    RecyclerView recyclerViewFAQ;
    List<FAQModel> list =new ArrayList<>();
    FAQAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        shareViewModel = ViewModelProviders.of(this).get(FAQViewModel.class);
        View root = inflater.inflate(R.layout.fragment_faq, container, false);
        recyclerViewFAQ =root.findViewById(R.id.recyclerViewFAQ);
        list.clear();

        for (int i = 0; i <5 ; i++) {
            FAQModel model =new FAQModel();
            model.setHeader("1. Lorem Ipsum is simply dummy");
            model.setmSubTittle("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
            list.add(model);
        }

        mAdapter = new FAQAdapter(getActivity(), list);
        recyclerViewFAQ.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewFAQ.setLayoutManager(mLayoutManager);
        recyclerViewFAQ.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFAQ.setAdapter(mAdapter);

        /* final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */

        return root;
    }
}