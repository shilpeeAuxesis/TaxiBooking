package com.taxibooking.ui.choose_destination;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.taxibooking.R;

public class ChooseDestinationFragment extends Fragment {
    private static final String TAG = "ChooseDestinationFragme";
    private ChooseDestinationViewModel chooseDestinationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chooseDestinationViewModel = ViewModelProviders.of(this).get(ChooseDestinationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_choose_destination, container, false);
        
        /*TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(TAG, "onChanged: "+"><><><");
                textView.setText(s);
            }
        });*/

        return root;
    }
}