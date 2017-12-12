import java.util.*;
public class AnimalTest {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Animal miPerro;
		String cadena;
		int edad;
		miPerro = new Animal();
		//System.out.println("Nombre: " + miPerro.nombre);
		//System.out.println("Raza: " + miPerro.raza);
		//System.out.println("Nombre: " + miPerro.edad);
		
		System.out.println("Nombre: " + miPerro.getNombre());
		System.out.println("Raza: " + miPerro.getRaza());
		System.out.println("Edad: " + miPerro.getEdad());
		
		miPerro.setNombre("Lolo");
		miPerro.setRaza("pekines");
		miPerro.setEdad(4);
		
		System.out.println("Hemos cambiado los datos del perro");
		System.out.println("Nombre: " + miPerro.getNombre());
		System.out.println("Raza: " + miPerro.getRaza());
		System.out.println("Edad: " + miPerro.getEdad());
		
		System.out.println("Nombre? ");
		cadena = teclado.nextLine();
		miPerro.setNombre(cadena);
		System.out.println("Raza? ");
		cadena = teclado.nextLine();
		miPerro.setRaza(cadena);
		System.out.println("Edad? ");
		edad = teclado.nextInt();
		miPerro.setEdad(edad);
		System.out.println("Hemos cambiado los datos del perro");
		System.out.println("Nombre: " + miPerro.getNombre());
		System.out.println("Raza: " + miPerro.getRaza());
		System.out.println("Edad: " + miPerro.getEdad());
		
		
		
	}//main

}//class
