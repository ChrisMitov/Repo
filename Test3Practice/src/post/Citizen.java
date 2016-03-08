package post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Citizen implements Runnable {
	private static final double RANDOM_COEFFICIENT = 0.5;
	private static final int CITIZEN_TO_WAIT_BEFORE_SEND_MAILOBJECT = 1000;
	private static final int NUMBER_OF_MAILBOXES = 25;
	private String firstName;
	private String lastName;
	private String address;
	private static PostOffice post;
	private static List<Mailbox> mailboxes;

	static {
		setPost(new PostOffice());
		mailboxes = new ArrayList<Mailbox>();
		for (int i = 0; i < NUMBER_OF_MAILBOXES; i++) {
			mailboxes.add(new Mailbox());
		}
	}

	public Citizen(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Otivam da puskam pismo");
			try {
				Thread.sleep(CITIZEN_TO_WAIT_BEFORE_SEND_MAILOBJECT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Pusnah go!");
			try {
				sendRandomMail();
			} catch (PostOfficeException e) {
				e.printStackTrace();
			}
			synchronized (mailboxes) {
				mailboxes.notifyAll();
			}
		}
	}

	public MailObject sendRandomMail() throws PostOfficeException {
		MailObject mail = null;
		if (Math.random() > RANDOM_COEFFICIENT) {
			int random = (int) (Math.random() * mailboxes.size());
			mail = new Letter(new Citizen("Pesho", "Petkov", "Bul.bylgaria"),
					new Citizen("Gosho", "Petrankin", "ul.Vrabcha"));
			Mailbox mb = mailboxes.get(random);
			if(Math.random() > RANDOM_COEFFICIENT){
				post.addMailObject(mail);
			}else{
				mb.addLetter((Letter) mail);
			}
		} else {
			mail = new Kolet(new Citizen("Pesho", "Petkov", "Bul.bylgaria"),
					new Citizen("Gosho", "Petrankin", "ul.Vrabcha"), generateRandom(), generateRandom(),
					generateRandom(), true);
			post.addMailObject(mail);
		}
		return mail;
	}

	@Override
	public String toString() {
		return "Citizen [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

	private int generateRandom() {
		return (int) (Math.random() * 100);
	}

	public static PostOffice getPost() {
		return post;
	}

	public static void setPost(PostOffice post) {
		Citizen.post = post;
	}

	public static List<Mailbox> getMailboxes() {
		return Collections.unmodifiableList(mailboxes);
	}
}
