package rDojo_Empleados;

import utilidades.Leer;

public class Tecnico extends Empleado {
	private String especialidad;
	private Float plusEspecialidad;
	private Responsable jefe;

	public Tecnico(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso,
			String especialidad, Float plusEspecialidad, Responsable jefe) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.especialidad = especialidad;
		this.plusEspecialidad = plusEspecialidad;
		this.jefe = jefe;
	}

	public Float calculoNomina() {
		return Empleado.getSalarioBase() + plusEspecialidad;
	}

	@Override
	public String toString() {
		return "Tecnico [especialidad=" + especialidad + ", plusEspecialidad=" + plusEspecialidad + ", jefe=" + jefe
				+ ", toString()=" + super.toString() + "]";
	}


	
}