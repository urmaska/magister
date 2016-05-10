package algoritm;

import java.util.ArrayList;
import java.util.List;

import andmeTabel.AndmeRida;
import andmeTabel.AndmeTabel;

public class SagedusTabel {
	private int[][] sagedusTabel;
	public int[][] getSagedusTabel() {
		return sagedusTabel;
	}

	private List<AndmeRida>[][] valjavıtuTabelid;
	private AndmeTabel andmeTabel;
	private int v‰ljundTulp;
	private int tulpi;
	private int v‰‰rtusi;

	@SuppressWarnings("unchecked")
	public SagedusTabel(int tulpi, int v‰‰rtusi, AndmeTabel andmeTabel) {
		super();
		v‰ljundTulp = tulpi-1;
		this.tulpi = tulpi;
		this.v‰‰rtusi = v‰‰rtusi;
		sagedusTabel = new int[tulpi][v‰‰rtusi];
		valjavıtuTabelid = new ArrayList[tulpi][v‰‰rtusi];
		this.andmeTabel = andmeTabel;
	}

	public void lisaRida(AndmeRida tabeliRida) {
		int tulp = 0;
		for(int atribuut : tabeliRida.getAtribuudid()){
			sagedusTabel[tulp][atribuut]++;
			if(valjavıtuTabelid[tulp][atribuut] == null)
				valjavıtuTabelid[tulp][atribuut] = new ArrayList<AndmeRida>();
			valjavıtuTabelid[tulp++][atribuut].add(tabeliRida);
		}
	}

	public void prindiSagedusTabel() {
		for(int v‰‰rtus=0; v‰‰rtus< v‰‰rtusi;v‰‰rtus++){
			String tabeliRida ="";
			for(int tulp =0; tulp<tulpi;tulp++)
				tabeliRida += sagedusTabel[tulp][v‰‰rtus] + " ";
			System.out.println(tabeliRida);
		}
	}

	public List<Reegel> otsiReeglid() {
		List<Reegel> leitudReeglid = new ArrayList<Reegel>();
		int nulle = 0;
		int mitteNull = 0;
		for(int i = 0; i< v‰‰rtusi; i++)
			if(sagedusTabel[v‰ljundTulp][i]==0)
				nulle++;
			else
				mitteNull=i;
		if((nulle+1)== v‰‰rtusi ){
			leitudReeglid.add(reegelLeitud(mitteNull));
			return leitudReeglid;
		} for(int tulp = 0; tulp < v‰ljundTulp; tulp++)
			for(int v‰‰rtus=0; v‰‰rtus<v‰‰rtusi; v‰‰rtus++)
				if(sagedusTabel[tulp][v‰‰rtus]==1){
					int v‰ljund = valjavıtuTabelid[tulp][v‰‰rtus].get(0).getValjund();
					leitudReeglid.add(reegelLeitud(tulp,v‰‰rtus,v‰ljund));
				}
		leitudReeglid.addAll(teeV‰ljavıtt());
		return leitudReeglid;
	}

	private List<Reegel> teeV‰ljavıtt() {
		List<Reegel> leitudReeglid = new ArrayList<Reegel>();
		int minTulp = 0;
		int minV‰‰rtus = 0;
		int minSagedus = Integer.MAX_VALUE;
		for(int tulp = 0; tulp < v‰ljundTulp; tulp++)
			for(int v‰‰rtus=0; v‰‰rtus<v‰‰rtusi; v‰‰rtus++){
				int sagedus = sagedusTabel[tulp][v‰‰rtus];
				if(sagedus!=0 && sagedus< minSagedus){
					minSagedus = sagedus;
					minTulp = tulp;
					minV‰‰rtus = v‰‰rtus;
				}
			}
		if(minSagedus == Integer.MAX_VALUE)
			return leitudReeglid;
		leitudReeglid.addAll(teeValjavott(minTulp,minV‰‰rtus));
		if(!kasLopp(tulpi))
			leitudReeglid.addAll(teeV‰ljavıtt());
		return leitudReeglid;
	}

	private boolean kasLopp(int tulpi) {
		for(int tulp=0; tulp< tulpi-1;tulp++)
			for(int v‰‰rtus=0;v‰‰rtus<v‰‰rtusi;v‰‰rtus++)
				if(sagedusTabel[tulp][v‰‰rtus] !=0 )
					return false;
		return true;
	}

	private List<Reegel> teeValjavott(int tulp, int v‰‰rtus) {
		AndmeTabel v‰ljavıtt = new AndmeTabel();
		v‰ljavıtt.setEelmineTase(andmeTabel);
		v‰ljavıtt.setValjavotuTulp(tulp);
		v‰ljavıtt.setValjavotuVaartus(v‰‰rtus);
		v‰ljavıtt.looSagedusTabel(tulpi);
		for (AndmeRida rida : valjavıtuTabelid[tulp][v‰‰rtus])
			v‰ljavıtt.lisaUusRida(rida);
		peegeldaNullSagedusTabelisse(tulp, v‰‰rtus);
		peegeldaNullidAlla(v‰ljavıtt, tulp);
		return v‰ljavıtt.otsiReeglid();
	}

	private void peegeldaNullidAlla(AndmeTabel v‰ljavıtt, int v‰ljaVıtuTulp) {
		int v‰‰rtusi = sagedusTabel[0].length;
		for(int tulp=0; tulp<tulpi;tulp++)
			for(int v‰‰rtus=0;v‰‰rtus<v‰‰rtusi;v‰‰rtus++)
				if(sagedusTabel[tulp][v‰‰rtus]==0 || v‰ljaVıtuTulp==tulp)
					v‰ljavıtt.peegeldaNullSagedusTabelisse(tulp,v‰‰rtus);		

	}

	public void peegeldaNullSagedusTabelisse(int tulp, int v‰‰rtus) {
		sagedusTabel[tulp][v‰‰rtus]=0;
//		valjavıtuTabelid [tulp][v‰‰rtus]= new ArrayList<AndmeRida>();
	}

	private Reegel reegelLeitud(int tulp, int v‰‰rtus, int v‰ljund) {
		Reegel reegel = new Reegel();
		reegel.setValjund(new Tunnus(sagedusTabel.length-1, v‰ljund ));
		reegel.lisaTunnus(new Tunnus(tulp, v‰‰rtus));
		reegel.setAndmeRead(valjavıtuTabelid[tulp][v‰‰rtus]);
		lisaTunnusReeglile(reegel, andmeTabel);
		peegeldaNullSagedusTabelisse(tulp, v‰‰rtus);
		return reegel;
	}

	private void lisaTunnusReeglile(Reegel reegel, AndmeTabel andmeTabel) {
		if(andmeTabel.getValjavotuTulp() == -1)
			return;
		int tulp = andmeTabel.getValjavotuTulp();
		int v‰‰rtus = andmeTabel.getValjavotuVaartus();
		reegel.lisaTunnus(new Tunnus(tulp, v‰‰rtus));
		lisaTunnusReeglile(reegel, andmeTabel.getEelmineTase());

	}

	private Reegel reegelLeitud(int valjund) {
		int tulp = andmeTabel.getValjavotuTulp();
		int v‰‰rtus = andmeTabel.getValjavotuVaartus();
		return andmeTabel.getEelmineTase().getSagedustabel().reegelLeitud(tulp, v‰‰rtus, valjund);
	}

}
