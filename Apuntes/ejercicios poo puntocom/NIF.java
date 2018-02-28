jercicio Básico de Clases en Java: Clase NIF
Crea una clase NIF que represente el DNI con su correspondiente letra. Los atributos de la clase serán el número de DNI y su letra.
La clase NIF dispondrá de los siguientes métodos:
Un constructor por defecto.
Un constructor que reciba como parámetro el DNI y calcule y asigne la letra que le corresponde.
Un método leer(): que pida por teclado el número de DNI y calcule a partir del DNI introducido la letra que le corresponde.
Método toString() que muestre el NIF de la siguiente forma: ocho dígitos, un guión y la letra en mayúscula. Por ejemplo: 12345678-Z
Método para obtener la letra del NIF:
La letra del NIF se calculará usando un método privado. La forma de obtener la letra del NIF es la siguiente:
Se obtiene el resto de la división entera del número de DNI entre 23 y se usa la siguiente tabla para obtener la letra que corresponde:
 0 - T     1 - R    2 - W     3 - A     4 - G     5 – M
 6 – Y     7 – F    8 – P     9 - D    10 – X    11 – B
12 – N    13 – J   14 – Z    15 – S    16 - Q    17 - V
18 - H    19 - L   20 – C    21 – K    22 – E

Una vez creada la clase, escribe un programa para probarla.
Solución:
//Clase NIF
import java.util.Scanner;
public class Nif {

    private int dni;
    private char letra;

    //Constructores
    public Nif() {
    }

    public Nif(int dni) {
        this.dni = dni;
        letra = calcularLetra();
    }

    //Método para calcular la letra del NIF
    private char calcularLetra() {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[dni % 23];
    }

    //Método para leer por teclado el número de DNI y calcular la letra
    public void leer() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce dni: ");
            dni = sc.nextInt();
        } while (dni <= 0);
        letra = calcularLetra();
    }

    //Método que devuelve un String de la forma 99999999-X
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dni);
        sb.append("-");
        sb.append(letra);
        return sb.toString();
    }

}

Un programa sencillo para probar esta clase puede der este:

//Clase Principal
public class Main {

    public static void main(String[] args) {
        Nif nif1 = new Nif();
        nif1.leer();
        System.out.println(nif1);

        Nif nif2 = new Nif(12345678);
        System.out.println(nif2);

    }
}
La ejecución de este programa produce esta salida por pantalla:
Introduce dni: 22334455
22334455-Y
12345678-Z