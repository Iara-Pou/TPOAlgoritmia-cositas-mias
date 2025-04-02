package main.org.uade.algoritm;

import main.org.uade.implementation.staticIMP.StaticStackADT;

public class StackTDAExercises {

    public void ejercicio18(StaticStackADT staticStackADT){
        StaticStackADT copyStaticStack = staticStackADT.copy();
        int originalSize = copyStaticStack.size();

        for (int i = 0; i < originalSize; i++) {
            System.out.println(copyStaticStack.getElement());
        }
    }

}


