package com.hambrospecial;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogUI {

    private final Catalog<LibraryItem<?>> catalog;
    private final Scanner scanner;
    private static int ID = 0;
    private final DecimalFormat ID_FORMATTER = new DecimalFormat("0000");

    public LibraryCatalogUI() {
        this.catalog = new Catalog<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n📚 === Library Catalog System === 📚");
            System.out.println("1️⃣. ➕ Add Item");
            System.out.println("2️⃣. ❌ Remove Item");
            System.out.println("3️⃣. 📖 View Catalog");
            System.out.println("4️⃣. 🚪 Exit");
            System.out.print("👉 Enter your choice (1-4): ");

            int choice = getValidIntegerInput();

            try {
                switch (choice) {
                    case 1 -> addItem();
                    case 2 -> removeItem();
                    case 3 -> viewCatalog();
                    case 4 -> {
                        System.out.println("👋 Goodbye!");
                        return;
                    }
                    default -> System.out.println("❗ Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        }
    }

    private void addItem() {
        System.out.println("\n1️⃣. 📘 Book");
        System.out.println("2️⃣. 📀 DVD");
        System.out.println("3️⃣. 📰 Magazine");
        System.out.print("📦 Select item type (1-3): ");
        int type = getValidIntegerInput();

        LibraryItem<?> item;
        String itemID;
        String title;
        String author;
        try {
            switch (type) {
                case 1 -> {
                    System.out.print("✏️ Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("✏️ Enter author: ");
                    author = scanner.nextLine();
                    System.out.print("✏️ Enter page count: ");
                    int pageCount = getValidIntegerInput();
                    System.out.print("✏️ Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("✏️ Enter genre: ");
                    String genre = scanner.nextLine();
                    itemID = "BK-".concat(ID_FORMATTER.format(++ID));
                    item = new Book(title, author, itemID, pageCount, isbn, genre);
                }
                case 2 -> {
                    System.out.print("✏️ Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("✏️ Enter director: ");
                    author = scanner.nextLine();
                    System.out.print("✏️ Enter duration (minutes): ");
                    double duration = getValidDoubleInput();
                    System.out.print("✏️ Enter rating: ");
                    String rating = scanner.nextLine();
                    System.out.print("✏️ Enter languages (comma-separated): ");
                    List<String> languages = Arrays.asList(scanner.nextLine().split(","));
                    System.out.print("✏️ Has subtitles? (true/false): ");
                    boolean hasSubtitles = getValidBooleanInput();
                    itemID = "VD-".concat(ID_FORMATTER.format(++ID));
                    item = new DVD(title, author, itemID, duration, rating, languages, hasSubtitles);
                }
                case 3 -> {
                    System.out.print("✏️ Enter title: ");
                    title = scanner.nextLine();
                    System.out.print("✏️ Enter author: ");
                    author = scanner.nextLine();
                    System.out.print("✏️ Enter publication date (YYYY-MM-DD): ");
                    String publicationDate = scanner.nextLine();
                    System.out.print("✏️ Enter issue number: ");
                    String issueNumber = scanner.nextLine();
                    System.out.print("✏️ Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("✏️ Is monthly? (true/false): ");
                    boolean isMonthly = getValidBooleanInput();
                    itemID = "MG-".concat(ID_FORMATTER.format(++ID));
                    item = new Magazine(title, author, itemID, publicationDate, issueNumber, category, isMonthly);
                }
                default -> {
                    System.out.println("❗ Invalid item type. Returning to the main menu.");
                    return;
                }
            }
            catalog.addItem(item);
            System.out.println("✅ Item added successfully!");
        } catch (Exception e) {
            System.out.println("⚠️ Error adding item: " + e.getMessage());
        }
    }

    private void removeItem() {
        System.out.print("🗑️ Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        if (catalog.removeItem(itemID)) {
            System.out.println("✅ Item removed successfully!");
        } else {
            System.out.println("❗ Item not found. Please check the ID and try again.");
        }
    }

    private void viewCatalog() {
        List<LibraryItem<?>> items = catalog.getAllItems();
        if (items.isEmpty()) {
            System.out.println("📭 Catalog is empty");
            return;
        }
        System.out.println("\n📖 Current Catalog:");
        items.forEach(System.out::println);
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input. Please enter a valid number: ");
            }
        }
    }

    private double getValidDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input. Please enter a valid number: ");
            }
        }
    }

    private boolean getValidBooleanInput() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.print("❌ Invalid input. Please enter 'true' or 'false': ");
            }
        }
    }

    public static void main(String[] args) {
        new LibraryCatalogUI().start();
    }
}
