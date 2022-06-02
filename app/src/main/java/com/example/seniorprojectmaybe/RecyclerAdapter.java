package com.example.seniorprojectmaybe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

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
            isSelected.setOnCheckedChangeListener(CompoundButton::setChecked);
            //isSelected.setOnCheckedChangeListener(this::updateObject);
        }

        private boolean isClicked() {
            if (isSelected.isChecked()){
                return true;
            }
            else{
                return false;
            }
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
        holder.name.setText(name);
        holder.bin.setText(recyclableOrNot);
        holder.isSelected.setChecked(isChecked);
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
