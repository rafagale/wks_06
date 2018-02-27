import java.util.Random;

public class Colegio {

	public static void main(String[] args) {

		// Se crea un array de alumnos y de asignaturas
		Alumno[] alumnos = new Alumno[1];
		Asignatura[] asignaturas = new Asignatura[6];

		// Se crean 3 alumnos y 6 asignaturas
		crearAlumnos(alumnos);
		crearAsignaturas(asignaturas);

		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i] + " \nsin matricular todavia esta muy indeciso");
		}
		
		
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < asignaturas.length; j++) {
				System.out.println("#" + j + " " + asignaturas[j]);
			}
			do {
				int opcion = Leer.pedirEntero("Elige una asignatura");
				alumnos[i].seMatriculaEn(asignaturas[opcion]);
			} while //Algo
			
		}

		for (int i = 0; i < asignaturas.length; i++) {
			System.out.println(asignaturas[i]);
		}
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < asignaturas.length; j++) {
				System.out.println("#" + j + " " + asignaturas[j]);
			}
			int opcion = Leer.pedirEntero("Elige una asignatura");
			alumnos[i].seMatriculaEn(asignaturas[opcion]);
		}
	}// main

	public static void crearAlumnos(Alumno[] alumnos) {
		Fecha fechaNacimiento;
		String[] nombres = { "Pepe", "Amancio", "Mariano", "Julia", "Clara", "Ines" };
		Random rand = new Random();
		for (int i = 0; i < 1; i++) {
			fechaNacimiento = new Fecha(rand.nextInt(28) + 1, rand.nextInt(11) + 1,
					rand.nextInt(2000 - 1995 + 1) + 1995);
			alumnos[i] = new Alumno(nombres[rand.nextInt(nombres.length)], fechaNacimiento);
		}

	}// crearAlumnos

	public static void crearAsignaturas(Asignatura[] asignaturas) {
		String[] nombres = { "Matematicas", "Lengua", "Ingles", "Fisica", "Quimica", "Dibujo tecnico", "Recreo",
				"Anatomia", "Fisiologia", "Informatica" };
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			asignaturas[i] = new Asignatura(nombres[rand.nextInt(nombres.length)], rand.nextInt(10 - 2 + 1) + 2,
					rand.nextInt(2 - 1 + 1) + 1);
		}
	}// crearAsignaturas

}// Class
