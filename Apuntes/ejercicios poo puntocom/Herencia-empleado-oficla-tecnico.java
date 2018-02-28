Ejercicio Resuelto Herencia en Java

Codifica la siguiente jerarquía de clases java representada por este diagrama UML:



La clase base es la clase Empleado. Esta clase contiene:
Un atributo privado nombre de tipo String que heredan el resto de clases. 
Un constructor por defecto.
Un constructor con parámetros que inicializa el nombre con el String que recibe.
Método set y get para el atributo nombre.
Un método toString() que devuelve el String: "Empleado " + nombre.

El resto de clases solo deben sobrescribir el método toString() en cada una de ellas y declarar el constructor adecuado de forma que cuando la ejecución de las siguientes instrucciones:

Empleado E1 = new Empleado("Rafa");
Directivo D1 = new Directivo("Mario");
Operario OP1 = new Operario("Alfonso");
Oficial OF1 = new Oficial("Luis");
Tecnico T1 = new Tecnico("Pablo");
System.out.println(E1);
System.out.println(D1);
System.out.println(OP1);
System.out.println(OF1);
System.out.println(T1);
Den como resultado:
Empleado Rafa
Empleado Mario -> Directivo
Empleado Alfonso -> Operario
Empleado Luis -> Operario -> Oficial
Empleado Pablo -> Operario -> Tecnico
Solución:
Primero escribimos el código de la clase Empleado que es la Clase Base:
//Clase Empleado. Clase Base de la jerarquía
public class Empleado {
    private String nombre;

    //constructor por defecto
    public Empleado() {
    }

    //constructor con un parámetro
    public Empleado(String nombre) {
        this.nombre = nombre;
        System.out.println("Constructor de Empleado " + nombre);
    }
   
    //métodos get y set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //método toString()
    //devuelve un String formado por la palabra “Empleado” y el nombre de empleado
    @Override
    public String toString() {
        return "Empleado " + nombre;
    }
}
A continuación escribimos el código de las Clases Derivadas.
La primera que vamos a crear es la clase Operario que hereda de forma directa de la clase Empleado. Recuerda que en java la herencia se expresa mediante la palabra extends: Operario extends Empleado indica que la clase Operario deriva o hereda de la clase Empleado.
La clase Operario hereda de Empleado el atributo nombre, los métodos get/set y el método toString(). El constructor de la clase recibe el nombre del empleado y lo pasa al constructor de la clase Base mediante la instrucción super(nombre).
En esta clase se modifica (override) el método toString() heredado de la clase base para que muestre un mensaje como pide el ejercicio.
//Clase Operario. Clase derivada de la clase Empleado
public class Operario extends Empleado{

    //constructor con un parámetro
    public Operario(String nombre) {
        super(nombre);
        System.out.println("Constructor de Operario");
    }

    //constructor por defecto
    public Operario() {
    }

    //modificación del método toString() para mostrar el mensaje adecuado
    @Override
    public String toString() {
        return super.toString() + " -> Operario";
    }
   
}

Ahora escribimos el código de la clase Oficial que hereda de la clase Operario.
La clase Oficial hereda de Operario el atributo nombre, los métodos get/set y el método toString().
El constructor de la clase recibe el nombre del empleado y lo pasa al constructor de su clase Base, en este clase la clase Operario, mediante la instrucción super(nombre).
En esta clase también se modifica el método toString() heredado de su clase base para que muestre un mensaje como pide el ejercicio.
//Clase Oficial. Clase derivada de la clase Operario
public class Oficial extends Operario{

    public Oficial() {
    }

    public Oficial(String nombre) {
        super(nombre);
        System.out.println("Constructor de Oficial");
    }
   
    @Override
    public String toString() {
        return super.toString() + " -> Oficial";
    }
}
El código Java del resto de las clases es similar a estos.
//Clase Directivo. Clase derivada de la clase Empleado
public class Directivo extends Empleado{

    public Directivo() {
    }
   
    public Directivo(String nombre) {
        super(nombre);
        System.out.println("Constructor de Directivo");
    }
   
    @Override
    public String toString() {
        return super.toString() + " -> Directivo";
    }
}

//Clase Tecnico. Clase derivada de la clase Operario
public class Tecnico extends Operario{

    public Tecnico() {
    }

    public Tecnico(String nombre) {
        super(nombre);
        System.out.println("Constructor de Tecnico");
    }
   
    @Override
    public String toString() {
        return super.toString() + " -> Tecnico";
    }
}
