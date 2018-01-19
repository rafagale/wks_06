
public class Autor {
	private String nombre;
	private String email;
	private char genero;
	private static int contadorAutores = 0;
	public Autor(String nombre, String email, String genero) {
		this.nombre = nombre;
		this.email = email;
		if (genero.toLowerCase().equals("hombre")) {
			this.genero='H';
		} else if (genero.toLowerCase().equals("mujer")){
			this.genero='M';
		}
		contadorAutores++;
	}//Constructor
	
	public String cadenaAutor(){
		return "Autor [nombre=" + nombre + ", email=" + email + ", genero=" + genero + "]";
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

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", email=" + email + ", genero=" + genero + "]";
	}

	public char getGenero() {
		return genero;
	}

	public static int getContadorAutores() {
		return contadorAutores;
	}


}//Class
