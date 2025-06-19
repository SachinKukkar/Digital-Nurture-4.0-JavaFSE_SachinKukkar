import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class Main {

    // Linear Search
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (assumes array is sorted by productName)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0)
                return mid;
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Mobile", "Electronics"),
            new Product(4, "Book", "Stationery")
        };

        // Sort for binary search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        String searchTerm = "Mobile";

        int linearIndex = linearSearch(products, searchTerm);
        System.out.println("Linear Search Index: " + linearIndex);

        int binaryIndex = binarySearch(products, searchTerm);
        System.out.println("Binary Search Index: " + binaryIndex);
    }
}
