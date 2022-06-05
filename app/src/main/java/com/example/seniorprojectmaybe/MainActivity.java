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
        arrayList.add(new RecycleObject("Aluminum Foil", "Garbage"));
        arrayList.add(new RecycleObject("Amazon Packaging", "Recyclable", true));
        arrayList.add(new RecycleObject("Bag of Chips", "Garbage"));
        arrayList.add(new RecycleObject("Batteries", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Broken Glass", "Garbage"));
        arrayList.add(new RecycleObject("Broken Plate", "Garbage"));
        arrayList.add(new RecycleObject("Broth Container", "Recyclable"));
        arrayList.add(new RecycleObject("Cables", "Garbage"));
        arrayList.add(new RecycleObject("Candy Wrappers", "Garbage"));
        arrayList.add(new RecycleObject("Cardboard", "Recyclable"));
        arrayList.add(new RecycleObject("Cereal Box", "Recyclable"));
        arrayList.add(new RecycleObject("Chains", "Garbage"));
        arrayList.add(new RecycleObject("Clamshell Packaging", "Garbage"));
        arrayList.add(new RecycleObject("Coffee Machine", "Garbage"));
        arrayList.add(new RecycleObject("Cool Ashes", "Garbage"));
        arrayList.add(new RecycleObject("Cup Noodles", "Garbage"));
        arrayList.add(new RecycleObject("Detergent Jug", "Recyclable"));
        arrayList.add(new RecycleObject("Diapers", "Garbage"));
        arrayList.add(new RecycleObject("Fertilizer Jug", "Recyclable"));
        arrayList.add(new RecycleObject("Frozen Food Packaging", "Garbage"));
        arrayList.add(new RecycleObject("Fuel", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Fuel Additive", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Gardening Hose", "Garbage"));
        arrayList.add(new RecycleObject("Gift Wrap", "Recyclable"));
        arrayList.add(new RecycleObject("Glass Soda Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Hangers", "Garbage"));
        arrayList.add(new RecycleObject("Heat to Eat", "Garbage"));
        arrayList.add(new RecycleObject("Kitchen Grease", "Garbage"));
        arrayList.add(new RecycleObject("Lightbulb", "Garbage"));
        arrayList.add(new RecycleObject("Magazine", "Recyclable"));
        arrayList.add(new RecycleObject("Masks", "Garbage"));
        arrayList.add(new RecycleObject("Metal Lids", "Recyclable"));
        arrayList.add(new RecycleObject("Metal Pans", "Recyclable"));
        arrayList.add(new RecycleObject("Milk Carton", "Recyclable"));
        arrayList.add(new RecycleObject("Milk Jugs", "Recyclable"));
        arrayList.add(new RecycleObject("Newspaper", "Recyclable"));
        arrayList.add(new RecycleObject("Non-Empty Bug Killer", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Non-Empty Fire Extinguisher", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Non-Empty Weed Killer", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Non-Plastic Bottle Caps", "Garbage"));
        arrayList.add(new RecycleObject("Orange Pill Bottle", "Garbage"));
        arrayList.add(new RecycleObject("Overwrap", "Recyclable"));
        arrayList.add(new RecycleObject("Paper Cups", "Recyclable"));
        arrayList.add(new RecycleObject("Penzoil Motor Oil", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Coke/Pepsi Can", "Recyclable"));
        arrayList.add(new RecycleObject("Plastic Bag", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Covers", "Recyclable"));
        arrayList.add(new RecycleObject("Plastic Plates", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Cup", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Gloves", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Straws", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Utensils", "Garbage"));
        arrayList.add(new RecycleObject("Plastic Wide Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Plastic Yogurt Container", "Recyclable"));
        arrayList.add(new RecycleObject("Plastic Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Prestone Fluid", "Hazardous Waste"));
        arrayList.add(new RecycleObject("Purell Wipes", "Garbage"));
        arrayList.add(new RecycleObject("Sauce Container", "Recyclable"));
        arrayList.add(new RecycleObject("Scissors", "Garbage"));
        arrayList.add(new RecycleObject("Soup Can", "Recyclable"));
        arrayList.add(new RecycleObject("Spray Can", "Recyclable"));
        arrayList.add(new RecycleObject("Spread Container", "Recyclable"));
        arrayList.add(new RecycleObject("Sprite Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Styrofoam (To-Go Box)", "Garbage"));
        arrayList.add(new RecycleObject("Styrofoam (Other)", "Garbage"));
        arrayList.add(new RecycleObject("Toaster", "Garbage"));
        arrayList.add(new RecycleObject("Vomit Bag", "Garbage"));
        arrayList.add(new RecycleObject("Wide Medicine Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Wine Bottle", "Recyclable"));
        arrayList.add(new RecycleObject("Wood Stud", "Compost"));
        arrayList.add(new RecycleObject("         ", ""));
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
        int j = 0;
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isSelected()) {
                j++;
                str += (i + 1) + ". ";
                str += arrayList.get(i).getCategory().toLowerCase().equals("recyclable") ? "Put the " + arrayList.get(i).getName() + " in the Recycle Bin." : "";
                str += arrayList.get(i).getCategory().toLowerCase().equals("garbage") ? "Put the " + arrayList.get(i).getName() + " in the Garbage Bin." : "";
                str += arrayList.get(i).getCategory().toLowerCase().equals("compost") ? "Put the " + arrayList.get(i).getName() + " in the Compost Bin." : "";
                str += arrayList.get(i).getCategory().toLowerCase().equals("hazardous waste") ? "DO NOT put the " + arrayList.get(i).getName() + " in ANY Bin. " : "";
                str += arrayList.get(i).getCategory().toLowerCase().equals("hazardous waste") ? "Dispose safely at a Drop-Off site." : "";
                str += "\n";
                str += "\n";
            }
        }
        if (str.equals("")){
            str = "Nothing selected!";
        }
        if (j > 8){
            Toast.makeText(this, "A maximum of 8 can be selected at once.", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this, InstructionActivity.class);
            String message = str;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            // Do something in response to button
        }
    }
}