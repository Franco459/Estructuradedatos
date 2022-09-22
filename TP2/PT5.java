/*
 * 5) Calcular el valor de una expresión matemática escrita en notación posfija. La notación posfija tiene la
ventaja que el orden en que se realizan las operaciones está completamente determinada por las
posiciones de los operadores y los operandos, nunca es necesario el uso de paréntesis. El mecanismo para
resolver una expresión en notación posfija necesita de una pila en la que se almacenan los operandos
(números) entonces se recorre la cadena de izquierda a derecha analizando cada símbolo de la misma, si el
símbolo es un operando (número) se guarda en la pila caso contrario se trata de un operador y en
consecuencia deberían estar dos operandos en la pila los que deben retirarse de la misma para realizar el
cálculo correspondiente, el resultado de dicho cálculo se almacena en la pila para que pueda utilizarse en
siguientes operaciones; finalmente el resultado debería estar en la pila y ser el único valor almacenado en
ella. Para simplificar el ejercicio se considera que los operandos son los dígitos 1 al 9 (un solo dígito por
operando) y los operadores corresponden a las cuatro operaciones básicas “+”, “-”, “*” y “/”.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP2;


public class PT5 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //definicion de variables
        Stack<Double> stack;
        int option;
        String msg, postFixOperation = "";
        //fin definicion de variables
        msg = "-----------MENU PROGRAMA CALCULA DE POSFIJA----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);

        //funcion menu principal
        if (option == 1){
            postFixOperation = verifyPostfixOperation();
        }

        /*una pila en la que se almacenan los operandos
(números) entonces se recorre la cadena de izquierda a derecha analizando
 cada símbolo de la misma, si el símbolo es un operando (número) se guarda 
 en la pila caso contrario se trata de un operador y en
consecuencia deberían estar dos operandos en la pila los que deben retirarse 
de la misma para realizar el
cálculo correspondiente, el resultado de dicho cálculo se almacena en la 
pila para que pueda utilizarse en
siguientes operaciones; finalmente el resultado debería estar en la pila y
 ser el único valor almacenado en
ella. */
        //obtencion valor final
        stack = new Stack<>(postFixOperation.length());
        System.out.println("El valor de la operacion es: " + obtainFinalValue(postFixOperation, stack));
    }

    ////////////////////////METHODS//////////////////////////////

    private static Double obtainFinalValue(String postFixOperation, Stack<Double> stack) {
        for(int i = 0; i < postFixOperation.length(); i++){
            if(Character.isDigit(postFixOperation.charAt(i))) stack.push(Double.parseDouble(String.valueOf(postFixOperation.charAt(i))));
            else{
                stack.push(getOperationValue(postFixOperation.charAt(i), stack));
            }
        }

        return stack.pop();
    }

    private static Double getOperationValue(char operatorValue, Stack<Double> stack) {
        Double operationValue = 0.0;
        Double firstValue = stack.pop();
        Double secondValue = stack.pop();
        switch(operatorValue){
            case '+':
                operationValue = firstValue + secondValue; 
            break;
            
            case '*':
                operationValue = firstValue * secondValue; 
            break;
            
            case '-':
                operationValue = secondValue - firstValue; 
            break;
            
            case '/':
                operationValue = secondValue / firstValue; 
            break;
        }
        System.out.println(operationValue);
        return operationValue;
    }

    private static String verifyPostfixOperation() {
        String msg = "Ingrese la cadena posfija para calcular su resultado";
        int countOperators = 0, countDigits = 0;
        while(true){
            try {
                String inputOperation = Helper.getValidsString(msg);
                
                if(!(Character.isDigit(inputOperation.charAt(0)) && Character.isDigit(inputOperation.charAt(1)))) throw new Exception("La operacion interfija necesita 2 digitos numericos antes de cualquier otro operador.");
                
                for(int i = 0; i < inputOperation.length(); i++){
                    if(!isOperatorChar(inputOperation.charAt(i)) && !Character.isDigit(inputOperation.charAt(i))) throw new RuntimeException("La operacion tiene un caracter no permitido.");
                    if(isOperatorChar(inputOperation.charAt(i))) countOperators++;
                    if(Character.isDigit(inputOperation.charAt(i))) countDigits++; 
                }

                if (countOperators == 0) throw new Exception("La operacion necesita tener un operador minimo");
                if (countDigits <= 1) throw new Exception("La operacion necesita tener 2 digitos minimo");

                return inputOperation;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static boolean isOperatorChar(char receivedChar) {
        
        Character[] validOperationChar = new Character[]{'*', '+', '-', '/'};
        for(int j = 0; j < validOperationChar.length; j++){
            if (receivedChar == validOperationChar[j]) return true;
        }
        return false;
    }
}
