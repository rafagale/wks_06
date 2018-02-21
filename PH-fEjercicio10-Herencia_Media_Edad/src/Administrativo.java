import rDojo_Empleados.Responsable;

public class Administrativo extends Empleado {
	private String estudiosAcademicos;
	private Integer numPcAsignado;
	private Responsable jefe;
	private static Integer contaAdministrativos = 0;



	public Administrativo(String nombre, Integer edad, String estudiosAcademicos, Integer numPcAsignado,
			Responsable jefe) {
		super(nombre, edad);
		this.estudiosAcademicos = estudiosAcademicos;
		this.numPcAsignado = numPcAsignado;
		this.jefe = jefe;
	}

	public static Integer getContaAdministrativos() {
		return contaAdministrativos;
	}

	@Override
	public String visualizar() {
		return super.visualizar() + ", Estudios academicos: " + estudiosAcademicos + ", nº ordenador asignado : "
				+ numPcAsignado + " (Administrativo)";
	}
}
