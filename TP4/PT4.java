/*
 * Dado un número entero positivo (validado); obtener una lista con la factorización del mismo y la
multiplicidad correspondiente. La factorización de un número entero positivo es una secuencia de los
factores primos de ese número con sus respectivos exponentes; la multiplicidad es el máximo exponente en
la secuencia.
Un factor primo es un número primo que divide exactamente a otro número entero positivo.
La factorización del número 6 es 2
1 x 3
1
; la multiplicidad es 1

La factorización del número 8 es 2
3
, la multiplicidad es 3

La factorización del número 63 es 3
2x71, la multiplicidad es 2

La factorización del número 855 es 3
2x5
1x19
1
, la multiplicidad es 2
 */
package TP4;

import java.util.Iterator;
import java.util.Scanner;

public class PT4 {
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args ){

        SimpleLinkedList<Factorizacion> listFactores = new SimpleLinkedList<>();
        int inputNumber;
        String msg;
        boolean isManualInput;
        //end region variables

        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);
        
        isManualInput = (option == 1) ? true : false;

        inputNumber = getNumber(isManualInput);
        
        if(!isManualInput) System.out.println("El numero aleatorio generado es: " + inputNumber);

        listFactores=primeFactors(inputNumber);

        System.out.println("Los factores con sus exponentes son: \n" + listFactores.toString());

        searchHigherMultiplicity(listFactores);
    }
    

    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static int getNumber(boolean isManualInput) {
        return (isManualInput) ? Helper.forcePositiveIntEnter("Ingrese numero para factorizar: ") : Helper.generateRandomIntegerInRange(10, 4000);
    }


    public static SimpleLinkedList<Factorizacion> primeFactors(int inputNumber){ 
        SimpleLinkedList<Factorizacion> listAux = new SimpleLinkedList<>();
        int divisor=2;
        int exponente=0;

        while(inputNumber != 1) {
            if(inputNumber % divisor == 0){
                inputNumber /= divisor;
                exponente++;
            }else { 
                if(exponente!=0){
                    listAux.addLast(new Factorizacion(divisor, exponente) );
                }
                exponente=0;
                divisor++;    
            }
        }
        listAux.addLast(new Factorizacion(divisor, exponente) );
        return listAux;
        
    }
    public static void searchHigherMultiplicity(SimpleLinkedList<Factorizacion> listFactores){
        Iterator<Factorizacion> localIterator = listFactores.iterator();
        Factorizacion max=listFactores.removeFirst();
        int multiplicidad=max.getExponente();

        while (localIterator.hasNext()){
            if(multiplicidad < localIterator.next().getExponente()){
                multiplicidad = localIterator.next().getExponente();
            }
        }

        System.out.print("La multiplicidad mayor es : " + multiplicidad);
    }

}
