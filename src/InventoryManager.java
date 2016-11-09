import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {

    private List<Product> products;

    public InventoryManager() {
        products = new ArrayList<>();

        products.add(new Product("Bread", 7.34, 100));
        products.add(new Product("Milk", 17.30, 10));
        products.add(new Product("Beer", 8.40, 50));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (products.contains(product)) {
            int indexOfProduct = products.indexOf(product);
            Product oldProduct = products.get(indexOfProduct);
            oldProduct.setPrice(product.getPrice());
            oldProduct.addQuantity(product.getQuantity());
        } else {
            products.add(product);
        }

    }

    public double calculateProductsPrice() {
        double result = 0;

        for (Product product : products) {
            result += product.getPrice() * product.getQuantity();
        }

        return result;
    }

    public Map<String, Double> calculateEachProductsPrice() {
        Map<String, Double> result = new HashMap<>();

        for (Product product : products) {
            result.put(product.getName(), product.getPrice() * product.getQuantity());
        }

        return result;
    }
}
