
public class Gestion_Electrica {

	public static void main(String[] args) {
		int opcion, modificacion;

		Empleado empleado1 = new Empleado(null, "Juan", 12, null, 5);
		Jefe jefe1 = new Jefe(null, "Amancio", 81, null, 0, null, 1);
		opcion = Teclado.pedirEntero(
				"1-Modificar el sueldo base de los empleados\n2-Modificar plus de los jefes\n3-Visualizar todos los empleados");
		while (opcion != 0) {
			switch (opcion) {
			case 1: // Modificar el sueldo base de todos los empleados.
				modificacion=Teclado.pedirEntero("Nuevo sueldo base");
				empleado1.setSueldoBase(modificacion);
				jefe1.setSueldoBase(modificacion);
				break;
			case 2: // Modificar el plus de todos los jefes.
				modificacion=Teclado.pedirEntero("Nuevo plus");
				jefe1.setPlusJefe(modificacion);
				break;
			case 3: // Visualizar los datos de todos los empleados.
				System.out.println(empleado1);
				System.out.println(jefe1);
				System.err.println("Pobres");
				break;

			default:
				break;
			}
			opcion = Teclado.pedirEntero(
					"1-Modificar el sueldo base de los empleados\n2-Modificar plus de los jefes\n3-Visualizar todos los empleados");
		}

	}// main

}// Class
