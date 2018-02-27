
public class Alumno {
	private String nombre;
	private Integer fechaNacimiento;
	private Asignatura[] asignaturas;
	private Integer[] notas;

	public Alumno(String nombre, Integer fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.asignaturas = new Asignatura[10];
		this.notas = new Integer[10];
	}

	public void matricular() {
		String nombre;
		Integer horas;
		Integer curso;
		for (int i = 0; i < asignaturas.length; i++) {
			do {
				nombre = Leer.pedirCadena("Nombre");
			} while (asignaturas[i].getNombre().equals(nombre));
			
			horas = Leer.pedirEntero("horas?");
			
			do {
				curso = Leer.pedirEntero("curso?");
			} while (curso != 1 || curso != 2);
			
			asignaturas[i] = new Asignatura(nombre, horas, curso);
		}

	}// matricular
}
