package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public abstract class ReadingMaterial {
	private String name;
	private String izdatelstvo;
	private List<History> history;
	private boolean isTaken;

	public ReadingMaterial(String name, String izdatelstvo) throws LibraryException {
		this.setName(name);
		this.setIzdatelstvo(izdatelstvo);
		history = new ArrayList<History>();
	}

	abstract int getTax() throws LibraryException;

	abstract int take() throws LibraryException;

	public abstract Comparator getComparator();

	public void takeIt(boolean b) {
		this.isTaken = b;
		if (isTaken) {
			history.add(new History(LocalDateTime.now()));
		} else {
			History h = this.history.get(history.size() - 1);
			h.setDateReturn(LocalDateTime.now());
		}
	}

	@Override
	public String toString() {
		return "ReadingMaterial [name=" + name + ", izdatelstvo=" + izdatelstvo + ", history=" + history + ", isTaken="
				+ isTaken + "]";
	}

	public String getName() {
		return name;
	}

	void setName(String name) throws LibraryException {
		validation(name);
		this.name = name;
	}

	public String getIzdatelstvo() {
		return izdatelstvo;
	}

	void setIzdatelstvo(String izdatelstvo) throws LibraryException {
		validation(izdatelstvo);
		this.izdatelstvo = izdatelstvo;
	}

	public boolean isTaken() {
		return isTaken;
	}
	
	public LocalDateTime timeTaken(){
		return this.history.get(history.size()-1).getDateReturn();
	}

	private void validation(String smth) throws LibraryException {
		if (smth == null || smth.trim().equals("")) {
			throw new LibraryException("Nekorektno vyvedeno ime");
		}
	}
}
