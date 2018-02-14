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
			maquinistas[i] = new Maquinista(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					rand.nextInt(10), rand.nextInt(10) + 5);
		}

		numero = Teclado.pedirEntero("Cuantos administrativos quieres crear?");
		Empleado adminstrativos[] = new Administrativo[numero];
		for (int i = 0; i < adminstrativos.length; i++) {
			adminstrativos[i] = new Administrativo(nombres[rand.nextInt(nombres.length)], rand.nextInt(30) + 25,
					estudios[rand.nextInt(estudios.length)], rand.nextInt(100));
		}

		System.out.println(visualizarNumeroEmpleados());

		System.out.println("\n--------------------Empleados rasos------------------");
		visualizarDatos(empleados);
		System.out.println("---------------------Maquinistas---------------------");
		visualizarDatos(maquinistas);
		System.out.println("--------------------Administrativos------------------");
		visualizarDatos(adminstrativos);

		System.out.println("\n--------------------Empleados rasos------------------");
		visualizarEdadMedia(empleados);
		System.out.println("---------------------Maquinistas---------------------");
		visualizarEdadMedia(maquinistas);
		System.out.println("--------------------Administrativos------------------");
		visualizarEdadMedia(adminstrativos);

	}// main

/*	public static void visualizarEdadMedia(Object trabajadores[]) {
		Empleado emp;
		int conta = 0;
		int suma = 0;
		for (int i = 0; i < trabajadores.length; i++) {
			if (trabajadores[i] instanceof Empleado) {
				emp = (Empleado) trabajadores[i];
				suma += emp.getEdad();
				conta++;
			}
		}
		System.out.println("Edad media: " + (double) suma / conta);
	}// visualizarEdadMedia
*/	

	public static void visualizarEdadMedia( Empleado[] trabajadores) {
		int conta = 0;
		int suma = 0;
		for (int i = 0; i < trabajadores.length; i++) {
			suma += trabajadores[i].getEdad();
			conta++;
		}
		System.out.println("Edad media : " + (double) suma / conta);
	}// visualizarEdadMedia
	
	public static void visualizarDatos( Empleado[] trabajadores) {
		for (int i = 0; i < trabajadores.length; i++) {
				System.out.println(trabajadores[i].visualizar());
		}
	}// visualizarDatos
	
	
	//Otra forma
/*	public static void visualizarEdadMedia(Empleado []trabajadores) {
		int conta = 0;
		int suma = 0;
		for (int i = 0; i < trabajadores.length; i++) {
				suma += trabajadores[i].getEdad();
				conta++;
		}
		System.out.println("Edad media: " + (double) suma / conta);
	}// visualizarEdadMedia
*/

	
/*	public static void visualizarDatos(Object trabajadores[]) {
		Empleado emp;
		for (int i = 0; i < trabajadores.length; i++) {
			if (trabajadores[i] instanceof Empleado) {
				emp = (Empleado) trabajadores[i];
				System.out.println(emp.visualizar());
			} else {
				System.out.println("No es dato de tipo empleado, maquinista o administrativo");
			}
		}
	}// visualizarDatos
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
