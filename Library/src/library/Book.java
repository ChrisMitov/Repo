package library;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Book extends ReadingMaterial {

	private String author;
	private LocalDateTime date;

	public Book(String name, String izdatelstvo, String author, LocalDateTime date) throws LibraryException {
		super(name, izdatelstvo);
		this.author = author;
		this.date = date;
	}

	@Override
	int getTax() {
		return 2;
	}

	@Override
	int take() {
		return 300;
	}


	@Override
	public Comparator getComparator() {
		return new BookComparator();
	}

	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", date=" + date + " , " + super.toString() + "]";
	}

}
