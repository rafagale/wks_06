
public class Autor {
	private String nombre;
	private String email;
	private char genero;
	private static int contaAutores=0;
	
	public Autor(String nombre, String email, char genero) {
		this.nombre = nombre;
		this.email = email;
		this.genero = genero;
		contaAutores++;
	}
	
	
	public static int getContaAutores() {
		return contaAutores;
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
