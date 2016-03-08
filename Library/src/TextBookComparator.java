import java.util.Comparator;

public class TextBookComparator implements Comparator<TextBook>{

	@Override
	public int compare(TextBook o1, TextBook o2) {		
		return o1.getName().compareTo(o2.getName());
	}


}
