package main.org.uade.implementation.dynamicIMP;

import main.org.uade.definition.StackADT;
import main.org.uade.exception.EmptyADTException;

public class DynamicStackADT implements StackADT {

    private int[] stackElements;

    //un solo elemento o array para la pila
    public DynamicStackADT(int element){
        this.stackElements = new int[1];
        this.stackElements[0] = element;
    }

    public DynamicStackADT(int[] stackElements) {
        this.stackElements = stackElements;
    }

    @Override
    public int getElement() {
        //si esta vacio, retorna excepción
        if (this.size() == 0) throw new EmptyADTException("La pila está vacía, no se puede retornar elementos.");

        //lista de mismo tamaño menos uno y genero otra a partir de eso
        //copiar pila sin el último y asignar
        int[] newStackElements = new int[this.size() -1];
        for(int i = 0; i <= this.size() -1; i++){
            newStackElements[i] = stackElements[i];
        }

        //asigno nueva pila, retorno último número
        int lastElement = stackElements[this.size() - 1];
        stackElements = newStackElements;
        return lastElement;
    }

    @Override
    public void add(int value) {
        //lista de mismo tamaño mas uno y genero otra a partir de eso
        //copiar pila sin el último y asignar
        int[] newStackElements = new int[this.size() + 1];
        for(int i = 0; i < this.size(); i++){
            newStackElements[i] = stackElements[i];
        }
        newStackElements[this.size()] = value;

        //asigno nueva pila
        stackElements = newStackElements;
    }

    @Override
    public void remove() {
        //si esta vacio, retorna excepción
        if (this.size() == 0) throw new EmptyADTException("La pila está vacía, no se puede retornar elementos.");

        //lista de mismo tamaño menos uno y genero otra a partir de eso
        //copiar pila sin el último y asignar
        int[] newStackElements = new int[this.size() -1];
        for(int i = 0; i < this.size() - 1; i++){
            newStackElements[i] = stackElements[i];
        }

        //asigno nueva pila sin elemento
        stackElements = newStackElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        int count = 0;

        try {
            while (true) {
                int temp = stackElements[count];
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Si excepción, ya no hay elementos.
        }
        return count;
    }


}
