package library;

import java.util.HashMap;
import java.util.Map;

public class Librarian extends Thread {
	private static final int LIBRIRIAN_TO_SLEEP = 1000;
	private Map<Chetivo, Double> vzetiChetiva;

	public Librarian() {
		setDaemon(true);
		this.vzetiChetiva = new HashMap<Chetivo, Double>();
	}

	@Override
	public void run() {
		while(true){
			try {
				sleep(LIBRIRIAN_TO_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Chetivo chetiva : vzetiChetiva.keySet()) {
				
			}
		}
	}

	public void addChetivoToWatch(Chetivo c) throws LibraryException {
		if (c != null) {
			try {
				synchronized (vzetiChetiva) {
					vzetiChetiva.put(c, (double) c.getTax());
				}
			} catch (LibraryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new LibraryException("Ne moje da go dobavq za gledane!!!");
		}
	}

	public void removeChetivoToWatch(Chetivo c) throws LibraryException {
		if (c != null && vzetiChetiva.containsKey(c)) {
			synchronized (vzetiChetiva) {
				vzetiChetiva.remove(c);
			}
		} else {
			throw new LibraryException("Ne moje da go dobavq za gledane!!!");
		}
	}

	public double getHowMuchToPay(Chetivo c) {
		return this.vzetiChetiva.get(c);
	}
}
