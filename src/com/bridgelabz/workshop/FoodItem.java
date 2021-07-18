package com.bridgelabz.workshop;

import java.util.Objects;

interface Iveg{}
interface InonVeg{}

public  class FoodItem {
    enum Taste {SPICY,SWEET,SOUR,EXTRA_SPICY}
    enum Category {MAIN_COURSE,STARTER,SNACKS,DESSERT}
    enum Type {VEG,NON_VEG}
    String name;
    Taste taste;
    Category category;
    Type type;
    int prepTime;
    int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem)) return false;
        FoodItem foodItem = (FoodItem) o;
        return prepTime == foodItem.prepTime && price == foodItem.price && name.equals(foodItem.name) && taste == foodItem.taste && category == foodItem.category && type == foodItem.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, taste, category, type, prepTime, price);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", taste=" + taste +
                ", category=" + category +
                ", type=" + type +
                ", prepTime=" + prepTime +
                ", price=" + price +
                '}';
    }
    //public abstract void printIngredients();

}
