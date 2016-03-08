package library;

import java.time.LocalDate;
import java.util.Comparator;

public class Magazine extends Chetivo {
	private int number;
	private LocalDate date;
	
	
	public Magazine(String name, String izdatelstvo, int number, LocalDate date) {
		super(name, izdatelstvo);
		this.setNumber(number);
		this.setDate(date);
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	int getTax() throws LibraryException {
		throw new LibraryException("Ne moje da vzimash spisaniq");
	}


	@Override
	int getSeconds() throws LibraryException {
		throw new LibraryException("Ne moje da vzimash spisaniq");
	}


	@Override
	Comparator getComparator() {
		return new MagazineComparator();
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
}
