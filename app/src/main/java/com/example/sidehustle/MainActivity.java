package com.example.sidehustle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().add(R.id.main_container, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        selectedFragment = new HomeFragment();
                        break;

                    case R.id.menu_track:
                        selectedFragment = new TrackFragment();
                        break;

                    case R.id.menu_player:
                        selectedFragment = new PlayerFragment();
                        break;

                    case R.id.menu_profile:
                        selectedFragment = new ProfileFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, selectedFragment).commit();
                return true;
            }
        });
    }
}