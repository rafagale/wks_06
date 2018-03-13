
public class Lujo extends Coche {
	private Integer codigo;
	private static Integer siguiente = 10001;

	public Lujo(String matricula, String marca, String modelo, Fecha fechaFabricacion, Integer precioDiario) {
		super(matricula, marca, modelo, fechaFabricacion, precioDiario);
		this.codigo = siguiente;
		siguiente++;
	}

	@Override
	public String visualizarCoche() {
		return "Lujo" +super.visualizarCoche() +"[codigo=" + codigo + "]";
	}


}
