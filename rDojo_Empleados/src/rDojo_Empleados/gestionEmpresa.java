package rDojo_Empleados;

import java.util.Random;

import utilidades.Fecha;
import utilidades.Leer;

public class gestionEmpresa {

	public static void main(String[] args) {
		int opcion;
		String nombres[] = { "Pepe", "Juan", "Amancio", "Mariano", "Soraya", "Esperanza", "Francisco", "Lucia" };
		String trabajos[] = { "Telecomunicaciones", "Peluqueria", "Sin estudios", "Futbolista", "Depredador", "Barrendero", "Piloto del Air Force One" };
		Random rand = new Random();

		//Crer vector empleados
		Empleado [] currantes = new Empleado[20];
		
		//Crear 2 jefes, 3 administradores y 4 tecnicos
	
		
		
		//crear jefes
		for (int i = 0; i < 2; i++) {
			//public Empleado(String nombre, Fecha fechaNacimiento, Integer numeroEmpleado, Fecha fechaIngreso) {
			currantes[i] = new Responsable(nombres[rand.nextInt(nombres.length)],Fecha(Fecha),rand.nextInt(30) + 25, Fecha(Fecha), rand.nextInt(30) + 25, trabajos[rand.nextInt(trabajos.length)],rand.nextInt(30) + 25,rand.nextInt(30) + 25);
		}
		
		for (int i = 2; i < 5; i++) {
			currantes[i] = new Administrativo(poner parametros);
		}
		
		for (int i = 5; i < 9; i++) {
			currantes[i] = new Tecnico(poner parametros);
		}
		
		
		opcion = Leer.pedirEntero("1-Crear administrativo\n2-Crear responsable \3-Crear tenico");
		while (opcion!=0) {
			switch (opcion) {
			case 1:
				
				break;

			default:
				break;
			}
		}
			
		
	}//main

}//Class
