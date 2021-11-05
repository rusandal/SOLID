public class TechnicService implements SoftwareService, DeliveryService {
    private static int lastOrder = 0;
    private int idOrder;
    private boolean status = false;

    @Override
    public void softwareInstall(Product product) {
        System.out.println("Software is installed");
    }

    @Override
    public void delivery(Product product, String address) {
        this.idOrder = lastOrder + 1;
        lastOrder = this.idOrder;
        Stockroom.stockroom.remove(product.getName());
        this.status = true;
    }

    public boolean isStatus() {
        return status;
    }
}
