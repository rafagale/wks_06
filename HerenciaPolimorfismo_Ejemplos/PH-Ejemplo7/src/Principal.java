import java.util.*;
public class Principal {
	public static void main(String[] args) {
		Random azar = new Random();
		String nombres[]={"Juan", "Pedro", "Luis", "Pilar","Carmen","Ana", "Alejandro", "David", "Alberto", "Sara"};
		String universidades[]={"Zaragoza", "La Rioja", "Complutense", "Salamanca", "Barcelona","UPV"};
		String departamentos[]={"Contabilidad", "Marketing", "Ventas", "Logistica"};
		Empleado[] empresa = { new Empleado(nombres[azar.nextInt(nombres.length)], azar.nextInt(16)+20), 
				             new Jefe(nombres[azar.nextInt(nombres.length)], azar.nextInt(16)+20,departamentos[azar.nextInt(departamentos.length)]), 
				             new Becario(nombres[azar.nextInt(nombres.length)], azar.nextInt(16)+20, universidades[azar.nextInt(universidades.length)])};
		for (int i = 0; i < empresa.length; i++) {
			empresa[i].imprimeTodo();
			// Vemos que las visualizaciones son diferentes.
		}
	}
}