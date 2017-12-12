import java.util.*;
public class PersonaTest {

	public static void main(String[] args) {
		Persona persona1, persona2;
		String nombre, frase;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Por ahora hay " + Persona.getNumPersonas());
		persona1 = new Persona("Pilar",17,168);
		System.out.println("Por ahora hay " + Persona.getNumPersonas());
		
		//persona1.setNombre("lolo");
		System.out.println("Persona1 se llama: " 
		+ persona1.getNombre()+" "+persona1.getEdad()
		+" "+persona1.getAltura());
		
		persona2= new Persona();
		System.out.println("Por ahora hay " + Persona.getNumPersonas());
		
		/*System.out.println("El nombre de la persona2 es? ");		
		nombre=teclado.nextLine();
		persona2.setNombre(nombre);*/
		System.out.println("El nombre de la persona2 es: "
					+persona2.getNombre()+" "+persona2.getEdad()+" "+persona2.getAltura());
		System.out.println("¿Que van a decir las personas?");
		//frase=teclado.nextLine();
		frase="asdfg";
		System.out.println(persona2.hablar(frase));
		System.out.println(persona1.hablar(frase));
		int i; int b=23;
		for(i=1;i<=10;i++){
			System.out.print(i + ", ");
		}
		System.out.println("\n******" + i);
		{
			
			System.out.println("\n******" + b);
		}
		//System.out.println("\n******" + b);
		
		
	}//main

}//class
