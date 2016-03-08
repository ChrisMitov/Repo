package library;

import java.util.Comparator;

public class Workbook extends Chetivo {
	private String author;

	public Workbook(String name, String izdatelstvo, String author) {
		super(name, izdatelstvo);
		this.author = author;
	}

	@Override
	int getTax() throws LibraryException {
		return 3;
	}

	@Override
	int getSeconds() throws LibraryException {
		return 150;
	}

	@Override
	Comparator getComparator() {
		return new WorkbookComparator();
	}

}
