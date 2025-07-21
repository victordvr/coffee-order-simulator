package com.victor.coffee;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final String ADMIN_PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
        ReceiptManager receiptManager = new ReceiptManager();

        System.out.println("***Welcome to the Coffee Order Machine!***");

        boolean running = true;

        while (running) {
            menu.display();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    if (order.getItems().isEmpty()) {
                        System.out.println("Hey, don't leave. You still have some time to drink coffee.");
                        running = false;
                        break;
                    }
                    OrderProcessor orderProcessor = new OrderProcessor();
                    orderProcessor.process(order);
                    receiptManager.saveReceipt(order.toString());
                    System.out.println();
                    System.out.println("Thank you! Your order has been processed.");
                    System.out.println("Keep drinking good Coffee with me ^-^");
                    running = false;
                    break;

                case 8:
                    if (order.getItems().isEmpty()) {
                        System.out.println("You have not added any coffee yet!");
                    } else {
                        System.out.println(order.toString());
                    }
                    break;

                case 9:
                    System.out.println("Enter admin password: ");
                    String password = sc.nextLine();
                    if (password.equals(ADMIN_PASSWORD)) {
                        System.out.println("Showing orders history:");
                        List<String> history = receiptManager.readAllReceipts();
                        if (history.isEmpty()) {
                            System.out.println("There are not orders yet.");
                        } else {
                            for (String receipt : history) {
                                System.out.println(receipt);
                                System.out.println("-----");
                            }
                        }
                    } else {
                        System.out.println("Incorrect password. Denied access.");
                    }
                    break;

                default:
                    try {
                        Coffee selected = menu.select(choice);
                        order.addCoffee(selected);
                    } catch (InvalidOrderException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            System.out.println();
        }
        sc.close();
    }
}
