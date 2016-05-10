package optimeeri;
import java.util.ArrayList;
import java.util.List;

import algoritm.Reegel;
import algoritm.Tunnus;

public class TunnusReegliPaar implements Comparable<TunnusReegliPaar> {
	private int sagedus;
	private int tulp;
	private int vaartus;
	private List<Reegel> reeglid = new ArrayList<Reegel>();
	private List<Tunnus> tunnused = new ArrayList<Tunnus>();
//	private boolean kaetud = false;
	
	public void setkaetud(){
//		kaetud = true;
		for (Tunnus tunnus: tunnused) {
			tunnus.setKaetud(true);
		}
	}
	
	public boolean isKaetud(){
		return tunnused.get(0).isKaetud();
	}
	
	public int getSagedus() {
		return sagedus;
	}

	public int getTulp() {
		return tulp;
	}

	public int getVaartus() {
		return vaartus;
	}

	public List<Reegel> getReeglid() {
		return reeglid;
	}
	
	public void lisaReegel(Tunnus tunnus, Reegel reegel, int sagedus){
		this.sagedus += sagedus;
		reeglid.add(reegel);
		tunnused.add(tunnus);
	}

	public TunnusReegliPaar(Tunnus tunnus, int sagedus, int tulp, int vaartus, Reegel reegel) {
		super();
		this.tulp = tulp;
		this.vaartus = vaartus;
		lisaReegel(tunnus, reegel, sagedus);
	}

	@Override
	public int compareTo(TunnusReegliPaar o) {
		return Integer.compare(sagedus, o.sagedus);
	}

	@Override
	public String toString() {
		return "t" + tulp + "=" + vaartus + " " + sagedus;
	}

	public void eemaldaKaetud() {
		int indeks = 0;
		for (Reegel reegel : reeglid) {
			if(!reegel.isKaetud())
				tunnused.get(indeks).setKaetud(false);
			indeks++;
		}
		
	}
	
	
}
