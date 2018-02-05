
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
		Empleado[] empleados = null;
		Jefe[] jefes = null;
		int num;
		String nombre;
		double sueldo;
		
		
		
		num=Teclado.pedirEntero("Cuantos empleados quieres crear?");
		empleados = new Empleado[num];
		for (int i = 0; i < empleados.length; i++) {
			nombre = Teclado.pedirString("Introduce un nombre");
			empleados[i].setNombre(nombre);
			sueldo = Teclado.pedirDouble("Introduce un SUELDO");
			empleados[i].setSueldo(sueldo);
		}
		
		num=Teclado.pedirEntero("Cuantos jefes quieres crear?");
		jefes = new Jefe[num];
		for (int i = 0; i < jefes.length; i++) {
			nombre = Teclado.pedirString("Introduce un nombre");
			jefes[i].setNombre(nombre);
			sueldo = Teclado.pedirDouble("Introduce un SUELDO");
			jefes[i].setSueldo(sueldo);
			nombre = Teclado.pedirString("Introduce Titulo");
			jefes[i].setTitulo(nombre);
			nombre = Teclado.pedirString("Introduce un nombre de departamento");
			jefes[i].setNombreDpto(nombre);
		}
		
		
		System.out.println("JEFES*-*******************************************************************");
		for (int i = 0; i < jefes.length; i++) {
			System.out.println(jefes[i]);
		}
		System.out.println("Empleados*-*******************************************************************");
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i]);
		}
	}// main

}// Class
