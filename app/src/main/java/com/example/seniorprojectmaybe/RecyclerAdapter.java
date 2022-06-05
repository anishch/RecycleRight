package com.example.seniorprojectmaybe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private ArrayList<RecycleObject> objectList;
    private ArrayList<RecycleObject> objectNamesList = null;

    public RecyclerAdapter(ArrayList<RecycleObject> list){
        System.out.println("RecyclerAdapter() constructor:" + list);
        this.objectList = list;
        this.objectNamesList = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView objectPicture;
        private TextView name;
        private TextView bin;
        private CheckBox isSelected;

        public MyViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.object_name);
            bin = v.findViewById(R.id.object_bin);
            isSelected = v.findViewById(R.id.check_box);
            objectPicture = v.findViewById(R.id.object_image);
            //isSelected.setOnCheckedChangeListener(CompoundButton::setChecked);
            isSelected.setOnCheckedChangeListener(this::createNotification);
        }

        private void createNotification(CompoundButton compoundButton, boolean b) {
            System.out.println("BUTTON CHANGED");
            System.out.println(this.getAdapterPosition());
            System.out.println(compoundButton.isSelected());
            System.out.println(b);
            objectNamesList.get(this.getAdapterPosition()).setSelected(b);
        }

        private void setImages() {
            if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Aluminum Foil")){
                objectPicture.setImageResource(R.drawable.aluminum_foil);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Amazon Packaging")){
                objectPicture.setImageResource(R.drawable.amazon_packaging);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Bag of Chips")){
                objectPicture.setImageResource(R.drawable.bag_of_chips);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Batteries")){
                objectPicture.setImageResource(R.drawable.batteries);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Broken Glass")){
                objectPicture.setImageResource(R.drawable.broken_glass);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Broken Plate")){
                objectPicture.setImageResource(R.drawable.broken_plate);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Broth Container")){
                objectPicture.setImageResource(R.drawable.broth_container);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Cables")){
                objectPicture.setImageResource(R.drawable.cables);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Candy Wrappers")){
                objectPicture.setImageResource(R.drawable.candy_wrappers);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Cardboard")){
                objectPicture.setImageResource(R.drawable.cardboard);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Cereal Box")){
                objectPicture.setImageResource(R.drawable.cereal_box);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Chains")){
                objectPicture.setImageResource(R.drawable.chains);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Clamshell Packaging")){
                objectPicture.setImageResource(R.drawable.clamshell_packaging);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Coffee Machine")){
                objectPicture.setImageResource(R.drawable.coffee_machine);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Cool Ashes")){
                objectPicture.setImageResource(R.drawable.cool_ashes);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Cup Noodles")){
                objectPicture.setImageResource(R.drawable.cup_noodles);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Detergent Jug")){
                objectPicture.setImageResource(R.drawable.detergent_jug);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Diapers")){
                objectPicture.setImageResource(R.drawable.diapers);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Fertilizer Jug")){
                objectPicture.setImageResource(R.drawable.fertilizer_jug);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Frozen Food Packaging")){
                objectPicture.setImageResource(R.drawable.frozen_food_packaging);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Fuel")){
                objectPicture.setImageResource(R.drawable.fuel);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Fuel Additive")){
                objectPicture.setImageResource(R.drawable.fuel_additive);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Gardening Hose")){
                objectPicture.setImageResource(R.drawable.gardening_hose);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Gift Wrap")){
                objectPicture.setImageResource(R.drawable.gift_wrap);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Glass Soda Bottle")){
                objectPicture.setImageResource(R.drawable.glass_soda_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Hangers")){
                objectPicture.setImageResource(R.drawable.hangers);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Heat to Eat")){
                objectPicture.setImageResource(R.drawable.heat_to_eat);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Kitchen Grease")){
                objectPicture.setImageResource(R.drawable.kitchen_grease);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Lightbulb")){
                objectPicture.setImageResource(R.drawable.light_bulb);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Magazine")){
                objectPicture.setImageResource(R.drawable.magazine);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Masks")){
                objectPicture.setImageResource(R.drawable.masks);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Metal Lids")){
                objectPicture.setImageResource(R.drawable.metal_lids);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Metal Pans")){
                objectPicture.setImageResource(R.drawable.metal_pan);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Milk Carton")){
                objectPicture.setImageResource(R.drawable.milk_carton);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Milk Jugs")){
                objectPicture.setImageResource(R.drawable.milk_jug);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Newspaper")){
                objectPicture.setImageResource(R.drawable.newspaper);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Non-Empty Bug Killer")){
                objectPicture.setImageResource(R.drawable.non_empty_bug_killer);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Non-Empty Fire Extinguisher")){
                objectPicture.setImageResource(R.drawable.non_empty_fire_extinguisher);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Non-Empty Weed Killer")){
                objectPicture.setImageResource(R.drawable.non_empty_weed_killer);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Non-Plastic Bottle Caps")){
                objectPicture.setImageResource(R.drawable.non_plastic_bottle_caps);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Orange Pill Bottle")){
                objectPicture.setImageResource(R.drawable.orange_medicine_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Overwrap")){
                objectPicture.setImageResource(R.drawable.overwrap);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Paper Cups")){
                objectPicture.setImageResource(R.drawable.paper_cup);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Penzoil Motor Oil")){
                objectPicture.setImageResource(R.drawable.pen_zoil_motor_oil);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Coke/Pepsi Can")){
                objectPicture.setImageResource(R.drawable.pepsi_can);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Bag")){
                objectPicture.setImageResource(R.drawable.plastic_bag);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Covers")){
                objectPicture.setImageResource(R.drawable.plastic_covers_and_plates);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Plates")){
                objectPicture.setImageResource(R.drawable.plastic_covers_and_plates);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Cup")){
                objectPicture.setImageResource(R.drawable.plastic_cup);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Gloves")){
                objectPicture.setImageResource(R.drawable.plastic_gloves);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Straws")){
                objectPicture.setImageResource(R.drawable.plastic_straws);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Utensils")){
                objectPicture.setImageResource(R.drawable.plastic_utensils);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Wide Bottle")){
                objectPicture.setImageResource(R.drawable.plastic_wide_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Yogurt Container")){
                objectPicture.setImageResource(R.drawable.plastic_yogurt_container);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Plastic Bottle")){
                objectPicture.setImageResource(R.drawable.plasticbottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Prestone Fluid")){
                objectPicture.setImageResource(R.drawable.prestone_fluid);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Purell Wipes")){
                objectPicture.setImageResource(R.drawable.purell_wipes);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Sauce Container")){
                objectPicture.setImageResource(R.drawable.sauce_container);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Scissors")){
                objectPicture.setImageResource(R.drawable.scissors);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Soup Can")){
                objectPicture.setImageResource(R.drawable.soup_can);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Spray Can")){
                objectPicture.setImageResource(R.drawable.spray_can);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Spread Container")){
                objectPicture.setImageResource(R.drawable.spread_container);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Sprite Bottle")){
                objectPicture.setImageResource(R.drawable.sprite_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Styrofoam (To-Go Box)")){
                objectPicture.setImageResource(R.drawable.styrofoam_to_go_box);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Styrofoam (Other)")){
                objectPicture.setImageResource(R.drawable.styrofoam_other);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Toaster")){
                objectPicture.setImageResource(R.drawable.toaster);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Vomit Bag")){
                objectPicture.setImageResource(R.drawable.vomit_bag);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Wide Medicine Bottle")){
                objectPicture.setImageResource(R.drawable.wide_medicine_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Wine Bottle")){
                objectPicture.setImageResource(R.drawable.wine_bottle);
            }
            else if (objectNamesList.get(this.getAdapterPosition()).getName().equals("Wood Stud")){
                objectPicture.setImageResource(R.drawable.wood_stud);
            }
            else{
                objectPicture.setVisibility(View.INVISIBLE);
                name.setText("");
                bin.setText("");
                isSelected.setVisibility(View.INVISIBLE);
                //objectPicture.setImageResource(R.drawable.blank);
            }
            //objectPicture.setImageResource(R.drawable.);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String name = objectNamesList.get(position).getName();
        String recyclableOrNot = objectNamesList.get(position).getCategory();
        //objectList.get(position).setSelected(holder.isSelected.isSelected());
        boolean isChecked = objectNamesList.get(position).isSelected();
        System.out.println(position + ":" + holder.isSelected.isChecked());
        holder.name.setText(name);
        holder.bin.setText(recyclableOrNot);
        holder.isSelected.setChecked(isChecked);
        holder.setImages();
      //  objectNamesList.get(position).setSelected(holder.isClicked());
    }

    @Override
    public int getItemCount() {
        return objectNamesList.size();
    }

    public void filter(String charText) {
        objectNamesList = new ArrayList<RecycleObject>();
        System.out.println("filter(): we've arrived here");
        if (charText.length() == 0) {
            //objectNamesList = objectList;
            objectNamesList.addAll(objectList);
            System.out.println("filter() - length = 0:" + objectNamesList);
        } else {
            //objectNamesList.clear();
            charText = charText.toLowerCase(Locale.getDefault());
            for (RecycleObject wp : objectList) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    objectNamesList.add(wp);
                }
            }
        }
        //objectNamesList = bob;
        System.out.println(objectNamesList);
        System.out.println(objectList);
        //System.out.println(bob);
        notifyDataSetChanged();
    }

}
