package com.example_frag5.mamani.recycleview_tutorial;

/**
 * Created by mamani on 21/07/16.
 */
public class Car {
    private String model;
    private String brand;
    private int photo;

    public Car(){};

    public Car(String model, String brand, int photo) {
        this.model=model;
        this.brand=brand;
        this.photo=photo;
    }



    public int getPhoto() {
        return photo;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
