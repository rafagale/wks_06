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
		System.out.print("\n\n\n\tNOMBRE: ");
		nombre = Leer.pedirCadena();
		System.out.print("\n\n\tEDAD: ");
		edad = Leer.pedirEnteroValidar();
	}

	public void imprimeTodo() {
		System.out.print("\nSus datos son: ");
		System.out.println("\tNOMBRE: " + nombre);
		System.out.println("\tEDAD: " + edad);
	}
}
