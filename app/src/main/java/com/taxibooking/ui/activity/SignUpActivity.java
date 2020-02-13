package com.taxibooking.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.taxibooking.R;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    RelativeLayout rLayoutSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initUI();
    }

    private void initUI() {
        rLayoutSignIn =findViewById(R.id.rLayoutSignIn);
        rLayoutSignIn.setOnClickListener( v -> {
            startActivity(new Intent(SignUpActivity.this,SignIn.class));
        });
    }
}
