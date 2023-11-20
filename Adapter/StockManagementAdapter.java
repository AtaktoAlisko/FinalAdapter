package Adapter;

public class StockManagementAdapter implements InternalBKSystem {
    private StockSystem stock;

    public StockManagementAdapter(StockSystem stock) {
        this.stock = stock;
    }

    @Override
    public void makeOrder() {
        stock.unload();
    }
}
