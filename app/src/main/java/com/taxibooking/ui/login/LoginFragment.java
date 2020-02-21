package com.taxibooking.ui.login;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.taxibooking.R;
import com.taxibooking.ui.activity.AfterLoginActivity;

public class LoginFragment extends Fragment {
    private static final String TAG = "LoginFragment";
    private LoginViewModel mViewModel;
    Button btnLogin;
    EditText edtEmail, edtPassword;
    String error_msg = "";

    //DatabaseReference myRef;
   // DatabaseReference rootRef, demoRef;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.login_fragment, container, false);
        edtEmail = root.findViewById(R.id.edtEmail);
        edtPassword = root.findViewById(R.id.edtPassword);

        btnLogin = root.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AfterLoginActivity.class));
        });
       /* //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("Testing");
        */


        /*
        btnLogin.setOnClickListener(v -> {
            Log.d(TAG, "onCreateView: "+">>>>>>>>>"+demoRef);
            String value = edtEmail.getText().toString();
            demoRef.child("value").setValue(value);
            //demoRef.push().setValue(value);
            Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
            */


     /*if (isInternetConnected(getActivity())) {
                if (Validation()) {
                    getLogin();
                } else {
                    Toast.makeText(getActivity(), error_msg, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), getResources().getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show();
            }*//*
           */
/* // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            Log.d(TAG, "onCreateView: " + "database-------" + database.toString());
            DatabaseReference myRef = database.getReference("message");
            myRef.setValue("Welcome to first application");
*//*
            //startActivity(new Intent(getActivity(), AfterLoginActivity.class));
        });
*/

        return root;
    }


   /* private void getLogin() {
       *//* String email =edtEmail.getText().toString().trim();
        String mPassword =edtPassword.getText().toString().trim();*//*

        LoginModel model = new LoginModel();
        model.setEmail(edtEmail.getText().toString().trim());
        model.setPassword(edtPassword.getText().toString().trim());
        // myRef = FirebaseDatabase.getInstance().getReference().child("Login");
        myRef = FirebaseDatabase.getInstance().getReference();
        Log.d(TAG, "getLogin: " + ">>>>>>>>>>>>" + myRef.toString());
        Log.d(TAG, "getLogin: " + ">>>" + model.getEmail());
        myRef.setValue(model);
        Toast.makeText(getActivity(), "Data save successfully...", Toast.LENGTH_SHORT).show();
    }*/

    private boolean Validation() {
        error_msg = "";
        if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
            error_msg = getString(R.string.enter_email);
            return false;
        } else if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
            error_msg = getString(R.string.enter_password);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

}
