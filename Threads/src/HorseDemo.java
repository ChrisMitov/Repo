import java.util.ArrayList;
import java.util.List;

public class HorseDemo {

	static final int NUMBER_OF_HORSES = 10;

	public static void main(String[] args) {
		List<Thread> horses = new ArrayList<Thread>();
		
		ThreadGroup grupaKone = new ThreadGroup("Normalni kone.");
		

		for (int horse = 1; horse <= NUMBER_OF_HORSES; horse++) {
			Kon kon = null;
			Thread konThread = null;
			
			if (Math.random() > 0.5) {
				kon = new Kon();
				konThread = new Thread(grupaKone, kon, "Kon nomer " + horse);
			}
			else {
				kon = new KucKon();
				konThread = new Thread(kon, "Kon nomer " + horse);
			}
			horses.add(konThread);
		}
		
		

		for (Thread konThread : horses) {
			konThread.start();
		}
		
		Thread publikaThread = new Thread(new Publika(grupaKone));
		publikaThread.setDaemon(true);
		publikaThread.start();	
		
		
	}

}
