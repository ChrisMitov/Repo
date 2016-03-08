package post;

public class Letter extends MailObject {

	private static final int TIME_FOR_LETTER = 10;
	private static final double TAX_FOR_LETTER = 0.5;

	public Letter(Citizen sender, Citizen receiver) {
		super(sender, receiver);
	}

	@Override
	double getTax() {
		return TAX_FOR_LETTER;
	}

	@Override
	int getTime() {
		return TIME_FOR_LETTER;
	}
	
}
