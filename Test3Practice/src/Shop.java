import java.util.List;

public class Shop extends TyrgovskiObekt implements Runnable {

	private static final int PO_KOLKO_DA_ZAREDQ = 5;
	private Warehouse warehouse;
	
	@Override
	public void run() {
		while (true) {
			List<Product> produkti = getProductiNaIzcherpvane();
			if (produkti.size() > 0) {
				for (Product p : produkti)
					try {
						warehouse.sellProduct(p, PO_KOLKO_DA_ZAREDQ);
						this.addProduct(p, PO_KOLKO_DA_ZAREDQ);
					} catch (WarehouseException e) {
						e.printStackTrace();
					}
			}
		}
		
	}

	public Shop(Warehouse warehouse) {
		super();
		this.warehouse = warehouse;
	}

}
