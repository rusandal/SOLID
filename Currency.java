public class Currency {
    private static Currency instance = null;
    private static double dollarExchange;
    private static double euroExchange;
    private static double eurUsd;


    private Currency() {
    }

    public static Currency get() {
        if (instance == null) instance = new Currency();
        return instance;
    }

    public static double getDollarExchange() {
        return dollarExchange;
    }

    public static void setDollarExchange(double dollarExchange) {
        Currency.dollarExchange = dollarExchange;
    }

    public static double getEuroExchange() {
        return euroExchange;
    }

    public static void setEuroExchange(double euroExchange) {
        Currency.euroExchange = euroExchange;
    }

    public static double getEurUsd() {
        return eurUsd;
    }

    public static void setEurUsd(double eurUsd) {
        Currency.eurUsd = eurUsd;
    }
}
