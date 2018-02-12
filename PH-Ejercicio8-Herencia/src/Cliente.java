
public class Cliente implements Persona{
	private String nombreCliente;
	private Integer edadCliente;
	
	//Cambia al cliente el nombre de la empresa por “editorial” porque es final

	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public Integer getEdadCliente() {
		return edadCliente;
	}


	public void setEdadCliente(Integer edadCliente) {
		this.edadCliente = edadCliente;
	}



	@Override
	public void pedirTodosDatos(String nombre, Integer edad) {
		this.nombreCliente = nombre;
		this.edadCliente = edad;
	}


	@Override
	public void visualizarTodosDatos() {
		System.out.println("El cliente se llama " +nombreCliente +" tiene " +edadCliente +" años y trabaja en " +Persona.nombreEmpresa);
	}

	public String getNombreEmpresa(){
		return Persona.nombreEmpresa;
	}
	
}
