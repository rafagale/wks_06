import java.util.Random;

public class GestionMaquinistasAdm {

	public static void main(String[] args) {
		int numero;
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };
		String estudios[] = { "Telecomunicaciones", "Peluqueria", "Sin estudios" };
		Random rand = new Random();

		numero = Teclado.pedirEntero("Cuantos empleados normales quieres crear?");
		Empleado empleados[] = new Empleado[numero];
		for (int i = 0; i < empleados.length; i++) {
			empleados[i] = new Empleado(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25);
		}

		numero = Teclado.pedirEntero("Cuantos maquinistas quieres crear?");
		Empleado maquinistas[] = new Maquinista[numero];
		for (int i = 0; i < maquinistas.length; i++) {
			empleados[i] = new Maquinista(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					rand.nextInt(10), rand.nextInt(10) + 5);
		}

		numero = Teclado.pedirEntero("Cuantos administrativos quieres crear?");
		Empleado adminstrativos[] = new Administrativo[numero];
		for (int i = 0; i < adminstrativos.length; i++) {
			empleados[i] = new Administrativo(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					estudios[rand.nextInt(estudios.length)], rand.nextInt(100));
		}

		System.out.println(visualizarNumeroEmpleados());

		/*
		 * Visualiza los datos de cada uno de ellos (por grupos). Para ello se
		 * usará un único método preparado para recibir los datos de un grupo de
		 * trabajadores con el fin de visualizar sus datos.
		 */
		visualizarDatos(empleados);
	}// main

	public static void visualizarDatos(Object trabajadores[]) {
		Empleado emp;
		Maquinista maq;
		Administrativo adm;
		for (int i = 0; i < trabajadores.length; i++) {
			if (trabajadores[i] instanceof Maquinista) {
				maq = (Maquinista) trabajadores[i];
			}
		}

	}

	public static String visualizarNumeroEmpleados() {
		return "Hay un total de: " + Empleado.getContaEmpleados() + " empleados, de los cuales "
				+ Maquinista.getContaMaquinistas() + " son maquinistas, " + Administrativo.getContaAdministrativos()
				+ " son administrativos y "
				+ (Empleado.getContaEmpleados()
						- (Administrativo.getContaAdministrativos() + Maquinista.getContaMaquinistas()))
				+ " son empleados en otros puestos";
	}// visualizarNumeroEmpleados

}// Class
