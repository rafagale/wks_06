import java.util.Random;

public class Colegio {

	public static void main(String[] args) {

		// Se crea un array de alumnos y de asignaturas
		Alumno[] alumnos = new Alumno[3];
		Asignatura[] asignaturas = new Asignatura[10];

		// Se crean 3 alumnos y 10 asignaturas
		crearAlumnos(alumnos);
		crearAsignaturas(asignaturas);

		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i] + " \nsin matricular todavia esta muy indeciso");
		}

		// Matricular en asignaturas. Si se repite solo hay 3 intentos
		int numeroAsig;
		int opcion;
		do {
			numeroAsig = Leer.pedirEntero("En cuantas asignaturas se quiere matricular?");
		} while (numeroAsig < 3);

		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i].getNombre());
			while (alumnos[i].getContaAsignaturas() < numeroAsig) {
				verAsignaturas(asignaturas);
				do {
					opcion = Leer.pedirEntero("Elige una asignatura");
				} while (opcion < 0 || opcion > 10);
				//String retorno = alumnos[i].seMatriculaEn(asignaturas[opcion]);
				//Haciendo el string y luego comprobar con eso 
				System.out.println(alumnos[i].seMatriculaEn(asignaturas[opcion]));
				System.out.println(alumnos[i]);
			}
		}
		// poner notas
		System.out.println("Introduce las notas del alumno");
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i].setNotas();
		}

		// imprimir boletin
		System.out.println("\tBoletin");
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i]);
			System.out.print(" Nota media: " + alumnos[i].notaMedia() +" ");
			alumnos[i].getNotas();
			System.out.println(alumnos[i].estado(asignaturas));
		}
		
		
	}// main

	private static void verAsignaturas(Asignatura[] asignaturas) {
		for (int j = 0; j < asignaturas.length; j++) {
			System.out.println("#" + j + " " + asignaturas[j]);
		}
	}

	public static void crearAlumnos(Alumno[] alumnos) {
		Fecha fechaNacimiento;
		String[] nombres = { "Pepe", "Amancio", "Mariano", "Julia", "Clara", "Ines" };
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			fechaNacimiento = new Fecha(rand.nextInt(28) + 1, rand.nextInt(11) + 1,
					rand.nextInt(2000 - 1995 + 1) + 1995);
			alumnos[i] = new Alumno(nombres[rand.nextInt(nombres.length)], fechaNacimiento);
		}

	}// crearAlumnos

	public static void crearAsignaturas(Asignatura[] asignaturas) {
		String[] nombres = { "Matematicas", "Lengua", "Ingles", "Fisica", "Quimica", "Dibujo tecnico", "Recreo",
				"Anatomia", "Fisiologia", "Informatica", "Economia" };
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			asignaturas[i] = new Asignatura(nombres[i], rand.nextInt(10 - 2 + 1) + 2,
					rand.nextInt(2 - 1 + 1) + 1);
		}
	}// crearAsignaturas

}// Class
