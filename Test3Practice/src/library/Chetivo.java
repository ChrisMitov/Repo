package library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Chetivo {
	private String name;
	private String izdatelstvo;
	private List<History> history;
	private boolean isTaken;

	public Chetivo(String name, String izdatelstvo) {
		this.name = name;
		this.izdatelstvo = izdatelstvo;
		isTaken = false;
		history = new ArrayList<History>();
	}

	abstract int getTax() throws LibraryException;

	abstract int getSeconds() throws LibraryException;

	@SuppressWarnings("rawtypes")
	abstract Comparator getComparator();

	@Override
	public String toString() {
		return "Chetivo [name=" + name + ", izdatelstvo=" + izdatelstvo + "]";
	}

	public String getName() {
		return name;
	}

	public void setChetivoTaken(boolean b) {
		this.isTaken = b;
		if (isTaken) {
			this.history.add(new History(LocalDateTime.now()));
		} else {
			History h = this.history.get(this.history.size() - 1);
			h.setDateReturned(LocalDateTime.now());
		}
	}

	public LocalDateTime timeForLastChetivo() {
		return this.history.get(this.history.size() - 1).getDateTaken();
	}

	public void showHistory() {
		for (History his : history) {
			System.out.println(his.toString());
		}
	}

	public boolean isTaken() {
		return isTaken;
	}
}
