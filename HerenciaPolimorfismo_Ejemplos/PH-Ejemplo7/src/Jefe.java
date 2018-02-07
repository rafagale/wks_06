import utilidades.Leer;

public class Jefe extends Empleado {
	String nomDeparJefe;

	public Jefe(String nombre,int edad, String nomDeparJefe) {
		super(nombre, edad);
		this.nomDeparJefe=nomDeparJefe;
	}

	public void pedirDatosJefe() {
		super.pedirDatos();
		System.out.print("\t\t\tNombre del departamento donde ejerce la jefatura: ");
		nomDeparJefe = Leer.pedirCadena();
	}

	@Override
	public void imprimeTodo() {
		super.imprimeTodo();
		System.out.println("\t\t\tNombre del departamento donde ejerce la jefatura: "
		                    + nomDeparJefe);
	}
}
