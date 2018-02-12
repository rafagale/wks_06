
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
	public void pedirTodosDatos() {
		nombreEmpleado = Teclado.pedirString("Nombre del empleado?");
		edadEmpleado = Teclado.pedirEntero("Edad del empleado?");
	}
	
	@Override
	public void visualizarTodosDatos() {
		System.out.println("El empleado se llama " +nombreEmpleado +" tiene " +edadEmpleado +" años y trabaja en " +Persona.nombreEmpresa);
	}

}