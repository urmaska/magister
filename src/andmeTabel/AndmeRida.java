package andmeTabel;

import java.util.ArrayList;
import java.util.List;

public class AndmeRida {

	private List<Integer> atribuudid = new ArrayList<Integer>();
	private int reegliteArv=0;
	private boolean onKaetud;
	
	public void lisaAtribuut(int atribuut){
		atribuudid.add(atribuut);
	}
	public int getAtribuut(int tulp) {
		return atribuudid.get(tulp);
	}

	public List<Integer> getAtribuudid() {
		return atribuudid;
	}
	
	public void setAtribuudid(List<Integer> atribuudid) {
		this.atribuudid = atribuudid;
	}

	public int getValjund() {
		return atribuudid.get(atribuudid.size()-1);
	}

	public int getReegliteArv() {
		return reegliteArv;
	}

	public void lisaReegel() {
		reegliteArv++;
	}
	
	public void eemaldaReegel() {
		reegliteArv--;
	}
	
	public boolean onYksReegel(){
		return reegliteArv ==1;
	}

	public boolean onKaetud() {
		return onKaetud;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (Integer atribuut : atribuudid)
			string += atribuut + " ";
		return string + " reegleid on: " + reegliteArv;
	}
	public void märgiKaetuks() {
		onKaetud = true;		
	}	
	
}
