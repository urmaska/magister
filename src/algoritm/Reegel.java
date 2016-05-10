package algoritm;

import java.util.ArrayList;
import java.util.List;

import andmeTabel.AndmeRida;

public class Reegel implements Comparable<Reegel> {
	private List<AndmeRida> andmeRead;
//	private String reegel;
	private List<Tunnus> sisendid = new ArrayList<Tunnus>();
	private Tunnus valjund;
	
	private boolean kaetud = false;
	
	@Override
	public String toString() {
		String string = "";
		for (Tunnus sisend : sisendid) {
			string += sisend.toString() + " & ";
		}
		string = string.substring(0, string.length()-3);
		return string + "->" + valjund.toString() + "\t katab " + andmeRead.size() + " rida";
	}

	public void lisaTunnus(Tunnus tunnus){
		sisendid.add(tunnus);
	}

	public List<Tunnus> getSisendid() {
		return sisendid;
	}

	public List<AndmeRida> getAndmeRead() {
		return andmeRead;
	}

	public void setAndmeRead(List<AndmeRida> andmeRead) {
		this.andmeRead = andmeRead;
	}
	
	public int katmataRidadeArv() {
		int katmataRidadeArv = 0;
		for (AndmeRida andmerida : andmeRead)
			if(!andmerida.onKaetud())
				katmataRidadeArv++;
		return katmataRidadeArv;
	}
	
	public Tunnus getValjund() {
		return valjund;
	}

	public void setValjund(Tunnus valjund) {
		this.valjund = valjund;
	}
	
	public void margiReadKaetuks() {
		for (AndmeRida andmeRida : andmeRead)
			andmeRida.märgiKaetuks();	
	}

	public void eemaldaReegel() {
		for (AndmeRida kaetudRida : andmeRead)
			kaetudRida.eemaldaReegel();
		
	}

	public boolean isKaetud() {
		return kaetud;
	}

	public void setKaetud(boolean kaetud) {
		this.kaetud = kaetud;
	}

	@Override
	public int compareTo(Reegel o) {
		if(o.getSisendid().size() == getSisendid().size())
			return Integer.compare(getAndmeRead().size(), o.getAndmeRead().size());
		return Integer.compare(o.getSisendid().size(), getSisendid().size());
	}
}
