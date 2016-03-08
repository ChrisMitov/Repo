import java.time.LocalDateTime;
import java.util.Comparator;

public class Magazine extends ReadingMaterial {

	private LocalDateTime date;
	private int number;
	
	public Magazine(LocalDateTime date, int number, 
			String name, String publisher) {
		super(name, publisher);
		this.date = date;
		this.number = number;
	}
	
	public Comparator getComparator() {
		return new MagazineComparator();
	}
	
	public int getSecondsForTake() throws LibraryException {
		throw new LibraryException("Tova ne mojesh da go vzemesh ve da ti *** ****** !!!");
	}
	
	public Double gePrice() throws LibraryException  {
		throw new LibraryException("Tuka kolkoto i da daesh nqma da ti go dam !!");
	}
	
	@Override
	public boolean canBeTaken() {
		return false;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Magazine [date=" + date + ", number=" + number + ", getName()=" + getName() + ", getPublisher()="
				+ getPublisher() + "]";
	}

}
