
public class Cliente implements Persona{
	private String codigoCliente;
	private Integer edadCliente;
	private Double dineroGastado;
	
	
	//Cambia al cliente el nombre de la empresa por “editorial” porque es final

	public String codigoCliente() {
		return codigoCliente;
	}


	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}


	public Integer getEdadCliente() {
		return edadCliente;
	}


	public void setEdadCliente(Integer edadCliente) {
		this.edadCliente = edadCliente;
	}



	@Override
	public void pedirTodosDatos() {
		codigoCliente = Teclado.pedirString("Nombre del cliente?");
		edadCliente = Teclado.pedirEntero("Edad del cliente?");
		dineroGastado = Teclado.pedirDouble("Dinero que lleva acumulado?");
	}


	@Override
	public void visualizarTodosDatos() {
		System.out.println("El codigo de cliente es " +codigoCliente +" tiene " +edadCliente +" años, trabaja en " +Persona.nombreEmpresa +" y se ha gastado " +dineroGastado +"€");
	}

	public String getNombreEmpresa(){
		return Persona.nombreEmpresa;
	}
	
}
