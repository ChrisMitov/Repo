public class Publika implements Runnable {

	ThreadGroup kone;
	
	public Publika(ThreadGroup kone) {
		super();
		this.kone = kone;
	}

	@Override
	public void run() {
		class Local{
			static final String here = "here";
			public void print(){
				System.err.println(here);
			}
		}
		while (kone.activeCount() > 0) {
			System.out.println("Vika i psuva.");
			System.out.println("Specialno shte psuvam ei tiq : ");
			
			Thread[] koneThreads = new Thread[kone.activeCount()];
			kone.enumerate(koneThreads, true);
			for (Thread kon : koneThreads) {
				System.out.println(kon.getName());
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Aide stavame i si trygvame. Kuci kone ne ni se geldat.");
		Local l = new Local();
		l.print();
	}

}
