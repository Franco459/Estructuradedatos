/*Ingrese una frase e imprima un mensaje indicando si la misma es palíndromo o no. Para ello, debe hacer
uso de Stack. Una frase es palíndromo cuando se lee igual hacia adelante que hacia atrás (no se tienen en
cuenta los espacios en blanco). Ejemplo “oso”, “somos”, “reconocer”, “anita lava la tina”.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente. */
package TP2;
public class PT2 {

    public static void main(String[] args) {
       //definicion de variables
        Stack<Character> stack;
        int option;
        String msg, inputString = "", reverseString;
        //fin definicion de variables
        msg = "-----------MENU PROGRAMA PALINDROMO----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);
        switch(option){
            case 1:
                msg = "Ingrese la cadena para comprobar si es palindromo";
                inputString = Helper.getValidsString(msg);
            break;
            case 2:
                //TODO randomVersion
            break;
        }

        stack = createStack(inputString);

        reverseString = reverseStack(stack);

        if(isPalindrome(reverseString, inputString)) System.out.println("La palabra " + inputString + ", SI es palindromo.");
        else System.out.println("La palabra " + inputString + ", NO es palindromo.");
    }

    private static boolean isPalindrome(String reverseString, String inputString) {
        return (reverseString.equalsIgnoreCase(inputString));
    }

    private static String reverseStack(Stack<Character> stack) {
        String finalString = "";
        while (!stack.empty()) {
            finalString += stack.pop();
        }

        return finalString;
    }

    private static Stack<Character> createStack(String inputString) {
        Stack<Character> auxStack = new Stack<>(inputString.length());
        for (int i = 0; i < inputString.length(); i++) {
            auxStack.push(inputString.charAt(i));
        }
        return auxStack;
    }
}