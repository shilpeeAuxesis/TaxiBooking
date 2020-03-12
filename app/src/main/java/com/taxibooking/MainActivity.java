package com.taxibooking;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        /*for nav header*/
        View headerView = navigationView.getHeaderView(0);

        /*  TextView profilename = (TextView)headerview.findViewById(R.id.prof_username);
          profilename.setText("your name");  */

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navigationView.setItemIconTintList(null);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_confirm_location, R.id.nav_choose_destination, R.id.nav_history,R.id.nav_profile,
                R.id.nav_rating, R.id.nav_faq, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        for (int i = 0; i <=6; i++) {
            navigationView.getMenu().getItem(i).setActionView(R.layout.menu_image_right);
        }
    }

     /* @Override
         public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
       } */

     @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

     }
