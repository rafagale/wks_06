
public class GestionEjercicio8 {

	public static void main(String[] args) {
		String nombre;
		Integer edad;

		System.out.println("Creando un empleado y un cliente");
		Cliente unCliente = new Cliente();
		Empleado unEmpleado = new Empleado();
		
		nombre = Teclado.pedirString("Nombre del empleado?");
		edad = Teclado.pedirEntero("Edad del empleado?");
		unEmpleado.pedirTodosDatos(nombre, edad);
		
		nombre = Teclado.pedirString("Nombre del cliente?");
		edad = Teclado.pedirEntero("Edad del cliente?");
		unCliente.pedirTodosDatos(nombre, edad);
		
		
		
		unEmpleado.visualizarTodosDatos();
		unCliente.visualizarTodosDatos();
		

	}// main

}// Class

