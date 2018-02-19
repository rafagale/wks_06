import java.util.Comparator;

public class OrdenPorCilindrada implements Comparator<Automovil> {
	public int compare(Automovil p1, Automovil p2) {
		return p1.getCilindrada().intValue() - (p2.getCilindrada().intValue());
	}
}