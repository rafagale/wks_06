
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	/**
	 * 
	 */

	/**
	 * @author yo
	 *
	 */
	public class Leer {
		
		/**
		 * Método para imprimir mensaje que se repetía
		 */
		static public void mostrarEnPantalla(String mensage){
			System.out.println(mensage);
		}
		
		/**
		 * @param texto
		 * @return
		 */
		static public String pedirCadena(final String texto) {
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
			String dato="";
			boolean error = true;
			while (error) {
				try {
					dato="";
					mostrarEnPantalla(texto);
					dato = dataIn.readLine();
					error=false;
				} catch (IOException e) {
					mostrarEnPantalla("Vuelve a introducir el dato, por favor: ");
					error = true;
				}
			}
			return dato;

		}
		
		/**
		 * @param texto
		 * @return
		 */
		static public int pedirEntero(final String mensaje) {
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
			int numero=0;
			boolean error = true;
			while (error) {
				try {
					System.out.println(mensaje);
					numero = Integer.parseInt(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a introducir el dato, por favor");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es entero");
					System.out.println("Vuelve a introducir el dato, por favor: ");
					error=true;
				}
			}
			return numero;
		}//Pedir entero
		
		/**
		 * @param texto
		 * @return
		 */
		static public double pedirDouble(final String mensaje) {
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
			double numero=0;
			boolean error = true;
			while (error) {
				try {
					System.out.println(mensaje);
					numero = Double.parseDouble(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					System.out.println("Vuelve a introducir el dato, por favor: ");
					error = true;
				} catch(NumberFormatException e){
					System.out.println("El dato introducido no es decimal");
					System.out.println("Vuelve a introducir el dato, por favor: ");
					error=true;
				}
			}
			return numero;
		}
		/**
		 * @param texto
		 * @return
		 */
		static public float pedirFloat(final String texto) {
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
			float dato=0;
			boolean error = true;
			while (error) {
				try {
					mostrarEnPantalla(texto);
					dato = Float.parseFloat(dataIn.readLine());
					error=false;
				} catch (IOException e) {
					mostrarEnPantalla("Vuelve a introducir el dato, por favor: ");
					error = true;
				} catch(NumberFormatException e){
					mostrarEnPantalla("El dato introducido no es decimal");
					mostrarEnPantalla("Vuelve a introducir el dato, por favor: ");
					error=true;
				}
			}
			return dato;

		}
	}
