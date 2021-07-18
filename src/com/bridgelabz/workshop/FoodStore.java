package com.bridgelabz.workshop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FoodStore {
    Set<FoodItem> foodList = new HashSet<>();

    void addFoodItems(FoodItem foodItem) {
        foodList.add(foodItem);
    }

    void printFoodItems() {
        for (FoodItem i : foodList) {
            System.out.println(i);
        }
    }

    void removeFoodItems() {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Food Name To Remove:");
            String name = sc.nextLine();
            FoodItem foodItem = getFoodItem(name);
            if (foodItem == null){
                System.out.println("** Sorry No food item found ** ");
            }else {
                foodList.remove(foodItem);
            }
        }

    int countFoodItems(){
        return foodList.size();
    }

    void printVegItems(){
        for (FoodItem i : foodList){
            if (i instanceof Iveg){
                System.out.println(i);
            }
        }
    }

    void printNonVegItems(){
        for (FoodItem i : foodList){
            if (i instanceof InonVeg){
                System.out.println(i);
            }
        }
    }

    FoodItem getFoodItem(String name) {
        Iterator iterator = foodList.iterator();
        for(FoodItem elements : foodList ) {
            if (iterator.hasNext()) {
                FoodItem fooditem = (FoodItem) iterator.next();
                if(fooditem.name.equalsIgnoreCase(name)) {
                    return fooditem;
                }
            }
        }
        return null;
    }
}
