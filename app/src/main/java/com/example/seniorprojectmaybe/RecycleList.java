package com.example.seniorprojectmaybe;

import java.util.ArrayList;

public class RecycleList {

    public ArrayList<RecycleObject> arrayList = new ArrayList<RecycleObject>();

    public RecycleList(){
        arrayList.add(new RecycleObject("bottle", "recyclable", false));
        arrayList.add(new RecycleObject("raw vegetables", "yakult", true));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
        arrayList.add(new RecycleObject("raw vegetables", "yakult"));
    }
}


