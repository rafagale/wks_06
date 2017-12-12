
public class Persona {

	private String nombre;
	private int edad;
	private int altura;
	private static int numPersonas=0;
	Persona(){
		nombre="NombreDadoPorConstructor";
		numPersonas++;
	}
	Persona(String unNombre, int unaEdad, int unAltura){
		nombre=unNombre;
		edad=unaEdad;
		altura=unAltura;
		numPersonas++;
	}
	public static int getNumPersonas() {
		return numPersonas;
	}
	
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String unNombre) {
		nombre = unNombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int unaEdad) {
		edad = unaEdad;
	}
	public String hablar(String frase){
		String temporal=" te digo que ";
		temporal=temporal + testMayorDeEdad();
		temporal=temporal + testAltura();
		temporal=temporal + "\ny " + frase;
		return "soy " + nombre + ", " + temporal;
	}//
	private String testMayorDeEdad(){
		if(edad>=18)
			return " soy mayor de edad ";
		else
			return " soy menor de edad ";
	}//
	private String testAltura(){
		if(altura>=165)
			return " soy alto/a ";
		else
			return " no soy muy alto/a ";
	}//
	
}//class










