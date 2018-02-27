import java.util.Arrays;

public class Alumno {
	private String nombre;
	private Integer edad;
	private Asignatura[] asignaturas;
	private Integer[] notas;

	public Alumno(String nombre, Fecha fechaNacimiento) {
		Fecha fechaActual = new Fecha(27, 2, 2018);
		this.nombre = nombre;
		this.edad = fechaNacimiento.difFechas(fechaActual) / 365;
		this.asignaturas = new Asignatura[10];
		this.notas = new Integer[10];
	}

	
	//Todas
	public void seMatriculaEn(Asignatura asignatura) {
			for (int i = 0; i < asignaturas.length; i++) {
				if (asignaturas[i] != null && asignaturas[i].getNombre().equalsIgnoreCase(asignatura.getNombre())) {
					System.out.println("Ya te has matriculado de esa subnormal");
				} else {
					asignaturas[i] = asignatura;
				}
			}
	}// seMatriculaEn

	public void setNotas() {
		int nota;
		for (int i = 0; i < asignaturas.length; i++) {
			if (asignaturas[i] != null) {
				nota = Leer.pedirEntero("Nota en " + asignaturas[i].getNombre() + " ?");
				notas[i] = nota;
			}
		}
	}// setNotas

	public void getNotas() {
		for (int i = 0; i < asignaturas.length && asignaturas[i] != null; i++) {
			System.out.println(asignaturas[i].getNombre());
			for (int j = 0; j < notas.length && notas[i] != null; j++) {
				System.out.println(" " + notas[j]);
			}
			System.out.println();
		}
	}// getNotas

	public String estado(Asignatura[] asignaturas) {
		String mensaje = "";
		for (int i = 0; i < asignaturas.length && asignaturas[i] != null; i++) {
			System.out.println(asignaturas[i].getNombre());
			for (int j = 0; j < notas.length && notas[i] != null; j++) {
				System.out.println(" " + notas[j]);
				if (notas[j] > 6) {
					mensaje = "Aprobado";
				} else {
					mensaje = "Suspenso";
				}
			}
			System.out.println();
		}
		return mensaje;
	}// estado

	public Double notaMedia() {
		int sumaNotas = 0;
		int contador = 0;
		double notaMedia;
		for (int i = 0; i < notas.length && notas[i] != null; i++) {
			sumaNotas += notas[i];
			contador++;
		}
		notaMedia = (double) (sumaNotas / contador);
		return notaMedia;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", asignaturas=" + Arrays.toString(asignaturas)
				+ "\n \t\t\t\t notas=" + Arrays.toString(notas) + "]";
	}// notaMedia

	public void matricular() {
		String nombre;
		Integer horas;
		Integer curso;
		boolean existe = false;
		int numeroAsig;
		numeroAsig = Leer.pedirEntero("Cuantas asignaturas va a llevar?");

		for (int i = 0; i < numeroAsig; i++) {
			existe = false;
			do {
				nombre = Leer.pedirCadena("Nombre");
				for (int j = 0; j < asignaturas.length && asignaturas[i] != null; j++) {
					if (asignaturas[i].getNombre().equals(nombre)) {
						System.out.println("existe ese nombre");
						existe = true;
					}
				}
			} while (existe);

			horas = Leer.pedirEntero("horas?");

			do {
				curso = Leer.pedirEntero("curso?");
			} while (curso != 1 && curso != 2);

			asignaturas[i] = new Asignatura(nombre, horas, curso);
		} // for

	}// matricular
	/*
	 * Implementar una clase Alumno que incluya todas las asignaturas a las que
	 * asiste un alumno y las notas que obtiene en esas asignaturas. Además de
	 * incluir los atributos nombre y edad, estarán disponibles las operaciones:
	 * - Constructor que acepta el nombre y la fecha de nacimiento del alumno
	 * como parámetros - Métodos para modificar y consultar el nombre del
	 * alumno. - Métodos para modificar y consultar la fecha de nacimiento del
	 * alumno. - Método para añadir las asignaturas en las que se matricula (de
	 * una en una). NOTA: un alumno puede estar matriculado hasta en 10
	 * asignaturas como máximo; el alumno no puede estar matriculado dos o más
	 * veces en la misma asignatura. - Método para introducir la calificación
	 * obtenida en una asignatura -valor real entre 0 y 10- (setNota del
	 * elemento correspondiente). - Métodos para recuperar la calificación de
	 * una asignatura (getNota del elemento correspondiente) - Método que
	 * devuelva la nota media del alumno. - Método que nos devuelva “Aprobado”
	 * si la calificación es mayor o igual a seis y “Suspenso” en caso
	 * contrario.
	 */
}
