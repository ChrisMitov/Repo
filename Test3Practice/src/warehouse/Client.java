package warehouse;

import java.util.List;

public class Client implements Runnable {
	private static final int TIME_TO_WAIT = 1000;
	private static final int MIN_PRODUCTS_TO_BUY = 1;
	private static final int MAX_PRODUCTS_TO_BUY = 3;
	private Shop shop;

	public Client(Shop shop2) {
		this.shop = shop2;
	}

	@Override
	public void run() {
		while (true) {
			List<Product> products = this.shop.getAllProducts();
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (products.size() > 0) {
				try {
					Product random = products.get((int) (Math.random() * products.size()));
					int quantity = (int) (Math.random() * MAX_PRODUCTS_TO_BUY + MIN_PRODUCTS_TO_BUY);
					System.out.println("Kupuvam " + random + " tolkova: " + quantity);
					this.shop.removeProduct(random, quantity);
				} catch (WarehouseException e) {
					e.printStackTrace();
				}
			} else {
				synchronized (shop) {

					shop.notify();
				}
			}
		}

	}

}
