package post;

import java.util.List;

public class Postman extends Citizen implements Runnable {
	private static final int MIN_MAILOBJECTS_TO_WORK = 50;
	private int staj;
	private int obraboteni = 0;

	public Postman(String firstName, String lastName, String address, int staj) {
		super(firstName, lastName, address);
		this.staj = staj;
	}

	@Override
	public void run() {
		while (true) {
			while (getPost().getNumberOfMailObjects() < MIN_MAILOBJECTS_TO_WORK) {
				try {
					getPost().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int numberOfAllPostman = Thread.currentThread().getThreadGroup().activeCount();
			int number = getPost().getNumberOfMailObjects() / numberOfAllPostman;

			try {
				List<MailObject> mails = getPost().takeMails(number);
				for (MailObject mailObject : mails) {
					Thread.sleep(mailObject.getTime());
				}
				obraboteni += mails.size();
				synchronized (getPost()) {
					getPost().notifyAll();
				}

			} catch (PostOfficeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Postman [staj=" + staj + ", obraboteni=" + obraboteni + ", " + super.toString() + "]";
	}

	public int getObraboteni() {
		return obraboteni;
	}
}
