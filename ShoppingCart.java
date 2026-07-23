import java.util.*;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> cart = new ArrayList<>();

        while (true) {

            System.out.println("\n====== Shopping Cart ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Product");
            System.out.println("4. Search Product");
            System.out.println("5. Total Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    cart.add(new Product(name, price, quantity));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println("\nProducts in Cart:");
                        for (Product p : cart) {
                            System.out.println("Name: " + p.name +
                                    " | Price: ₹" + p.price +
                                    " | Qty: " + p.quantity +
                                    " | Total: ₹" + p.getTotal());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    String remove = sc.nextLine();

                    boolean removed = false;

                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).name.equalsIgnoreCase(remove)) {
                            cart.remove(i);
                            removed = true;
                            System.out.println("Product removed successfully.");
                            break;
                        }
                    }

                    if (!removed)
                        System.out.println("Product not found.");
                    break;

                case 4:
                    System.out.print("Enter product name to search: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (Product p : cart) {
                        if (p.name.equalsIgnoreCase(search)) {
                            System.out.println("Product Found");
                            System.out.println("Price: ₹" + p.price);
                            System.out.println("Quantity: " + p.quantity);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Product not found.");
                    break;

                case 5:
                    double total = 0;

                    for (Product p : cart) {
                        total += p.getTotal();
                    }

                    System.out.println("Grand Total Bill: ₹" + total);
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

