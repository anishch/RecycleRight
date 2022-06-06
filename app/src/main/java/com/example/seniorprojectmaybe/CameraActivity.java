package com.example.seniorprojectmaybe;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seniorprojectmaybe.R;
import com.example.seniorprojectmaybe.ml.ModelSuccess74;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.example.seniorprojectmaybe.ml.ModelSuccess74;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CameraActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Spinner spinnerLanguages;
    Button btLoadImage;
    TextView tvResult,textView2, textView3;
    ImageView ivAddImage;
    ActivityResultLauncher<String> mgetContent;
    int whichModeltoUse = 0;
    String[] modelNames = new String[]{"Model One", "Model Two", "Model Three", "Model Four", "Model Five", "Model Six", "Model Seven", "Model 8"};
    ArrayList<String> modelsNames = new ArrayList<String>(Arrays.asList(modelNames));
    String[] labelNames = new String[]{"Glass Bottles + Jars", "Metal Cans + Scrap Metal", "Paper + Cardboard", "Plastic Bag + Film + Styrofoam", "Plastic Bottles", "Plastic Jugs", "Plastic Tubs + Cups", "Utensils + Small Items", "Wrappers + Food Packaging"};
    ArrayList<String> labelsNames = new ArrayList<String>(Arrays.asList(labelNames));
    String[] labelCategories = new String[]{"Recyclable", "Recyclable", "Recyclable", "Garbage", "Recyclable", "Recyclable", "Recyclable", "Garbage", "Garbage"};
    int[] modelRight = new int[modelNames.length];
    int[] modelGuesses = new int[modelNames.length];
    double[] modelAccuracies = new double[modelNames.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //spinnerLanguages = findViewById(R.id.spinner_languages);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        bottomNav = findViewById(R.id.bottom_navigation_3);
        bottomNav.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        bottomNav.setSelectedItemId(R.id.page_2);
        ivAddImage = findViewById(R.id.iv_add_image);
        //tvResult = findViewById(R.id.result);
        btLoadImage = findViewById(R.id.bt_load_image3);
        textView2 = findViewById(R.id.textView2);
        textView2.setVisibility(View.INVISIBLE);
        textView3 = findViewById(R.id.textView3);

        mgetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                Bitmap imageBitmap = null;
                try {
                    imageBitmap = UriToBitmap(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // ivAddImage.setImageURI(result);
                ivAddImage.setImageBitmap(imageBitmap);
                outputGenerator(imageBitmap);
            }
        });

        btLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mgetContent.launch("image/*");
            }
        });

        /*tvResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/search?q=" +tvResult.getText().toString()));
                startActivity(intent);
            }
        });*/
    }

    private void onNavigationItemSelected(View view) {
    }

    private void outputGenerator(Bitmap imageBitmap) {
        try {
            ModelSuccess74 model = ModelSuccess74.newInstance(CameraActivity.this);

            // Creates inputs for reference.
            TensorImage image = TensorImage.fromBitmap(imageBitmap);

            // Runs model inference and gets result.
            ModelSuccess74.Outputs outputs = model.process(image);
            List<Category> probability = outputs.getProbabilityAsCategoryList();

            // Releases model resources if no longer used.

            int index = 0;
            float max = probability.get(0).getScore();
            for(int i=0;i<probability.size();i++){
                if(max<probability.get(i).getScore()){
                    max=probability.get(i).getScore();
                    index=i;
                }
            }

            Category output = probability.get(index);
            //tvResult.setText(output.getLabel());
            System.out.println(output.getLabel());
            textView2.setVisibility(View.VISIBLE);
            String ultimateCategory = "";
            try {
                ultimateCategory = labelCategories[labelsNames.indexOf(output.getLabel())];
            }
            catch (Exception e){

            }
            String addOn;
            if (ultimateCategory.equals("Recyclable")){
                addOn = "<font color='#103474'>";
            }
            else{
                addOn = "<font color='#107427'>";
            }
            textView2.setText(Html.fromHtml(output.getLabel() + ": "));
            textView3.setText(Html.fromHtml(addOn + ultimateCategory + "</font>"));
            // Releases model resources if no longer used.
            model.close();
        }catch (IOException e) {
            e.printStackTrace();

        }
    }

    private Bitmap UriToBitmap(Uri result) throws IOException {
        return MediaStore.Images.Media.getBitmap(this.getContentResolver(), result);

    }

    public boolean onNavigationItemSelected(MenuItem item) {
        System.out.println("we're here");
        switch (item.getItemId()) {
            case R.id.page_2:
                Toast.makeText(this, "camera", Toast.LENGTH_LONG);
                //startActivity(new Intent(this, About.class));
                return true;

            case R.id.page_3:
                startActivity(new Intent(this, DisplayGuideActivity.class));
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