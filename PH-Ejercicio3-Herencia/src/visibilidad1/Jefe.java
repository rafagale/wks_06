package visibilidad1;

import visibilidad2.EmpleadoEspecial;

public class Jefe extends Empleado {
	/*En la función constructora de la clase Jefe, prueba a poner "super" y ver qué es lo que te deja usar de la clase Empleado.*/
	private EmpleadoEspecial nombre_Objeto_tipo_Empleado_Especial;
	
	public Jefe() {

	}

	@Override
	public String toString() {
		return "Jefe [toString()=" + super.toString() + "]";
	}
}