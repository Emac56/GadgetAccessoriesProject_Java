package com.mycompany.emacgadgetaccessories_finaloutput.cp1;

import java.util.Scanner;
import java.time.LocalDate;

public class EmacGadgetAccessories_FinalOutputCp1 {

    //Global Variables
    static Scanner input = new Scanner(System.in);
    static LocalDate date = LocalDate.now();
    static String saveReceipt = "";

    //Display Welcome Message
    public static void showMainMenu() {
        System.out.println("==============================");
        System.out.println("WELCOME TO EMAC'S GADGET SHOP");
        System.out.println("Your one-shop for accessories.");
        System.out.println("==============================");

        boolean loop = true;

        while (loop) {
            System.out.println(" [1] Order Accessories");
            System.out.println(" [2] View Recent Order");
            System.out.println(" [3] Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    items();
                    break;

                case "2":
                    if (saveReceipt.equals("")) {
                        System.out.println("No recent activity yet\n");
                    } else {
                        System.out.println(saveReceipt);
                    }
                    break;

                case "3":
                    System.out.println("Thank you for visiting Gadget Shop");
                    System.out.println("See you next time!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid input. Kindly select a valid option from menu.");
            }
        }
        input.close();
    }

    //Method to show items
    public static void showItems(String[] item, double[] php) {
        System.out.println("\nAVAILABLE ACCESSORIES:");
        System.out.println("==================================================================");
        System.out.println("ITEM NAME\t\t\t\tPRICE");
        System.out.println("==================================================================");

        for (int i = 0; i < item.length; i++) {
            System.out.println((i + 1) + ". " + item[i] + "\tPHP " + php[i]);
        }

        System.out.println("==================================================================\n");
    }

    //Method for products and price
    public static void items() {
        String[] itemName = {
            "Apple iPhone 14 128GB          ",
            "Samsung Galaxy A54 256GB       ",
            "Xiaomi Redmi Note 13 Pro 5G    ",
            "Huawei FreeBuds SE Earbuds     ",
            "JBL GO 3 Bluetooth Speaker    ",
            "ASUS TUF Gaming F15            ",
            "Logitech G213 RGB Keyboard    ",
            "Anker PowerCore 20000mAh       ",
            "GoPro HERO11 Black             ",
            "Sony WH-1000XM4 Headphones    "
        };

        double[] itemPrice = {
            42990, 21990, 16999, 1899, 2399,
            48995, 2995, 1699, 29990, 16499
        };

        showItems(itemName, itemPrice);
        chooseItem(itemName, itemPrice);
    }

    //Method for ordering
    public static void chooseItem(String[] product, double[] price) {

        int pieces;
        final int VAT = 12;
        double totalPurchase;
        double totalVat;
        double totalAmount;
        double cash;
        double change;

        String customerName;
        String address;
        String contact;

        
        System.out.print("Select item number from the list: ");
        int selectedItem = Integer.parseInt(input.nextLine()) - 1;

        if (selectedItem < 0 || selectedItem >= product.length) {
            System.out.println("Invalid Option. Please choose between 1 to " + product.length);
            return;
        }

        System.out.println("\nYou choose: " + product[selectedItem].trim() + " ₱" + price[selectedItem]);
        
        System.out.print("How many pieces would you like to buy?: ");
        pieces = input.nextInt();
        input.nextLine();

        System.out.print("Enter your full name: ");
        customerName = input.nextLine();

        System.out.print("Enter your address: ");
        address = input.nextLine();

        System.out.print("Enter your contact number: ");
        contact = input.nextLine();

        

        totalPurchase = totalPurc(pieces, price[selectedItem]);
        totalVat = totalVat(totalPurchase, VAT);
        totalAmount = totalPurchase + totalVat;

        System.out.println("Total amount to pay: " + totalAmount);
        System.out.print("Enter your cash amount: ");
        cash = input.nextDouble();
        input.nextLine();
        
        //Check cash
        if (cash < totalAmount) {
            System.out.println("\nINSUFFICIENT FUNDS!");
            System.out.println("Your cash: PHP " + cash);
            System.out.println("Total amount: PHP " + totalAmount);
            return;
        }

        change = cash - totalAmount;

        showReceipt(
            customerName,
            address,
            contact,
            product[selectedItem],
            totalPurchase,
            totalVat,
            totalAmount,
            VAT,
            pieces,
            cash,
            change
        );

        saveReceipt =
            "\n=========== Recent Receipt ============" +
            "\nCustomer Name: " + customerName +
            "\nAddress: " + address +
            "\nContact: " + contact +
            "\nItem name: " + product[selectedItem] +
            "\nItem quantity: " + pieces +
            "\nSubtotal: PHP " + totalPurchase +
            "\nVAT: PHP " + totalVat +
            "\nTotal Amount: PHP " + totalAmount +
            "\nCash: PHP " + cash +
            "\nChange: PHP " + change +
            "\n======================================";
    }

    //Compute total purchase
    public static double totalPurc(double a, double b) {
        return a * b;
    }

    //Compute VAT
    public static double totalVat(double c, double d) {
        return (c * d) / 100;
    }

    //Show receipt
    public static void showReceipt(
        String name,
        String address,
        String contact,
        String item,
        double totalPurchase,
        double totalvat,
        double totalAmount,
        int VAT,
        int quantity,
        double cash,
        double change
    ) {

        System.out.println("\n========== RECEIPT ==========");
        System.out.println("===== EMAC'S GADGET SHOP =====");
        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Contact: " + contact);
        System.out.println("Item: " + item);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: PHP " + totalPurchase);
        System.out.println("VAT: " + VAT + "%");
        System.out.println("Total VAT: PHP " + totalvat);
        System.out.println("Total Amount: PHP " + totalAmount);
        System.out.println("Cash: PHP " + cash);
        System.out.println("Change: PHP " + change);
        System.out.println("Date Purchased: " + date);
        System.out.println("================================\n");
    }

    public static void main(String[] args) {
        showMainMenu();
    }
}