package com.example.seniorprojectmaybe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarMenuView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public static final String EXTRA_MESSAGE = "com.example.seniorprojectmaybe.MESSAGE";

    BottomNavigationView bottomNav;
    Button sendButton;
    RecyclerView rView;
    ArrayList<RecycleObject> arrayList;
    SearchView searchView;
    FloatingActionButton fab;
    RecyclerAdapter adapter;
    RecycleList rList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("hello habibi");
        super.onCreate(savedInstanceState);
        rList = new RecycleList();
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this::sendMessage);
        searchView = (SearchView) findViewById(R.id.search);
        bottomNav = findViewById(R.id.bottom_navigation);
        rView = findViewById(R.id.recycler_view);
        bottomNav.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        arrayList = new ArrayList<RecycleObject>();
        setObjectInfo();
        setAdapter();
        searchView.setOnQueryTextListener(this);
    }

    private void setObjectInfo(){
        arrayList.add(new RecycleObject("bottle", "recyclable", false));
        arrayList.add(new RecycleObject("raw celery ", "yakult", true));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        arrayList.add(new RecycleObject("raw celery", "yakult"));
        System.out.println("setObjectInfo(): " + arrayList);
    }

    private void setAdapter(){
        System.out.println("setAdapter(): " + arrayList);
        adapter = new RecyclerAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rView.setLayoutManager(layoutManager);
        rView.setItemAnimator(new DefaultItemAnimator());
        rView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_navigation_menu, menu);
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        System.out.println("we're here");
        switch (item.getItemId()) {
            case R.id.page_2:
                startActivity(new Intent(this, CameraActivity.class));
                Toast.makeText(this, "camera", Toast.LENGTH_LONG);
                //startActivity(new Intent(this, About.class));
                return true;

            case R.id.page_3:
                //Toast.makeText(this, "camera", Toast.LENGTH_LONG);
                startActivity(new Intent(this, DisplayGuideActivity.class));
                return true;

            case R.id.page_1:
                Toast.makeText(this, "manual", Toast.LENGTH_LONG);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        System.out.println("onQueryTextSubmit reached");
        // do something on text submit
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        System.out.println("onQueryTextChange(): " +  newText);
        String text = newText;
        adapter.filter(text);
        return false;
    }

    public void sendMessage(View v) {
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isSelected()) {
                str += (i + 1) + ". ";
                str += arrayList.get(i).getCategory().equals("recyclable") ? "put this item in the blue bin (recycle)" : "";
                str += arrayList.get(i).getCategory().equals("compost") ? "put this item in the red bin (recycle)" : "";
                str += arrayList.get(i).getCategory().equals("yard waste") ? "put this item in the gray bin (recycle)" : "";
                str += "\n";
            }
        }
        if (str.equals("")){
            str = "Nothing selected!";
        }
        Intent intent = new Intent(this, InstructionActivity.class);
        String message = str;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        // Do something in response to button
    }
}