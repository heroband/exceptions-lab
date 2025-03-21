package com.exceptions.lab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        CoffeeShop shop = new CoffeeShopClass(2);

        while(true){
            System.out.println("Enter command: (1. buy, 2. buyIfPresent, 3. feedback, 4. read, 5. amount, 6. exit): ");
            int command = Integer.parseInt(scanner.nextLine());
            try{
                switch(command){
                    case 1:
                        shop.buyCoffee();
                        break;
                    case 2:
                        shop.buyCoffeeIfPresent();
                        break;
                    case 3:
                        System.out.println("Enter feedback: ");
                        shop.giveFeedback(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Feedbacks: " + shop.readFeedbacks());
                        break;
                    case 5:
                        System.out.println("Coffee left: " + shop.coffeeAmount());
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}