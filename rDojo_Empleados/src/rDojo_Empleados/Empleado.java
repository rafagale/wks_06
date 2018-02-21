package rDojo_Empleados;

public class Empleado {
	private String nombre;
	private Fecha fechaNacimiento;
	private Integer numeroEmpleado;
	private static Integer siguiente=0;
	private static Float salarioBase = 1000f;
	private Fecha fechaIngreso;
	

	public Empleado(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroEmpleado = numeroEmpleado;
		this.fechaIngreso = fechaIngreso;
		siguiente++; // ContadorEmpleados
	}

	public Integer edadEmpleado(Fecha fechaNacimiento) {
		Integer edadEmpleado;
		Fecha fechaActual = new Fecha(20, 2, 2018);
		edadEmpleado = fechaNacimiento.difFechas(fechaActual);
		return edadEmpleado/365;
	}

	public Float calculoNomina() {
		return salarioBase;
	}

	public static Float getSalarioBase() {
		return salarioBase;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public static Integer getSiguiente() {
		return siguiente;
	}

	public Fecha getFechaIngreso() {
		return fechaIngreso;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", fechaNacimiento:" + fechaNacimiento + ", nº emp: "+ numeroEmpleado + ", fechaIngreso: " + fechaIngreso +", ";
	}

}
