package rDojo_Empleados;

import utilidades.Leer;
import utilidades.Fecha;

public class Empleado {
	private String nombre;
	private Fecha fechaNacimiento;
	private Integer numeroEmpleado;
	private static Integer siguiente;
	private static Float salarioBase = 1000f;
	private Fecha fechaIngreso;

	public Empleado(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroEmpleado = numeroEmpleado;
		this.fechaIngreso = fechaIngreso;
		siguiente++; //Contador
	}

	public Integer edadEmpleado(Fecha fechaNacimiento) {
		Integer edadEmpleado;
		edadEmpleado = llamar al metodo de la clase Fecha para restar fechas

		return 1;
	}

	

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", numeroEmpleado="
				+ numeroEmpleado + ", fechaIngreso=" + fechaIngreso + "]";
	}

	public Float calculoNomina() {
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
