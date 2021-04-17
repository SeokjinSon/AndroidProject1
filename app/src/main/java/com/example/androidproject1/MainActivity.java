package com.example.androidproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // Debug Value
    private final static boolean    D       = true;
    private final static String     TAG     = "MainActivity";

    // Fragment Value
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;

    // View Value
    private BottomNavigationView navigationView;

    // Listener Value
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelect
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()) {
                case R.id.page_1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment1).commit();
                    return true;
                case R.id.page_2:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2).commit();
                    return true;
                case R.id.page_3:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment3).commit();
                    return true;
            }
            return false;
        }
    };

    // Override Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // NavigationView에 리스너 등록
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelect);
        // Home Fragment가 먼저 실행되도록
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment1).commit();
        if(D)
            Log.i(TAG, "onCreate() Success!");
    }

    public void init() {
        fragment1 = new FragmentHome();
        fragment2 = new FragmentSearch();
        fragment3 = new FragmentMyPage();
        navigationView = findViewById(R.id.bottom_navigation);

        if(D)
            Log.i(TAG, "init() Success!");
    }
}