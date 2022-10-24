/*
 * Codificar una implementación de la clase Queue<ELEMENT> (Cola genérica) utilizando en la estructura
interna una lista genérica. Usando dicha implementación, encolar números enteros en una cola hasta que
se ingrese el número 99; luego desencolarlos y hacer lo siguiente: calcular el factorial de los números
positivos, sumar los negativos y contar los ceros.
Para la implementación de la clase, tener en cuenta los diagramas presentados. En el primer diagrama se
muestra el campo interno “list” de la clase Queue<ELEMENT> y en el segundo se presenta los detalles de la
clase SimpleLinkedList<ELEMENT>.
 */
package TP4;

import javax.swing.text.StyledEditorKit.BoldAction;

public class PT1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        String msg;
        boolean isManualInput;
        int option, inputNumber;

        msg = "-----------MENU PROGRAMA CALCULA DE POSFIJA----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;

        if(isManualInput){      
            while (true){
                inputNumber = getNumber(isManualInput);
                if (inputNumber == 99) break;
                queue.enqueue(inputNumber);
            }
        }
        else{
            int amount = Helper.generateRandomIntegerInRange(3, 15);
            for (int i = 0; i < amount; i++) {
                inputNumber = getNumber(isManualInput);
                queue.enqueue(inputNumber);
            }
        }
        System.out.println("La cola es: " + queue.toString());

        getPositives(queue);
        System.out.println("La suma de los numeros negativos es: " + sumNegatives(queue));
        System.out.println("La cantidad de 0 en la cola es: " + countZeros(queue));
        
    }

    private static int countZeros(QueueLinkedList<Integer> queue) {
        int size = queue.size(), count = 0;
        for (int i = 0; i < size; i++) {
            int element = (int) queue.dequeue();
            if ( element == 0 ) count++;
            queue.enqueue(element);
        }
        return count;
    }

    private static int sumNegatives(QueueLinkedList<Integer> queue) {
        int size = queue.size(), sum = 0;
        for (int i = 0; i < size; i++) {
            int element = (int) queue.dequeue();
            if ( element < 0 ) sum += element;
            queue.enqueue(element);
        }
        return sum;
    }

    private static void getPositives(QueueLinkedList<Integer> queue) {
        int size = queue.size();
        boolean existPositive = false;
        for (int i = 0; i < size; i++) {
            int element = (int) queue.dequeue();
            if ( element > 0 ) {
                System.out.println("El factorial de " + element + " es:" + getFactorial(element));
                existPositive = true;
            }
            queue.enqueue(element);
        }
        if(!existPositive) System.out.println("No se generaron numeros enteros positivos");
    }

    private static long getFactorial(int element) {
        long factorial = 1;
        for (long i = element; i > 0; i--) {
            factorial = factorial * i; 
        }
        return factorial;
    }

    private static int getNumber(boolean isManualInput) {
        return (isManualInput) ? Helper.forceInteger("Ingrese valor entero para encolar (99 para dejar de cargar)\n RECOMENDACION: No poner numeros excesivamente grandes para evitar problemas en calculo de Factorial") : Helper.generateRandomNumbersInRange(10, -10);
    }
}
