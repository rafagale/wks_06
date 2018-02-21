package rDojo_Empleados;

public class Administrativo extends Empleado {
	private static Float plusAntiguedad = 50f;
	private String departamento;
	private Responsable jefe;
	private static int contaAdm = 0;
	
	public Administrativo(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso,
			String departamento, Responsable jefe) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.departamento = departamento;
		this.jefe = jefe;
		contaAdm++;
	}

	public Float calculoNomina() {
		Fecha fechaActual = new Fecha(20,2,2018);
		Float sueldo;
		Float antiwedad;
		antiwedad = (float)( getFechaIngreso().difFechas(fechaActual) / 365);
		sueldo=1000+(plusAntiguedad * antiwedad);
		return sueldo;
	}

	public static int getContaAdm() {
		return contaAdm;
	}

	@Override
	public String toString() {
		return super.toString() +" departamento: " + departamento + ", jefe: " + jefe + " (Administrativo) ";
	}

	public Float getPlusAnteiguedad() {
		return plusAntiguedad;
	}

	public void setPlusAntiguedad(Float plusAnteiguedad) {
		this.plusAntiguedad = plusAnteiguedad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Responsable getJefe() {
		return jefe;
	}

	public void setJefe(Responsable jefe) {
		this.jefe = jefe;
	}

}
