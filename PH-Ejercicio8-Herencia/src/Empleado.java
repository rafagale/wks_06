
public class Empleado implements Persona{
	private String nombreEmpleado;
	private Integer edadEmpleado;
	

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Integer getEdadEmpleado() {
		return edadEmpleado;
	}

	public void setEdadEmpleado(Integer edadEmpleado) {
		this.edadEmpleado = edadEmpleado;
	}

	@Override
	public void pedirTodosDatos(String nombre, Integer edad) {
		this.nombreEmpleado = nombre;
		this.edadEmpleado = edad;
	}
	
	@Override
	public void visualizarTodosDatos() {
		System.out.println("El empleado se llama " +nombreEmpleado +" tiene " +edadEmpleado +" años y trabaja en " +Persona.nombreEmpresa);
	}

}
