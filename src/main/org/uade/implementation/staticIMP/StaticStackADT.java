package main.org.uade.implementation.staticIMP;

import main.org.uade.definition.StackADT;
import main.org.uade.exception.EmptyADTException;

public class StaticStackADT implements StackADT {

    private int[] stackElements;
    private int top;

    public StaticStackADT(int stackSize) {
        this.stackElements = new int[stackSize];
        // Si pila vacía, top -1
        this.top = -1;
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new EmptyADTException("La pila está vacía, no se puede retornar elementos.");

        int lastElement = stackElements[top];
        top--;

        return lastElement;
    }

    @Override
    public void add(int value) {
        if (top >= stackElements.length - 1) {
            throw new RuntimeException("La pila está llena, no se pueden agregar más elementos.");
        }

        top++;
        // Agrega el valor
        stackElements[top] = value;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new EmptyADTException("La pila está vacía, no se puede eliminar elementos.");
        top--;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public StaticStackADT copy() {
        StaticStackADT tempStack = new StaticStackADT(this.size());
        StaticStackADT copyStack = new StaticStackADT(this.size());

        // Sacar los elementos de la pila original y ponerlos en la auxiliar
        while (!this.isEmpty()) {
            tempStack.add(this.getElement());
        }

        // Restaurar la pila original y copiar los elementos a la nueva pila
        while (!tempStack.isEmpty()) {
            int value = tempStack.getElement();
            this.add(value);
            copyStack.add(value);
        }

        return copyStack;
    }

    public int size() {
        //ultima posicion llena +1 (arranca en 0)
        return top + 1;
    }

}
