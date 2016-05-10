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

	private List<AndmeRida>[][] valjav�tuTabelid;
	private AndmeTabel andmeTabel;
	private int v�ljundTulp;
	private int tulpi;
	private int v��rtusi;

	@SuppressWarnings("unchecked")
	public SagedusTabel(int tulpi, int v��rtusi, AndmeTabel andmeTabel) {
		super();
		v�ljundTulp = tulpi-1;
		this.tulpi = tulpi;
		this.v��rtusi = v��rtusi;
		sagedusTabel = new int[tulpi][v��rtusi];
		valjav�tuTabelid = new ArrayList[tulpi][v��rtusi];
		this.andmeTabel = andmeTabel;
	}

	public void lisaRida(AndmeRida tabeliRida) {
		int tulp = 0;
		for(int atribuut : tabeliRida.getAtribuudid()){
			sagedusTabel[tulp][atribuut]++;
			if(valjav�tuTabelid[tulp][atribuut] == null)
				valjav�tuTabelid[tulp][atribuut] = new ArrayList<AndmeRida>();
			valjav�tuTabelid[tulp++][atribuut].add(tabeliRida);
		}
	}

	public void prindiSagedusTabel() {
		for(int v��rtus=0; v��rtus< v��rtusi;v��rtus++){
			String tabeliRida ="";
			for(int tulp =0; tulp<tulpi;tulp++)
				tabeliRida += sagedusTabel[tulp][v��rtus] + " ";
			System.out.println(tabeliRida);
		}
	}

	public List<Reegel> otsiReeglid() {
		List<Reegel> leitudReeglid = new ArrayList<Reegel>();
		int nulle = 0;
		int mitteNull = 0;
		for(int i = 0; i< v��rtusi; i++)
			if(sagedusTabel[v�ljundTulp][i]==0)
				nulle++;
			else
				mitteNull=i;
		if((nulle+1)== v��rtusi ){
			leitudReeglid.add(reegelLeitud(mitteNull));
			return leitudReeglid;
		} for(int tulp = 0; tulp < v�ljundTulp; tulp++)
			for(int v��rtus=0; v��rtus<v��rtusi; v��rtus++)
				if(sagedusTabel[tulp][v��rtus]==1){
					int v�ljund = valjav�tuTabelid[tulp][v��rtus].get(0).getValjund();
					leitudReeglid.add(reegelLeitud(tulp,v��rtus,v�ljund));
				}
		leitudReeglid.addAll(teeV�ljav�tt());
		return leitudReeglid;
	}

	private List<Reegel> teeV�ljav�tt() {
		List<Reegel> leitudReeglid = new ArrayList<Reegel>();
		int minTulp = 0;
		int minV��rtus = 0;
		int minSagedus = Integer.MAX_VALUE;
		for(int tulp = 0; tulp < v�ljundTulp; tulp++)
			for(int v��rtus=0; v��rtus<v��rtusi; v��rtus++){
				int sagedus = sagedusTabel[tulp][v��rtus];
				if(sagedus!=0 && sagedus< minSagedus){
					minSagedus = sagedus;
					minTulp = tulp;
					minV��rtus = v��rtus;
				}
			}
		if(minSagedus == Integer.MAX_VALUE)
			return leitudReeglid;
		leitudReeglid.addAll(teeValjavott(minTulp,minV��rtus));
		if(!kasLopp(tulpi))
			leitudReeglid.addAll(teeV�ljav�tt());
		return leitudReeglid;
	}

	private boolean kasLopp(int tulpi) {
		for(int tulp=0; tulp< tulpi-1;tulp++)
			for(int v��rtus=0;v��rtus<v��rtusi;v��rtus++)
				if(sagedusTabel[tulp][v��rtus] !=0 )
					return false;
		return true;
	}

	private List<Reegel> teeValjavott(int tulp, int v��rtus) {
		AndmeTabel v�ljav�tt = new AndmeTabel();
		v�ljav�tt.setEelmineTase(andmeTabel);
		v�ljav�tt.setValjavotuTulp(tulp);
		v�ljav�tt.setValjavotuVaartus(v��rtus);
		v�ljav�tt.looSagedusTabel(tulpi);
		for (AndmeRida rida : valjav�tuTabelid[tulp][v��rtus])
			v�ljav�tt.lisaUusRida(rida);
		peegeldaNullSagedusTabelisse(tulp, v��rtus);
		peegeldaNullidAlla(v�ljav�tt, tulp);
		return v�ljav�tt.otsiReeglid();
	}

	private void peegeldaNullidAlla(AndmeTabel v�ljav�tt, int v�ljaV�tuTulp) {
		int v��rtusi = sagedusTabel[0].length;
		for(int tulp=0; tulp<tulpi;tulp++)
			for(int v��rtus=0;v��rtus<v��rtusi;v��rtus++)
				if(sagedusTabel[tulp][v��rtus]==0 || v�ljaV�tuTulp==tulp)
					v�ljav�tt.peegeldaNullSagedusTabelisse(tulp,v��rtus);		

	}

	public void peegeldaNullSagedusTabelisse(int tulp, int v��rtus) {
		sagedusTabel[tulp][v��rtus]=0;
//		valjav�tuTabelid [tulp][v��rtus]= new ArrayList<AndmeRida>();
	}

	private Reegel reegelLeitud(int tulp, int v��rtus, int v�ljund) {
		Reegel reegel = new Reegel();
		reegel.setValjund(new Tunnus(sagedusTabel.length-1, v�ljund ));
		reegel.lisaTunnus(new Tunnus(tulp, v��rtus));
		reegel.setAndmeRead(valjav�tuTabelid[tulp][v��rtus]);
		lisaTunnusReeglile(reegel, andmeTabel);
		peegeldaNullSagedusTabelisse(tulp, v��rtus);
		return reegel;
	}

	private void lisaTunnusReeglile(Reegel reegel, AndmeTabel andmeTabel) {
		if(andmeTabel.getValjavotuTulp() == -1)
			return;
		int tulp = andmeTabel.getValjavotuTulp();
		int v��rtus = andmeTabel.getValjavotuVaartus();
		reegel.lisaTunnus(new Tunnus(tulp, v��rtus));
		lisaTunnusReeglile(reegel, andmeTabel.getEelmineTase());

	}

	private Reegel reegelLeitud(int valjund) {
		int tulp = andmeTabel.getValjavotuTulp();
		int v��rtus = andmeTabel.getValjavotuVaartus();
		return andmeTabel.getEelmineTase().getSagedustabel().reegelLeitud(tulp, v��rtus, valjund);
	}

}
