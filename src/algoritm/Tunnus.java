package algoritm;

public class Tunnus {
	private int tulp, vaartus;
	private boolean kaetud = false;
	
	
	public Tunnus(int tulp, int vaartus) {
		super();
		this.tulp = tulp;
		this.vaartus = vaartus;
	}

	public int getTulp() {
		return tulp;
	}

	public int getVaartus() {
		return vaartus;
	}

	@Override
	public String toString() {
		return "t" + tulp + "=" + vaartus;
	}

	public boolean isKaetud() {
		return kaetud;
	}

	public void setKaetud(boolean kaetud) {
		this.kaetud = kaetud;
	}
}
