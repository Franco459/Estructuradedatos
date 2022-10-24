/*Codificar una implementación de la clase Stack<T> (Pila genérica) utilizando en la estructura interna una
lista genérica. Usando dicha implementación, escribir un programa que permita verificar la parentización
simple de una expresión matemática. Una expresión como 4 * (5 – 2) se dice que está correctamente
parentizada porque contiene un paréntesis de apertura y uno de cierre. El programa solicitado debe
permitir el ingreso de una cadena que contiene una expresión matemática con paréntesis, la cual deberá
verificarse. */
package TP4;


public class PT2 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        //region variables
        StackLinkedList<Character> stack = new StackLinkedList<>();
        String msg, inputString;
        boolean isManualInput;
        int option;
        //end region variables

        msg = "-----------MENU PROGRAMA CALCULA DE POSFIJA----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;

        inputString = getInputString(isManualInput);

        System.out.println("La cadena " + ((isManualInput) ? "INGRESADA" : "GENERADA") + ": '" + inputString + "', está " + ((getParenting(inputString, stack)) ? "MAL" : "BIEN") + " parentizada");

    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static boolean getParenting(String inputString, StackLinkedList<Character> stack) {
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == '(' || inputString.charAt(i) == '[' || inputString.charAt(i) == '{'){
                stack.add(inputString.charAt(i));
            }
            if(inputString.charAt(i) == ')' || inputString.charAt(i) == ']' || inputString.charAt(i) == '}'){
                char value = ' ';

                if (!stack.isEmpty()) value = (char) stack.pop();
                else return true;
                System.out.println(value + " compare " + inputString.charAt(i));
                
                System.out.println((int)value + " compare " + (int) inputString.charAt(i));
                System.out.println(value == inputString.charAt(i));
                if(((value) != getInverse(inputString.charAt(i)))) return true;

            }
        }
        return false;
    }


    private static char getInverse(char charInString) {
        char[] inverseOperator = {'(', '[', '{'};
        if(charInString == ')') return inverseOperator[0];
        else if(charInString == ']') return inverseOperator[1];
        else return inverseOperator[2];
    }


    private static String getInputString(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidsString("Ingrese cadena para verificar parentizacion") : Helper.generateRandomOperation();    
    }
}
