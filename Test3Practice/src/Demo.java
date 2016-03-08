
public class Demo {
	public static void main(String[] args) {
		Warehouse wh = new Warehouse();
		new Thread(new Supplier(wh)).start();
		Shop shop = new Shop(wh);
		new Thread(shop).start();
//		new Thread(new Client(shop)).start();
		ThreadGroup group = new ThreadGroup("Kupuvachi");
		for (int i = 0; i < 5; i++) {
			new Thread(group, new Client(shop)).start();
		}
	}
}
