
public class KucKon extends Kon {
	
	@Override
	String getHorseName() {
		return "Kuc kon " + super.getHorseName();
	}
	
	@Override
	protected int getTimeToRunAMile() {
		return 2*super.getTimeToRunAMile();
	}
}
