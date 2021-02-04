package com.example.coronavirusapi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.coronavirusapi.ui.gallery.GalleryFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    FragmentContant fragmentContant;
    GalleryFragment galleryFragment;
    FragmentRegionl fragmentRegionl;
    FragmentChange fragmentChange;
    DrawerLayout drawer;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
                //drawerOpened = false;
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
                //drawerOpened = true;
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        imageView = findViewById(R.id.image_back);

        fragmentContant = new FragmentContant();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragmentContant)
//                .addToBackStack(fragmentContant.getTag())
                .commit();


//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_activity2, menu);

        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_Regionl:
                fragmentRegionl = new FragmentRegionl();
                getSupportFragmentManager().beginTransaction().
                        setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                        .replace(R.id.container_layout, fragmentRegionl)
                        .addToBackStack(fragmentRegionl.getTag())
                        .commit();
                break;
            case R.id.action_change:
                fragmentChange = new FragmentChange();
                getSupportFragmentManager().beginTransaction().
                        setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                        .replace(R.id.container_layout, fragmentChange)
                        .addToBackStack(fragmentChange.getTag())
                        .commit();
                break;

            case R.id.action_date:

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finishAffinity();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.nav_home: {
                fragmentContant = new FragmentContant();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container_layout, fragmentContant)
                        .addToBackStack(fragmentContant.getTag())
                        .commit();
                getSupportActionBar().setTitle("Home");

                break;
            }
            case R.id.nav_notification:
                galleryFragment = new GalleryFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_layout, galleryFragment)
                        .addToBackStack(galleryFragment.getTag())
                        .commit();
                getSupportActionBar().setTitle("Notification");
                break;

        }
        //close navigation drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finish() {
        super.finish();

        fragmentRegionl = new FragmentRegionl();
        getSupportFragmentManager().beginTransaction().
                setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right);

    }
}