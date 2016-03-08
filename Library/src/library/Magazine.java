package library;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Magazine extends ReadingMaterial {

	public int getNumber() {
		return number;
	}

	private int number;
	private LocalDateTime date;

	public Magazine(String name, String izdatelstvo, int number, LocalDateTime date) throws LibraryException {
		super(name, izdatelstvo);
		this.number = number;
		this.date = date;
	}

	@Override
	int getTax() throws LibraryException {
		throw new LibraryException("Spisaniqta ne se vzimat i nqmat taksa!!!");
	}

	@Override
	int take() throws LibraryException {
		throw new LibraryException("Ne mojesh da vzemesh spisanie");
	}

	@Override
	public Comparator getComparator() {
		return new MagazineComparator();
	}

	@Override
	public String toString() {
		return "Magazine [number=" + number + ", date=" + date + ", " + super.toString() + "]";
	}


}