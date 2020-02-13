package com.taxibooking.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.taxibooking.R;

public class SignIn extends AppCompatActivity {
    private static final String TAG = "SignIn";
    RelativeLayout rLayoutSignUp;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initUI();
    }

    private void initUI() {
        rLayoutSignUp = findViewById(R.id.rLayoutSignUp);
        btnLogin =findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignIn.this,AfterLoginActivity.class));
        });
        rLayoutSignUp.setOnClickListener(v -> {
            startActivity(new Intent(SignIn.this, SignUpActivity.class));
        });
    }
}
