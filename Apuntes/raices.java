7) Vamos a realizar una clase llamada Raices, donde representaremos los valores de una ecuación de 2º grado.
Tendremos los 3 coeficientes como atributos, llamémosles a, b y c.
Hay que insertar estos 3 valores para construir el objeto.
Las operaciones que se podrán hacer son las siguientes:

obtenerRaices(): imprime las 2 posibles soluciones
obtenerRaiz(): imprime única raíz, que será cuando solo tenga una solución posible.
getDiscriminante(): devuelve el valor del discriminante (double), el discriminante tiene la siguiente formula, (b^2)-4*a*c
tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para que esto ocurra, el discriminante debe ser mayor o igual que 0.
tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para que esto ocurra, el discriminante debe ser igual que 0.
calcular(): mostrara por consola las posibles soluciones que tiene nuestra ecuación, en caso de no existir solución, mostrarlo también.
Formula ecuación 2º grado: (-b±√((b^2)-(4*a*c)))/(2*a)
Solo varia el signo delante de -b


–Clase Raices

/**
 * Clase Raices
 * Representa una ecuacion de 2º grado
 * @author discoduroderoer
 */
public class Raices {
     
    /*Atributos*/
    private double a;
    private double b;
    private double c;
     
    /**
     * Ecuacion de 2º grado
     * @param a
     * @param b
     * @param c 
     */
    public Raices(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
     
    /**
     * Metodos para obtener las raices cuando hay 2 soluciones posibles
     */
    private void obtenerRaices(){
         
        double x1=(-b+Math.sqrt(getDiscriminante()))/(2*a);
        double x2=(-b-Math.sqrt(getDiscriminante()))/(2*a);
         
        System.out.println("Solucion X1");
        System.out.println(x1);
        System.out.println("Solucion X2");
        System.out.println(x2);
    }
     
    /**
     * Obtiene una unica raiz, cuando solo tiene la posibilidad de er una solucion
     */
    private void obtenerRaiz(){
         
        double x=(-b)/(2*a);
         
        System.out.println("Unica solucion");
        System.out.println(x);
         
    }
     
    /**
     * Nos devuelve el valor del discriminante,  
     * @return 
     */
    private double getDiscriminante(){
        return Math.pow(b, 2)-(4*a*c);
    }
     
    /**
     * Si el discriminante es mayor que 0 tiene mas de una raiz
     * (No hemos puesto >= ya que puede confundirse con una solucion)
     * @return 
     */
    private boolean tieneRaices(){
        return getDiscriminante()>0;
    }
     
    /**
     * Si el discriminante es igual a cero tiene una sola raiz
     * @return 
     */
    private boolean tieneRaiz(){
        return getDiscriminante()==0;
    }
     
    /**
     * Nos permite calcular las raices de una ecuacion de 2º grado
     */
    public void calcular(){
         
        if(tieneRaices()){
            obtenerRaices();
        }else if(tieneRaiz()){
            obtenerRaiz();
        }else{
            System.out.println("No tiene soluciones");
        }
         
    }
     
}

–Clase Principal

public class Principal {
 
    public static void main(String[] args) {
       Raices ecuacion=new Raices(1,4,4); //creamos el objeto
       ecuacion.calcular(); //Calculamos
        
    }
     
}

