package visibilidad1;
/*Comprueba:
 * 
1� En la funci�n constructora de la clase Jefe, prueba a poner "super" y ver qu� es lo que te deja usar de la clase Empleado.
Hoja 1 Tema 9. Ejercicios de herencia y polimorfismo P�gina 2 de 3
---->Los metodos de la clase Empleado

2� En la funci�n constructora de la clase JefeEspecial, prueba a poner" super" y ver qu� es lo que te deja usar de la clase EmpleadoEspecial.

3� A�ade a la clase Jefe un nuevo atributo de tipo "EmpleadoEspecial" (recuerda que hay que importar dicha clase para poder usarla fuera de su paquete).
Instancia dicho objeto dentro de la funci�n constructora, pon "nombre_Objeto_tipo_Empleado_Especial" y comprueba qu� es lo que te deja usar.*/

public class MainEjercicio2 {

	public static void main(String[] args) {

		Jefe amancio = new Jefe();
		System.out.println(amancio);
		JefeEspecial rato = new JefeEspecial();
	}
}
