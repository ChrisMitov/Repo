import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TyrgovskiObekt implements IMall {
	private static final int DEFAULT_QUANTITY = 15;
	private static final int MIN_QUANTITY = 5;
	
	private Map<Product, Integer> produkti = new
			ConcurrentHashMap<Product, Integer>();
	
	public TyrgovskiObekt() {
		for (String productName : new String[]{"Banana","Orange","Apple"})
			produkti.put(new Product(productName, ProductType.FRUITS),DEFAULT_QUANTITY);
		
		for (String productName : new String[]{"Pork","Beef","Chicken"})
			produkti.put(new Product(productName, ProductType.MEATS),DEFAULT_QUANTITY);
		
		for (String productName : new String[]{"Potato","Eggplant","Cucumber"})
			produkti.put(new Product(productName, ProductType.VEGETABLES),DEFAULT_QUANTITY);
	
	}
	
	/* (non-Javadoc)
	 * @see IMall#addProduct(Product, int)
	 */
	@Override
	public void addProduct(Product p, int quantity) throws WarehouseException {	
		if (p != null && produkti.containsKey(p)) {
			int newQuantity = produkti.get(p);
			newQuantity += quantity;
			
			produkti.put(p, newQuantity);
			
			synchronized (produkti) {
				produkti.notify();
			}
		}
		else {
			throw new WarehouseException("Kyv e toq prodykt be galmak?");
		}
	}
	
	private boolean canIBuyThisProduct(Product p, int quantity) {
		return produkti.get(p) >= quantity;
	}
	
	/* (non-Javadoc)
	 * @see IMall#removeProduct(Product, int)
	 */
	@Override
	public void sellProduct(Product p, int quantity) throws WarehouseException {
		if (p != null && produkti.containsKey(p)) {
			while (!canIBuyThisProduct(p, quantity)) {
				try {
					synchronized (produkti) {
						produkti.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int newQuantity = produkti.get(p);
			newQuantity -= quantity;
			
			produkti.put(p, newQuantity);
		}
		else {
			throw new WarehouseException("Kyv e toq prodykt be galmak?");
		}
	}
	
	public List<Product> getProductiNaIzcherpvane() {
		List<Product> produktiNaIzcherpvane = new ArrayList<Product>();
		for (Product p : produkti.keySet()) {
			if (produkti.get(p) < MIN_QUANTITY)
				produktiNaIzcherpvane.add(p);
		}
		
		return produktiNaIzcherpvane;
	}
}
