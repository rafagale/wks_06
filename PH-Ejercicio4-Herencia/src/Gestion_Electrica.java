
public class Gestion_Electrica {

	public static void main(String[] args) {
		int opcion, modificacion;

		
		Empleado empleado1 = new Empleado("Juan", 25, 5);			
		Empleado jefe1 = new Jefe("Amancio", 81, 20, "Contabilidad");
		opcion = Teclado.pedirEntero(
				"1-Modificar el sueldo base de los empleados\n2-Modificar plus de los jefes\n3-Visualizar todos los empleados");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Modificar el sueldo base de todos los empleados.
				modificacion=Teclado.pedirEntero("Nuevo sueldo base");
				Empleado.setSueldoBase(modificacion);
				break;
			case 2: // Modificar el plus de todos los jefes.
				modificacion=Teclado.pedirEntero("Nuevo plus");
				Jefe.setPlusJefe(modificacion);
				break;
			case 3: // Visualizar los datos de todos los empleados.
				System.out.println(empleado1);
				System.out.println(jefe1);
				break;

			default:
				break;
			}
			opcion = Teclado.pedirEntero(
					"1-Modificar el sueldo base de los empleados\n2-Modificar plus de los jefes\n3-Visualizar todos los empleados");
		}

	}// main

}// Class
