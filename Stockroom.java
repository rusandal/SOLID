import java.util.HashMap;
import java.util.Map;

public class Stockroom {
    public static Map<String, Product> stockroom = new HashMap<>();

    public static String myStaticToString() {
        String myStockroom = "Магазин: ";
        for (Product product : stockroom.values()) {
            myStockroom += product;
        }
        return myStockroom;
    }
}
