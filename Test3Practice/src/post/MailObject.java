package post;

public abstract class MailObject {
	private Citizen sender;
	private Citizen receiver;
	
	
	public MailObject(Citizen sender, Citizen receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	abstract double getTax();
	abstract int getTime();
}
