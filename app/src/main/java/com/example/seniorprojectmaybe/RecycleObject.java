package com.example.seniorprojectmaybe;

public class RecycleObject {

    private String name; // what the hell is it?
    private String category; //is it recyclable, in the trash, or what?
    private boolean isSelected; //is it selected?

    public RecycleObject(String str, String str1){
        this.name = str;
        this.category = str1;
        this.isSelected = false;
    }

    public RecycleObject(String str, String str1, boolean bool){
        this.name = str;
        this.category = str1;
        this.isSelected = bool;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
