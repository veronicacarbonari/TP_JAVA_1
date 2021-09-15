package turismo;

import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator <Atraccion> {
	
	@Override
	public int compare(Atraccion atrac, Atraccion otraAtrac) {
		return Integer.compare(atrac.getPrecio(), otraAtrac.getPrecio() * -1);
	}
}
