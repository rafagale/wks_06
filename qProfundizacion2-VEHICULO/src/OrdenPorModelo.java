import java.util.Comparator;

public class OrdenPorModelo implements Comparator<Automovil> {
	public int compare(Automovil p1, Automovil p2) {
		return p1.getModelo().compareTo(p2.getModelo());
	}
}