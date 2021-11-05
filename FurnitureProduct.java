public class FurnitureProduct extends Product {
    private final int height;
    private final int width;

    public FurnitureProduct(String name, int cost, String brand, String type, int height, int width) {
        super(name, cost, brand, type);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return super.toString() + " ширина=" + height + " высота= " + width + '\n';
    }
}
