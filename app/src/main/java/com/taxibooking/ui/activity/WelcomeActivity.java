package com.taxibooking.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.taxibooking.R;
import com.taxibooking.ui.adapter.CustomViewPagerAdapter;
import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";
    boolean doubleBackToExitPressedOnce = false;
    ViewPager viewPager;
    LinearLayout llPagerDots;
    Button btnSkip;
    private ArrayList<Integer> logoImg = new ArrayList<>();
    private ArrayList<Integer> centerImg = new ArrayList<>();
    private ArrayList<String> headerMess = new ArrayList<>();
    private ArrayList<String> message_1 = new ArrayList<>();
    private ArrayList<String> message_2 = new ArrayList<>();
    private ImageView[] ivArrayDotsPager;
    CustomViewPagerAdapter mAdapter;
    int lastIdx = 0;
    int curItem = 0;
    boolean lastPageChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initUi();
    }

    private void initUi() {
        //For logo
        logoImg.clear();
        logoImg.add(R.drawable.car);
        logoImg.add(R.drawable.car);
        logoImg.add(R.drawable.car);
        //for header message
        headerMess.clear();
        headerMess.add("TAXIFY");
        headerMess.add("TAXIFY");
        headerMess.add("TAXIFY");
        //For center image
        centerImg.clear();
        centerImg.add(R.drawable.business_person);
        centerImg.add(R.drawable.smartphone);
        centerImg.add(R.drawable.call_center);
        //for message
        message_1.clear();
        message_1.add("Professional Drivers");
        message_1.add("Lowest Fare");
        message_1.add("24 * 7 Services");
        //For message 2
        message_2.clear();
        message_2.add("The first mate and his Skipper too will do their very comfortable in their tropic island nest");
        message_2.add("The first mate and his Skipper too will do their very comfortable in their tropic island nest");
        message_2.add("The first mate and his Skipper too will do their very comfortable in their tropic island nest");

        //For view pager
        llPagerDots = findViewById(R.id.llPagerDots);
        btnSkip = findViewById(R.id.btnSkip);
        viewPager = findViewById(R.id.viewPager);
        btnSkip.setOnClickListener(v -> {
           // startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            //startActivity(new Intent(WelcomeActivity.this, SignIn.class));
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            overridePendingTransition(R.anim.enter, R.anim.exit);
            finish();
        });

        mAdapter = new CustomViewPagerAdapter(WelcomeActivity.this, logoImg, headerMess, centerImg, message_1, message_2);
        viewPager.setAdapter(mAdapter);
        setupPagerIndidcatorDots();
        ivArrayDotsPager[0].setImageResource(R.drawable.active_dot_indicator);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ivArrayDotsPager.length; i++) {
                    ivArrayDotsPager[i].setImageResource(R.drawable.inactive_dot_indicator);
                }
                ivArrayDotsPager[position].setImageResource(R.drawable.active_dot_indicator);
                Log.d(TAG, "onPageSelected: " + String.valueOf(position));
              /*  if (position==2){
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged: " + String.valueOf(state));
                // Log.d(TAG, "onPageScrollStateChanged: "+String.valueOf(mAdapter.getCount()-1));
                lastIdx = mAdapter.getCount() - 1;
                curItem = viewPager.getCurrentItem();
               /* if (curItem == lastIdx && state == 1) {
                    lastPageChange = true;
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
                } else {
                    lastPageChange = false;
                    Log.d("tag", "page scroll " + lastPageChange);
                }*/

               /*
                runOnUiThread(new Runnable() {
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                        Log.d(TAG, "run: " + "Calling ");
                    }
                });

                if (curItem == lastIdx *//*&& lastPos==lastIdx*//* && state == 1) {
                    lastPageChange = true;
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
                } else {
                    lastPageChange = false;
                    Log.d("tag", "page scroll state outside>>lastPageChange>> ********" + lastPageChange);
                }*/
            }
        });
    }

    private void setupPagerIndidcatorDots() {
        ivArrayDotsPager = new ImageView[message_1.size()];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.inactive_dot_indicator);
            ivArrayDotsPager[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setAlpha(1);
                }
            });
            llPagerDots.addView(ivArrayDotsPager[i]);
            llPagerDots.bringToFront();
        }
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
