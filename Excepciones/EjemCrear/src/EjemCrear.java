/*Creamos la clase Exception para controlar que de una determinada clase no haya 
 * demasiados objetos de ese tipo. Cuando se llegue al numero maximo de objetos
 * se lanzara un error y terminara el programa.
 * Supongamos que puede haber como máximo 3 objetos de la clase Alumno.
 * En el método main creamos 2 objetos y en el método mayor creamos el tercero,
 * lo comparamos con los dos que recibe como parámetro y devuelve el mayor.
 * Al salir del método mayor se libera el tercer objeto creado (siempre que no sea 
 * el mayor de los tres) y dejará crear un objeto más y sólo uno más*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class EjemCrear {
	public static void main(String[] args) throws InterruptedException{
		Random azar = new Random();
		Alumno vecAlumnos[]= new Alumno[4];
		Alumno alumMayor;
		String nombres[]={"Ana", "Luis", "Juan","Pilar","Jorge"};
		int k;
		try{
			for(k=0;k<2;k++){
				vecAlumnos[k]=new Alumno(nombres[k],azar.nextInt(10)+7);
				vecAlumnos[k].mostrarAlumno();
			}
		}catch(DemasiadosObjetos e){
			e.informeError("Alumno");
			System.out.println("Finaliza el programa");
			System.exit(0);
		}

		alumMayor=mayor(vecAlumnos[0], vecAlumnos[1]);
		System.gc();
		Thread.sleep(100);//pausa para que actue el garbage collector
		
		System.out.println("\nEl mayor de los tres alumnos que hay hasta ahora es: ");
		alumMayor.mostrarAlumno();
		
		try{
			System.out.println("\nCreamos otro alumno (y serán 4)");
			vecAlumnos[2]=new Alumno(nombres[2],azar.nextInt(10)+7);
			vecAlumnos[2].mostrarAlumno();
			System.out.println("\nCreamos otro alumno (y serán 5)");
			vecAlumnos[3]=new Alumno(nombres[3],azar.nextInt(10)+7);
			vecAlumnos[3].mostrarAlumno();
		}catch(DemasiadosObjetos e){
			e.informeError("Alumno");
			System.out.println("Finaliza el programa");
			System.exit(0);
		}

	}//main

	static Alumno mayor(Alumno alu1, Alumno alu2){
		Alumno unAlumno=null, alumMayor=null;
		try{
			unAlumno= new Alumno("Tercer alumno", (int)Math.floor(Math.random()*(10)+7));
			unAlumno.mostrarAlumno();
		}catch(DemasiadosObjetos e){
			e.informeError("Alumno");
			System.out.println("Finaliza el programa");
			System.exit(0);
		}
		if(alu1.getEdad()>= alu2.getEdad() && alu1.getEdad()>=unAlumno.getEdad()){
			alumMayor=alu1;
		}else if(alu2.getEdad()>= alu1.getEdad() && alu2.getEdad()>=unAlumno.getEdad()){
			alumMayor=alu2;
		}
		else{
			alumMayor=unAlumno;
		}
		return alumMayor;
	}
	
}//class
