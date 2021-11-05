public class Product {
    protected String name;
    protected int cost;
    protected String brand;
    protected String type;


    public Product(String name, int cost, String brand, String type) {
        this.name = name;
        this.cost = cost;
        this.brand = brand;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Название='" + name + '\'' +
                ", Стоимость в рублях =" + cost +
                ", Стоимость в долларах =" + String.format("%.2f", cost * Currency.getDollarExchange()) +
                ", Стоимость в евро =" + String.format("%.2f", cost * Currency.getEuroExchange()) +
                ", Брэнд ='" + brand + '\'' +
                '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
