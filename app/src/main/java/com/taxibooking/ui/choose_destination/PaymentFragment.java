package com.taxibooking.ui.choose_destination;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taxibooking.R;

public class PaymentFragment extends Fragment {
    private static final String TAG = "PaymentFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment, container, false);


        return root;
    }
}
