/**
 * 
 * @author Rafa
 *
 */

public class Metodos {
	private static final double PI=3.141592;

	public static boolean esPrimo (int numero){
		//Un numero menor o igual que 1, no es primo.
		if (numero<=1){
			return false;
		}
		//Declaramos esta variable aqui ya que despues es usada"
		int cont=0;
		for (int divisor=(int)Math.sqrt(numero);divisor>1;divisor--){
			//contabilizados los divisibles"
			if (numero%divisor==0){
				cont+=1;
			}
		}
		//Según el numero de divisibles es o no primo"
		if (cont>=1){
			return false;
		}else{
			return true;
		}
	}//esPrimo

	public static int cuentaCifras (int numero){
		int contador=0;
		for (int i=numero;i>0;i/=10){
			//Incrementamos el contador
			contador++;
		}
		return contador;
	}//cuentaCifras
	public static int cuentaDivisores (int numero){
		int cont=0;
		for (int divisor=(int)Math.sqrt(numero);divisor>1;divisor--){
			//contabilizados los divisores
			if (numero%divisor==0){
				cont+=1;
			}
		}
		return cont;
	}//CuentaDivisores
	
    public static double factorial(double numero) {
        double factorial = 1;
        for (int i = 1; i <= numero; i++) {
        	factorial *= i;
        }
        return factorial;
    }//Factorial

}//Class