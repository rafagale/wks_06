16) Vamos a hacer unas mejoras a la clase Baraja del ejercicio 5 de POO de los videos.

Lo primero que haremos es que nuestra clase Baraja será la clase padre y será abstracta.

Le añadiremos el número de cartas en total y el número de cartas por palo.

El método crearBaraja() será abstracto.

La clase Carta tendrá un atributo genérico que será el palo de nuestra versión anterior.

Creamos dos Enum:

PalosBarEspañola:
OROS
COPAS
ESPADAS
BASTOS
PalosBarFrancesa:
DIAMANTES
PICAS
CORAZONES
TREBOLES
Creamos dos clases hijas:

BarajaEspañola: tendrá un atributo boolean para indicar si queremos jugar con las cartas 8 y 9 (total 48 cartas) o no (total 40 cartas).
BarajaFrancesa: no tendrá atributos, el total de cartas es 52 y el número de cartas por palo es de 13. Tendrá dos métodos llamados:
cartaRoja(Carta<PalosBarFrancesa> c): si el palo es de corazones y diamantes.
cartaNegra(Carta<PalosBarFrancesa> c): si el palo es de tréboles y picas.
De la carta modificaremos el método toString()

Si el palo es de tipo PalosBarFrancesa:

La carta número 11 será Jota
La carta numero 12 será Reina
La carta numero 13 será Rey
La carta numero 1 será As
Si el palo es de tipo PalosBarFrancesa:

La carta numero 10 será Sota
La carta numero 12 será Caballo
La carta numero 13 será Rey
La carta numero 1 será As


— Palos baraja española

public enum PalosBarajaEspañola {
    OROS,
    COPAS,
    ESPADAS,
    BASTOS;
}

— Palos baraja francesa

public enum PalosBarajaFrancesa { 
    DIAMANTES,
    PICAS,
    TREBOLES,
    CORAZONES;
}

— Carta

/**
 * Clase Carta
 * @author Disco Duro de Roer
 */
public class Carta<T> {
     
    //Atributos
    private int numero;
    private T palo;
 
    public int getNumero() {
        return numero;
    }
 
    public T getPalo() {
        return palo;
    }
     
    //Constructor
    public Carta(int numero, T palo) {
        this.numero = numero;
        this.palo = palo;
    }
 
    @Override
    public String toString() {
         
        String estado="";
        String nombreFigura="";
         
        if(palo.getClass().getSimpleName().equals("PalosBarajaEspañola")){
             
            switch(numero){
                case 1:
                    nombreFigura="As";
                    break;
                case 10:
                    nombreFigura="Sota";
                    break;
                case 11:
                    nombreFigura="Caballo";
                    break;
                case 12:
                    nombreFigura="Rey";
                    break;
                default:
                    nombreFigura=numero+"";
            }
             
             
             
             
        }else if(palo.getClass().getSimpleName().equals("PalosBarajaFrancesa")){
             
            switch(numero){
                case 1:
                    nombreFigura="As";
                    break;
                case 11:
                    nombreFigura="Jota";
                    break;
                case 12:
                    nombreFigura="Reina";
                    break;
                case 13:
                    nombreFigura="Rey";
                    break;
                default:
                    nombreFigura=numero+"";
            }
             
        }
         
        estado = nombreFigura + " de "+ palo;
         
        return estado;
         
    }
     
}
— Baraja

/**
 * Clase Baraja
 *
 * @author Disco Duro de Roer
 */
public abstract class Baraja<T> {
 
    //Atributos
    protected Carta<T> cartas[];
    protected int posSiguienteCarta;
    protected int numCartas;
    protected int cartasPorPalo;
 
    public Baraja() {
        this.posSiguienteCarta = 0;
    }
 
    /**
     * Metodo abstracto crearBaraja
     */
    public abstract void crearBaraja();
 
    /**
     * Baraja todas las cartas
     */
    public void barajar() {
 
        int posAleatoria = 0;
        Carta c;
 
        //Recorro las cartas
        for (int i = 0; i < cartas.length; i++) {
 
            posAleatoria = Metodos.generaNumeroEnteroAleatorio(0, numCartas - 1);
 
            //intercambio
            c = cartas[i];
            cartas[i] = cartas[posAleatoria];
            cartas[posAleatoria] = c;
 
        }
 
        //La posición vuelve al inicio
        this.posSiguienteCarta = 0;
 
    }
 
    /**
     * Devuelve la casta donde se encuentre "posSiguienteCarta"
     *
     * @return carta del arreglo
     */
    public Carta siguienteCarta() {
 
        Carta c = null;
 
        if (posSiguienteCarta == numCartas) {
            System.out.println("Ya no hay mas cartas, barajea de nuevo");
        } else {
            c = cartas[posSiguienteCarta++];
        }
 
        return c;
 
    }
 
    /**
     * Devuelve un numero de cartas. Controla si hay mas cartas de las que se
     * piden
     *
     * @param numCartas
     * @return
     */
    public Carta[] darCartas(int numCartas) {
 
        if (numCartas > numCartas) {
            System.out.println("No se puede dar mas cartas de las que hay");
        } else if (cartasDisponible() < numCartas) {
            System.out.println("No hay suficientes cartas que mostrar");
        } else {
 
            Carta[] cartasDar = new Carta[numCartas];
 
            //recorro el array que acabo de crear para rellenarlo
            for (int i = 0; i < cartasDar.length; i++) {
                cartasDar[i] = siguienteCarta(); //uso el metodo anterior
            }
 
            //Lo devuelvo
            return cartasDar;
 
        }
 
        //solo en caso de error
        return null;
 
    }
 
    /**
     * Indica el numero de cartas que hay disponibles
     *
     * @return
     */
    public int cartasDisponible() {
        return numCartas - posSiguienteCarta;
    }
 
    /**
     * Muestro las cartas que ya han salido
     */
    public void cartasMonton() {
 
        if (cartasDisponible() == numCartas) {
            System.out.println("No se ha sacado ninguna carta");
        } else {
            //Recorro desde 0 a la posSiguienteCarta
            for (int i = 0; i < posSiguienteCarta; i++) {
                System.out.println(cartas[i]);
            }
        }
 
    }
 
    /**
     * Muestro las cartas que aun no han salido
     */
    public void mostrarBaraja() {
 
        if (cartasDisponible() == 0) {
            System.out.println("No hay cartas que mostrar");
        } else {
            for (int i = posSiguienteCarta; i < cartas.length; i++) {
                System.out.println(cartas[i]);
            }
        }
 
    }
 
}
— Baraja Española

/**
 * Baraja Española
 * @author Disco Duro de Roer
 */
public class BarajaEspañola extends Baraja {
 
    private boolean incluye_8_9;
 
    public BarajaEspañola(boolean incluye_8_9) {
        super();
 
        this.incluye_8_9 = incluye_8_9;
 
        if (incluye_8_9) {
            numCartas = 48;
            cartasPorPalo = 12;
        } else {
            numCartas = 40;
            cartasPorPalo = 10;
        }
 
        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }
 
    @Override
    public void crearBaraja() {
 
        this.cartas = (Carta<PalosBarajaEspañola>[]) new Carta[numCartas];
 
        PalosBarajaEspañola[] palos = PalosBarajaEspañola.values();
 
        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {
 
            //Recorro los numeros
            for (int j = 0; j < cartasPorPalo; j++) { if (incluye_8_9) { cartas[((i * cartasPorPalo) + j)] = new Carta(j + 1, palos[i]); } else { //Las posiciones del 8 y del 9 son el 7 y el 8 (emepzamos en 8) if (j >= 7) {
                        //Solo para la sota, caballo y rey
                        cartas[((i * cartasPorPalo) + j)] = new Carta(j + 3, palos[i]);
                    } else {
                        //Para los casos de 1 a 7
                        cartas[((i * cartasPorPalo) + j)] = new Carta(j + 1, palos[i]);
                    }
                }
 
            }
 
        }
 
    }
 
}
–Baraja Francesa

/**
 * Baraja francesa
 * @author Disco Duro de Roer
 */
public class BarajaFrancesa extends Baraja {
 
    public BarajaFrancesa() {
        super();
 
        this.numCartas = 52;
        this.cartasPorPalo = 13;
 
        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }
 
    @Override
    public void crearBaraja() {
 
        this.cartas = (Carta<PalosBarajaFrancesa>[]) new Carta[numCartas];
 
        PalosBarajaFrancesa[] palos = PalosBarajaFrancesa.values();
 
        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {
 
            //Recorro los numeros
            for (int j = 0; j < cartasPorPalo; j++) {
                cartas[((i * cartasPorPalo) + j)] = new Carta(j + 1, palos[i]);
            }
 
        }
 
    }
 
    public boolean cartaRoja(Carta<PalosBarajaFrancesa> c) {
        return c.getPalo() == PalosBarajaFrancesa.CORAZONES || c.getPalo() == PalosBarajaFrancesa.DIAMANTES;
    }
 
    public boolean cartaNegra(Carta<PalosBarajaFrancesa> c) {
        return c.getPalo() == PalosBarajaFrancesa.TREBOLES || c.getPalo() == PalosBarajaFrancesa.PICAS;
    }
 
}
–Metodos

/**
 * Clase Metodos, contiene métodos estaricos sueltos
 * @author Disco Duro de Roer
 */
public class Metodos {
 
    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }
 
}
— Main

public class Ejercicio_POO_DDR_12 {
 
    public static void main(String[] args) {
         
        //Creamos la baraja
        BarajaFrancesa b = new BarajaFrancesa();
         
        //Mostramos las cartas disponibles (40)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");
        
        //Saco una carta
        b.siguienteCarta();
         
        //Saco 5 cartas
        b.darCartas(5);
         
        //Mostramos las cartas disponibles (34)
        System.out.println("Hay "+b.cartasDisponible()+" cartas disponibles");
        
        System.out.println("Cartas sacadas de momento");
         
        b.cartasMonton();
         
         
        //Barajamos de nuevo
        b.barajar();
        
        //Saco 5 cartas
        Carta[] c = b.darCartas(5);
         
        System.out.println("Cartas sacadas despues de barajar ");
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
         
    }
     
}