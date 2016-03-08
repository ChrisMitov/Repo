package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class TyrgovskiObekt implements IMall {
	private static final int MIN_VALUE = 5;
	private static final int DEFAULT_QUANTITY = 20;
	private Map<Product, Integer> products = new ConcurrentHashMap<Product, Integer>();

	public TyrgovskiObekt() {
		for (String product : new String[] { "Banana", "Apple", "Kaisiq" }) {
			products.put(new Product(TypeOfProduct.FRIUTS, product), DEFAULT_QUANTITY);
		}
		for (String product : new String[] { "Domat", "Krastavica", "Tikvichka" }) {
			products.put(new Product(TypeOfProduct.VEGETABLES, product), DEFAULT_QUANTITY);
		}
		for (String product : new String[] { "Svinsko", "Pileshko", "Agneshko" }) {
			products.put(new Product(TypeOfProduct.MEATS, product), DEFAULT_QUANTITY);
		}
	}

	@Override
	public void addProduct(Product p, int quantity) throws WarehouseException {
		if (p != null || quantity > 0) {
			int newQuantity = products.get(p) + quantity;
			products.put(p, newQuantity);
			synchronized (products) {
				products.notify();
			}
		} else {
			throw new WarehouseException("Nekorektno sydyrjanie na zaqvkata");
		}

	}

	@Override
	public void removeProduct(Product p, int quantity) throws WarehouseException {
		if (p != null || quantity > 0) {
			while (!canIBuyThisProduct(p, quantity)) {
				try {
					synchronized (products) {
						products.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int newQuantity = quantity - products.get(p);
			products.put(p, newQuantity);
		} else {
			throw new WarehouseException("Nekorektno sydyrjanie na zaqvkata");
		}

	}

	private boolean canIBuyThisProduct(Product p, int quantity) {
		if (products.containsKey(p) && products.get(p) >= quantity) {
			return true;
		}
		return false;
	}

	public List<Product> getAllProducts() {
		List<Product> producti = new ArrayList<>();
		for (Product product : products.keySet()) {
			if (products.get(product) > 0) {
				producti.add(product);
			}
		}
		return producti;
	}

	public List<Product> getProductiNaIzcherpvane() {
		List<Product> produktiNaIzcherpvane = new ArrayList<Product>();
		for (Product p : products.keySet()) {
			if (products.get(p) < MIN_VALUE)
				produktiNaIzcherpvane.add(p);
		}
		
		return produktiNaIzcherpvane;
	}
}
