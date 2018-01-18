
public class Autor {
	private String nombre;
	private String email;
	private char genero;

	Autor(String nombre, String email, String genero) {
		this.nombre = nombre;
		this.email = email;
		this.genero = genero.charAt(0);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public char getGenero() {
		return genero;
	}

	public String cadenaAutor() {
		return "\nAutor [Nombre: " + nombre + " email: " + email + " genero: " + genero + " ]";
	}

}

