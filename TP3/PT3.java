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
        int option, sizeSelected;
        Queue_circular<Integer> first_Queue = new Queue_circular<Integer>();
        Queue_circular<Integer> second_Queue = new Queue_circular<Integer>();
        Queue_circular<Integer> union_Queue = new Queue_circular<Integer>();
        //end region variables
        
        msg = "---------------MENU QUEUE INTEGER PUNTO 3--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);
        msg = "Cuantos datos desea que tenga su cola?";
        sizeSelected = Helper.forcePositiveIntEnter(msg);
        for(int i = 0; i < sizeSelected; i++){
            if(option == 1){
                //manual for integer
                //TODO manual 
            }
            else{
                first_Queue.add(Helper.generateRandomIntegerInRange(1, 9));
                second_Queue.add(Helper.generateRandomIntegerInRange(1, 9));
            }
        }
        System.out.println(first_Queue.toString());
        System.out.println(second_Queue.toString());
        //Union of queues
        union_Queue = queueUnion(first_Queue, second_Queue);
        System.out.println("La cola final es: \n"
                           + union_Queue.toString());
    }

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static Queue_circular<Integer> queueUnion(Queue_circular<Integer> first_Queue, Queue_circular<Integer> second_Queue) {
        int secondSize, firstSize; 
        Queue_circular<Integer> aux_Queue = new Queue_circular<Integer>();
        firstSize = first_Queue.size();
        secondSize = second_Queue.size();
        for (int i = 0; i < firstSize; i++){
            int valueToSearch = first_Queue.pool();
            //funciona
            /*for(int j = 0; j < secondSize; j++){
                int peekValue = second_Queue.pool();
                if (peekValue != valueToSearch) second_Queue.add(peekValue);
            }*/
            //test funciona
            if(!second_Queue.isValueInQueue(valueToSearch)){
                if(!aux_Queue.isValueInQueue(valueToSearch))aux_Queue.add(valueToSearch);
            }
        }
        System.out.println(second_Queue.toString());
        
        second_Queue = getQueueNoDuplicates(second_Queue, aux_Queue);
        second_Queue = getQueueNoDuplicates(second_Queue, second_Queue);

        aux_Queue = aux_Queue.union(second_Queue);
        
        return aux_Queue;
    }


    private static Queue_circular<Integer> getQueueNoDuplicates(Queue_circular<Integer> second_Queue, Queue_circular<Integer> aux_Queue2) {
        
        for (int i = 0; i < second_Queue.size(); i++) {
            var valueInQueue = second_Queue.pool();
            if (!aux_Queue2.isValueInQueue(valueInQueue)) second_Queue.add(valueInQueue);
        }
        return second_Queue;
    }
}
