/*
 * Escribir una función, método o subprograma que reciba como parámetros dos colas y devuelva una cola
que resulte ser la unión de las otras dos, sin elementos repetidos. Para este caso el mecanismo de “unión
entre colas” es en el que sucesiva y alternadamente se toma un elemento de cada cola y se encola en una
nueva. El mecanismo de unión debe incluir las consideraciones necesarias para incorporar solo una vez
cada valor a la cola resultante de manera que no haya elementos repetidos. Considere que las colas pueden
ser de longitudes diferentes.
 */
package TP3;

import java.util.LinkedList;
import java.util.Queue;

public class PT3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //TODO Preguntar por tipo de dato en la queue
        //region variables
        
        String msg;
        int option, firstSizeSelected, secondSizeSelected;
        Queue_circular<Integer> first_Queue = new Queue_circular<Integer>();
        Queue_circular<Integer> second_Queue = new Queue_circular<Integer>();
        Queue_circular<Integer> union_Queue = new Queue_circular<Integer>();
        //end region variables
        
        msg = "---------------MENU QUEUE INTEGER PUNTO 3--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);
        msg = "Cuantos datos desea que tenga la primer cola?";
        firstSizeSelected = Helper.forcePositiveIntEnter(msg);
        msg = "Cuantos datos desea que tenga la segunda cola?";
        secondSizeSelected = Helper.forcePositiveIntEnter(msg);

        if(option == 1){
            //manual for integer
            //TODO manual
            msg = "Ingrese valor para insertar en la cola."; 
            for(int i = 0; i < firstSizeSelected; i++){
                first_Queue.add(Helper.forcePositiveIntEnter(msg));
            }
            for(int i = 0; i < secondSizeSelected; i++){
                second_Queue.add(Helper.forcePositiveIntEnter(msg));
            }
        }
        else{
            for(int i = 0; i < firstSizeSelected; i++){
                first_Queue.add(Helper.generateRandomIntegerInRange(1, 9));
            }
            for(int i = 0; i < secondSizeSelected; i++){
                second_Queue.add(Helper.generateRandomIntegerInRange(1, 9));
            }
        }
        System.out.println("Las colas generadas son: ");
        System.out.println("1° cola: " + first_Queue.toString());
        System.out.println("2° cola: " + second_Queue.toString());
        //Union of queues
        union_Queue = queueUnion(first_Queue, second_Queue);
        System.out.println("La cola final es: \n"
                           + union_Queue.toString());
    }

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static Queue_circular<Integer> queueUnion(Queue_circular<Integer> first_Queue, Queue_circular<Integer> second_Queue) {
        int secondSize, firstSize; 
        Queue_circular<Integer> aux_Queue = new Queue_circular<Integer>();

        while(!first_Queue.isEmpty() || !second_Queue.isEmpty()){
            int firstItem = -55, secondItem = -55;
            if(!first_Queue.isEmpty()) firstItem = first_Queue.pool();
            if(!second_Queue.isEmpty()) secondItem = second_Queue.pool();

            if(firstItem != secondItem){
                if (!aux_Queue.isValueInQueue(firstItem) && firstItem != -55) aux_Queue.add(firstItem);
                if (!aux_Queue.isValueInQueue(secondItem) && secondItem != -55) aux_Queue.add(secondItem);
            }
            else{

                if (!aux_Queue.isValueInQueue(firstItem)) aux_Queue.add(firstItem);
            }

        }        
        return aux_Queue;
    }
}
