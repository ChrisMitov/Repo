package library;

import java.time.LocalDate;
import java.util.Comparator;

public class Book extends Chetivo {
	private String author;
	private LocalDate dataNaIzdavane;

	public Book(String name, String izdatelstvo, String author, LocalDate dataNaIzdavane) {
		super(name, izdatelstvo);
		this.author = author;
		this.setDataNaIzdavane(dataNaIzdavane);
	}

	@Override
	int getTax() {
		return 2;
	}

	@Override
	int getSeconds() {
		return 300;
	}

	@SuppressWarnings("rawtypes")
	@Override
	Comparator getComparator() {
		return new BookComparator();
	}
	
	@Override
	public String toString() {
		return "Book [author=" + author + ", dataNaIzdavane=" + dataNaIzdavane + "," + super.toString()
				+ "]";
	}

	public LocalDate getDataNaIzdavane() {
		return dataNaIzdavane;
	}

	public void setDataNaIzdavane(LocalDate dataNaIzdavane) {
		this.dataNaIzdavane = dataNaIzdavane;
	}


}
