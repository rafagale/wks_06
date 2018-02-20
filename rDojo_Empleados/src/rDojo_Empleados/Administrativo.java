package rDojo_Empleados;

import utilidades.Fecha;
import utilidades.Leer;

public class Administrativo extends Empleado {
	private static Float plusAntiguedad = 300f;
	private String departamento;
	private Responsable jefe;

	public Administrativo(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso,
			String departamento, Responsable jefe) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.departamento = departamento;
		this.jefe = jefe;
	}

	public Float calculoNomina() {
		Fecha fechaActual = new Fecha(20,2,2018);
		Float sueldo;
		Float antiwedad;
		
		antiwedad = (float)( getFechaIngreso().difFechas(fechaActual) / 365);
		System.out.println(antiwedad);
		sueldo=1000+(plusAntiguedad * antiwedad);
		return sueldo;
	}

	@Override
	public String toString() {
		return "Administrativo [departamento=" + departamento + ", jefe=" + jefe + ", toString()=" + super.toString()
				+ "]";
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
