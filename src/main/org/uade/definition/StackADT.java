package main.org.uade.definition;

public interface StackADT {
        // Devuelve el último elemento de la estructura.
        int getElement();
        // Agrega un elemento al final de la estructura.
        void add(int value);
        // Elimina el último elemento que existe.
        void remove();
        // Debe comprobar si la estructura tiene o no
        boolean isEmpty();

}
