import java.util.Arrays;
import java.util.List;

public class Client implements Runnable{

	private Shop shop;
	
	@Override
	public void run() {
		List<Product> moqtSpisyk =  Arrays.asList(
				new Product("Pork", ProductType.MEATS),
				new Product("Cucumber", ProductType.VEGETABLES),
				new Product("Banana", ProductType.FRUITS));
				
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return ;
			}
			
			System.out.println("Q sega da si ponazaruvam");
			try {
				Product randomProduct = moqtSpisyk.get((int)(Math.random() * moqtSpisyk.size()));
				int randomQuantity = (int)(Math.random() * 3)+1; 
				
				shop.sellProduct(randomProduct, randomQuantity);
				
				System.out.println("Kupih "+ randomProduct + " - sega shte go izqm!");
			} catch (WarehouseException e) {
				e.printStackTrace();
			}
		}
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Client(Shop shop) {
		super();
		this.shop = shop;
	}

}
