
public class Asignatura {
	
	private String nombre;
	private Integer horasSemana;
	private Integer curso;
	
	public Asignatura(String nombre, Integer horasSemana, Integer curso) {
		this.nombre = nombre;
		this.horasSemana = horasSemana;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
