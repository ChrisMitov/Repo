package warehouse;

import java.util.List;

public class Shop extends TyrgovskiObekt implements Runnable{
	private static final int KOLICHESTVO_ZA_ZAREJDANE = 5;
	private Warehouse warehouse;

	public Shop(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		while (true) {
			List<Product> products = warehouse.getProductiNaIzcherpvane();
			if(products.size() > 0){
				for (Product product : products) {
					try {
						warehouse.removeProduct(product, KOLICHESTVO_ZA_ZAREJDANE);
						this.addProduct(product, KOLICHESTVO_ZA_ZAREJDANE);
					} catch (WarehouseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
}
