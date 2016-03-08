import java.time.LocalDateTime;
import java.util.Comparator;

public class Book extends ReadingMaterial {

	private String author;
	private LocalDateTime date;
	
	public Book(LocalDateTime date, String author, 
			String name, String publisher) {
		super(name, publisher);
		this.author = author;
		this.date = date;
	}

	public Comparator getComparator() {
		return new BookComparator();
	}
	
	public int getSecondsForTake() {
		return 3000;
	}
	
	public Double gePrice()  {
		return 2.0;
	}
	
	@Override
	public String toString() {
		return "Book [author=" + author + ", date=" + date + ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	
}
