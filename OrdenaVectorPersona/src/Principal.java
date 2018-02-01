import java.util.Random;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		Persona personas[] =new Persona[100]; //un array de 100 objetos (Persona) desordenados
		// generamos los objetos y los guardamos en el vector
		generaDatos(personas);
	
		//imprimimos por pantalla el array de personas
		System.out.println("\n******Array sin orden:");
		listar(personas);
		//ordenamos con nuestro comparador el array de personas y lo imprimimos por pantalla
		System.out.println("\n******En orden segun el comparador Edad:");
		Arrays.sort(personas, new OrdenPorEdad());
		listar(personas);
		// ordenamos por otro criterio
		System.out.println("\n******En orden segun el comparador DNI:");
		Arrays.sort(personas, new OrdenPorDni());
		listar(personas);
	}//main

	static public void generaDatos(Persona personas[]){// genera el vector
		Random azar = new Random();
		int t,z;
		String dni;
		String nombre[]={"Luis","Carlos","Jose","Eva","Carmen","Luisa","Manuel","Santos"};
		for (t=0;t<personas.length;t++){
			dni="";
			for (z=1;z<=8;z++){
				dni=dni+(char)(azar.nextInt(10)+48);
			}
			personas[t] =new Persona(nombre[azar.nextInt(nombre.length)],
					azar.nextInt(10)+40,azar.nextInt(50)+150,dni);
		}
	}//generaDatos

	static public void listar(Persona personas[])// metodo estático para imprimir vector
	{
		int t;
		for (t=0;t<personas.length;t++){
			System.out.println(personas[t].getNombre() + "\t" +personas[t].getEdad()
					+ "\t"+personas[t].getAltura()+ "\t" +personas[t].getDni());
		}
	}//listar

}//class
