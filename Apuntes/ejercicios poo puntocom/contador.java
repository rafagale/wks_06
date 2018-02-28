Ejercicio Básico POO. Clase Contador

Crea una clase llamada Contador que contenga un único atributo entero llamado cont.
La clase tendrá los siguientes constructores:
Constructor por defecto
Constructor con parámetros para inicializar el contador con un valor no negativo. Si el valor inicial que se recibe es negativo el contador tomará el valor cero como valor inicial.
Constructor copia.
Además de los métodos getter y setter, la clase contendrá los métodos:
incrementar: incrementa el contador en una unidad.
decrementar: decrementa el contador en una unidad. El contador nunca podrá tener un valor negativo. Si al decrementar se alcanza un valor negativo el contador toma el valor cero.
Una vez creada la clase, escribe un método main para probar la clase.
Solución:
//Ejercicio Básico Programación Orientada a Objetos Java 
//Clase Contador
public class Contador {

    private int cont;

    //constructor por defecto
    public Contador() {
    }

    //constructor con parámetros
    public Contador(int cont) {
        if (cont < 0) {
            this.cont = 0;
        } else {
            this.cont = cont;
        }
    }

    //constructor copia
    public Contador(final Contador c) {
        cont = c.cont;
    }

    //getter
    public int getCont() {
        return cont;
    }

    //setter
    public void setCont(int cont) {
        if (cont < 0) {
            this.cont = 0;
        } else {
            this.cont = cont;
        }
    }

    //método incrementar contador
    public void incrementar() {
        cont++;
    }

    //método decrementar contador
    public void decrementar() {
        cont--;
        if (cont < 0) {
            cont = 0;
        }
    }
}

Un método main para probar la clase puede ser este:
public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
       
        //Utilizar el constructor por defecto
        Contador contador1 = new Contador();
      
        int n;
        System.out.println("Introduce valor para inicializar el contador: ");
        n = sc.nextInt();
       
        //asignar un valor al contador
        contador1.setCont(n);
        //incrementar el contador
        contador1.incrementar();
        //mostrar el valor actual
        System.out.println(contador1.getCont());
       
        contador1.incrementar();
        contador1.incrementar();
       
        //mostrar el valor actual
        System.out.println(contador1.getCont());
       
        //restar 1 al valor del contador
        contador1.decrementar();
       
        //mostrar el valor actual
        System.out.println(contador1.getCont());

        //crear un nuevo objeto Contador con valor inicial 10
        Contador contador2 = new Contador(10);
       
        //incrementar y decrementar el contador2 y mostrar su valor
        contador2.incrementar();
        System.out.println(contador2.getCont());
        contador2.decrementar();
        System.out.println(contador2.getCont());

        //crear un objeto Contador utilizando el constructor copia
        //se crea el objeto contador3 como copia de contador2
        Contador contador3 = new Contador(contador2);

        //mostrar el valor de contador3
        System.out.println(contador3.getCont());
    }