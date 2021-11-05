public class Exchange {
    static String exchange(String value1, String value2) {
        if (value1.equals("RUB") & value2.equals("USD")) {
            return "1 рубль = " + Currency.getDollarExchange() + "доллар";
        } else if (value1.equals("RUB") & value2.equals("EUR")) {
            return "1 рубль = " + Currency.getEuroExchange() + "евро";
        }
        return "1 евро = " + Currency.getEurUsd() + "доллар";
    }
}
