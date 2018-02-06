import utilidades.Leer;

public class Empleado {
	private String nombre;
	private int edad;

	public Empleado(String nombre,int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}
	
	public void pedirDatos() {
		System.out.println("\nVamos a insertar los datos del empleado: ");
		nombre = Leer.pedirCadena("\n\n\n\tNOMBRE: ");
		edad = Leer.pedirEntero("\n\n\tEDAD: ");
	}

	public static void indicaTipoPersonal() {
		Leer.mostrarEnPantalla("\tESTA PERSONA ES UN EMPLEADO DE LA EMPRESA.");
	}

	public void setNombre(String nombre){	
		this.nombre=nombre;
		return;
	}
	
	
	public void setTodo(String nombre,int edad){
		this.nombre=nombre;
		this.edad=edad;
		return;
	}
	public void imprimeNombre(){
		Leer.mostrarEnPantalla("\n\t\tNOMBRE " + nombre);
		return;
	}
	
	public void imprimeEdad(){
		Leer.mostrarEnPantalla("\n\t\tEDAD: " + edad);
		return;
	}
	public void imprimeTodo(){
		indicaTipoPersonal();
		imprimeNombre();
		imprimeEdad();		
		return;
	}
}