
public class Demo {
	public static void main(String[] args) throws InterruptedException {
		Library lib = new Library();
//		Client gergana = new Client(lib);
//		Thread t = new Thread(gergana);
//		t.start();
//		Thread.sleep(23000);
//		lib.logTakenMaterials();
		lib.showCatalog(TypeOfReadingMaterial.BOOK);
	}
}
