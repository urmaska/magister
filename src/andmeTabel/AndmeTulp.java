package andmeTabel;

import java.util.ArrayList;
import java.util.List;

public class AndmeTulp {
	private List<String> vaartused = new ArrayList<String>();
	private String nimi;
	public AndmeTulp(String nimi) {
		this.setNimi(nimi);
	}

	public int getvaartuseKood(String vaartus){
		int kood = vaartused.indexOf(vaartus);
		if(kood != -1)
			return kood;
		vaartused.add(vaartus);
		return getvaartuseKood(vaartus);
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getVäärtus(int index) {
		return vaartused.get(index);
	}
}
