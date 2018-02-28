Java Ejercicios POO Resueltos. Clase Complejo
Escribe una clase Complejo que modele el comportamiento de los números complejos.
Un número complejo, es una entidad matemática que viene dada por un par de números reales, el primero a se denomina la parte real y al segundo b la parte imaginaria.
Se representa escribiendo las dos partes del número entre paréntesis (a, b) o también de la forma a + bi.
La i se denomina unidad imaginaria, representa la raíz cuadrada de -1.
La clase Complejo tendrá dos datos privados de tipo double: parte real y parte imaginaria.
La clase Complejo contendrá un constructor por defecto que inicializará a 0 los atributos y un constructor con dos parámetros correspondientes a los valores de la parte real e imaginaria a asignar al nuevo objeto.
Contendrá, además de los setters y getters, los siguientes métodos:
sumar para sumar dos números complejos.
(a, b) + (c, d) = (a + c, b + d);
restar para restar dos números complejos.
(a, b) - (c, d) = (a - c, b - d);
multiplicar para multiplicar dos números complejos:
(a, b) * (c, d) = (a*c – b*d, a*d + b*c)
multiplicar para multiplicar un número complejo por un número double:
(a, b) * n = (a * n, b * n)
dividir para dividir dos números complejos:
(a, b) / (c, d) = ((a*c + b*d) / (c2 + d2) , (b*c – a*d) / (c2 + d2))
Todos los métodos anteriores devuelven el objeto número complejo resultado de la operación.
La clase contendrá además un método toString para mostrar el número complejo de la siguiente forma: (parte real, parte imaginaria) y un método equals que compruebe si dos números complejos son iguales o no.
Una vez creada la clase, escribe un programa para probar la clase. Un ejemplo de main podría ser este:

public static void main(String[] args) {
        // declaración de números complejos
        Complejo c1 = new Complejo(1.0, 1.0);
        Complejo c2 = new Complejo(2.0, 2.0);
        Complejo c3;
        // operadores aritméticos
        c3 = c1.sumar(c2);
        System.out.println(c1 + " + " + c2 + " = " + c3);
        c3 = c1.restar(c2);
        System.out.println(c1 + " - " + c2 + " = " + c3);
        c3 = c1.dividir(c2);
        System.out.println(c1 + " / " + c2 + " = " + c3);
        c3 = c1.multiplicar(c2);
        System.out.println(c1 + " * " + c2 + " = " + c3);
        c3 = c1.multiplicar(3.5);
        System.out.println(c1 + " * 3.5 = " + c3);
        if (c2.equals(c3)) {
            System.out.println(c2 + " igual que " + c3);
        } else {
            System.out.println(c2 + " distinto que " + c3);
        }
}

Si la clase Complejo está bien diseñada, este programa debe mostrar el siguiente resultado por pantalla:

(1.0, 1.0) + (2.0, 2.0) = (3.0, 3.0)
(1.0, 1.0) - (2.0, 2.0) = (-1.0, -1.0)
(1.0, 1.0) / (2.0, 2.0) = (0.5, 0.0)
(1.0, 1.0) * (2.0, 2.0) = (0.0, 4.0)
(1.0, 1.0) * 3.5 = (3.5, 3.5)
(2.0, 2.0) distinto que (3.5, 3.5)

Solución: A continuación se muestra la clase Complejo

public class Complejo {
    private double real;
    private double imag;
  
    //Constructor por defecto de la clase
    public Complejo() {
   
    }
    //Constructor con parámetros
    public Complejo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    //métodos setters y getters
    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
   
    //sumar dos números complejos
    //(a, b) + (c, d) = (a + c, b + d);
    public Complejo sumar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real + c.real;
        aux.imag = imag + c.imag;
        return aux;
    }
   
    //restar dos números complejos
    //(a, b) - (c, d) = (a - c, b - d);
    public Complejo restar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real - c.real;
        aux.imag = imag - c.imag;
        return aux;
    }
   
    //multiplicar dos números complejos
    //(a, b) * (c, d) = (a*c – b*d, a*d + b*c)
    public Complejo multiplicar(Complejo c){
        Complejo aux = new Complejo();
        aux.real = real * c.real - imag * c.imag;
        aux.imag = real * c.imag + imag * c.real;
        return aux;
    }
   
    //multiplicar un número complejo por un número de tipo double
    //(a, b) * n = (a * n, b * n)
    public Complejo multiplicar(double n){
        Complejo aux = new Complejo();
        aux.real = real * n;
        aux.imag = imag * n;
        return aux;
    }
   
    //dividir dos números complejos
    //(a, b) / (c, d) = ((a*c + b*d) / (c^2 + d^2) , (b*c – a*d) / (c^2 + d^2))
    public Complejo dividir(Complejo c){
        Complejo aux = new Complejo();
        aux.real = (real * c.real + imag * c.imag)/(c.real * c.real + c.imag * c.imag);
        aux.imag = (imag * c.real - real * c.imag)/(c.real * c.real + c.imag * c.imag);
        return aux;
    }

    //método toString
    @Override
    public String toString() {
        return "(" + real + ", " + imag + ")";
    }

    //método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complejo other = (Complejo) obj;
        if (this.real != other.real) {
            return false;
        }
        if (this.imag != other.imag) {
            return false;
        }
        return true;
    } 
} //Fin de la Clase Complejo Java