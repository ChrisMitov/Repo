package library;

public class Demo {
	public static void main(String[] args) throws LibraryException {
		Library lib = new Library();
		lib.showCatalog(TypeOfReadingMaterial.BOOK);
	}
}
