package rDojo_Empleados;

import utilidades.Leer;
import utilidades.Fecha;

public class Empleado {
	private String nombre;
	private Fecha fechaNacimiento;
	private Integer numeroEmpleado;
	private static Integer siguiente;
	private static Float salarioBase=1000f;
	private Fecha fechaIngreso;

	public Empleado(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroEmpleado = numeroEmpleado;
		this.fechaIngreso = fechaIngreso;
		siguiente++;
	}

	public Integer edadEmpleado(Fecha edad) {
		// Fechahoy-fechanacimiento /365
		
		return 1;
	}

	public Float calculoNomina() {

		// Fechahoy-fechanacimiento /365
		return salarioBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public static Float getSalarioBase() {
		return salarioBase;
	}

	public static void setSalarioBase(Float salarioBase) {
		Empleado.salarioBase = salarioBase;
	}

	public Fecha getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Fecha fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public static Integer getSiguiente() {
		return siguiente;
	}

}
