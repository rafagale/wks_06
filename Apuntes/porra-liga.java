11) Estando en un grupo de amigos, se planea hacer una porra de la liga de fútbol. A nosotros se nos ocurre hacer un programa en POO para simular como podría desarrollarse la porra.

Cada jugador de la porra, pone un 1 euro cada jornada y decide el resultado de los partidos acordados.

Si nadie acierta en una jornada los resultados, el bote se acumula.

En principio, deben acertar el resultado de dos partidos para llevarse el dinero del bote de la porra.

Todos empiezan con un dinero inicial que será decidido por el programador (ya sea como parámetro o como constante). Si el jugador no tiene dinero en una jornada no podrá jugar la porra.

Para esta versión, entre jugadores podrán repetir resultados repetidos, por lo que el jugador que primero diga ese resultado (tal como estén de orden) se llevara primero el bote.

Los resultados de la porra serán generados aleatoriamente, tanto los de jugador como los de los partidos (no es necesario nombre, solo resultados).

Al final del programa, se deberá mostrar el dinero que tienen los jugadores y el número de veces que han ganado.

Para este ejercicio, recomiendo usar interfaces (no hablo de interfaces gráficas) para las constantes y métodos que sean necesarios

— Constantes

/**
 * Interfaz Constantes
 * @author Disco Duro de Roer
 */
public interface Constantes {
    public final int NUMERO_PARTIDOS=2;
     
    public final int NUMERO_JORNADAS=38;
    public final double DINERO_INICIAL=35;
     
    public final int RESULTADO_MINIMO=0;
    public final int RESULTADO_MAXIMO=3;
     
    public final double DINERO_CADA_JORNADA=1;
     
    public final Jugador[] JUGADORES={ 
                                    new Jugador("Make"),
                                    new Jugador("JuanMa"),
                                    new Jugador("Fernando"),
                                    new Jugador("Alberto"),
                                    new Jugador("Lorente"),
                                    new Jugador("Adrian"),
                                    new Jugador("Maria"),
                                    new Jugador("Parra"),
                                    new Jugador("Pablo"),
                                    new Jugador("Prieto"),
                                    new Jugador("Ruben"),
                                    new Jugador("Jony"),
                                    new Jugador("Fran"),
                                    new Jugador("Isidoro"),
                                    new Jugador("Rafa")
                                };
}
— Jugador

/**
 * Clase Jugador
 * @author Disco Duro de Roer
 */
public class Jugador implements Constantes, MetodosInterfaz{
  
    private String nombre;
    private double dinero;
    private int porrasGanadas;
    private String[] resultados;
     
    public Jugador(String nombre){
        this.nombre=nombre;
        this.dinero = DINERO_INICIAL;
        this.porrasGanadas=0;
        this.resultados = new String[NUMERO_PARTIDOS];
        reiniciarResultados();
    }
     
    public void reiniciarResultados(){
         
        for(int i=0;i<resultados.length;i++){
            resultados[i]="";
        }
         
    }
     
    public boolean puedePagar(){
        return dinero>=DINERO_CADA_JORNADA;
    }
     
    public void ponerEnElBote(){
        dinero-=DINERO_CADA_JORNADA;
        System.out.println("Jugador "+nombre+" ha puesto "+DINERO_CADA_JORNADA+" euro/s y le queda "+dinero+" euro/s");
    }
     
    public void ganarBote(double bote){
        dinero+=bote;
        porrasGanadas++;
        System.out.println("Jugador "+nombre+" ha ganado "+bote+" euro/s y tiene "+dinero+" euro/s");
    }
     
    @Override
    public void generarResultados() {
         
        int pLocal, pVisitante;
         
        for(int i=0;i<resultados.length;i++){
            pLocal = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            pVisitante = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
             
            resultados[i] = pLocal +" - "+pVisitante;
             
            System.out.println("El Jugador "+nombre+" ha elegido el resultado "+resultados[i]);
             
        }
        System.out.println("");
    }
     
    public boolean haAcertadoPorra(String[] resultados_partidos){
         
        for(int i=0;i<resultados.length;i++){
            if(!resultados[i].equals(resultados_partidos[i])){
                return false;
            }    
        }
        return true;
         
    }
     
 
    @Override
    public String toString() {
        return "El jugador " + nombre + " tiene dinero=" + dinero + " y ha ganado " + porrasGanadas + " porra/s";
    }
     
}
— Métodos

**
 * Clase Métodos
 * @author Disco Duro de Roer
 */
public class Metodos {
     
    /**
     * Genera un numero aleatorio entre un minimo y un maximo
     * @param minimo
     * @param maximo
     * @return 
     */
     public static int generaNumeroAleatorio(int minimo, int maximo){
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
}
— Métodos Interfaz

public interface MetodosInterfaz {
     
    public void generarResultados();
     
}
— POOrra

/**
 * Clase POOrra
 * @author Disco Duro de Roer
 */
public class POOrra implements Constantes{
     
    private double bote;
     
    public POOrra(){
        bote=0;
    }
     
    /**
     * Aumenta la cantidad del bote
     * @param dinero 
     */
    public void aumentarBote(double dinero){
        bote+=dinero;
    }
     
    /**
     * Dejamos el bote a 0
     */
    public void vacirBote(){
        bote=0;
    }
     
    /**
     * Metodo principal que simula el transcurso de la porra
     */
    public void jornadas(){
         
        Resultados resultados = new Resultados();
        String[] partidos;
         
        //Recorremos las jornadas
        for(int i=0;i<NUMERO_JORNADAS;i++){
             
            System.out.println("JORNADA "+(i+1));
            System.out.println("");
             
            //Apuesta
            for(int j=0;j<JUGADORES.length;j++){
                //Si un jugador puede pagar
                if(JUGADORES[j].puedePagar()){
                    //el jugador paga, dice sus resultados y el bote se aumenta
                    JUGADORES[j].ponerEnElBote();
                    JUGADORES[j].generarResultados();
                    aumentarBote(DINERO_CADA_JORNADA);
                }else{
                    //Si no puede pagar, los resultados se vacian
                    JUGADORES[j].reiniciarResultados();
                }
                 
            }
             
             
            //Partido
            resultados.generarResultados();
            partidos = resultados.getPartidos();
             
            //Comprobacion
            for(int j=0;j<JUGADORES.length;j++){
                //Indica si ha acertado
                if (JUGADORES[j].haAcertadoPorra(partidos)){
                    //Le damos el bota al jugador y vaciamos el bote
                    JUGADORES[j].ganarBote(bote);
                    vacirBote();
                }
                 
            }
             
            System.out.println("");
            System.out.println("");
             
            System.out.println(toString());
             
            System.out.println("");
            System.out.println("");
             
        }
         
        //Motramos el estado de los jugadores
        for(int i=0;i<JUGADORES.length;i++){
            System.out.println(JUGADORES[i]);
        }
         
    }
 
    @Override
    public String toString() {
        return "En la POOrra hay de bote" + bote + " euro/s";
    }
     
}
— Resultados

/**
 * Clase Resultados
 * @author Disco Duro de Roer
 */
public class Resultados implements Constantes,MetodosInterfaz{
     
    private String[] partidos;
 
    public Resultados() {
        partidos=new String[NUMERO_PARTIDOS];
    }
 
    /**
     * Genera los resultado del partido
     */
    @Override
    public void generarResultados() {
         
        int pLocal, pVisitante;
         
        for(int i=0;i<partidos.length;i++){
            //Generamos los resultados
            pLocal = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
            pVisitante = Metodos.generaNumeroAleatorio(RESULTADO_MINIMO, RESULTADO_MAXIMO);
             
            partidos[i] = pLocal +" - "+pVisitante;
             
            System.out.println("El partido "+(i+1)+" ha generado el resultado "+partidos[i]);
        }
         
    }
 
    public String[] getPartidos() {
        return partidos;
    }
 
}
— Main

public class Ejercicio_POO_DDR_06 {
 
    public static void main(String[] args) {
        POOrra p = new POOrra();
        p.jornadas();
         
    }
     
}

