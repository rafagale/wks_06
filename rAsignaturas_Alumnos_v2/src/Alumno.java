import java.util.Arrays;

public class Alumno {
	private String nombre;
	private Fecha fechaNacimiento;
	private Asignatura[] asignaturas;
	private Integer[] notas;
	//private int contaAsignaturas;


	public Alumno(String nombre, Fecha fechaNacimiento) {
		//Fecha fechaActual = new Fecha(27, 2, 2018);
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		//this.edad = fechaNacimiento.difFechas(fechaActual) / 365;
		this.asignaturas = new Asignatura[10];
		this.notas = new Integer[10];
	}

	// Todas
	public String seMatriculaEn(Asignatura asignatura) {
		boolean existe = false;
		int i;
		String respuesta;
		for (i = 0; i < asignaturas.length && asignaturas[i] != null && !existe; i++) {
			//if (asignaturas[i] != null && asignaturas[i].getNombre().equals(asignatura.getNombre())) {
			if (asignaturas[i] != null && asignaturas[i]==asignatura) {
				existe = true;
			} 
		}
		if (i < asignaturas.length) {
			if (!existe) {
				asignaturas[i] = asignatura;
				respuesta = "Matriculado en " + asignatura.getNombre();
			} else {
				respuesta = "No se puede";
			}

		} else {
			respuesta = "No se puede";
		}
		return respuesta;
	}// seMatriculaEn

	/*public int getContaAsignaturas() {
		return contaAsignaturas;
	}*/

	public void setNotas() {
		int nota;
		for (int i = 0; i < asignaturas.length && asignaturas[i] != null; i++) {
			do {
				nota = Leer.pedirEntero("Nota en " + asignaturas[i].getNombre() + " ?");
			} while (nota < 0 || nota > 10);
			notas[i] = nota;
		}
	}// setNotas

	public void getNotas() {
		System.out.println();
		for (int i = 0; i < asignaturas.length && asignaturas[i] != null; i++) {
			System.out.print(asignaturas[i].getNombre());
			System.out.print(": " + (double)(notas[i]) +"\n");
			
		}
	}// getNotas

	
	
	public String getNombre() {
		return nombre;
	}

	public String estado(Asignatura[] asignaturas) {
		String mensaje;
		if (notaMedia() > 6) {
			mensaje = "Aprobado";
		} else {
			mensaje = "Suspenso";
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
		return "Alumno [nombre=" + nombre + ", asignaturas=" + Arrays.toString(asignaturas)
				+ "\n \t\t\t\t notas=" + Arrays.toString(notas) + "]";
	}// notaMedia

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
