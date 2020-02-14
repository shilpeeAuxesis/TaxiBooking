package com.taxibooking.ui.choose_destination;

import android.os.Bundle;
import android.util.Log;
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

public class ChooseDestinationFragment extends Fragment {
    private static final String TAG = "ChooseDestinationFragme";
    private ChooseDestinationViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(ChooseDestinationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_choose_destination, container, false);
        
        TextView textView = root.findViewById(R.id.text_gallery);

        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "onChanged: "+"><><><");
                textView.setText(s);
            }
        });

        return root;
    }
}