package warehouse;

import java.util.List;

public class Supplier implements Runnable {

	private static final int HOW_MUCH_TO_SELL = 25;
	private static final int TIME_TO_SLEEP = 1000;
	private Warehouse warehouse;

	public Supplier(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {

		while (true) {
			List<Product> products = warehouse.getProductiNaIzcherpvane();
			try {
				Thread.sleep(TIME_TO_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Sega go zaredih s ei tiq raboti " + products);
			for (Product product : products) {
				try {
					warehouse.addProduct(product, HOW_MUCH_TO_SELL);
				} catch (WarehouseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
