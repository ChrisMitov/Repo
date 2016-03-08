package library;
import java.util.Comparator;

public class UchebnikComparator implements Comparator<Uchebnik>{

	@Override
	public int compare(Uchebnik o1, Uchebnik o2) {		
		return o1.getName().compareTo(o2.getName());
	}


}
