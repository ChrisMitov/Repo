import java.util.Comparator;

public class TextBook extends ReadingMaterial {

	private String author;
	
	public TextBook(String author, String name, String publisher) {
		super(name, publisher);
		this.author  = author;
	}
	
	public Comparator getComparator() {
		return new TextBookComparator();
	}
	
	public int getSecondsForTake() {
		return 1500;
	}
	
	public Double gePrice()  {
		return 3.0;
	}

	@Override
	public String toString() {
		return "TextBook [author=" + author + ", getName()=" + getName() + ", getPublisher()=" + getPublisher() + "]";
	}

}
