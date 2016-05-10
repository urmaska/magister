import java.util.ArrayList;
import java.util.List;

import algoritm.Tunnus;

public class ReegliOsa {

	private List<ReegliOsa> alternatiivid = new ArrayList<ReegliOsa>();
	private ReegliOsa viimane;
	public void lisaAlternatiiv(Tunnus tunnus) {
		viimane = new ReegliOsa();
		alternatiivid.add(viimane);
		
	}

}
