
public class GestionEmpleadosJefes {
	/*
	 * Escribe un programa que pida los datos de una serie de empleados que no
	 * son jefes, tantos como el usuario indique. También hay que pedir los
	 * datos de una serie de jefes que son, al mismo tiempo, empleados, tantos
	 * como el usuario indique. Una vez insertados todos los datos, hay que
	 * visualizarlos. De los empleados nos interesa: nombre y sueldo. De los
	 * jefes nos interesa: nombre, sueldo, título y nombre del departamento del
	 * que es jefe.
	 */
	public static void main(String[] args) {
		int num;
		String nombre, titulo, dpto;
		double sueldo;
		Empleado[] empleados = null;
		Jefe[] jefes = null;
		
		Empleado unJefe = new Jefe("Torete", 5000.0, "Carnicero", "Transportes");
		
		num = Teclado.pedirEntero("Cuantos empleados quieres crear?");
		empleados = new Empleado[num];
		for (int i = 0; i < empleados.length; i++) {
			nombre = Teclado.pedirString("Introduce un nombre");
			sueldo = Teclado.pedirDouble("Introduce un SUELDO");
			empleados[i] = new Empleado(nombre, sueldo);
		}

		num = Teclado.pedirEntero("Cuantos jefes quieres crear? Tambien son empleados");
		
		jefes = new Jefe[num];
		for (int i = 0; i < jefes.length; i++) {
			nombre = Teclado.pedirString("Introduce un nombre");
			sueldo = Teclado.pedirDouble("Introduce un sueldo");
			titulo = Teclado.pedirString("Introduce Titulo");
			dpto = Teclado.pedirString("Introduce un nombre de departamento");
			jefes[i] = new Jefe(nombre, sueldo, titulo, dpto);
		}
		visualizar("Jefes");
		System.out.println("Jefe random: "+unJefe);
		for (int i = 0; i < jefes.length; i++) {
			System.out.println("Jefe #" + (i + 1) + jefes[i]);
		}
		visualizar("Empleados");
		for (int i = 0; i < empleados.length; i++) {
			System.out.println("Empleado #" + (i + 1) + empleados[i]);
		}

	}// main

	public static void visualizar(String nombre) {
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("***********" + nombre + "*******************");
		System.out.println("///////////////////////////////////////");
	}

}// Class
