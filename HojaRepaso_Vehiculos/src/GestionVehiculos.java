import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestionVehiculos {

	public static void main(String[] args) {
		int opcion, n;
		Vehiculo coche = new Vehiculo(4, 250.0, 50.0, 1800.5);
		Vehiculo bici = new Vehiculo(2, 80.0, 20.5, 5.35);

		System.out.println("Hay " + Vehiculo.contadorVehiculos + " vehiculos");

		opcion = pedirEntero(
				"1-Visualizar vehiculos\n2-Comprobar si son iguales\n3-Copiar\n4-Modificar valores\n5-Salir");
		while (opcion != 0) {
			switch (opcion) {
			case 1:
				visualizar(coche, bici);
				break;
			case 2:
				if (coche.esIgual(bici)) {
					System.out.println("Los vehiculos son iguales");
				} else {
					System.out.println("Los vehiculos son distintos");
				}
				break;
			case 3:
				do {
					visualizar(coche, bici);
					n = pedirEntero("Que vehiculo quieres duplicar?");
					if (n == 1) {
						coche.copia(bici);
						System.out.println("Ahora");
					} else if (n == 2) {
						bici.copia(coche);
					} else {
						System.out.println("Elige una opcion valida");
					}
				} while (n != 1 && n != 2);
				visualizar(coche, bici);
				break;
			case 4:
				do {
					visualizar(coche, bici);
					n = pedirEntero("Que vehiculo quieres modificar?");
					if (n == 1) {
						modificar(coche);
					} else if (n == 2) {
						modificar(bici);
					} else {
						System.out.println("Elige una opcion valida");
					}
				} while (n != 1 && n != 2);

				break;
			default:
				break;
			}// Switch
			opcion = pedirEntero(
					"1-Visualizar vehiculos\n2-Comprobar si son iguales\n3-Copiar\n4-Modificar valores\n5-Salir");
		} // While

	}// main

	private static void modificar(Vehiculo coche) {
		int n;
		int modificacionInt;
		double modificacionDouble;
		n = pedirEntero("1-Numero de ruedas\n2-Velocidad actual\n3-Velocidad maxima\n4-Peso");
		switch (n) {
		case 1:
			modificacionInt = pedirEntero("Nuevo numero de ruedas?");
			do {
				coche.setNumeroDeRuedas(modificacionInt);
			} while (modificacionInt < 0);
			break;
		case 2:
			modificacionDouble = pedirDouble("Velocidad actual?");
			coche.setVelocidadActual(modificacionDouble);
			break;
		case 3:
			modificacionDouble = pedirDouble("Velocidad maxima?");
			coche.setVelocidadMax(modificacionDouble);
			break;
		case 4:
			modificacionDouble = pedirDouble("Peso nuevo?");
			coche.setPeso(modificacionDouble);
		}
	}

	private static void visualizar(Vehiculo coche, Vehiculo bici) {
		System.out.println("Vehiculo #1");
		System.out.println(coche);
		if (coche.getNumeroDeRuedas() == 0) {
			System.out.println("El vehiculo es una nave espacial");
		} else if (coche.getNumeroDeRuedas() == 2) {
			System.out.println("El vehiculo es una bici o una moto");
		} else if (coche.getNumeroDeRuedas() == 3) {
			System.out.println("El vehiculo es un triciclo");
		} else if (coche.getNumeroDeRuedas() == 4) {
			System.out.println("El vehiculo es un coche");
		} else if (coche.getNumeroDeRuedas() > 4) {
			System.out.println("El vehiculo es un somier chino");
		}
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Vehiculo #2");
		System.out.println(bici);
		if (coche.getNumeroDeRuedas() == 0) {
			System.out.println("El vehiculo es una nave espacial");
		} else if (bici.getNumeroDeRuedas() == 2) {
			System.out.println("El vehiculo es una bici o una moto");
		} else if (bici.getNumeroDeRuedas() == 3) {
			System.out.println("El vehiculo es un triciclo");
		} else if (bici.getNumeroDeRuedas() == 4) {
			System.out.println("El vehiculo es un coche");
		} else if (bici.getNumeroDeRuedas() > 4) {
			System.out.println("El vehiculo es un somier chino");
		}
		System.out.println("-----------------------------------------------------------------------");
	}

	static public double pedirDouble(final String mensaje) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		double numero = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.println(mensaje);
				numero = Double.parseDouble(dataIn.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato introducido no es decimal");
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			}
		}
		return numero;
	}// Pedir double

	static public int pedirEntero(final String mensaje) {
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		boolean error = true;
		while (error) {
			try {
				System.out.println(mensaje);
				numero = Integer.parseInt(dataIn.readLine());
				error = false;
			} catch (IOException e) {
				System.out.println("Vuelve a introducir el dato, por favor");
				error = true;
			} catch (NumberFormatException e) {
				System.out.println("El dato introducido no es entero");
				System.out.println("Vuelve a introducir el dato, por favor: ");
				error = true;
			}
		}
		return numero;
	}// Pedir entero

}// Class
