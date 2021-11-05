public class ExchangeService {

    static String exchange(String value1, String value2) {

        Stockroom.stockroom.put(Sold.getSold().get(value1).getName(), Sold.getSold().get(value1));
        Sold.setSold(Stockroom.stockroom.get(value2));
        Stockroom.stockroom.remove(value2);
        Sold.getSold().remove(value1);
        return "Замена произведена";
    }
}
