package turismo;

import java.util.Comparator;

public class OrdenarPorTiempo implements Comparator <Atraccion>{
	
	@Override
	public int compare(Atraccion atrac, Atraccion otraAtrac) {
		return Integer.compare(atrac.getTiempo(), otraAtrac.getTiempo());
	}
	
}
