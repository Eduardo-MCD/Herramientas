package mx.unam.fes.estatico;

public class Lista<E> {
    private Nodo<E> cabeza, cola;
    private int longitud = 0;

    
    public Lista() {
        cabeza = cola = null;
    }

    /**
     * Comprueba si la lista no tiene elementos.
     */
    public boolean esVacia() {
        return cabeza == null;
    }

    /**
     * Inserta un nuevo elemento al principio de la lista.
     */
    public void agregarCabeza(E dato) {
        cabeza = new Nodo<>(dato, cabeza);
        if (cola == null) {
            cola = cabeza;
        }
        longitud++;
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     */
    public void agregarCola(E dato) {
        if (!esVacia()) {
            cola.setSiguiente(new Nodo<>(dato));
            cola = cola.getSiguiente();
        } else {
            cabeza = cola = new Nodo<>(dato);
        }
        longitud++;
    }

    /**
     * Elimina el primer elemento de la lista y te devuelve su dato.
     */
    public E eliminarDeCabeza() {
        E dato = null;
        if (!esVacia()) {
            dato = cabeza.getDato();
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                cabeza = cabeza.getSiguiente();
            }
            longitud--;
        }
        return dato;
    }

    /**
     * Devuelve el tamaño actual de la lista.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Elimina el último elemento de la lista y te devuelve su dato.
     */
    public E eliminarDeCola() {
        E dato = null;
        if (!esVacia()) {
            dato = cola.getDato();
            if (cabeza == cola) {
                cabeza = cola = null;
            } else {
                Nodo<E> temp;
                for (temp = cabeza; temp.getSiguiente() != cola; temp = temp.getSiguiente());
                cola = temp;
                cola.setSiguiente(null);
            }
            longitud--;
        }
        return dato;
    }

    /**
     * Busca un nodo por su índice (empezando desde 0) y devuelve lo que contiene.
     */
    public E obtenerNodo(int indice) {
        Nodo<E> temp = cabeza;
        for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente());
        
        if (temp != null) {
            return temp.getDato();
        } else {
            return null;
        }
    }

    /**
     * Sobrescribe el dato de un nodo en el índice especificado.
     *  solo reemplaza la información del nodo actual.
     */
    public boolean insertarEnIndice(E dato, int indice) {
        Nodo<E> temp = cabeza;
        for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente());
        
        if (temp != null) {
            temp.setDato(dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Imprime en consola todos los elementos de la lista, uno por uno.
     */
    public void imprimir() {
        for (Nodo<E> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
            System.out.println(temp.getDato() + " ");
        }
    }

    /**
     * Busca la primera aparición de un dato en específico y lo borra de la lista.
     */
    public void borrar(E dato) {
        if (!esVacia()) {
            if (cabeza == cola && dato.equals(cabeza.getDato())) {
                cabeza = cola = null;
                longitud--;
            } 
            else if (dato.equals(cabeza.getDato())) {
                cabeza = cabeza.getSiguiente();
                longitud--;
            } 
            else {
                Nodo<E> predecesor, tmp;
                for (predecesor = cabeza, tmp = cabeza.getSiguiente();
                     tmp != null && !tmp.getDato().equals(dato);
                     predecesor = predecesor.getSiguiente(), tmp = tmp.getSiguiente());
                
                if (tmp != null) {
                    predecesor.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = predecesor;
                    }
                    longitud--;
                }
            }
        }
    }

    /**
     * Borra el nodo que se encuentre en la posición exacta del índice.
     */
    public void borrarEnIndice(int indice) {
        if (!esVacia()) {
            if (cabeza == cola && indice == 0) {
                cabeza = cola = null;
                longitud--;
            } else if (indice == 0) {
                cabeza = cabeza.getSiguiente();
                longitud--;
            } else {
                Nodo<E> predecesor, tmp;
                int contador = 1;
                for (predecesor = cabeza, tmp = cabeza.getSiguiente();
                     contador < indice && tmp != null;
                     contador++, predecesor = predecesor.getSiguiente(), tmp = tmp.getSiguiente());
                
                if (tmp != null) {
                    predecesor.setSiguiente(tmp.getSiguiente());
                    if (tmp == cola) {
                        cola = predecesor;
                    }
                    longitud--;
                }
            }
        }
    }

    /**
     * Busca la posición de un elemento en la lista.
     * Retorna el índice donde lo encontró, o -1 si no existe.
     */
    public int localizar(E dato) {
        Nodo<E> temp = cabeza;
        int indice = 0;
        while (temp != null) {
            if (temp.getDato().equals(dato)) {
                return indice;
            }
            temp = temp.getSiguiente();
            indice++;
        }
        return -1; 
    }

    /**
     * Devuelve el dato del primer elemento de la lista sin sacarlo/borrarlo.
     */
    public E obtenerPrimero() {
        if (!esVacia()) {
            return cabeza.getDato();
        }
        return null; 
    }

    /**
     * Resetea la lista y la deja completamente vacía.
     */
    public void limpiar() {
        cabeza = cola = null;
        longitud = 0;
    }
}
