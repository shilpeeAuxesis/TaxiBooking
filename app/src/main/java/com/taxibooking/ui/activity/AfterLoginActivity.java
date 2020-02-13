package com.taxibooking.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.taxibooking.MainActivity;
import com.taxibooking.R;

public class AfterLoginActivity extends AppCompatActivity {
    private static final String TAG = "AfterLoginActivity";
    RelativeLayout rLayoutCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        initUI();
    }

    private void initUI() {
        rLayoutCurrent =findViewById(R.id.rLayoutCurrent);
        rLayoutCurrent.setOnClickListener(v -> {
            startActivity(new Intent(AfterLoginActivity.this, MainActivity.class));
        });
    }


}
