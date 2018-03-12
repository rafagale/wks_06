/**
 * @author Rafael Gale
 * @category Ejercicio 2
 */
public class Normal extends Coche {
	private String parking;
/**
 * Constructor coche normal
 * @param matricula
 * @param marca
 * @param modelo
 * @param fechaFabricacion
 * @param disponible
 * @param precioDiario
 * @param parking
 */
	public Normal(String matricula, String marca, String modelo, Fecha fechaFabricacion, Boolean disponible,
			Integer precioDiario, String parking) {
		super(matricula, marca, modelo, fechaFabricacion, disponible, precioDiario);
		this.parking = parking;
	}
@Override
public String toString() {
	return  super.toString() +"Normal [parking=" + parking + "]";
}

	
	
}
