import java.util.List;

public class Supplier implements Runnable{

	private static final int HOW_MUCH_TO_SELL = 25;
	private Warehouse warehouse;
	
	@Override
	public void run() {
		while (true) {
			List<Product> products = warehouse.getProductiNaIzcherpvane();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return ;
			}
			
			System.out.println("Sega go zaredih s ei tiq raboti " + products);
			
			for (Product p : products) {
				try {
					warehouse.addProduct(p, HOW_MUCH_TO_SELL);
				} catch (WarehouseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Supplier(Warehouse warehouse) {
		super();
		this.warehouse = warehouse;
	}

}
