

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Menu
		 * 			1 matricular alumno
		 * 			2 poner notas
		 * 			3 imprimir notas (incluye la media)
		 *                
		 */
		final int NUMALU=3;//alumnos a crear
		final int NUMASI=6;//asignaturas a crear
		Alumno[] lista=new Alumno[NUMALU];//alumnos
		Asignatura[] materias=new Asignatura[NUMASI];//asignaturas
		iniciaAsignaturas(materias);
		iniciaAlumnos(lista);
		int alu;//posición de alumno en vector de alumnos
		int asi;//posición de materia en vector de asignaturas
		float nota;//nota a leer
		String regex="";

		int opcion=0;//opción de menú
		do {//menú
			opcion = menu();
			switch (opcion) {//acciones de menú
			case 1://matricular
				verAlumnos(NUMALU,lista);
				alu=Leer.pedirEntero("Escoge el alumno","[0-"+(NUMALU-1)+"]");//escoge alumno de la lista
				verAsignaturas(NUMASI, materias);
				asi=Leer.pedirEntero("Escoge la asignatura","[0-"+(NUMASI-1)+"]");//escoge asignatura
				lista[alu].matricular(materias[asi]);//intenta matricular
				break;
			case 2://poner nota
				verAlumnos(NUMALU,lista);
				alu=Leer.pedirEntero("Escoge el alumno","[0-"+(NUMALU-1)+"]");//escoge alumno de la lista
				if(lista[alu].getNumAsignaturas()==0){
					Leer.mostrarEnPantalla("El alumno "+lista[alu].getNombre()+" no tiene asignaturas");
				} else{
					Leer.mostrarEnPantalla(lista[alu].verMatricula());
					Leer.mostrarEnPantalla("---------------");
					asi=Leer.pedirEntero("Escoge la asignatura","[0-"+(lista[alu].getNumAsignaturas()-1)+"]");
					nota=Leer.pedirFloat("Introduce la nota","(10|[0-9])");
					lista[alu].setNotas(asi, nota);//asigna la nota
				}
				break;
			case 3://imprime boletines
				for(int i=0; i<NUMALU; i++){
					Leer.mostrarEnPantalla(lista[i].getAlumno());
					Leer.mostrarEnPantalla(lista[i].verNotas());
					Leer.mostrarEnPantalla("Media: "+lista[i].media()+" "+lista[i].notaTexto(lista[i].media()));
					Leer.mostrarEnPantalla("---------------");
				}
				break;
			case 4://imprime matrícula de un alumno
				verAlumnos(NUMALU,lista);
				alu=Leer.pedirEntero("Escoge el alumno","[0-"+(NUMALU-1)+"]");
				Leer.mostrarEnPantalla(lista[alu].verMatricula());
				Leer.mostrarEnPantalla("---------------");
				break;
			}

		} while(opcion!=0);
	}

	private static void iniciaAlumnos(Alumno[] lista) {
		lista[0]=new Alumno("Jorgito", 15);
		lista[1]=new Alumno("Juanito", 18);
		lista[2]=new Alumno("Jaimito", 19);
	}

	private static void iniciaAsignaturas(Asignatura[] materias) {
		materias[0]=new Asignatura("Bases de datos", '1', 6);
		materias[1]=new Asignatura("Programación", '1', 8);
		materias[2]=new Asignatura("Entornos de Desarrollo", '1', 3);
		materias[3]=new Asignatura("Lenguajes de marcas", '1', 3);
		materias[4]=new Asignatura("Sistemas", '1', 6);
		materias[5]=new Asignatura("Desarrollo entorno servidor", '1', 9);
	}

	public static void verAsignaturas(int NUMASI, Asignatura[] materias){//lista de materias
		for (int i=0; i<NUMASI; i++){
			Leer.mostrarEnPantalla(i+" "+materias[i].getNombre());
		}
		Leer.mostrarEnPantalla("---------------------");
	}

	public static void verAlumnos(int NUMALU, Alumno[] lista){//lista de alumnos
		for (int i=0; i<NUMALU; i++){
			Leer.mostrarEnPantalla(i+" "+lista[i].getNombre());
		}
		Leer.mostrarEnPantalla("--------------------");
	}
	
	public static int menu(){
		int opcion;
		Leer.mostrarEnPantalla("1.- Asignar asignaturas a alumno");
		Leer.mostrarEnPantalla("2.- Asignar calificación a asinatura de alumno");
		Leer.mostrarEnPantalla("3.- Imprimir todos los boletines");
		Leer.mostrarEnPantalla("4.- Ver asignaturas de un alumno");
		Leer.mostrarEnPantalla("0.- Salir");
		opcion=Leer.pedirEntero("Elije opción", "[0-4]");
		return opcion;
	}
}
