/*
Incorporar un método a la implementación de clase Stack (versiones básica o genérica propuestas en
teoría) que reciba como parámetros dos valores (actual y nuevo) y realice la operación de reemplazo del
valor actual por el nuevo sobre el objeto Stack que está ejecutando el mensaje o método. El método
deberá tener un valor de retorno que indicará la cantidad de reemplazos realizados, cuando no los haya se
debe retornar cero. Comprobar la funcionalidad incorporada creando una pila de caracteres y
reemplazando diferentes caracteres a pedido del operador. Para cada caso indicar cuantos reemplazos se
realizaron.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
*/
package TP2;

public class PT1 {
    /**
     * @param args
     */

    public static void main(String[] args) {
        // definicion de variables 
        Stack_pt1<Character> stack;
        String msg;
        int stackSize, option; 
        Character actualValue, newValue;
        char charInput;
        // fin definicion de variables 
        msg = "Ingrese tamaño deseado del arreglo";
        stackSize = Helper.forcePositiveIntEnter(msg);

        stack = new Stack_pt1<>(stackSize);

        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);
        System.out.println( "********************"+
                            "AVISO: no se distinguirá "+
                            " mayusculas de minusculas"+
                            "********************");
        for(int i = 0; i < stackSize; i++){
            if(option == 1) {
                msg= "Ingrese valor de caracter";
                charInput = Character.toLowerCase(returnCharacter(msg));
                if (i == stackSize-1) msg = "Carga manual finalizada.";
            }
            else {
                charInput = Helper.generateRandomChar();
                
                if (i == stackSize-1) msg = "Carga automatica finalizada.";
            }

            stack.push(charInput);
        }
        System.out.println("El stack generado es: " + stack.toString());
        msg = "Ingrese el valor a buscar para ser reemplazado.";
        actualValue = returnCharacter(msg);

        msg = "Ingrese el valor a reemplazar por el valor a buscar";
        newValue = returnCharacter(msg);
        
        System.out.println("La cantidad de cambios es: " + stack.valueCountChange(actualValue, newValue));
        System.out.println("El stack final es: " + stack.toString());
    }

    
    private static char returnCharacter(String msg) {
        return Helper.getChar(msg);
    }
}
