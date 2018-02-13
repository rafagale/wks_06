import java.util.Random;

public class GestionMaquinistasAdm_v2 {

	public static void main(String[] args) {
		Integer cuantosEmp, cuantosAdmin, cuantosMaqui, total;
		Empleado[] empleados;
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };
		String estudios[] = { "Telecomunicaciones", "Peluqueria", "Sin estudios" };
		Random rand = new Random();

		cuantosEmp = Teclado.pedirEntero("Cuantos empleados hay en la empresa?");
		total = cuantosEmp;

		cuantosMaqui = Teclado.pedirEntero("Cuantos maquinistas hay en la empresa?");
		total += cuantosMaqui;

		cuantosAdmin = Teclado.pedirEntero("Cuantos administrativos hay en la empresa?");
		total += cuantosAdmin;

		empleados = new Empleado[total];

		crearEmpleados(nombres, estudios, rand, empleados, cuantosEmp, cuantosMaqui, cuantosAdmin);

		System.out.println(visualizarNumeroEmpleados());

		visualizarDatos(empleados);

	}// main

	public static void crearEmpleados(String[] nombres, String[] estudios, Random rand, Empleado[] empleados, int numEmp, int numMaq, int numAdm) {
		for (int i = 0; i < numEmp; i++) {
			empleados[i] = new Empleado(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25);
		}
		for (int i = numEmp; i < numEmp + numMaq; i++) {
			empleados[i] = new Maquinista(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					rand.nextInt(10), rand.nextInt(10) + 5);
		}
		for (int i = numEmp + numMaq; i < empleados.length; i++) {
			empleados[i] = new Administrativo(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					estudios[rand.nextInt(estudios.length)], rand.nextInt(100));
		}
	}

	public static void visualizarDatos(Empleado[] trabajadores) {
		for (int i = 0; i < trabajadores.length; i++) {
			System.out.println(trabajadores[i].visualizar());
		}
	}

	/*
	 * public static void visualizarDatos(Object trabajadores[]) { Empleado emp;
	 * Maquinista maq; Administrativo adm; for (int i = 0; i <
	 * trabajadores.length; i++) { if (trabajadores[i] instanceof Empleado) {
	 * emp = (Empleado) trabajadores[i]; System.out.println(emp.visualizar()); }
	 * else if (trabajadores[i] instanceof Maquinista) { maq = (Maquinista)
	 * trabajadores[i]; System.out.println(maq.visualizar()); } else if
	 * (trabajadores[i] instanceof Administrativo) { adm = (Administrativo)
	 * trabajadores[i]; System.out.println(adm.visualizar()); } else {
	 * System.out.
	 * println("No es dato de tipo empleado, maquinista o administrativo"); } }
	 * }// visualizarDatos
	 */
	public static String visualizarNumeroEmpleados() {
		return "Hay un total de: " + Empleado.getContaEmpleados() + " empleados, de los cuales "
				+ Maquinista.getContaMaquinistas() + " son maquinistas, " + Administrativo.getContaAdministrativos()
				+ " son administrativos y "
				+ (Empleado.getContaEmpleados()
						- (Administrativo.getContaAdministrativos() + Maquinista.getContaMaquinistas()))
				+ " son empleados en otros puestos";
	}// visualizarNumeroEmpleados

}// Class
