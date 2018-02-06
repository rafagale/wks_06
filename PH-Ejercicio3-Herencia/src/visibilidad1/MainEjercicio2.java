package visibilidad1;
/*Comprueba:
 * 
1º En la función constructora de la clase Jefe, prueba a poner "super" y ver qué es lo que te deja usar de la clase Empleado.
Hoja 1 Tema 9. Ejercicios de herencia y polimorfismo Página 2 de 3
---->Los metodos de la clase Empleado

2º En la función constructora de la clase JefeEspecial, prueba a poner" super" y ver qué es lo que te deja usar de la clase EmpleadoEspecial.

3º Añade a la clase Jefe un nuevo atributo de tipo "EmpleadoEspecial" (recuerda que hay que importar dicha clase para poder usarla fuera de su paquete).
Instancia dicho objeto dentro de la función constructora, pon "nombre_Objeto_tipo_Empleado_Especial" y comprueba qué es lo que te deja usar.*/

public class MainEjercicio2 {

	public static void main(String[] args) {

		Jefe amancio = new Jefe();
		System.out.println(amancio);
		JefeEspecial rato = new JefeEspecial();
	}
}
