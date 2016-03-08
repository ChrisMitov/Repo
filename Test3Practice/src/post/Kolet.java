package post;

public class Kolet extends MailObject {
	private static final int TIME_TO_DELIVER = 20;
	private static final double COEFFICIENT_FOR_OVERSIZED = 0.5;
	private static final double NORMAL_PRIZE_OF_KOLET = 2.0;
	private static final int OVERSIZE_FOR_KOLET = 60;
	private int height;
	private int width;
	private int length;
	private boolean isChupliv;

	public Kolet(Citizen sender, Citizen receiver, int height, int width, int length, boolean isChupliv) {
		super(sender, receiver);
		this.height = height;
		this.width = width;
		this.length = length;
		this.isChupliv = isChupliv;
	}

	@Override
	double getTax() {
		double tax = NORMAL_PRIZE_OF_KOLET;
		if (isObemen()) {
			tax *= COEFFICIENT_FOR_OVERSIZED;
		}
		if (isChupliv()) {
			tax *= COEFFICIENT_FOR_OVERSIZED;
		}
		return tax;
	}

	public boolean isChupliv() {
		return isChupliv;
	}

	@Override
	int getTime() {
		return TIME_TO_DELIVER;
	}

	private boolean isObemen() {
		return this.height > OVERSIZE_FOR_KOLET || this.width > OVERSIZE_FOR_KOLET || this.length > OVERSIZE_FOR_KOLET;
	}

}
