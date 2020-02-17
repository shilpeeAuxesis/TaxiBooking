package com.taxibooking.ui.rating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.taxibooking.R;

public class RatingFragment extends Fragment {
    private static final String TAG = "RatingFragment";
    private RatingViewModel ratingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        ratingViewModel = ViewModelProviders.of(this).get(RatingViewModel.class);

        View root = inflater.inflate(R.layout.fragment_rating, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        ratingViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}