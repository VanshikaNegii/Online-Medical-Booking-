import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product 
{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCartItem 
{
    private Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

class OnlineMedicalStore 
{
    private List<Product> products;
    private List<ShoppingCartItem> cart;

    public OnlineMedicalStore() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product("Painkiller", 10.99, 50));
        products.add(new Product("Bandages", 5.99, 100));
        products.add(new Product("Vitamins", 8.99, 75));
        products.add(new Product("Thermometer", 12.99, 25));
        products.add(new Product("Hand Sanitizer", 6.99, 80));
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice() + " (" + product.getQuantity() + " available)");
        }
    }

    public void addToCart(int productIndex, int quantity) {
        if (productIndex >= 0 && productIndex < products.size()) {
            Product selectedProduct = products.get(productIndex);
            if (selectedProduct.getQuantity() >= quantity) {
                ShoppingCartItem item = new ShoppingCartItem(selectedProduct, quantity);
                cart.add(item);
                selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                System.out.println("Item added to the cart.");
            } else {
                System.out.println("Insufficient quantity available for the selected product.");
            }
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (int i = 0; i < cart.size(); i++) {
                ShoppingCartItem item = cart.get(i);
                Product product = item.getProduct();
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice() +
                        " (" + item.getQuantity() + " item(s)) Total: $" + item.getTotalPrice());
            }
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
        } else {
            double totalPrice = 0;
            for (ShoppingCartItem item : cart) {
                totalPrice += item.getTotalPrice();
            }
            System.out.println("Total Price: $" + totalPrice);
System.out.println("Thank you for shopping!");
cart.clear();
}
}
}

public class OnlineMedicalStoreApp 
{
public static void main(String[] args) 
{
Scanner scanner = new Scanner(System.in);
OnlineMedicalStore store = new OnlineMedicalStore();

    while (true) {
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) 
        {
            case 1:
                store.displayProducts();
                break;
            case 2:
                System.out.print("Enter the product index: ");
                int productIndex = scanner.nextInt();
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();
                store.addToCart(productIndex - 1, quantity);
                break;
            case 3:
                store.displayCart();
                break;
            case 4:
                store.checkout();
                break;
            case 5:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}
