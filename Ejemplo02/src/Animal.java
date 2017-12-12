
public class Animal {
	private String nombre;
	private String raza;
	private int edad;
	
	Animal(){
		nombre = "Pluto";
		raza = "golden";
		edad = 13;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}//class
