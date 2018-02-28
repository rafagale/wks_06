12)  Nos piden hacer una un programa que gestione empleados.

Los empleados se definen por tener:

Nombre
Edad
Salario
También tendremos una constante llamada PLUS, que tendrá un valor de 300€

Tenemos dos tipos de empleados: repartidor y comercial.

El comercial, aparte de los atributos anteriores, tiene uno más llamado comisión (double).

El repartidor, aparte de los atributos de empleado, tiene otro llamado zona (String).

Crea sus constructores, getters and setters y toString (piensa como aprovechar la herencia).

No se podrán crear objetos del tipo Empleado (la clase padre) pero si de sus hijas.

Las clases tendrán un método llamado plus, que según en cada clase tendrá una implementación distinta. Este plus básicamente aumenta el salario del empleado.

En comercial, si tiene más de 30 años y cobra una comisión de más de 200 euros, se le aplicara el plus.
En repartidor, si tiene menos de 25 y reparte en la “zona 3”, este recibirá el plus.
Puedes hacer que devuelva un booleano o que no devuelva nada, lo dejo a tu elección.

Crea una clase ejecutable donde crees distintos empleados y le apliques el plus para comprobar que funciona.

— Empleado

/**
 * Clase Empleado, es abtracta
 *
 * @author DiscoDurodeRoer
 */
public abstract class Empleado {
 
    //Atributos
    private String nombre;
    private int edad;
    private double salario;
 
    //Constantes
    public final double PLUS = 300;
 
    //Constructores
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
 
    //Metodos
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public double getSalario() {
        return salario;
    }
 
    public void setSalario(double salario) {
        this.salario = salario;
    }
 
    @Override
    public String toString() {
        return "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", ";
    }
 
    //Metodo abstracto, obliga a las clases hijas que implementen esta función
    public abstract boolean plus();
 
}
— Comercial

/**
 * Clase comercial, hija de Empleado
 *
 * @author DiscoDurodeRoer
 */
public class Comercial extends Empleado {
 
    //Atributos
    private double comision;
 
    //Constructores
    public Comercial(double comision, String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.comision = comision;
    }
 
    //Metodos
    public double getComision() {
        return comision;
    }
 
    public void setComision(double comision) {
        this.comision = comision;
    }
 
    /**
     * Devuelve el estado del objeto, llama primero al toString de la clase
     * padre
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " comision=" + comision;
    }
 
    /**
     * Si tiene mas de 30 años y la comision es mayor que 200, aumentamos el
     * sueldo al empleado
     *
     * @return
     */
    @Override
    public boolean plus() {
 
        if (super.getEdad() > 30 && this.comision > 200) {
            //Con super. llamo a un metodo de la clase padre
            double nuevoSalario = super.getSalario() + super.PLUS;
            super.setSalario(nuevoSalario);
            System.out.println("Se le añadido el plus, al empleado " + super.getNombre());
            return true;
        }
 
        return false;
 
    }
 
}
— Repartidor

/**
 * Clase Repartidor, hija de empleado
 * @author DiscoDurodeRoer
 */
public class Repartidor extends Empleado {
 
    //Atributos
    private String zona;
 
    //Constructores
    public Repartidor(String zona, String nombre, int edad, double salario) {
        super(nombre, edad, salario);
        this.zona = zona;
    }
 
    //Metodos
    public String getZona() {
        return zona;
    }
 
    public void setZona(String zona) {
        this.zona = zona;
    }
 
    @Override
    public String toString() {
        return super.toString() + " zona=" + zona;
    }
 
    /**
     * Si tiene menos de 25 años y la zona es "zona 3",
     * aumentamos el sueldo al empleado
     * @return 
     */
    @Override
    public boolean plus() {
 
        if (super.getEdad() < 25 && this.zona.equalsIgnoreCase("zona 3")) {
            //Con super. llamo a un metodo de la clase padre
            double nuevoSalario = super.getSalario() + super.PLUS;
            super.setSalario(nuevoSalario);
            System.out.println("Se le añadido el plus, al empleado "+super.getNombre());
            return true;
        }
 
        return false;
    }
 
}
— Main

public class Ejercicio_POO_DDR_08 {
 
    public static void main(String[] args) {
 
        //Creamos los objetos
        Comercial c1 = new Comercial(300, "DDR", 37, 1000);
        Repartidor r1 = new Repartidor("zona 3", "Fer", 26, 900);
 
        //Llamamos a plus
        c1.plus();
        r1.plus();
 
        //Mostramos la informacion
        System.out.println(c1);
        System.out.println(r1);
    }
 
}