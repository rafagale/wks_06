/**
 * @author Rafael Gale
 * @category Ejercicio 2
 */
public class Lujo extends Coche {
	private Integer codigo;
	private static Integer siguiente = 1;

	/**
	 * Constructor coche de lujo
	 * 
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param fechaFabricacion
	 * @param disponible
	 * @param precioDiario
	 * @param codigo
	 */
	public Lujo(String matricula, String marca, String modelo, Fecha fechaFabricacion, Boolean disponible,
			Integer precioDiario) {
		super(matricula, marca, modelo, fechaFabricacion, disponible, precioDiario);
		this.codigo = 10001 + siguiente;
		siguiente++;
	}

	@Override
	public String toString() {
		return super.toString() + " Lujo [codigo=" + codigo + "]";
	}
}
