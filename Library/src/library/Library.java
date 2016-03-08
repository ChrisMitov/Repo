package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
	private Map<TypeOfReadingMaterial, Map<String, List<ReadingMaterial>>> materials;
	private int numberOfTakenMaterials;
	private Librarian librarian;

	public Library() throws LibraryException {
		this.librarian = new Librarian();
		librarian.start();
		materials = new HashMap<>();
		materials.put(TypeOfReadingMaterial.BOOK, new TreeMap<>());
		materials.put(TypeOfReadingMaterial.MAGAZINE, new TreeMap<>());
		materials.put(TypeOfReadingMaterial.UCHEBNIK, new TreeMap<>());

		materials.get(TypeOfReadingMaterial.BOOK).put("Istoricheski",
				Arrays.asList(new Book("Prosveta", "Ivan Vazov", "Pod igoto", LocalDateTime.of(1963, 11, 10, 3, 34)),
						new Book("Nov svqt", "Ekziuperi", "Malkiq Princ", LocalDateTime.now())));

		materials.get(TypeOfReadingMaterial.MAGAZINE).put("Modni",
				Arrays.asList(new Magazine("Anubis", "Cosmos", 3, LocalDateTime.now()),
						new Magazine("Bulvest 2000", "Blqsyk", 5, LocalDateTime.now())));

		materials.get(TypeOfReadingMaterial.UCHEBNIK).put("Matematika",
				Arrays.asList(new Uchebnik("Ganio Hristev", "Algebra za 5 klas", "Anubis"),
						new Uchebnik("Stamat Stoynov", "Integrali za 2-ri klas", "Prosveta")));
	}

	public void showCatalog(TypeOfReadingMaterial type) {
		Map<String, List<ReadingMaterial>> catalog = materials.get(type);
		for (String category : catalog.keySet()) {
			List<ReadingMaterial> list = catalog.get(category);
			list.sort(list.get(0).getComparator());
			for (ReadingMaterial rm : list) {
				System.out.println(rm);
			}
		}
	}

	public void getReadingMaterial(ReadingMaterial rm) throws LibraryException {
		if (rm != null && !rm.isTaken()) {
			rm.takeIt(true);
			this.librarian.addMaterial(rm);
		} else {
			throw new LibraryException("Kakvo e tova!!");
		}
	}

	public void returnReadingMaterial(ReadingMaterial rm) throws LibraryException {
		if (rm != null && !rm.isTaken()) {
			rm.takeIt(false);
			System.out.println("Trqbva da platish " + this.librarian.returnMoney(rm));
			this.librarian.removeMaterial(rm);
		} else {
			throw new LibraryException("Kakvo e tova!!");
		}
	}
	
	
}
