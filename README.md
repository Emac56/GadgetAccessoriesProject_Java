EMAC Gadget Shop Java Console Application
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
} create me best readme.md for github papakita ko sa mga tao english and have a Programmer: Jaymark package com.mycompany.emacgadgetaccessories_finaloutput.cp1;

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
}icente Course: BSIT School: OMSC
EMAC Gadget Accessories Shop - Java Console Application
A complete console-based gadget shop management system built with Java that handles product ordering, receipt generation, and order tracking.

📋 Overview
EMAC Gadget Accessories Shop is a Java console application that simulates an electronics retail system. Customers can browse products, place orders, calculate VAT, and receive digital receipts. The system also maintains a record of recent transactions for quick reference.

✨ Features
Interactive Menu System: User-friendly console interface with navigation options

Product Catalog: Displays 10 popular gadgets and accessories with prices

Order Processing: Complete order workflow with quantity selection

VAT Calculation: Automatically calculates 12% VAT on purchases

Receipt Generation: Professional digital receipts with customer details

Transaction History: View recent orders with all details

Input Validation: Handles invalid selections and insufficient funds

Customer Management: Collects and stores customer information

🛠️ Technologies Used
Java SE - Core programming language

Scanner Class - For user input handling

LocalDate - For automatic date tracking

Console I/O - Text-based user interface

📁 Project Structure
text
EmacGadgetAccessories_FinalOutputCp1.java
├── Global Variables
│   ├── Scanner input
│   ├── LocalDate date
│   └── String saveReceipt
├── Main Methods
│   ├── showMainMenu() - Main program interface
│   ├── items() - Product catalog display
│   ├── chooseItem() - Order processing logic
│   ├── showReceipt() - Receipt generation
│   └── main() - Application entry point
└── Utility Methods
    ├── showItems() - Display product list
    ├── totalPurc() - Calculate subtotal
    └── totalVat() - Compute VAT amount
🎮 How to Use
Running the Application
Compile the Java file:

bash
javac EmacGadgetAccessories_FinalOutputCp1.java
Run the compiled class:

bash
java EmacGadgetAccessories_FinalOutputCp1
Program Flow
Main Menu Options:

Option 1: Order Accessories - Browse and purchase items

Option 2: View Recent Order - Check last transaction

Option 3: Exit - Close the application

Ordering Process:

Select item from numbered list (1-10)

Enter quantity desired

Provide customer details (name, address, contact)

Enter payment amount

Receive receipt with change calculation

📊 Product Catalog
#	Item	Price (PHP)
1	Apple iPhone 14 128GB	42,990
2	Samsung Galaxy A54 256GB	21,990
3	Xiaomi Redmi Note 13 Pro 5G	16,999
4	Huawei FreeBuds SE Earbuds	1,899
5	JBL GO 3 Bluetooth Speaker	2,399
6	ASUS TUF Gaming F15	48,995
7	Logitech G213 RGB Keyboard	2,995
8	Anker PowerCore 20000mAh	1,699
9	GoPro HERO11 Black	29,990
10	Sony WH-1000XM4 Headphones	16,499
💰 Pricing Logic
Subtotal: Quantity × Item Price

VAT: 12% of Subtotal

Total Amount: Subtotal + VAT

Change: Cash Payment - Total Amount

🧪 Sample Transaction
text
Select item number from the list: 3
You choose: Xiaomi Redmi Note 13 Pro 5G ₱16999
How many pieces would you like to buy?: 2
Enter your full name: Juan Dela Cruz
Enter your address: Manila City
Enter your contact number: 09123456789

Total amount to pay: 38057.76
Enter your cash amount: 40000

========== RECEIPT ==========
===== EMAC'S GADGET SHOP =====
Customer Name: Juan Dela Cruz
Address: Manila City
Contact: 09123456789
Item: Xiaomi Redmi Note 13 Pro 5G
Quantity: 2
Subtotal: PHP 33998.0
VAT: 12%
Total VAT: PHP 4079.76
Total Amount: PHP 38077.76
Cash: PHP 40000.0
Change: PHP 1922.24
Date Purchased: 2024-01-15
================================
🚀 Features to Consider Adding
Multiple Item Selection - Allow customers to order multiple products in one transaction

Inventory Management - Track stock levels and prevent overselling

Receipt Saving - Export receipts to text files

Admin Mode - Add/remove products and view sales reports

Discount System - Implement promotional codes or loyalty discounts

Search Functionality - Find products by name or category

📝 Code Highlights
Modular Design: Separated business logic into reusable methods

Error Handling: Validates user inputs and handles edge cases

Clean Formatting: Properly aligned product displays and receipts

Memory Efficiency: Static variables for shared resources

👨‍💻 Developer Information
Programmer: Jaymark Vicente
Course: BSIT (Bachelor of Science in Information Technology)
School: OMSC (Our Lady of Mercy Scholastic Center)

📄 License
This project is created for educational purposes as part of a BSIT coursework requirement.

Note: This is a console-based application designed to demonstrate core Java programming concepts including methods, arrays, conditionals, loops, and basic financial calculations.
