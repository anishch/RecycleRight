package com.example.seniorprojectmaybe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class DisplayGuideActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_guide);
        bottomNav = findViewById(R.id.bottom_navigation_3);
        bottomNav.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        //bottomNav.getMenu().findItem(R.id.page_3).setEnabled(false);
        bottomNav.setSelectedItemId(R.id.page_3);
        //super.onOptionsItemSelected(bottomNav.getMenu().findItem(R.id.page_3));
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        System.out.println("we're here");
        switch (item.getItemId()) {
            case R.id.page_2:
                Toast.makeText(this, "camera", Toast.LENGTH_LONG);
                //startActivity(new Intent(this, About.class));
                return true;

            case R.id.page_3:
                //Toast.makeText(this, "camera", Toast.LENGTH_LONG);
                return true;

            case R.id.page_1:
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "manual", Toast.LENGTH_LONG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}