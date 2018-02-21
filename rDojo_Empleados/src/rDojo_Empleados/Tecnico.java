package rDojo_Empleados;

public class Tecnico extends Empleado {
	private String especialidad;
	private Float plusEspecialidad;
	private Responsable jefe;
	private static int contaTec = 0;

	public Tecnico(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso,
			String especialidad, Float plusEspecialidad, Responsable jefe) {
		super(nombre, fechaNacimiento, numeroEmpleado, fechaIngreso);
		this.especialidad = especialidad;
		this.plusEspecialidad = plusEspecialidad;
		this.jefe=jefe;
		this.jefe.getCurrantes(); //suma una a personas a cargo del jefe pasado por parametro
		contaTec++;
	}

	public Float calculoNomina() {
		return Empleado.getSalarioBase() + plusEspecialidad;
	}

	@Override
	public String toString() {
		return super.toString() +" especialidad: " + especialidad + ", plusEspecialidad: " + plusEspecialidad + ", jefe: " + jefe +" (tecnico)";
	}

	public static int getContaTec() {
		return contaTec;
	}


	
}