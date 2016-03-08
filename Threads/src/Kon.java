
public class Kon implements Runnable {

	private static final int TIME_TO_RUN_A_MILE = 10;
	private static final int MILES_TO_RUN = 50;

	@Override
	public void run() {
		System.out.println(getHorseName() + " starts running.");

		for (int mile = 1; mile <= MILES_TO_RUN; mile++) {
			try {
				Thread.sleep(getTimeToRunAMile());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getHorseName() + " izbqga ei tolkoz dosega " + mile);
		}
		
		System.out.println(getHorseName() + " finished.");
	}

	String getHorseName() {
		return Thread.currentThread().getName();
	}

	protected int getTimeToRunAMile() {
		return TIME_TO_RUN_A_MILE;
	}
}
