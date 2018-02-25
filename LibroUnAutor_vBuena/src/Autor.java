
public class Autor {
	private String nombre;
	private String email;
	private char genero;
	
	public Autor(String nombre, String email, char genero) {
		this.nombre = nombre;
		this.email = email;
		this.genero = genero;
	}
	
	public Autor(String nombre, String email, String genero) {
		this.nombre = nombre;
		this.email = email;
		this.genero = genero.charAt(0);
	}
	
	public String cadenaAutor(){
		return "Autor[nombre = " + nombre + ", email = " + email + ", genero = "+ genero + "]";
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
	
}
