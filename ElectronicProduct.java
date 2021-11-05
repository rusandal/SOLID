public class ElectronicProduct extends Product {
    private final int memory;

    public ElectronicProduct(String name, int cost, String brand, String type, int memory) {
        super(name, cost, brand, type);
        this.memory = memory;
    }

    @Override
    public String toString() {
        return super.toString() + " память=" + memory + "\n";
    }
}
