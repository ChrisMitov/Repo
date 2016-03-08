package post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mailbox {
	List<Letter> letters = new ArrayList<Letter>();

	public void addLetter(Letter l) throws PostOfficeException {
		if (l != null) {
			synchronized (letters) {
				letters.add(l);
			}
		} else {
			throw new PostOfficeException("Nekorektno pismo!!");
		}
	}
	
	public List<Letter> getAllLetterInMailbox(){
		List<Letter> list = new ArrayList<>();
		synchronized (letters) {
			Collections.copy(list, letters);
			letters.clear();
		}
		return list;
	}
}
