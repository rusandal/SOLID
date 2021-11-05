import java.util.HashMap;
import java.util.Map;

public class Sold {
    private static final Map<String, Product> sold = new HashMap<>();

    public static Map<String, Product> getSold() {
        return sold;
    }

    public static void setSold(Product product) {
        sold.put(product.getName(), product);
    }
}
