package post;

import java.util.List;

public class Colector extends Postman {

	private static final int TIME_TO_MAKE_WALKING = 2000;
	private static final int NUMBER_OF_MAILOBJECTS_TO_START_WORK = 50;

	public Colector(String firstName, String lastName, String address, int staj) {
		super(firstName, lastName, address, staj);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (true) {
			while (getPost().getNumberOfMailObjects() > NUMBER_OF_MAILOBJECTS_TO_START_WORK) {
				try {
					synchronized (getPost()) {
						getPost().wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(TIME_TO_MAKE_WALKING);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Mailbox mailboxes : getMailboxes()) {
				List<Letter> letters = mailboxes.getAllLetterInMailbox();
				try {
					getPost().addMailObject(letters);
				} catch (PostOfficeException e) {
					e.printStackTrace();
				}
				synchronized (getPost()) {
					getPost().notify();
				}
			}

		}
	}

}
