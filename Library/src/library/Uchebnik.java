package library;

import java.util.Comparator;

public class Uchebnik extends ReadingMaterial {

	private String author;
	
	public Uchebnik(String name, String izdatelstvo, String author) throws LibraryException {
		super(name, izdatelstvo);
		this.author = author;
	}

	@Override
	int getTax() {
		return 3;
	}

	@Override
	int take() throws LibraryException {
		return 150;
	}

	@Override
	public Comparator getComparator() {
		return new UchebnikComparator();
	}

	@Override
	public String toString() {
		return "Uchebnik [author=" + author + ", " + super.toString() + "]";
	}


}
