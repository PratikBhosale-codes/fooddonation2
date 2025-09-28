package com.example.fooddonation;

import com.google.firebase.database.PropertyName;

public class FoodModel {
    private String id;
    private String pickupAddress;
    private String foodItem;
    private String name;
    private String mob_no;    
    private String pickupDate;
    private String pickupTime;
    private int quantity;

    // Empty constructor required for Firebase
    public FoodModel() {}

    public FoodModel(String id, String name, String mob_no, String pickupAddress,
                     String foodItem, String pickupDate, String pickupTime, int quantity) {
        this.id = id;
        this.name = name;
        this.mob_no = mob_no;
        this.pickupAddress = pickupAddress;
        this.foodItem = foodItem;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.quantity = quantity;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
/*
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMob_no() { return mob_no; }
    public void setMob_no(String mob_no) { this.mob_no = mob_no; }  */
@PropertyName("Name")
public String getName() { return name; }
    @PropertyName("Name")
    public void setName(String name) { this.name = name; }

    @PropertyName("Mob_no")
    public String getMob_no() { return mob_no; }
    @PropertyName("Mob_no")
    public void setMob_no(String mob_no) { this.mob_no = mob_no; }


    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }

    public String getFoodItem() { return foodItem; }
    public void setFoodItem(String foodItem) { this.foodItem = foodItem; }

    public String getPickupDate() { return pickupDate; }
    public void setPickupDate(String pickupDate) { this.pickupDate = pickupDate; }

    public String getPickupTime() { return pickupTime; }
    public void setPickupTime(String pickupTime) { this.pickupTime = pickupTime; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
