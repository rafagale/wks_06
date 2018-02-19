import java.util.Comparator;

public class OrdenPorPrecio implements Comparator<Automovil> {
	public int compare(Automovil p1, Automovil p2) {
		return p1.getPrecio().intValue() - (p2.getPrecio().intValue());
	}
}