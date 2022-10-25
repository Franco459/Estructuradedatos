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


public class PT1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        //region variables
        String msg;
        boolean isManualInput;
        int option, inputNumber;
        //end region variables

        msg = "-----------MENU PROGRAMA COLA LINKED LIST----------- \n"
        +    "1- Cargar cola con valores manuales \n"
        +    "2- Cargar cola con valores aleatorios ";
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
        System.out.println("-----------------RESULTADOS DE LA OPERACION-----------------");
        System.out.println("La cola es: " + queue.toString());
        System.out.println(getResults(queue));
        
    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static String getResults(QueueLinkedList<Integer> queue) {
        int countZeros = 0, sumnegatives = 0;
        String msg = "";

        if(queue.isEmpty()) msg = "La cola está vacia. No se realizaran calculos";
        else{
           
            while(!queue.isEmpty()){
                int element = (int) queue.dequeue();
                if ( element == 0 ) countZeros++;
                else if ( element < 0 ) sumnegatives += element;
                else System.out.println("El factorial del numero positivo encolado '" + element + "', es:" + getFactorial(element));
            }

            msg += (countZeros > 0) ? "La cantidad de 0 encolados es: " + countZeros + ".\n" : "No se encontraron '0' encolados.\n";
            msg += (sumnegatives < 0) ? "La suma de numeros negativos es: " + sumnegatives + ".\n" : "No se encontraron 'numeros negativos' encolados.\n";
        
        }
        return msg;
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
