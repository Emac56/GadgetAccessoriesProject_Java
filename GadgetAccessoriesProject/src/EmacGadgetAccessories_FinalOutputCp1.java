import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmacGadgetAccessories_FinalOutputCp1 {

    static Scanner input = new Scanner(System.in);
    static LocalDate date = LocalDate.now();
    static String saveReceipt = "";

    public static void showMainMenu() {
        while (true) {
            System.out.println("==============================");
            System.out.println("WELCOME TO EMAC'S GADGET SHOP");
            System.out.println("==============================");
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
                    System.out.println(saveReceipt.isEmpty() ? "No recent order yet.\n" : saveReceipt);
                    break;
                case "3":
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }

    public static void items() {

        String[] itemName = {
            "Apple iPhone 14 128GB",
            "Samsung Galaxy A54 256GB",
            "Xiaomi Redmi Note 13 Pro 5G",
            "Huawei FreeBuds SE",
            "JBL GO 3 Speaker",
            "ASUS TUF Gaming F15",
            "Logitech G213 Keyboard",
            "Anker PowerCore 20000mAh",
            "GoPro HERO11",
            "Sony WH-1000XM4"
        };

        double[] itemPrice = {
            42990, 21990, 16999, 1899, 2399,
            48995, 2995, 1699, 29990, 16499
        };

        ArrayList<String> cartItems = new ArrayList<>();
        ArrayList<Integer> cartQty = new ArrayList<>();
        ArrayList<Double> cartSubTotal = new ArrayList<>();

        boolean buyMore = true;

        while (buyMore) {
            showItems(itemName, itemPrice);

            System.out.print("Select item number: ");
            int choice = Integer.parseInt(input.nextLine()) - 1;

            if (choice < 0 || choice >= itemName.length) {
                System.out.println("Invalid item.\n");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(input.nextLine());

            double subtotal = qty * itemPrice[choice];

            cartItems.add(itemName[choice]);
            cartQty.add(qty);
            cartSubTotal.add(subtotal);

            System.out.print("Would you like to buy more? (Y/N): ");
            buyMore = input.nextLine().equalsIgnoreCase("Y");
        }

        checkout(cartItems, cartQty, cartSubTotal);
    }

    public static void showItems(String[] item, double[] price) {
        System.out.println("\nAVAILABLE ITEMS:");
        System.out.println("------------------------------------");
        for (int i = 0; i < item.length; i++) {
            System.out.println((i + 1) + ". " + item[i] + " - PHP " + price[i]);
        }
        System.out.println("------------------------------------");
    }

    public static void checkout(
        ArrayList<String> items,
        ArrayList<Integer> qty,
        ArrayList<Double> subtotal
    ) {

        final int VAT = 12;
        double total = 0;

        System.out.print("\nEnter full name: ");
        String name = input.nextLine();

        System.out.print("Enter address: ");
        String address = input.nextLine();

        System.out.print("Enter contact number: ");
        String contact = input.nextLine();

        for (double sub : subtotal) total += sub;

        double vatAmount = (total * VAT) / 100;
        double totalAmount = total + vatAmount;

        System.out.println("\nTotal Amount: PHP " + totalAmount);
        System.out.print("Enter cash: ");
        double cash = Double.parseDouble(input.nextLine());

        if (cash < totalAmount) {
            System.out.println("Insufficient cash.\n");
            return;
        }

        double change = cash - totalAmount;

        showReceipt(name, address, contact, items, qty, total, vatAmount, totalAmount, cash, change);
    }

    public static void showReceipt(
        String name,
        String address,
        String contact,
        ArrayList<String> items,
        ArrayList<Integer> qty,
        double subtotal,
        double vat,
        double total,
        double cash,
        double change
    ) {

        StringBuilder receipt = new StringBuilder();

        receipt.append("\n========== RECEIPT ==========\n");
        receipt.append("EMAC'S GADGET SHOP\n");
        receipt.append("Customer: ").append(name).append("\n");
        receipt.append("Address: ").append(address).append("\n");
        receipt.append("Contact: ").append(contact).append("\n\n");

        for (int i = 0; i < items.size(); i++) {
            receipt.append(items.get(i))
                   .append(" x")
                   .append(qty.get(i))
                   .append("\n");
        }

        receipt.append("\nSubtotal: PHP ").append(subtotal);
        receipt.append("\nVAT: PHP ").append(vat);
        receipt.append("\nTotal: PHP ").append(total);
        receipt.append("\nCash: PHP ").append(cash);
        receipt.append("\nChange: PHP ").append(change);
        receipt.append("\nDate: ").append(date);
        receipt.append("\n============================\n");

        System.out.println(receipt);
        saveReceipt = receipt.toString();
    }

    public static void main(String[] args) {
        showMainMenu();
    }
            }
