
public class Alumno {
	private String nombre;
	private int edad;
	static int contador=0;

	public Alumno() throws DemasiadosObjetos{
		DemasiadosObjetos eDemObjetos = new DemasiadosObjetos();
		if (contador==3){
			throw eDemObjetos;
		}else{
			contador++;
		}
	}
	
	public Alumno(String nombre, int edad) throws DemasiadosObjetos{
		DemasiadosObjetos eDemObjetos = new DemasiadosObjetos();
		if (contador==3){
			throw eDemObjetos;
		}else{
			this.nombre=nombre;
			this.edad=edad;
			contador++;
		}
	}//Alumno

	public int getEdad() {
		return edad;
	}
	
	public void mostrarAlumno(){
		System.out.println("\nNombre: "+nombre);
		System.out.println("edad: "+edad);
	}

	protected void finalize(){
		System.out.println("\nSe libera la referencia del objeto correspondiente al alumno:");
		this.mostrarAlumno();
		contador--;
	}

}//class
