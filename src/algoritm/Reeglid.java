package algoritm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import andmeTabel.AndmeRida;

public class Reeglid {

	private static List<Reegel> reeglid;
	private static List<Reegel> uuedReeglid = new ArrayList<Reegel>();

	public static List<Reegel> optimeeri(List<Reegel> reeglid) {
		Reeglid.reeglid = reeglid;
		minimeeriReegleid();
		return uuedReeglid;
	}

	private static void minimeeriReegleid() {
		leiaYheReegligaKaetud();
		leiaAinultKaetutegaReeglid();
		int reegleidJargi = reeglid.size();
		if(reegleidJargi==1)
			uuedReeglid.add(reeglid.get(0));
		else if(reegleidJargi==0)
			return;
		else
			lisaPotensiaalneReegel();
	}

	private static void lisaPotensiaalneReegel() {
		int maksimaalneKaetus=0;
		Reegel potentsiaalneReegel = null;
		for (Reegel reegel : reeglid) {
			int katmataRidadeArv = reegel.katmataRidadeArv();
			if(maksimaalneKaetus < katmataRidadeArv){
				maksimaalneKaetus = katmataRidadeArv;
				potentsiaalneReegel = reegel;
			}
		}
		potentsiaalneReegel.margiReadKaetuks();
		uuedReeglid.add(potentsiaalneReegel);
		reeglid.remove(potentsiaalneReegel);
		minimeeriReegleid();
	}

	private static void leiaAinultKaetutegaReeglid() {
		Iterator<Reegel> iterator = reeglid.iterator();
		while (iterator.hasNext()) {
			Reegel reegel = iterator.next(); // must be called before you can call i.remove()
			if(onYleLiigneReegel(reegel)){
				iterator.remove();
				reegel.eemaldaReegel();
			}
		}
	}

	private static boolean onYleLiigneReegel(Reegel reegel) {
		List<AndmeRida> kaetudRead = reegel.getAndmeRead();
		for (AndmeRida andmeRida : kaetudRead) {
			if(!andmeRida.onKaetud())
				return false;
		}
		return true;
	}

	private static void leiaYheReegligaKaetud() {
		Iterator<Reegel> iterator = reeglid.iterator();
		while (iterator.hasNext()) {
			Reegel reegel = iterator.next(); // must be called before you can call i.remove()
			if(vahemaltYheReaJaoksOnReegelUnikaalne(reegel)){
				uuedReeglid.add(reegel);
				reegel.margiReadKaetuks();
				iterator.remove();
			}
		}
	}

	private static boolean vahemaltYheReaJaoksOnReegelUnikaalne(Reegel reegel) {
		List<AndmeRida> kaetudRead = reegel.getAndmeRead();
		for (AndmeRida andmeRida : kaetudRead) {
			if(andmeRida.onYksReegel())
				return true;
		}
		return false;
	}

}
