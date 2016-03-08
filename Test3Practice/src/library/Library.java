package library;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
	private Map<TypeOfChetivo, Map<String, List<Chetivo>>> chetiva;
	private Librarian librarian;

	public Library() {
		librarian = new Librarian();
		librarian.start();
		chetiva = new HashMap<>();
		chetiva.put(TypeOfChetivo.Book, new TreeMap<>());
		chetiva.put(TypeOfChetivo.Magazine, new TreeMap<>());
		chetiva.put(TypeOfChetivo.Workbook, new TreeMap<>());

		chetiva.get(TypeOfChetivo.Book).put("Istoricheski",
				Arrays.asList(new Book("Iliada", "Prosveta", "Omir", LocalDate.of(1967, 12, 1)),
						new Book("Antigona", "Anubis", "petkan", LocalDate.now())));
	}

	public void takeChetivoPodNaem(Chetivo c) throws LibraryException {
		if (c != null && !c.isTaken()) {
			synchronized (chetiva) {
				c.setChetivoTaken(true);
				librarian.addChetivoToWatch(c);
			}
		} else {
			throw new LibraryException("Ne moje da vzemesh tozi produkt");
		}
	}

	public void returnChetivoPodNaem(Chetivo c) throws LibraryException {
		if (c != null && c.isTaken()) {
			synchronized (chetiva) {
				c.setChetivoTaken(false);
				System.out.println("Dyljish" + librarian.getHowMuchToPay(c));
				librarian.removeChetivoToWatch(c);
			}
		} else {
			throw new LibraryException("Ne moje da vyrnesh tozi produkt");
		}
	}
}