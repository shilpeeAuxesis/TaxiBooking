package com.taxibooking.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.taxibooking.R;
import static com.taxibooking.ui.constant.Utils.isInternetConnected;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private static int SPLASH_SCREEN_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //
        initUI();
    }

    private void initUI() {
        if (isInternetConnected(getApplicationContext())){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(SplashActivity.this, IntroductionSplashActivity.class);
                    startActivity(mainIntent);
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
                }
            }, SPLASH_SCREEN_TIME_OUT);
        }else {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SplashActivity.this);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle(R.string.no_internet);
            alertBuilder.setMessage("Please turn on internet connection to continue");
            alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alert = alertBuilder.create();
            alert.show();
        }
    }
}
