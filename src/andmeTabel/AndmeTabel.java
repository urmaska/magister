package andmeTabel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import andmeTabel.AndmeRida;
import andmeTabel.AndmeTabel;
import andmeTabel.AndmeTulp;
import optimeeri.SagedusReegel;
import optimeeri.TunnusReegliPaar;
import algoritm.Reegel;
import algoritm.Reeglid;
import algoritm.SagedusTabel;
import algoritm.Tunnus;

public class AndmeTabel {
	private List<AndmeRida> andmeTabel = new ArrayList<AndmeRida>();
	private List<AndmeTulp> andmeTulbad = new ArrayList<AndmeTulp>();
	private List<Reegel> reeglid = new ArrayList<Reegel>();
	private SagedusTabel sagedustabel;
	private int tulpadeArv;
	private AndmeTabel eelmineTase;
	private int valjavotuTulp=-1;
	private int valjavotuVaartus=-1;
	boolean lisatud = false;
	private String sisendidStr="";
	private int[][] koopia;
	
	public int objektideArv(){
		return andmeTabel.size();
	}
	
	public AndmeTabel getEelmineTase() {
		return eelmineTase;
	}

	public int getValjavotuTulp() {
		return valjavotuTulp;
	}

	public int getValjavotuVaartus() {
		return valjavotuVaartus;
	}

	public void looTabel(String[] andmed) {
		tulpadeArv = andmed.length;
		looSagedusTabel(tulpadeArv);
		for(int i=0; i< tulpadeArv; i++)
			andmeTulbad.add(new AndmeTulp(andmed[i]));
	}	
	
	public void setEelmineTase(AndmeTabel eelmineTase) {
		this.eelmineTase = eelmineTase;
	}

	public void setValjavotuTulp(int valjavotuTulp) {
		this.valjavotuTulp = valjavotuTulp;
	}

	public void setValjavotuVaartus(int valjavotuVaartus) {
		this.valjavotuVaartus = valjavotuVaartus;
	}

	public void lisaUusRida(String[] andmed) {
		AndmeRida tabeliRida = new AndmeRida();
		teisendaAndmed(andmed, tabeliRida);
		lisaUusRida(tabeliRida);			
	}

	public void lisaUusRida(AndmeRida rida) {
		andmeTabel.add(rida);
//		lisatud=true;
		sagedustabel.lisaRida(rida);	
	}
	
	private void teisendaAndmed(String[] andmed, AndmeRida tabeliRida) {
		for(int i=0; i< tulpadeArv; i++){
			int atribuut =andmeTulbad.get(i).getvaartuseKood(andmed[i]);
			tabeliRida.lisaAtribuut(atribuut);
		}
	}

	public void prindiSagedusTabel() {
		sagedustabel.prindiSagedusTabel();	
	}
	
	@Override
	public String toString() {
		String result="";
		for (AndmeRida rida : andmeTabel)
			result+=rida+"\n";
		return result;
	}

	public List<Reegel> otsiReeglid() {

//		if(lisatud)
		if(andmeTabel.isEmpty())
			return new ArrayList<Reegel>();
		reeglid.addAll(sagedustabel.otsiReeglid());
		return reeglid;
	}

	public SagedusTabel getSagedustabel() {
		return sagedustabel;
	}

	public void looSagedusTabel(int tulpadeArv) {
		sagedustabel = new SagedusTabel(tulpadeArv, 15, this);		
	}

	public void peegeldaNullSagedusTabelisse(int tulp, int väärtus) {
		sagedustabel.peegeldaNullSagedusTabelisse(tulp, väärtus);
	}

	public void prindiReeglid() {
		for (Reegel reegel : reeglid)
			System.out.println(reegel);
	}

	public void minimeeriReeglid() {
		reeglid = Reeglid.optimeeri(reeglid);	
	}

	public List<Reegel> getReeglid() {
		return reeglid;
	}

	public void prindiReegliSüsteem() throws IOException {
		fout = new File("src/test/RuleSystem.java");
		fos = new FileOutputStream(fout);
		bw = new BufferedWriter(new OutputStreamWriter(fos));
		kirjutaAlgus();
//		String süsteem = "";
		boolean esimeneRida = true;
		for (Reegel reegel : reeglid){
			
			String tingimusLause = "";
			for (Tunnus sisend : reegel.getSisendid()) {
				if(!tingimusLause.equals(""))
					tingimusLause += " && ";
				AndmeTulp tulp = andmeTulbad.get(sisend.getTulp());
				tingimusLause += tulp.getNimi() + ".equals(\"" + tulp.getVäärtus(sisend.getVaartus()) +"\")";
			}
			AndmeTulp väljundTulp = andmeTulbad.get(tulpadeArv-1);
			String väljund = väljundTulp.getVäärtus(reegel.getValjund().getVaartus());
			tingimusLause = "(" + tingimusLause + ")\n\t\t\t return \"" + väljund+"\";";
			if(esimeneRida){
				esimeneRida = false;
				tingimusLause = "if" + tingimusLause;
			}
			else
				tingimusLause = "else if" + tingimusLause;
			kirjutaRidaTeksti("\t\t" + tingimusLause);
		}
//		süsteem += "\n}";
		kirjutaRidaTeksti("\t\treturn \"\";");
		kirjutaRidaTeksti("\t}");
		kirjutaSagedaseimTunnus();
		kirjutaSageduseJargi();
		kirjutaPikkuseJargi();
//		System.out.println(süsteem);
		kirjutaRidaTeksti("}");
		bw.close();
	}
	
	private void kirjutaPikkuseJargi() throws IOException {
		kirjutaRidaTeksti("\tpublic static String pikkus(" + sisendidStr + "){");
		kirjutaRidaTeksti(optimeeriPikkus(reeglid));
		kirjutaRidaTeksti("\t\treturn \"\";");
		kirjutaRidaTeksti("\t}");
	}
	
	private void kirjutaSageduseJargi() throws IOException {
		kirjutaRidaTeksti("\tpublic static String sagedus(" + sisendidStr + "){");
		kirjutaRidaTeksti(optimeeriSagedus(reeglid));
		kirjutaRidaTeksti("\t\treturn \"\";");
		kirjutaRidaTeksti("\t}");
	}

	private void kirjutaSagedaseimTunnus() throws IOException {
		kirjutaRidaTeksti("\tpublic static String sagedaseimTunnus(" + sisendidStr + "){");
		kirjutaRidaTeksti(optimeeri(reeglid, 0));
		kirjutaRidaTeksti("\t\treturn \"\";");
		kirjutaRidaTeksti("\t}");
	}

	private void kirjutaAlgus() throws IOException {
		kirjutaRidaTeksti("package test;");
		kirjutaRidaTeksti("");
		kirjutaRidaTeksti("public class RuleSystem {");
		kirjutaRidaTeksti("");
		String sisendid = "";
		int mitmes = 1;
		for (AndmeTulp tulp : andmeTulbad) {
			if (mitmes++ == tulpadeArv)
				break;
			if(!sisendid.equals(""))
				sisendid += ", ";
			sisendid += "String " + tulp.getNimi();
		}
		sisendidStr = sisendid;
		kirjutaRidaTeksti("\tpublic static String reegliSystem(" + sisendid + "){");
	}

	private File fout;
	private FileOutputStream fos;
	private BufferedWriter bw;
	
	public void kirjutaRidaTeksti(String rida) throws IOException {
		bw.write(rida);
		bw.newLine();
	}
	
	private String optimeeri(List<Reegel> reeglid, int tase) {
		String taseStr="";
		for(int i=0; i<tase+2;i++)
			taseStr +="\t";
		int sagedused[][] = new int[25][15];
		TunnusReegliPaar tunnused[][] = new TunnusReegliPaar[25][15];
//		PriorityQueue<TunnusReegliPaar> tunnusteQueue = new PriorityQueue<TunnusReegliPaar>();   //new PriorityQueue<TunnusReegliPaar>(10, Collections.reverseOrder());
		PriorityQueue<TunnusReegliPaar> tunnusteQueue = new PriorityQueue<TunnusReegliPaar>(10, Collections.reverseOrder());
		List<TunnusReegliPaar> tunnusteList = new ArrayList<TunnusReegliPaar>(); 
		for (Reegel reegel : reeglid){
			int sagedus = reegel.getAndmeRead().size();
			for(Tunnus tunnus : reegel.getSisendid()){
				if(!tunnus.isKaetud()){
					int tulp = tunnus.getTulp();
					int vaartus = tunnus.getVaartus();
					if(tunnused[tulp][vaartus] == null){
						TunnusReegliPaar tunnusPaar = new TunnusReegliPaar(tunnus, sagedus, tulp, vaartus, reegel); 
						tunnused[tulp][vaartus] = tunnusPaar;
						tunnusteList.add(tunnusPaar);
						
					} else
						tunnused[tulp][vaartus].lisaReegel(tunnus, reegel, sagedus);
					sagedused[tulp][vaartus] += sagedus;
				}
			}
		}
		tunnusteQueue.addAll(tunnusteList);
		TunnusReegliPaar trp = null;
		String reeglisysteem="\n" + taseStr;
		int alternatiive = 0;
		while( (trp = tunnusteQueue.poll()) != null) {
			if(!trp.isKaetud()){
				
				AndmeTulp tulp = andmeTulbad.get(trp.getTulp());
				String tunnus = tulp.getNimi() + ".equals(\"" + tulp.getVäärtus(trp.getVaartus()) +"\")";
				trp.setkaetud();
				if(alternatiive==0)
					reeglisysteem += "if(" + tunnus + "){";
				else
					reeglisysteem +="\n" + taseStr + "}if(" + tunnus + "){";
				reeglisysteem += optimeeri(trp.getReeglid(),tase+1);
				trp.eemaldaKaetud();
				alternatiive++;
			}
		}
		if (alternatiive==0){		
			AndmeTulp väljundTulp = andmeTulbad.get(tulpadeArv-1);
			reeglid.get(0).setKaetud(true);
			return "\n" + taseStr + "\treturn \"" + väljundTulp.getVäärtus(reeglid.get(0).getValjund().getVaartus()) + "\";";
		}
		reeglisysteem += "}";
		if(tase ==0){
			int katmataReeglid =0;
			for (Reegel reegel : reeglid) {
				if(!reegel.isKaetud())
					katmataReeglid++;
			}
			if(katmataReeglid>0)
				reeglisysteem += optimeeri(reeglid, tase);
		}
		return reeglisysteem;
	}
	
	private String optimeeriPikkus(List<Reegel> reeglid) {
		PriorityQueue<Reegel> reegliteQueue = new PriorityQueue<Reegel>(10, Collections.reverseOrder());
		for (Reegel reegel : reeglid)
			reegliteQueue.add(reegel);
		Reegel reegel = null;
		boolean esimeneRida = true;
		String reeglisysteem="";
		while( (reegel = reegliteQueue.poll()) != null) {
			String tingimusLause = "";
			for (Tunnus sisend : reegel.getSisendid()) {
				if(!tingimusLause.equals(""))
					tingimusLause += " && ";
				AndmeTulp tulp = andmeTulbad.get(sisend.getTulp());
				tingimusLause += tulp.getNimi() + ".equals(\"" + tulp.getVäärtus(sisend.getVaartus()) +"\")";
			}
			AndmeTulp väljundTulp = andmeTulbad.get(tulpadeArv-1);
			String väljund = väljundTulp.getVäärtus(reegel.getValjund().getVaartus());
			tingimusLause = "(" + tingimusLause + ")\n\t\t\t return \"" + väljund+"\";";
			if(esimeneRida){
				esimeneRida = false;
				tingimusLause = "if" + tingimusLause;
			}
			else
				tingimusLause = " else if" + tingimusLause;
			reeglisysteem += "\n\t\t" + tingimusLause;
		}
		return reeglisysteem;
	}	

	private String optimeeriSagedus(List<Reegel> reeglid) {
		PriorityQueue<SagedusReegel> reegliteQueue = new PriorityQueue<SagedusReegel>(10, Collections.reverseOrder());
		for (Reegel reegel : reeglid)
			reegliteQueue.add(new SagedusReegel(reegel));
		SagedusReegel reegel = null;
		boolean esimeneRida = true;
		String reeglisysteem="";
		while( (reegel = reegliteQueue.poll()) != null) {
			String tingimusLause = "";
			for (Tunnus sisend : reegel.getSisendid()) {
				if(!tingimusLause.equals(""))
					tingimusLause += " && ";
				AndmeTulp tulp = andmeTulbad.get(sisend.getTulp());
				tingimusLause += tulp.getNimi() + ".equals(\"" + tulp.getVäärtus(sisend.getVaartus()) +"\")";
			}
			AndmeTulp väljundTulp = andmeTulbad.get(tulpadeArv-1);
			String väljund = väljundTulp.getVäärtus(reegel.getValjund().getVaartus());
			tingimusLause = "(" + tingimusLause + ")\n\t\t\t return \"" + väljund+"\";";
			if(esimeneRida){
				esimeneRida = false;
				tingimusLause = "if" + tingimusLause;
			}
			else
				tingimusLause = " else if" + tingimusLause;
			reeglisysteem += "\n\t\t" + tingimusLause;
		}
		return reeglisysteem;
	}

	public int[][] getKoopia() {
		return koopia;
	}

	public void setKoopia() {
		this.koopia = Arrays.copyOf(this.sagedustabel.getSagedusTabel(), this.sagedustabel.getSagedusTabel().length);
	}	
	
}
