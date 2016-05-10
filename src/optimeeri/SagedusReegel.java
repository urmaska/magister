package optimeeri;

import java.util.ArrayList;
import java.util.List;

import algoritm.Reegel;
import algoritm.Tunnus;
import andmeTabel.AndmeRida;

public class SagedusReegel implements Comparable<SagedusReegel> {
	private List<AndmeRida> andmeRead;
	private List<Tunnus> sisendid = new ArrayList<Tunnus>();
	private Tunnus valjund;

	public SagedusReegel(Reegel reegel) {
		super();
		andmeRead = reegel.getAndmeRead();
		sisendid = reegel.getSisendid();
		valjund = reegel.getValjund();
	}

	public List<Tunnus> getSisendid() {
		return sisendid;
	}

	public List<AndmeRida> getAndmeRead() {
		return andmeRead;
	}

	public Tunnus getValjund() {
		return valjund;
	}

	@Override
	public int compareTo(SagedusReegel o) {
		return Integer.compare(getAndmeRead().size(), o.getAndmeRead().size());
	}
}
