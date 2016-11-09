import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by Дмитрий on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InventoryManager inventoryManager = new InventoryManager();

        do {
            printMenu();

            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int menuItem = Integer.parseInt(reader.readLine());

                switch (menuItem) {
                    case 0:
                        List<Product> products = inventoryManager.getAllProducts();
                        for (Product product : products) {
                            System.out.println(product.toString());
                        }
                        break;
                    case 1:
                        Product product = fetchNewProduct();
                        inventoryManager.addProduct(product);
                        break;
                    case 2:
                        double allProductsPrice = inventoryManager.calculateProductsPrice();
                        System.out.println(allProductsPrice);
                        break;
                    case 3:
                        Map<String, Double> productsPrice = inventoryManager.calculateEachProductsPrice();
                        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
                            System.out.printf("Price of %s = %.2f.\n", entry.getKey(), entry.getValue());
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please enter correct menu item!");
                }
            } catch (Exception e) {
                System.out.println("Please try again.");
            }
        } while (true);
    }

    private static Product fetchNewProduct() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter name of product: ");
        String name = reader.readLine();
        System.out.println("Please enter price of product: ");
        double price = Double.parseDouble(reader.readLine());
        System.out.println("Please enter quantity of product: ");
        int quantity = Integer.parseInt(reader.readLine());

        return new Product(name, price, quantity);
    }

    private static void printMenu() {
        String menu = new StringBuilder()
                .append("Select an option:\n")
                .append("[0] Print out all products\n")
                .append("[1] Add new Product\n")
                .append("[2] Calculate price of all Products on stock\n")
                .append("[3] Calculate price for each Product on stock\n")
                .append("[4] Exit")
                .toString();

        System.out.println(menu);
    }
}


