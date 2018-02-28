14) Nos piden hacer un almacén, vamos a usar programación orientado a objetos.

En un almacén se guardan un conjunto de  bebidas.

Estos productos son bebidas como agua mineral y bebidas azucaradas (coca-cola, fanta, etc). De los productos nos interesa saber su identificador (cada uno tiene uno distinto), cantidad de litros, precio y marca.

Si es agua mineral nos interesa saber también el origen (manantial tal sitio o donde sea).

Si es una bebida azucarada queremos saber el porcentaje que tiene de azúcar y si tiene o no alguna promoción (si la tiene tendrá un descuento del 10% en el precio).

En el almacén iremos almacenado estas bebidas por estanterías (que son las columnas de la matriz).

Las operaciones del almacén son las siguientes:

Calcular precio de todas las bebidas: calcula el precio total de todos los productos del almacén.
Calcular el precio total de una marca de bebida: dada una marca, calcular el precio total de esas bebidas.
Calcular el precio total de una estantería: dada una estantería (columna) calcular el precio total de esas bebidas.
Agregar producto: agrega un producto en la primera posición libre, si el identificador esta repetido en alguno de las bebidas, no se agregará esa bebida.
Eliminar un producto: dado un ID, eliminar el producto del almacén.
Mostrar información: mostramos para cada bebida toda su información.
Puedes usar un main para probar las funcionalidades (añade productos, calcula precios, muestra información, etc)



— Bebida

public class Bebida {
     
    private static int idActual=1;
     
    private int id;
    private double cantidad;
    private double precio;
    private String marca;
     
    public Bebida(double cantidad, double precio, String marca){
         
        this.id=idActual++;
         
        this.cantidad=cantidad;
        this.precio=precio;
        this.marca=marca;
         
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public double getCantidad() {
        return cantidad;
    }
 
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    @Override
    public String toString() {
        return  "id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", marca=" + marca + " ";
    }
     
}
— Bebida Azucarada

public class BebidaAzucarada extends Bebida {
     
    private double porcentajeAzucar;
    private boolean promocion;
 
    public BebidaAzucarada(double porcentajeAzucar, boolean promocion, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.porcentajeAzucar = porcentajeAzucar;
        this.promocion = promocion;
    }
 
    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }
 
    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }
 
    public boolean isPromocion() {
        return promocion;
    }
 
    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }
     
    @Override
    public double getPrecio(){
        if(isPromocion()){
            return super.getPrecio()*0.9;
        }else{
            return super.getPrecio();
        }
    }
 
    @Override
    public String toString() {
        return super.toString() + "porcentajeAzucar=" + porcentajeAzucar + ", promocion=" + promocion ;
    }
     
}
— Agua mineral

public class AguaMineral extends Bebida {
 
    //Atributos
    private String manatial;
 
    //Constructores
    public AguaMineral(String manatial, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.manatial = manatial;
    }
 
    //Metodos
    public String getManatial() {
        return manatial;
    }
 
    public void setManatial(String manatial) {
        this.manatial = manatial;
    }
 
    @Override
    public String toString() {
        return super.toString() + "manatial=" + manatial;
    }
 
}
— Almacen

public class Almacen {
 
    //Atributos
    private Bebida[][] estanteria;
 
    //Constructores
    public Almacen(int filas, int columnas) {
        estanteria = new Bebida[filas][columnas];
    }
 
    public Almacen() {
        estanteria = new Bebida[5][5];
    }
 
    //Metodos
     
    /**
     * Agega una bebida, primera posicion que encuentre
     * @param b 
     */
    public void agregarBebida(Bebida b) {
 
        boolean encontrado = false;
        for (int i = 0; i < estanteria.length && !encontrado; i++) {
            for (int j = 0; j < estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] == null) {
                    estanteria[i][j] = b; //inserto la bebida
                    encontrado = true; //Salgo
                }
            }
        }
 
        //Indico si se ha añadiddo la bebida o no
        if (encontrado) {
            System.out.println("Bebida añadida");
        } else {
            System.out.println("No se ha podido añadir la bebida");
        }
 
    }
 
    /**
     * Elimina la bebida con el id que le pasen, sino esta se indica
     * @param id 
     */
    public void eliminarBebida(int id) {
 
        boolean encontrado = false;
        for (int i = 0; i < estanteria.length && !encontrado; i++) {
            for (int j = 0; j < estanteria[0].length && !encontrado; j++) {
                if (estanteria[i][j] != null) {
                    if (estanteria[i][j].getId() == id) {
                        estanteria[i][j] = null; //Elimino la bebida
                        encontrado = true; //Salgo
                    }
                }
            }
        }
 
        //Indico si se ha eliminado
        if (encontrado) {
            System.out.println("Bebida eliminada");
        } else {
            System.out.println("No existe la bebida");
        }
 
    }
 
    /**
     * Recorro las estantenrias y muestro las bebidas
     */
    public void mostrarBebidas() {
 
         
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos
                    System.out.println("fila " + i + ", columna: " + j + " Bebida: " + estanteria[i][j].toString());
                }
            }
        }
 
    }
 
    /**
     * Calculo el precio de todas las bebidas
     * @return 
     */
    public double calcularPrecioBebidas() {
 
        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos
                    precioTotal += estanteria[i][j].getPrecio();//acumulo el precio
                }
            }
        }
 
        return precioTotal;
 
    }
 
    /**
     * Calculo el precio de todas las bebidas dde una marca
     * @param marca
     * @return 
     */
    public double calcularPrecioBebidas(String marca) {
 
        double precioTotal = 0;
        for (int i = 0; i < estanteria.length; i++) {
            for (int j = 0; j < estanteria[0].length; j++) {
                if (estanteria[i][j] != null) {//controlo nulos
 
                    if (estanteria[i][j].getMarca().equalsIgnoreCase(marca)) {
                        precioTotal += estanteria[i][j].getPrecio(); //acumulo el precio
                    }
 
                }
            }
 
        }
 
        return precioTotal;
    }
 
    /**
     * Calculo el precio de todas las bebidas de una determinada columna
     * @param columna
     * @return 
     */
    public double calcularPrecioBebidas(int columna) {
 
        double precioTotal = 0;
        if (columna >= 0 && columna < estanteria[0].length) {
 
            for (int i = 0; i < estanteria.length; i++) {
 
                if (estanteria[i][columna] != null) { //controlo nulos
                    precioTotal += estanteria[i][columna].getPrecio(); //acumulo el precio
                }
 
            }
 
        } else {
            System.out.println("La columna debe estar entre 0 y " + estanteria[0].length);
        }
 
        return precioTotal;
 
    }
 
}
— Main

public class Ejercicio_POO_DDR_10 {
 
    public static void main(String[] args) {
         
        //Creo el almacen
        Almacen a = new Almacen();
         
        Bebida b;
         
        //Añado bebidas (un poco de todo)
        //La forma de hacerlo es opcional
        for(int i=0;i<10;i++){
            switch(i%2){
                case 0:
                    b=new AguaMineral("manantial1", 1.5, 5, "bezoya");
                    a.agregarBebida(b);
                    break;
                case 1:
                    b=new BebidaAzucarada(0.2, true, 1.5, 10, "Coca Cola");
                    a.agregarBebida(b);
                    break;
            }
        }
         
        //Muestro las bebidas
        a.mostrarBebidas();
         
        //Calculo el precio de todas las bebidas
        System.out.println("Precio de todas las bebidas "+a.calcularPrecioBebidas());
         
        //Elimino una bebida en concreto
        a.eliminarBebida(4);
         
        //Muestro las bebidas
        a.mostrarBebidas();
         
        //
        System.out.println("Precio de todas las bebidas"+a.calcularPrecioBebidas());
         
        System.out.println("Precio de todas las bebidas de la marca bezoya" +a.calcularPrecioBebidas("bezoya"));
         
        System.out.println("Calcular el precio de la columna 0: "+a.calcularPrecioBebidas(0));
         
    }
     
}