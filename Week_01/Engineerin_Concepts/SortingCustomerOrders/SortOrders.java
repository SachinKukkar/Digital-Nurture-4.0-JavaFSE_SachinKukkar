package Week_01.Engineerin_Concepts.SortingCustomerOrders;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Name: " + customerName + ", Total: ₹" + totalPrice;
    }
}

public class SortOrders {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Ravi", 2499.99),
            new Order(102, "Neha", 1299.50),
            new Order(103, "Amit", 3799.00),
            new Order(104, "Sara", 799.00)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nOrders sorted by Bubble Sort:");
        printOrders(orders);

        // Reset and use Quick Sort
        orders = new Order[]{
            new Order(101, "Ravi", 2499.99),
            new Order(102, "Neha", 1299.50),
            new Order(103, "Amit", 3799.00),
            new Order(104, "Sara", 799.00)
        };
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        printOrders(orders);
    }
}
