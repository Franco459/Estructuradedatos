/*Escribir una función, método o subprograma que reciba como parámetros una cola y un número; debe
devolver una cola en la que se suprimen todas las apariciones del número, de sus múltiplos y de sus
divisores. Para la resolución del ejercicio debe utilizar colas circulares que prioricen la velocidad.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente. */
package TP3;


public class PT2 {
    public static void main(String[] args) {
        
        //region variables
        
        String msg;
        int option, size, valueToRemove;
        Queue_velocity<Integer> queue ;
        //end region variables
        
        msg = "Ingrese tamaño de la cola";
        size = Helper.forcePositiveIntEnter(msg);
        queue = new Queue_velocity<>(size + 1);


        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);
        if(option == 1){
            queue = generateQueue(size, true);
            
            valueToRemove = getValue(true);
        }
        else{
            queue = generateQueue(size, false);
            System.out.println("Cola generada aleatoriamente.");
            valueToRemove = getValue(false);  
            System.out.println("El numero generado para suprimir apariciones es " + valueToRemove);

        }

        System.out.println("La cola obtenida es: \n" + queue.toString());

        queue = delNumbersDivisorsMultiples (queue, valueToRemove);

        System.out.println("Cola resultante sin apariciones, multiplos o divisores es: \n" + queue.toString());
    }
    
    //////////////////////////////////////METHODS///////////////////////////////////////

    private static int getValue(boolean isManualInput) {
        if (isManualInput){
            String msg = "Ingrese valor para quitar de la cola junto a sus divisores y multiplos";
            return Helper.forcePositiveIntEnter(msg);
        }
        else return Helper.generateRandomIntegerInRange(1, 9);
    }

    private static Queue_velocity<Integer> generateQueue(int size, boolean isManual) {
        Queue_velocity<Integer> aux_Queue = new Queue_velocity<>(size);
        for (int i = 0; i < size; i++) {
            if(!isManual) aux_Queue.enqueue(Helper.generateRandomIntegerInRange(1, 9));
            else{
                String msg = "Ingrese valor para ingresar en la cola";
                aux_Queue.enqueue(Helper.forcePositiveIntEnter(msg));
            }
        }
        return aux_Queue;
    }

    private static Queue_velocity<Integer> delNumbersDivisorsMultiples(Queue_velocity<Integer> queue, int valueToRemove) {

        Queue_velocity<Integer> aux_queue = new Queue_velocity<>(queue.getSize() + 1 );
        while(!queue.isEmpty()){
            int value = queue.dequeue();
            if (value != valueToRemove && (value % valueToRemove != 0) && (valueToRemove % value != 0)) aux_queue.enqueue(value);
        }

        return aux_queue;
    }
}
