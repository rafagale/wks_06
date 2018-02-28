17) Una academia nos pide hacer un programa para hacer un pequeño test a sus alumnos.

Estas preguntas, para facilitar la inclusión, estarán escritas en un txt (incluido en la descarga del proyecto).

Una opción se compone de:

El texto de la opción (digamos la respuesta)
Es correcto o no
Una pregunta consta de:

Pregunta (tendrá delante dos puntos y coma ;P;)
Opciones de la pregunta (entre 2 y 4)
Opción correcta (tendrá delante dos puntos y coma ;R;)
Puntos
La pregunta no será válida en los siguientes casos:

Las opciones no están entre 2 y 4.
La opción correcta esta entre el número de opciones y es un número.
Los puntos es un número entero.
Sus métodos son:

mostrarPregunta(): muestra la pregunta con sus opciones.
comprobarRespuesta(int respuestaUsuario): comprueba la respuesta del usuario si es correcta o no.
Getter de los atributos.
Un test está formado por un conjunto preguntas y los puntos acumulados. Piensa que debemos saber por cual pregunta vamos.

Sus métodos son:

cargarPreguntas(String fichero): carga todas las preguntas del fichero
siguientePregunta(): devuelve la siguiente pregunta
reiniciarTest(): nos permite reiniciar el test.
realizarTest(): empieza el test y empieza a formular las preguntas
El fichero de preguntas tiene el siguiente formato:

;P;Pregunta 1

Opción 1 pregunta 1

Opción 2 pregunta 1

Opción 3 pregunta 1

Opción 4 pregunta 1

;R;Numero opción correcta

Puntos pregunta 1

;P;Pregunta 2

Opción 1 pregunta 2

Opción 2 pregunta 2

…

…



— Nodo

/**
 * Clase Nodo
 *
 * @author DiscoDurodeRoer
 * @param <T>
 */
public class Nodo<T> {
 
    //Atributos
    private T elemento;
    private Nodo<T> siguiente; //Apunta al siguiente nodo
 
    //Contructor
    public Nodo(T elemento, Nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
 
    //Metodos
    public T getElemento() {
        return elemento;
    }
 
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
 
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
 
    @Override
    public String toString() {
        return elemento + "n";
    }
 
     
     
}
— Lista dinamica

/**
 * Lista Dinamica Version 2.0
 *
 * @author DiscoDurodeRoer
 */
public class ListaDinamica<T> {
 
    //Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;
 
    public ListaDinamica() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }
 
    /**
     * Indica si esta la lista vacia o no
     *
     * @return
     */
    public boolean isEmpty() {
        return tamanio == 0;
    }
 
    /**
     * Devuelve el tamaño de la lista
     *
     * @return
     */
    public int size() {
        return tamanio;
    }
 
    /**
     * Devuelve el elemento en la posicion indicada
     *
     * @param index
     * @return
     */
    public T get(int index) {
 
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getFirst(); //Cojo el primero
        } else if (index == size() - 1) {
            return getLast(); //Cojo el ultimo
        } else {
 
            //Uso la funcion getNode para coger el nodo deseado
            Nodo<T> buscado = getNode(index);
 
            return buscado.getElemento();
 
        }
 
    }
 
    /**
     * Devuelve el primer elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getFirst() {
        //Si esta vacia, no hay primero que coger
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }
 
    /**
     * Devuelve el ultimo elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }
 
    /**
     * Devuelve el nodo completo de una posicion concreta
     *
     * @param index
     * @return
     */
    private Nodo<T> getNode(int index) {
 
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {
 
            Nodo<T> buscado = primero;
 
            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }
 
            //Me devuelve el buscado
            return buscado;
 
        }
 
    }
 
    /**
     * Añade un elemento al final de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addLast(T elemento) {
 
        Nodo<T> aux;
 
        //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (isEmpty()) {
            return addFirst(elemento);
        } else {
 
            //Hago el intercambio
            aux = new Nodo<>(elemento, null);
 
            ultimo.setSiguiente(aux);
            ultimo = aux;
 
        }
 
        //Aumento el tamanño
        tamanio++;
        return ultimo.getElemento();
 
    }
 
    /**
     * Añade el elemento al principio de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addFirst(T elemento) {
 
        Nodo<T> aux;
 
        //si esta vacia, el nodo será el primero y ultimo
        if (isEmpty()) {
            aux = new Nodo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            Nodo<T> primeroActual = primero;
            aux = new Nodo<>(elemento, primeroActual);
            primero = aux;
 
        }
 
        //Aumento el tamanño
        tamanio++;
        return primero.getElemento();
 
    }
 
    /**
     * Añade un elemento en una posicion indicada
     *
     * @param elemento
     * @param index debe ser un indice valido
     * @return elemento añadido
     */
    public T add(T elemento, int index) {
 
        //si esta vacio o el indice no es correcto, devuelve null
        if (index == 0) {
            return addFirst(elemento); //Añade en la primera posicion
        } else if (index == size()) {
            return addLast(elemento); //añade en la ultima posicion
        } else if ((index < 0 || index >= size())) {
            return null;
        } else {
 
            //Cojo el anterior nodo al que estoy buscando
            Nodo<T> buscado_anterior = getNode(index - 1);
 
            //Cojo el nodo de la posicion indicada
            Nodo<T> buscado_actual = getNode(index);
 
            //Creo el nuevo novo, este apuntara al de la posicion actual
            Nodo<T> aux = new Nodo<>(elemento, buscado_actual);
 
            //el nodo anterior apunta a nuestro nuevo nodo
            buscado_anterior.setSiguiente(aux);
 
            //Aumento el tamaño
            tamanio++;
            return getNode(index).getElemento();
 
        }
 
    }
 
    /**
     * Devuelve el estado de la lista
     *
     * @return
     */
    public String toString() {
 
        String contenido = "";
 
        //Si esta vacia, lo indica
        if (isEmpty()) {
            contenido = "Lista vacia";
        } else {
 
            Nodo<T> aux = primero;
 
            //Recorre la lista, mostrando el contenido
            while (aux != null) {
                contenido += aux.toString();
                aux = aux.getSiguiente();
            }
 
        }
 
        return contenido;
 
    }
 
    /**
     * Indica si existe el elemento indicado
     *
     * @param elemento
     * @return
     */
    public boolean exists(T elemento) {
 
        //Si esta vacio, devuelve el false
        if (isEmpty()) {
            return false;
        } else {
 
            Nodo<T> aux = primero;
 
            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }
 
            //Si no lo encuentra devuelve false
            return false;
 
        }
    }
 
    /**
     * Indica la posición del elemento
     *
     * @param elemento
     * @return
     */
    public int indexOf(T elemento) {
 
        //Si esta vacio, devuelvemos -1
        if (isEmpty()) {
            return -1;
        } else {
 
            Nodo<T> aux = primero;
 
            int posicion = 0;
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return posicion; //Existe
                }
                posicion++;
                aux = aux.getSiguiente();
            }
            //Si no lo encuentra devuelve -1
            return -1;
 
        }
 
    }
 
    /**
     * Elimina el primer elemento de la lista
     *
     * @return
     */
    public T removeFirst() {
 
        //Si la lista esta vacia, devolvemos null
        if (isEmpty()) {
            return null;
        } else {
 
            //Guardo el elemento antes
            T elemento = primero.getElemento();
 
            //Cojo el segundo
            Nodo<T> aux = primero.getSiguiente();
            primero = null; //Lo marco como null para el recolector
            primero = aux; //Este es mi nuevo primero
 
            //En caso de que borremos el ultimo elemento,el ultimo también
            if (size() == 1) {
                ultimo = null;
            }
 
            tamanio--;
 
            return elemento;
 
        }
 
    }
 
    /**
     * Borra el ultimo elemento de la lista
     *
     * @return
     */
    public T removeLast() {
 
        if (isEmpty()) {
            return null;
        } else {
 
            //Coge el elemento antes de borrar
            T elemento = ultimo.getElemento();
 
            //Cojo el penultimo
            Nodo<T> aux = getNode(size() - 2);
 
            //En caso de que sea null
            //Hay 1 o dos elementos
            if (aux == null) {
 
                //marco el ultimo como nulo
                ultimo = null;
                //Si hay dos, el primero y el ultimo seran el mismo
                //Si hay 1 elemento, significa que borramos la lista
                if (size() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }
 
            } else {
                //el penultimo es el nuevo ultimo 
                //y le ponemos como siguiente nulo
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }
 
            tamanio--;
 
            return elemento;
 
        }
 
    }
 
    /**
     * Elimina el nodo de la lista en una posicion concreta
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
 
            //Cojo el nodo anterior al que quiero borrar
            Nodo<T> nodo_anterior = getNode(index - 1);
 
            //Cojo el nodo que quiero borrar
            Nodo<T> nodo_actual = getNode(index);
 
            //Cojo el elemento antes de borrar
            T elemento = nodo_actual.getElemento();
 
            //Cojo el nodo siguiente al que quiero borrar
            Nodo<T> nodo_siguiente = nodo_actual.getSiguiente();
 
            //Lo marco para borrar para el recolector
            nodo_actual = null;
 
            //El nodo anterior apunta al nodo siguiente
            nodo_anterior.setSiguiente(nodo_siguiente);
 
            tamanio--;
 
            return elemento;
 
        }
    }
 
    /**
     * Modifico el elemento de una posicion No afecta a la estructura de la
     * lista
     *
     * @param elemento
     * @param index
     * @return
     */
    public T modify(T elemento, int index) {
 
        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else {
 
            //Nodo actual
            Nodo<T> aux = getNode(index);
 
            //modifico
            aux.setElemento(elemento);
 
            return aux.getElemento();
 
        }
 
    }
 
}
— Leer

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
 
/**
 * Clase para gestionar entrada de datos y validaciones
 *
 * @author DiscoDurodeRoer
 */
public class Leer {
 
    //Scanner para pedir datos
    private Scanner sc;
 
    /**
     * Por defecto
     */
    public Leer() {
        sc = new Scanner(System.in);
        sc.useDelimiter("n"); //Usado para nextLine()
        sc.useLocale(Locale.US); // Para double
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte() {
 
        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero byte");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero byte");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte(String mensaje) {
 
        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero byte");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByte(String mensaje, String mensajeError) {
 
        byte num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo() {
 
        byte num;
        do {
            try {
                System.out.println("Introduce un numero entero byte positivo");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero byte positivo");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo(String mensaje) {
 
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero byte positivo");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public byte pedirBytePositivo(String mensaje, String mensajeError) {
 
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println(mensajeError);
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo() {
        byte num;
        do {
            try {
                System.out.println("Introduce un numero entero byte negativo");
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero byte negativo");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo(String mensaje) {
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero byte negativo");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public byte pedirByteNegativo(String mensaje, String mensajeError) {
        byte num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo) {
        byte num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero byte entre " + minimo + " y " + maximo);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero byte entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo, String mensaje) {
        byte num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero byte entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public byte pedirByteRango(byte minimo, byte maximo, String mensaje, String mensajeError) {
        byte num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            byte aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextByte();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public int pedirInt() {
 
        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero integer");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirInt(String mensaje) {
 
        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero integer");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public int pedirInt(String mensaje, String mensajeError) {
 
        int num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo() {
 
        int num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo integer");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo(String mensaje) {
 
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo integer");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero positivo introducido por el usuario
     */
    public int pedirIntPositivo(String mensaje, String mensajeError) {
 
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println(mensajeError);
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo() {
        int num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo integer");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo integer");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo(String mensaje) {
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo integer");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero negativo introducido por el usuario
     */
    public int pedirIntNegativo(String mensaje, String mensajeError) {
        int num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo) {
        int num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero integer entre " + minimo + " y " + maximo);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje) {
        int num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje, String mensajeError) {
        int num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide una cadena
     *
     * @return cadena introducida por el usuario
     */
    public String pedirString() {
 
        System.out.println("Introduce una cadena");
        String cadena = sc.next();
 
        return cadena;
 
    }
 
    /**
     * Pide una cadena
     *
     * @param mensaje
     * @return cadena introducida por el usuario
     */
    public String pedirString(String mensaje) {
 
        System.out.println(mensaje);
        String cadena = sc.next();
 
        return cadena;
 
    }
 
    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima) {
 
        String cadena = "";
        do {
            System.out.println("Introduce una cadena");
            cadena = sc.next();
             
            if(!(cadena.length() < longitudMaxima)){
                System.out.println("Error, la longitud maxima es "+longitudMaxima+" caracteres");
            }
             
        } while (!(cadena.length() < longitudMaxima));
 
        return cadena;
 
    }
 
    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @param mensaje
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima, String mensaje) {
 
        String cadena = "";
        do {
            System.out.println(mensaje);
            cadena = sc.next();
             
            if(!(cadena.length() < longitudMaxima)){
                System.out.println("Error, la longitud maxima es "+longitudMaxima+" caracteres");
            }
             
        } while (!(cadena.length() < longitudMaxima));
 
        return cadena;
 
    }
     
    /**
     * Pide una cadena con una longitud maxima
     *
     * @param longitudMaxima
     * @param mensaje
     * @param mensajeError
     * @return cadena introducida por el usuario
     */
    public String pedirString(int longitudMaxima, String mensaje, String mensajeError) {
 
        String cadena = "";
        do {
            System.out.println(mensaje);
            cadena = sc.next();
             
            if(!(cadena.length() < longitudMaxima)){
                System.out.println(mensajeError);
            }
             
        } while (!(cadena.length() < longitudMaxima));
 
        return cadena;
 
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public long pedirLong() {
 
        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero long");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public long pedirLong(String mensaje) {
 
        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero long");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public long pedirLong(String mensaje, String mensajeError) {
 
        long num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo() {
 
        long num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo long");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo(String mensaje) {
 
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo long");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public long pedirLongPositivo(String mensaje, String mensajeError) {
 
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println(mensajeError);
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo() {
        long num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo long");
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo long");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo(String mensaje) {
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo long");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public long pedirLongNegativo(String mensaje, String mensajeError) {
        long num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo) {
        long num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero long entre " + minimo + " y " + maximo);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero long entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo, String mensaje) {
        long num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero long entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public long pedirLongRango(long minimo, long maximo, String mensaje, String mensajeError) {
        long num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextLong();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @return numero entero introducido por el usuario
     */
    public short pedirShort() {
 
        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero entero short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero short");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public short pedirShort(String mensaje) {
 
        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println("Error, introducce un numero entero short");
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Nos pide un valor númerico, valida si es un valor numerico
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public short pedirShort(String mensaje, String mensajeError) {
 
        short num = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            //En caso de error, muestro el error
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo() {
 
        short num;
        do {
            try {
                System.out.println("Introduce un numero entero positivo short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo short");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo(String mensaje) {
 
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println("Error, introducce un numero entero positivo short");
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un valor entero positivo, valida que sea un numero y que sea
     * positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte positivo introducido por el usuario
     */
    public short pedirShortPositivo(String mensaje, String mensajeError) {
 
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno negativo
                num = -1;
                sc.next();
            }
 
            if (num < 0) {
                System.out.println(mensajeError);
            }
 
        } while (num < 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo() {
        short num;
        do {
            try {
                System.out.println("Introduce un numero entero negativo short");
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo short");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo(String mensaje) {
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println("Error, introducce un numero entero negativo short");
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entero negativo, valida que sea un numero y sea negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte negativo introducido por el usuario
     */
    public short pedirShortNegativo(String mensaje, String mensajeError) {
        short num;
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como uno positivo
                num = 1;
                sc.next();
            }
 
            if (num >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (num >= 0);
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(long minimo, long maximo) {
        short num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            long aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero short entre " + minimo + " y " + maximo);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero short entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(short minimo, short maximo, String mensaje) {
        short num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            short aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero short entre " + minimo + " y " + maximo);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero byte introducido por el usuario
     */
    public short pedirShortRango(short minimo, short maximo, String mensaje, String mensajeError) {
        short num;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            short aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                num = sc.nextShort();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = (byte) (maximo + 1);
                sc.next();
            }
 
            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(num >= minimo && num <= maximo));
 
        return num;
    }
 
    /**
     * Pide un double, valida que sea un numero
     *
     * @return double introducido por el usuario
     */
    public double pedirDouble() {
 
        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double, valida que sea un numero
     *
     * @param mensaje
     * @return double introducido por el usuario
     */
    public double pedirDouble(String mensaje) {
 
        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real");
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double, valida que sea un numero
     *
     * @param mensaje
     * @param mensajeError
     * @return double introducido por el usuario
     */
    public double pedirDouble(String mensaje, String mensajeError) {
 
        double real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo() {
 
        double real;
        do {
            try {
                System.out.println("Introduce un numero real positivo double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo(String mensaje) {
 
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un double positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return double positivo introducido por el usuario
     */
    public double pedirDoublePositivo(String mensaje, String mensajeError) {
 
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println(mensajeError);
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo() {
        double real;
        do {
            try {
                System.out.println("Introduce un numero real negativo double");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo double");
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo(String mensaje) {
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo double");
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un double negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return double negativo introducido por el usuario
     */
    public double pedirDoubleNegativo(String mensaje, String mensajeError) {
        double real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo) {
 
        double real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero double entre " + minimo + " y " + maximo);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero double entre " + minimo + " y " + maximo + " como maximo");
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
 
    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo, String mensaje) {
 
        double real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero double entre " + minimo + " y " + maximo + " como maximo");
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
 
    /**
     * Pide un double entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return double entre un rango introducido por el usuario
     */
    public double pedirDoubleRango(double minimo, double maximo, String mensaje, String mensajeError) {
 
        double real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            double aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
 
    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real double con "+decimales+" decimales como maximo");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales, String mensaje) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real double");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return double con un double con unos decimales menos que lo indicado
     */
    public double pedirDoubleDecimales(int decimales, String mensaje, String mensajeError) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        double real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales) {
 
        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println("Introduce un numero real positivo double con "+decimales+" decimales como maximo");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales, String mensaje) {
 
        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo double");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un double positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return double con un double positivo con unos decimales menos que lo
     * indicado
     */
    public double pedirDoublePositivoDecimales(int decimales, String mensaje, String mensajeError) {
 
        double real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float, valida que sea un numero
     *
     * @return float introducido por el usuario
     */
    public float pedirFloat() {
 
        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float, valida que sea un numero
     *
     * @param mensaje
     * @return float introducido por el usuario
     */
    public float pedirFloat(String mensaje) {
 
        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float, valida que sea un numero
     *
     * @param mensaje
     * @param mensajeError
     * @return float introducido por el usuario
     */
    public float pedirFloat(String mensaje, String mensajeError) {
 
        float real = 0;
        boolean correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                // En caso de error, se marca como incorrecto
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo() {
 
        float real;
        do {
            try {
                System.out.println("Introduce un numero real positivo float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo(String mensaje) {
 
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float positivo, valida que sea un numero y positivo
     *
     * @param mensaje
     * @param mensajeError
     * @return float positivo introducido por el usuario
     */
    public float pedirFloatPositivo(String mensaje, String mensajeError) {
 
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println(mensajeError);
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo() {
        float real;
        do {
            try {
                System.out.println("Introduce un numero real negativo float");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo float");
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo(String mensaje) {
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println("Error, introducce un numero real negativo float");
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un float negativo, valida que sea un numero y negativo
     *
     * @param mensaje
     * @param mensajeError
     * @return float negativo introducido por el usuario
     */
    public float pedirFloatNegativo(String mensaje, String mensajeError) {
        float real;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = 1;
                sc.next();
            }
 
            if (real >= 0) {
                System.out.println(mensajeError);
            }
 
        } while (real >= 0);
 
        return real;
    }
 
    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo) {
 
        float real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println("Introduce un numero float entre " + minimo + " y " + maximo);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero float entre " + minimo + " y " + maximo + " como maximo");
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
 
    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo, String mensaje) {
 
        float real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println("Error, Introduce un numero float entre " + minimo + " y " + maximo + " como maximo");
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
 
    /**
     * Pide un float entre en un rango, valida que sea un numero
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return float entre un rango introducido por el usuario
     */
    public float pedirFloatRango(float minimo, float maximo, String mensaje, String mensajeError) {
 
        float real;
 
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            float aux = minimo;
            minimo = maximo;
            maximo = aux;
        }
 
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = maximo + 1;
                sc.next();
            }
 
            if (!(real >= minimo && real <= maximo)) {
                System.out.println(mensajeError);
            }
 
        } while (!(real >= minimo && real <= maximo));
 
        return real;
    }
     
    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @return  float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un numero real float con "+decimales+" decimales como maximo");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real float");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return  float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales, String mensaje) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un numero real float con "+decimales+" decimales como maximo");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return  float con unos decimales menos que lo indicado
     */
    public float pedirFloatDecimales(int decimales, String mensaje, String mensajeError) {
 
        if (decimales < 1) {
            decimales = 1;
        }
 
        float real = 0;
        boolean correcto;
        String[] parteDecimal;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                correcto = false;
                sc.next();
            }
 
            if (!correcto) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    correcto = false;
                    System.out.println("Error, el numero de decimales debe ser " + decimales + " como maximo");
                }
            }
 
        } while (!correcto);
 
        return real;
 
    }
 
    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @return float positivo con unos decimales menos que lo
     * indicado
     */
    public float pedirFloatPositivoDecimales(int decimales) {
 
        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println("Introduce un numero real positivo float con "+decimales+" decimales como maximo");
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @return double con un float positivo con unos decimales menos que lo
     * indicado
     */
    public float pedirFloatPositivoDecimales(int decimales, String mensaje) {
 
        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println("Error, introducce un numero real positivo float");
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un float positivo, con un numero de decimales como maximo
     *
     * @param decimales
     * @param mensaje
     * @param mensajeError
     * @return float positivo con unos decimales menos que lo
     * indicado
     */
    public float pedirFloatPositivoDecimales(int decimales, String mensaje, String mensajeError) {
 
        float real;
        String[] parteDecimal;
        do {
            try {
                System.out.println(mensaje);
                real = sc.nextFloat();
            } catch (InputMismatchException ex) {
                real = -1;
                sc.next();
            }
 
            if (real < 0) {
                System.out.println(mensajeError);
            } else {
                parteDecimal = String.valueOf(real).split("\.");
 
                if (parteDecimal[1].length() > decimales) {
                    real = -1;
                    System.out.println("Error, el numero de decimales debe ser " + decimales);
                }
            }
 
        } while (real < 0);
 
        return real;
    }
 
    /**
     * Pide un char, si tiene mas de un caracter, coge el primero
     *
     * @return
     */
    public char pedirChar() {
 
        System.out.println("Introduce un caracter (en caso de tener mas de un caracter, se cogera el primer caracter)");
        char caracter = sc.next().charAt(0);
 
        return caracter;
 
    }
 
    /**
     * Pide un char, si tiene mas de un caracter, coge el primero
     *
     * @param mensaje
     * @return
     */
    public char pedirChar(String mensaje) {
 
        System.out.println(mensaje);
        char caracter = sc.next().charAt(0);
 
        return caracter;
 
    }
 
    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean() {
 
        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println("Introduce un booleano (true o false)");
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @param mensaje
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean(String mensaje) {
 
        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
    /**
     * Pide un booleano, valida que sea un booleano
     *
     * @param mensaje
     * @param mensajeError
     * @return booleano introducido por el usuario
     */
    public boolean pedirBoolean(String mensaje, String mensajeError) {
 
        boolean booleano = false, correcto;
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo() {
 
        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println("Introduce Si o No");
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
 
            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }
 
            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @param mensaje
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo(String mensaje) {
 
        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
 
            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }
 
            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }
 
            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
    /**
     * Pide al usuario un si o un no, true = si, no = false
     *
     * @param mensaje
     * @param mensajeError
     * @return booleano introducido por el usuario
     */
    public boolean pedirBooleanSiNo(String mensaje, String mensajeError) {
 
        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }
 
            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }
 
            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }
 
            if (!correcto) {
                System.out.println(mensajeError);
            }
 
        } while (!correcto);
 
        return booleano;
    }
 
}
— Pregunta

import listaDinamica.ListaDinamica;
 
public class Pregunta {
     
    private String pregunta;
    private ListaDinamica<Respuesta> respuestas;
    private int puntos;
 
    public Pregunta(String pregunta, ListaDinamica<Respuesta> respuestas, int puntos) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.puntos = puntos;
    }
 
    public String getPregunta() {
        return pregunta;
    }
 
    public ListaDinamica<Respuesta> getRespuestas() {
        return respuestas;
    }
 
    public int getPuntos() {
        return puntos;
    }
 
    public void mostrarPregunta(){
         
        System.out.println(pregunta);
         
        int i=0;
        while(i<respuestas.size()){
            System.out.println("t"+(i+1)+". "+respuestas.get(i));
            i++;
        }
         
    }
     
    public boolean comprobarRespuesta(int respuesta){
         
        Respuesta r = respuestas.get(respuesta - 1);
         
        if(r!=null){
            return r.isCorrecta();
        }
         
        return false;
         
    }
     
}
— Respuesta

public class Respuesta {
     
    private String respuesta;
    private boolean correcta;
 
    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }
 
    public String getRespuesta() {
        return respuesta;
    }
 
    public boolean isCorrecta() {
        return correcta;
    }
 
    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
 
    @Override
    public String toString() {
        return respuesta;
    }
     
     
     
     
}
— Test

import Leer.Leer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import listaDinamica.ListaDinamica;
 
public class Test {
 
    //atributos
    private ListaDinamica<Pregunta> preguntas;
    private int puntosTotales;
    private int preguntaActual;
 
    //Constructor
    public Test() {
        preguntas = new ListaDinamica<>();
        puntosTotales = 0;
        preguntaActual = 0;
    }
 
    //Getter
    public ListaDinamica<Pregunta> getPreguntas() {
        return preguntas;
    }
 
    public int getPuntosTotales() {
        return puntosTotales;
    }
 
    public int getPreguntaActual() {
        return preguntaActual;
    }
 
    public Pregunta siguientePregunta() {
 
        //cojo la siguiente pregunta
        Pregunta p = preguntas.get(preguntaActual);
 
        //si la pregunta es distinto de null, paso la siguiente
        if (p != null) {
            preguntaActual++;
        }
 
        return p;
 
    }
 
    public void reiniciarTest() {
        preguntaActual = 0;
        puntosTotales = 0;
    }
 
    public void realizarTest() {
 
        //si estan vacias las preguntas, no hacemos nada
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas");
        } else {
 
            //Creamos un objeto leer
            Leer teclado = new Leer();
 
            int i = 0, respuesta;
            Pregunta p;
 
            //recorremos las preguntas
            while (i < preguntas.size()) {
 
                //Cojemos una pregunta
                p = preguntas.get(i);
                //La mostramos
                p.mostrarPregunta();
 
                //Pedimos una respuesta
                respuesta = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce la respuesta");
 
                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta)) {
                    System.out.println("Has acertado");
                    puntosTotales += p.getPuntos();
                } else {
                    System.out.println("No has acertado");
                }
 
                i++;
            }
 
        }
 
        //muestro los puntos
        System.out.println("Has obtenido " + puntosTotales + " puntos");
 
    }
 
    public void cargarFichero(String fichero) throws FileNotFoundException, IOException {
 
        //Creo el buffer
        BufferedReader br = new BufferedReader(new FileReader(fichero));
 
        //variables necesarias
        String linea;
        Pregunta p;
        ListaDinamica<Respuesta> respuestas = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;
 
        //leo el fichero
        while ((linea = br.readLine()) != null) {
 
            try {
 
                //si empieza por ;P; es una pregunta
                if (linea.startsWith(";P;")) {
                    texto_pregunta = linea.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea.startsWith(";R;")) {
                    opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, cojo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, cojo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas.addLast(new Respuesta(linea));
 
                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas.size() > 4) {
                        throw new Exception();
                    }
                }
 
                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas.size() >= 2 && respuestas.size() <= 4)) {
 
                    //Marcamos la respuesta correcta como la correcta
                    respuestas.get(opcioncorrecta - 1).setCorrecta(true);
 
                    //creo la pregunta
                    p = new Pregunta(texto_pregunta, respuestas, puntosPregunta);
 
                    //añado la pregunta
                    preguntas.addLast(p);
 
                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas = new ListaDinamica<>();
 
                }
 
            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas = new ListaDinamica<>();
            }
 
        }
 
        br.close();
 
    }
 
}
— Main

import java.io.IOException;
 
 
public class Ejercicio_POO_DDR_13 {
 
    public static void main(String[] args) {
         
        Test t=new Test();
         
        try {
            t.cargarFichero("preguntas-incorrecto.txt");
             
             t.realizarTest();
             
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
    }
     
}