package com.bridgelabz.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodMain {
    static FoodMain foodMain = new FoodMain();
    static Scanner sc = new Scanner(System.in);
    static FoodStore foodStore = new FoodStore();

    public static void main(String[] args) {
//        Biryani biryani = new Biryani();
//        biryani.price = 100;
//
//        Burger burger = new Burger();
//        burger.price = 60;
//
//        IceCream iceCream = new IceCream();
//        iceCream.price = 30;
//
//        MasalaPapad masalaPapad = new MasalaPapad();
//        masalaPapad.price = 20;
//
//        foodMain.foodStore.addFoodItems(biryani);
//        foodMain.foodStore.addFoodItems(burger);
//        foodMain.foodStore.addFoodItems(iceCream);
//        foodMain.foodStore.addFoodItems(masalaPapad);

        //foodStore.printFoodItems();

        foodMain.showMenu();
        //foodStore.printFoodItems();

    }
    void addFoodItem(){
        FoodItem foodItem = new FoodItem();
        System.out.println("Enter Food Name:");
        foodItem.name = sc.next();

        System.out.println("Enter Food Type:");
        System.out.println(" 1.VEG 2.NONVEG ");
        int type = sc.nextInt();
        if(type == 1){
            foodItem.type = FoodItem.Type.VEG;
        }else{
            foodItem.type = FoodItem.Type.NON_VEG;
        }
        System.out.println("Enter Food Category");
        System.out.println("1.Main_Course 2.Starter 3.Snacks 4.Dessert");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> foodItem.category = FoodItem.Category.MAIN_COURSE;
            case 2 -> foodItem.category = FoodItem.Category.STARTER;
            case 3 -> foodItem.category = FoodItem.Category.SNACKS;
            case 4 -> foodItem.category = FoodItem.Category.DESSERT;

        }
        System.out.println("Enter Food Taste:");
        System.out.println("1.Spicy 2.Sweet 3.Sour 4.ExtraSpicy ");
        int choice1 = sc.nextInt();
        switch (choice1){
            case 1 -> foodItem.taste = FoodItem.Taste.SPICY;
            case 2 -> foodItem.taste = FoodItem.Taste.SWEET;
            case 3 -> foodItem.taste = FoodItem.Taste.SOUR;
            case 4 -> foodItem.taste = FoodItem.Taste.EXTRA_SPICY;
        }
        System.out.println("Enter Prepration Time");
        foodItem.prepTime = sc.nextInt();

        System.out.println("Enter Price");
        foodItem.price = sc.nextInt();

        foodStore.foodList.add(foodItem);

    }

    void showMenu() {
        int choice = 0;
        while (choice != 10) {
            System.out.println("Press 1: Add Food Item\nPress 2: Print Food Item\nPress 3: Update Food Item  \nPress 4: Remove Food Item \nPress 5: Place Order\nPress10: Exit  ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> addFoodItem();
                case 2 -> foodStore.printFoodItems();
                case 3 -> updateFoodItem();
                case 4 -> foodStore.removeFoodItems();
                case 5 -> placeOrder();
                case 10-> choice = 10;
            }
        }
    }

    void placeOrder() {
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        while(true) {
            System.out.println("\n1.Order food\n2.Exit");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Please enter food name :");
                String name = sc.next().concat(sc.nextLine());
                FoodItem foodItem = foodStore.getFoodItem(name);
                if (foodItem == null) {
                    System.out.println("Food Item Not Found");
                } else {
                    System.out.println("Please Enter Food Quantity :");
                    int quantity = sc.nextInt();
                    order.hMap.put(foodItem,quantity);
                    System.out.println("Total amount payable : " + order.setTotalPrice());
                }
            } else break;
        }
        System.out.println("\nPlease Enter Customer Name :");
        String customerName = sc.next().concat(sc.nextLine());
        order.setCustomerName(customerName);

        System.out.println("Please Enter Address :");
        order.setDeliveryAddress(sc.next().concat(sc.nextLine()));

        System.out.println("Please Enter Mobile Number :");
        order.setMobileNumber(sc.nextLong());

        System.out.println("Select Payment Method :");
        System.out.println("1.COD, 2.CREDIT_CARD, 3.DEBIT_CARD, 4.NET_BANKING, 5.UPI, 6.WALLET");
        switch (sc.nextInt()) {
            case 1 -> order.setPaymentMethods(Order.PAYMENT_METHODS.COD);
            case 2 -> order.setPaymentMethods(Order.PAYMENT_METHODS.CREDIT_CARD);
            case 3 -> order.setPaymentMethods(Order.PAYMENT_METHODS.DEBIT_CARD);
            case 4 -> order.setPaymentMethods(Order.PAYMENT_METHODS.NET_BANKING);
            case 5 -> order.setPaymentMethods(Order.PAYMENT_METHODS.UPI);
            case 6 -> order.setPaymentMethods(Order.PAYMENT_METHODS.WALLET);
        }
        order.setDateAndTime(new java.util.Date(System.currentTimeMillis()));


        orderList.add(order);
        System.out.println(orderList);
    }


    private void updateFoodItem() {
        System.out.println("1.Change taste ");
        System.out.println("2.Change price ");
        System.out.println("3.Change preparation time ");
        System.out.println("4.Change category ");

       int choice = sc.nextInt();
        switch (choice) {
            case 1 -> updateTaste();
            case 2 -> updatePrice();
            case 3 -> updatePrepTime();
            case 4 -> updateCategory();
        }
    }

    private void updateCategory() {
        System.out.println("Enter food name ");
        String itemName = sc.next();
        FoodItem foodItem = foodStore.getFoodItem(itemName);
        System.out.println("1.MAIN_COURSE, 2.STARTER, 3.SNACKS, 4.DESSERT");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> foodItem.category = FoodItem.Category.MAIN_COURSE;
            case 2 -> foodItem.category = FoodItem.Category.STARTER;
            case 3 -> foodItem.category = FoodItem.Category.SNACKS;
            case 4 -> foodItem.category = FoodItem.Category.DESSERT;
        }
    }

    private void updatePrepTime() {
        System.out.println("Enter Food Name:");
        String name = sc.next();
        FoodItem foodItem = foodStore.getFoodItem(name);
        System.out.println("Enter New Prepration Time:");
        foodItem.prepTime = sc.nextInt();
    }

    private void updatePrice() {
        System.out.println("Enter Food Name:");
        String name = sc.next();
        FoodItem foodItem = foodStore.getFoodItem(name);
        System.out.println("Enter New Price:");
        foodItem.price = sc.nextInt();
    }

    private void updateTaste() {
        System.out.println("Enter food name ");
        String itemName = sc.next();
        FoodItem foodItem = foodStore.getFoodItem(itemName);
        System.out.println("1.SPICY,2.SWEET,3.SOUR,4.EXTRA_SPICY");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> foodItem.taste = FoodItem.Taste.SPICY;
            case 2 -> foodItem.taste = FoodItem.Taste.SWEET;
            case 3 -> foodItem.taste = FoodItem.Taste.SOUR;
            case 4 -> foodItem.taste = FoodItem.Taste.EXTRA_SPICY;
        }
    }
}

