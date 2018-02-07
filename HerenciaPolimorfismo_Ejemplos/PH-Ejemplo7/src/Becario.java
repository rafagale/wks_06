import utilidades.Leer;

public class Becario extends Empleado {
	String univEstud;

	public Becario(String nombre,int edad, String univEstud) {
		super(nombre,edad);
		this.univEstud=univEstud;
	}

	public void pedirDatosBecario() {
		super.pedirDatos();
		System.out.print("\t\t\tNombre de la universidad donde estudia el becario: ");
		univEstud = Leer.pedirCadena();
	}

	@Override
	public void imprimeTodo() {
		super.imprimeTodo();
		System.out.print("\t\t\tNOMBRE DE LA UNIVERSIDAD DONDE ESTUDIA: "
				+ univEstud);
	}
}