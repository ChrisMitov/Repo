package library;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Librarian extends Thread {
	private static final int TIME_TO_WAIT = 1000;
	private Map<ReadingMaterial, Double> materialsToWatch;

	public Librarian() {
		this.setDaemon(true);
		materialsToWatch = new HashMap<>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (ReadingMaterial materials : materialsToWatch.keySet()) {
				int secForThisBook;
				try {
					secForThisBook = materials.take();
					Duration d = Duration.between(materials.timeTaken(), LocalDateTime.now());
					if (d.getSeconds() > secForThisBook) {
						int sec = (int) (d.getSeconds() - secForThisBook);
						double money = ((100 + sec) / 100) * materials.getTax();
						synchronized (materialsToWatch) {
							materialsToWatch.put(materials, money);
						}
					}
				} catch (LibraryException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void addMaterial(ReadingMaterial rm) throws LibraryException {
		if (rm != null) {
			synchronized (materialsToWatch) {
				materialsToWatch.put(rm, (double) rm.getTax());
			}
		} else {
			throw new LibraryException("Nekorekten material");
		}
	}

	public void removeMaterial(ReadingMaterial rm) throws LibraryException {
		if (rm != null) {
			synchronized (materialsToWatch) {
				materialsToWatch.remove(rm);
			}
		} else {
			throw new LibraryException("Kakyv e tozi material");
		}
	}

	public double returnMoney(ReadingMaterial rm) {
		return this.materialsToWatch.get(rm);
	}

	public SortedSet<ReadingMaterial> getMateralsByDate() {
		SortedSet<ReadingMaterial> sorted = new TreeSet<ReadingMaterial>((s1, s2) -> {
			return s1.timeTaken().compareTo(s2.timeTaken());
		});
		sorted.addAll(this.materialsToWatch.keySet());
		return sorted;
	}

	public SortedSet<ReadingMaterial> getMaterialsByOverdue() {
		SortedSet<ReadingMaterial> sorted = new TreeSet<>(
				(s1, s2) -> this.materialsToWatch.get(s1).compareTo(this.materialsToWatch.get(s2)));
		sorted.addAll(this.materialsToWatch.keySet());
		return sorted;
	}

}
