/*3) Escribir un programa que permita transformar una expresión matemática escrita en notación interfija a
notación posfija. Normalmente las expresiones matemáticas se escriben de la forma “4+5”, que es conocida
como notación interfija dado que el operador “+” está en el medio (eso significa inter) de los dos operandos
“4” y “5”; la misma expresión se puede escribir como “45+” y en este caso se dice que está en notación
posfija porque el operador “+” está después (eso significa pos) de los dos operandos “4” y “5”. Para
simplificar el ejercicio se considera que los operandos son los dígitos 1 al 9 (un solo dígito por operando) y
los operadores corresponden a las cuatro operaciones básicas “+”, “-”, “*” y “/”.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
*/
package TP2;

import java.util.Stack;

public class PT3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
       //definicion de variables
       Stack<Character> stack;
       int option;
       String msg, interfixOperation = "";
       //fin definicion de variables
       msg = "-----------MENU PROGRAMA INFIJA A POSFIJA----------- \n"
       +    "1- Ingresar valores manuales \n"
       +    "2- Ingresar valores aleatorios ";
       option = Helper.menuTwoOptions(msg);
       switch(option){
            case 1:
                msg= "Ingrese su cadena INFIJA SIN ESPACIOS: ";
                interfixOperation = getStringOperation(msg);
            break;
            case 2:
                System.out.println("Se genero su cadena INFIJA ");
                interfixOperation = generateInterfix();
                System.out.println(interfixOperation);
            break;
       }
       //System.out.println(interfixOperation);
       System.out.println("La notacion postfija es: ");
       stack = new Stack<>();
       System.out.println(interfixToPostfixMethod(stack, interfixOperation));
    }

    ////////////////////////METHODS//////////////////////////////


    private static String generateInterfix() {
        String interfixString = "";
        int num = Helper.getImparNum(3, 11);
            for(int i=0; i<num;i++){
                if(i%2 == 0){
                    interfixString += Helper.generateRandomIntegerInRange(1,9);
                }else{
                    interfixString += Helper.generateRandomOperadores();
            }
        }
        return interfixString;
    }

    private static String interfixToPostfixMethod(Stack<Character> stack, String interfixOperation) {
        String finalNotation = "";
        for (int i = 0; i < interfixOperation.length(); i++){
            char actualCharValue = interfixOperation.charAt(i);
            if(isOperatorChar(actualCharValue)){
                if (stack.empty()) stack.push(actualCharValue);
                else if (priorityOperator(actualCharValue) > priorityOperator(stack.peek())) stack.push(actualCharValue);
                else{
                    while (!stack.empty() && priorityOperator(actualCharValue) <= priorityOperator(stack.peek())){
                        finalNotation += stack.pop();
                    }         
                    stack.push(actualCharValue);       
                }
            }
            else finalNotation += actualCharValue;
        }
        while(!stack.empty()) finalNotation += stack.pop();
        return finalNotation;
    }

    private static int priorityOperator(Character selectedValue) {
        if (selectedValue == '/' || selectedValue == '*') return 2;
        else return 1;
    }

    private static String getStringOperation(String msg) {
        while(true){
            try {
                String inputString = Helper.getValidsString(msg);
                if(!searchOperators(inputString)) throw new RuntimeException("Necesita tener al menos un operador");
                if(inputString.length() <= 1) throw new RuntimeException("La cadena debe ser mayor que 1");
                if(searchSpacesInString(inputString)) throw new RuntimeException("No se permiten espacios en la cadena");
                if(searchNoValidCharacters(inputString)) throw new RuntimeException("No se permiten caracteres no validos. Solo validos: [(0-9), (*,+,-,/)]");
                if(searchTwoOperators(inputString)) throw new RuntimeException("No ingrese mas de 2 operadores");
                return inputString;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static boolean searchOperators(String inputString) {
        for (int i = 0; i < inputString.length() - 1; i++){
            if(isOperatorChar(inputString.charAt(i))) return true;
        }
        return false;
    }

    private static boolean searchTwoOperators(String inputString) {
        for (int i = 0; i < inputString.length() - 1; i++){
            if(isOperatorChar(inputString.charAt(i)) && isOperatorChar(inputString.charAt(i+1))) return true;
        }
        return false;
    }

    private static boolean searchNoValidCharacters(String inputString) {
        int i = 0;
        for (i = 0; i < inputString.length(); i++){
            if(!(Character.isDigit(inputString.charAt(i)))
            ){
                if(!isOperatorChar(inputString.charAt(i)))return true;
            }
        }
        return false;
    }

    private static boolean isOperatorChar(char receivedChar) {
        
        Character[] validOperationChar = new Character[]{'*', '+', '-', '/'};
        for(int j = 0; j < validOperationChar.length; j++){
            if (receivedChar == validOperationChar[j]) return true;
        }
        return false;
    }

    private static boolean searchSpacesInString(String inputString) {
        for (int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == ' ') return true;
        }
        return false;
    }
}
