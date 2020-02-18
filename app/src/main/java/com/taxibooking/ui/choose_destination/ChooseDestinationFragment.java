package com.taxibooking.ui.choose_destination;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.taxibooking.R;

public class ChooseDestinationFragment extends Fragment {
    private static final String TAG = "ChooseDestinationFragme";
    private ChooseDestinationViewModel chooseDestinationViewModel;
    RelativeLayout rLayoutExpand;
    BottomSheetDialog dialog_1;
    LinearLayout lLayPayment, lLayCoupon;
    Button btnChooseVehicle;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chooseDestinationViewModel = ViewModelProviders.of(this).get(ChooseDestinationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_choose_destination, container, false);


        rLayoutExpand = root.findViewById(R.id.rLayoutExpand);
        rLayoutExpand.setOnClickListener(v -> {

            getBottomSheet();
        });

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

    //For Camera
    private void getBottomSheet() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        dialog_1 = new BottomSheetDialog(getActivity());
        dialog_1.setContentView(view);
        lLayPayment = dialog_1.findViewById(R.id.lLayPayment);
        lLayCoupon = dialog_1.findViewById(R.id.lLayCoupon);
        btnChooseVehicle = dialog_1.findViewById(R.id.btnChooseVehicle);
        /*lLayRemove = dialog_1.findViewById(R.id.lLayRemove);
        btnCancel = dialog_1.findViewById(R.id.btnCancel);
*/
        lLayPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

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

        dialog_1.show();
    }

}