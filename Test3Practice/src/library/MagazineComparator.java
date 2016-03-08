package library;

import java.util.Comparator;

public class MagazineComparator implements Comparator<Magazine> {

	@Override
	public int compare(Magazine o1, Magazine o2) {
		if (o1.getName().equals(o2.getName()))
			return o1.getNumber() - o2.getNumber();
		return o1.getName().compareTo(o2.getName());
	}

}
