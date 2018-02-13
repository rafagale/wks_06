
public class Maquinista extends Empleado {
	private Integer maquinaAsignada;
	private Integer aniosExperiencia;
	private static Integer contaMaquinistas = 0;

	public Maquinista(String nombre, Integer edad, Integer maquinaAsignada, Integer aniosExperiencia) {
		super(nombre, edad);
		this.maquinaAsignada = maquinaAsignada;
		this.aniosExperiencia = aniosExperiencia;
		contaMaquinistas++;
	}

	public static Integer getContaMaquinistas() {
		return contaMaquinistas;
	}

	@Override
	public String visualizar() {
		return super.visualizar() + ", Maquina asignada: " + maquinaAsignada + ", años de experiencia: "
				+ aniosExperiencia + " (Maquinista)";
	}

}
