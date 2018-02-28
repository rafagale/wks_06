13) Nos piden hacer que gestionemos una serie de productos.

Los productos tienen los siguientes atributos:

Nombre
Precio
Tenemos dos tipos de productos:

Perecedero: tiene un atributo llamado días a caducar
No perecedero: tiene un atributo llamado tipo
Crea sus constructores, getters, setters y toString.

Tendremos una función llamada calcular, que según cada clase hará una cosa u otra, a esta función le pasaremos un numero siendo la cantidad de productos

En Producto, simplemente seria multiplicar el precio por la cantidad de productos pasados.
En Perecedero, aparte de lo que hace producto, el precio se reducirá según los días a caducar:
Si le queda 1 día para caducar, se reducirá 4 veces el precio final.
Si le quedan 2 días para caducar, se reducirá 3 veces el precio final.
Si le quedan 3 días para caducar, se reducirá a la mitad de su precio final.
En NoPerecedero, hace lo mismo que en producto
Crea una clase ejecutable y crea un array de productos y muestra el precio total de vender 5  productos de cada uno. Crea tú mismo los elementos del array.



— Producto

/**
 * Clase Producto, clase padre
 * @author DiscoDurodeRoer
 */
public class Producto {
     
    //Atributos
    private String nombre;
    private double precio;
 
    //Constructores
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
 
    //Metodos
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    @Override
    public String toString() {
        return "nombre=" + nombre + ", precio=" + precio +", ";
    }
     
    /**
     * Indica el precio total segun una cantidad
     * @param cantidad
     * @return 
     */
    public double calcular(int cantidad){
        return precio*cantidad;
    }
     
     
}
— Perecedero

/**
 * Clase Perecedero, clase hija de Producto
 * @author DiscoDurodeRoer
 */
public class Perecedero extends Producto {
 
    //Atributos
    private int dias_a_caducar;
 
    //Constructores
    public Perecedero(int dias_a_caducar, String nombre, double precio) {
        super(nombre, precio);
        this.dias_a_caducar = dias_a_caducar;
    }
 
    //Metodos
    public int getDias_a_caducar() {
        return dias_a_caducar;
    }
 
    public void setDias_a_caducar(int dias_a_caducar) {
        this.dias_a_caducar = dias_a_caducar;
    }
 
    @Override
    public String toString() {
        return super.toString() + " dias_a_caducar=" + dias_a_caducar;
    }
 
    /**
     * Calcula el precio segun una cantidad,
     * tambien segun los dias que le queden al prodcuto,
     * se reducira el precio.
     * <ul>
     * <li>1: 4 veces menos</li>
     * <li>2: 3 veces menos</li>
     * <li>3: 2 veces menos</li>
     * </ul>
     * @param cantidad
     * @return 
     */
    @Override
    public double calcular(int cantidad) {
 
        double precioFinal = super.calcular(cantidad);
 
        switch (dias_a_caducar) {
            case 1:
                precioFinal /= 4;
                break;
            case 2:
                precioFinal /= 3;
                break;
            case 3:
                precioFinal /= 2;
                break;
        }
         
        return precioFinal;
 
    }
 
}
— No Perecedero

/**
 * Clase NoPerecedero, clase hija de Producto
 * No se ha implementado calcular, llama al del padre
 * @author DiscoDurodeRoer
 */
public class NoPerecedero extends Producto{
     
    //Atributos
    private String tipo;
 
    //constructores
    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }
 
    //Metodos
    public String getTipo() {
        return tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    @Override
    public String toString() {
        return super.toString() + " tipo=" + tipo + '}';
    }
     
     
}
— Main

public class Ejercicio_POO_DDR_09 {
 
    public static void main(String[] args) {
         
        //Creo que array de productos
        Producto[] productos = new Producto[3];
         
        //Creo los elementos
        productos[0] = new Producto("producto 1", 10);
        productos[1] = new Perecedero(1, "producto 2", 20);
        productos[2] = new NoPerecedero("tipo 1", "producto 3", 5);
 
        //Calculo el precio
        double total=0;
        for(int i=0;i<productos.length;i++){
            total += productos[i].calcular(5); //Polimorfismo
        }
         
        //Muestro el total
        System.out.println("el total es "+total);
         
    }
     
}