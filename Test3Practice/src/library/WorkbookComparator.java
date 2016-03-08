package library;

import java.util.Comparator;

public class WorkbookComparator implements Comparator<Workbook>{

	@Override
	public int compare(Workbook o1, Workbook o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
