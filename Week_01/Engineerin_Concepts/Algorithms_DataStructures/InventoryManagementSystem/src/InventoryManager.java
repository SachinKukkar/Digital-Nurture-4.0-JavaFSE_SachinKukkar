import java.util.HashMap;
import java.util.Scanner;

public class InventoryManager {
    private HashMap<String, Product> inventory = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        inventory.put(id, new Product(id, name, quantity, price));
        System.out.println("Product added!");
    }

    public void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();
        if (inventory.containsKey(id)) {
            System.out.print("Enter New Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter New Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Product p = inventory.get(id);
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product updated!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void listInventory() {
        System.out.println("----- Inventory List -----");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. List Inventory\n5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> listInventory();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.menu();
    }
}
