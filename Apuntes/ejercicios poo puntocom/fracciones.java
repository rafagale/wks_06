Ejercicio Básico Programación Orientada a Objetos Java. Clase Fraccion
Escribe una clase para representar fracciones. La clase tendrá dos atributos de tipo int: num (numerador) y den (denominador). La clase debe contener los constructores y métodos adecuados para que este método main funcione de forma correcta:
public static void main(String[] args) {
        // Se crean 4 fracciones
        Fraccion f1 = new Fraccion(1, 4); // Fracción 1/4
        Fraccion f2 = new Fraccion(1, 2); // Fracción 1/2
        Fraccion f3 = new Fraccion(); // Fracción 0/1
        Fraccion f4 = new Fraccion(4); // Fracción 4/1
        // operaciones aritméticas con esas fracciones
        Fraccion suma = f1.sumar(f2);
        Fraccion resta = f1.restar(f3);
        Fraccion producto = f1.multiplicar(f4);
        Fraccion cociente = f1.dividir(f2);
        //mostrar resultados
        System.out.println(f1 + " + " + f2 + " = " + suma);
        System.out.println(f1 + " - " + f3 + " = " + resta);
        System.out.println(f1 + " * " + f4 + " = " + producto);
        System.out.println(f1 + " / " + f2 + " = " + cociente);
}
La ejecución del método main debe mostar por pantalla lo siguiente:
1/4 + 1/2 = 3/4
1/4 - 0/1 = 1/4
1/4 * 4/1 = 1/1
1/4 / 1/2 = 1/2
Las fracciones se deben mostrar siempre simplificadas. Para ello la clase Fraccion debe contener un método privado simplificar() que actuará de la siguiente forma:
Para simplificar una fracción primero hay que hallar el máximo común divisor del numerador y del denominador. Una vez hallado se divide el numerador y el denominador por este número. Para calcular el máximo común divisor podemos usar este método mcd que calcula y devuelve el máximo común divisor del numerador y del denominador utilizando el método de Euclides
//Cálculo del máximo común divisor
private int mcd(){
     int u=Math.abs(num);
     int v=Math.abs(den);
     if(v==0){
          return u;
     }
     int r;
     while(v!=0){
          r=u%v;
          u=v;
          v=r;
     }
     return u;
}

Solución: Vamos a estudiar el código del método main y a continuación escribiremos los métodos necesarios en Clase Fracción.
1. Para poder crear los objetos f1 y f2:
Fraccion f1 = new Fraccion(1, 4); // Fracción 1/4
Fraccion f2 = new Fraccion(1, 2); // Fracción 1/2
la clase Fracción debe tener un constructor con dos parámetros, el primer parámetro es el valor del numerador y el segundo el del denominador. Debemos controlar que el denominador de la fracción no sea cero. Si el valor del segundo parámetro es cero, es decir, si se crean objetos de esta forma:
Fraccion f = new Fraccion(3, 0);
en el constructor se asignará el valor 1 la denominador.
//constructor de la clase con dos parámetros
public Fraccion(int num, int den) {
        this.num = num;
        if(den==0){
            den = 1;
        }
        this.den = den;
        simplificar();
    }
El constructor llama al método simplificar.
2. Para poder crear objetos como el f3:
Fraccion f3 = new Fraccion(); // Fracción 0/1
La clase Fraccion tendrá un constructor por defecto (sin parámetros), que asigne el valor 0 al numerador y el valor 1 al denominador.
//constructor por defecto
public Fraccion() {
        this.num = 0;
        this.den = 1;
}
3. Para crear objetos como el f4:
Fraccion f4 = new Fraccion(4); // Fracción 4/1
La clase deberá tener un tecer constructor con un solo parámetro. El valor del parámetro es el valor de numerador de la fracción. El valor del denominador será 1.
//constructor con un parámetro
public Fraccion(int num) {
        this.num = num;
        this.den = 1;
}
4. Operaciones con fracciones.
Para realizar las operaciones aritméticas:
Fraccion suma = f1.sumar(f2);
Fraccion resta = f1.restar(f3);
Fraccion producto = f1.multiplicar(f4);
Fraccion cociente = f1.dividir(f2);
la clase Fraccion tendrá un método para cada una de ellas. Estos métodos reciben un objeto Fracción que será la que se opere con la fracción que llama al método. Se devuelve el objeto Fracción resultante de la operación.
El método sumar puede ser éste:
//sumar fracciones
public Fraccion sumar(Fraccion f) {
        Fraccion aux = new Fraccion();  //fracción para guardar la suma
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
}
Después de cada operación se simplifica la fracción resultante. El resto de métodos para realizar las otras operaciones aritméticas son similares a éste.
5. Para que una instrucción println como esta:
System.out.println(f1 + " + " + f2 + " = " + suma);
Muestre por pantalla:
1/4 + 1/2 = 3/4
La clase debe tener un método toString() que devuelva un String con el contenido de la fracción de la forma: numerador/denominador
//método toString
@Override
public String toString() {
        simplificar();
        return num + "/" + den;
}
Solo faltan por añadir los métodos get y set para acceder a los atributos de la clase y el método simplificar que a su vez llama al método mcd.
//Clase Fracción
public class Fraccion {

    private int num;
    private int den;

    public Fraccion() {
        this.num = 0;
        this.den = 1;
    }

    public Fraccion(int num, int den) {
        this.num = num;
        if(den==0){
            den = 1;
        }
        this.den = den;
        simplificar();
    }

    public Fraccion(int num) {
        this.num = num;
        this.den = 1;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //sumar fracciones
    public Fraccion sumar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //restar fracciones
    public Fraccion restar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den - this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //multiplicar fracciones
    public Fraccion multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //dividir fracciones
    public Fraccion dividir(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }
   
    //Cálculo del máximo común divisor por el algoritmo de Euclides
    private int mcd() {
        int u = Math.abs(num); //valor absoluto del numerador
        int v = Math.abs(den); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    //método para simplificar fracciones
    private void simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        num = num / n;
        den = den / n;
    }

    @Override
    public String toString() {
        simplificar();
        return num + "/" + den;
    }    
} //Fin de la clase Fraccion