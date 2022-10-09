/*
 * Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo de caracteres
como contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de
una cola que prioriza velocidad. Comprobar la implementación propuesta creando una instancia de la cola y
utilizando las operaciones de la misma a pedido del operador. Para ello, puede usar un menú de opciones.
 */
package TP3;

public class PT1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //region variables
        char inputValue;
        String msgPrincipal, msgManualRandom, msg;
        int optionManualRandom, optionAction, size;
        Queue_velocity<Character> queue ;
        //end region variables
        msgManualRandom = "---------------MENU--------------- \n"
            +    "1- Ingresar valores manuales durante toda la ejecucion\n"
            +    "2- Ingresar valores aleatorios durante toda la ejecucion";
        optionManualRandom = Helper.menuTwoOptions(msgManualRandom);

        queue = generateQueue(optionManualRandom);

        System.out.println("Se ha obtenido la cola de tamaño " + queue.getSize() + "\n"
                        + " Con los siguientes items: \n" + queue.toString());

        while(true){
            msgPrincipal = "---------------MENU--------------- \n"
            +    "1- Ingresar valores a la cola \n"
            +    "2- Remover valor de la cola \n"
            +    "3- Saber el proximo a salir \n"
            +    "4- Ver cantidad de elementos \n"
            +    "5- Salir del programa ";
            optionAction = Helper.menuOptions(msgPrincipal,5);
            if (optionAction == 5) break;

            switch(optionAction){
                case 1:
                    try { 
                        msg = "Ingrese caracter para ingresar a la cola";
                        if (optionManualRandom == 1) inputValue = Helper.getChar(msg);
                        else inputValue = Helper.generateRandomChar();
                        queue.enqueue(inputValue);

                        showQueue(queue);
                    } 
                    catch (Exception e) {
                        System.out.println("No se pueden agregar elementos, la cola está llena.");
                    }
                break;
                
                case 2:
                    try{
                        System.out.println("El valor removido de la cola es: " + queue.dequeue());
                    
                        showQueue(queue);
                    }
                    
                    catch (Exception e) {
                        System.out.println("No se pueden eliminar elementos, la cola está vacia.");
                    }
                break;
                
                case 3:
                    System.out.println("El proximo valor a salir es: " + queue.getFront());
                break;
                
                case 4:
                    System.out.println("La cantidad de elementos es " + queue.getAmountItems() + ", en la cola de tamaño " + queue.getSize() );
                break;
            }
        }
    }

    private static void showQueue(Queue_velocity<Character> queue) {
        System.out.println("El nuevo valor de la cola es: " + queue.toString());
    }

    private static Queue_velocity<Character> generateQueue(int optionManualRandom) {
        
        //region variables
        Queue_velocity<Character> aux_Queue ;
        String msg; 
        int size, amountOfChar;
        //end region variables

        if (optionManualRandom == 1){
            msg = "Ingrese tamaño deseado de la cola";
            size = Helper.forcePositiveIntEnter(msg);
            aux_Queue = new Queue_velocity<>(size + 1);
            do{
                msg = "Ingrese caracter para agregar a la cola";
                aux_Queue.enqueue(Helper.getChar(msg));
            }while(!aux_Queue.isEmpty() || Helper.continueProgram("Desea agregar mas valores a la cola?  Opciones validas: (S/s || N/n)"));
        }
        else{
            size = Helper.generateRandomIntegerInRange(1, 8);
            amountOfChar = Helper.generateRandomIntegerInRange(1, size);
            aux_Queue = new Queue_velocity<>(size + 1);
            for (int i = 0; i < amountOfChar; i++) {
                aux_Queue.enqueue(Helper.generateRandomChar());
            }
        }
        return aux_Queue;
    }
}
