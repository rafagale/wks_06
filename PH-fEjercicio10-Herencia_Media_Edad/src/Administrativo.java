
public class Administrativo extends Empleado {
	private String estudiosAcademicos;
	private Integer numPcAsignado;
	private static Integer contaAdministrativos = 0;

	public Administrativo(String nombre, Integer edad, String estudiosAcademicos, Integer numPcAsignado) {
		super(nombre, edad);
		this.estudiosAcademicos = estudiosAcademicos;
		this.numPcAsignado = numPcAsignado;
		contaAdministrativos++;
	}

	public static Integer getContaAdministrativos() {
		return contaAdministrativos;
	}

	@Override
	public String toString() {
		return super.toString() + ", Estudios academicos: " + estudiosAcademicos + ", nº ordenador asignado : "
				+ numPcAsignado + " (Administrativo)";
	}
}
