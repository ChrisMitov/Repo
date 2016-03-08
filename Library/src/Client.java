import java.util.List;

public class Client implements Runnable {
	
	private Library library;
	

	public Client(Library library) {
		this.library = library;
	}

	@Override
	public void run() {
		for (int i = 1; i<=10; i++) {
			List<ReadingMaterial> books = library.catalogOfBooks();
			try {
				ReadingMaterial r = books.get((int) (Math.random()*books.size()));
				library.getReadingMaterial(r);
				Thread.sleep((long) (Math.random() * 5000.0));
				library.returnReadingMaterial(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i<=10; i++) {
			List<ReadingMaterial> books = library.catalogOfTextBooks();
			try {
				ReadingMaterial r = books.get((int) (Math.random()*books.size()));
				library.getReadingMaterial(r);
				Thread.sleep((long) (Math.random() * 5000.0));
				library.returnReadingMaterial(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




}
