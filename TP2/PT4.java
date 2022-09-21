/*
 * Para convertir un número dado en base decimal a una base destino se debe dividir dicho número entre la
base destino, dejando el residuo y dividiendo el cociente sucesivamente entre la base destino hasta
obtener cociente 0, luego los restos de las divisiones leídos en orden inverso indican el número en la base
destino. Alternativamente, se puede dividir sucesivamente como en el caso anterior hasta que el dividendo
sea menor que el divisor, en cuyo caso el número en la base destino se obtendrá tomando el último
cociente calculado y luego los restos en orden inverso (ver figuras). Elaborar un programa que permita
convertir un número dado en base decimal a las bases binario u octal, a petición del usuario. Para ello, haga
uso de Stack.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP2;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //definicion de variables
        Stack<Integer> stack;
        int option, inputValue = 0, baseSelected, baseSelectedToMethod;
        String msg, valueToSize;
        //fin definicion de variables

        //primer menu
        msg = "-----------MENU PROGRAMA DECIMAL A BASE----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);     
        

        //menu de base
        msg = "-----------MENU ELECCION DE BASE----------- \n"
        +    "1- Pasar a base binaria \n"
        +    "2- Pasar a base octal";
        baseSelected = Helper.menuTwoOptions(msg);
        //control base elegida del programa
        msg = "Ingrese valor DECIMAL para pasar a valor ";
        if (baseSelected == 1){
            msg += "BINARIO";
            baseSelectedToMethod = 2;
        }
        else{
            msg += "OCTAL";
            baseSelectedToMethod = 8;

        }
        //control accion manual(1)/aleatoria(else)
        if(option == 1){
            inputValue = Helper.forcePositiveIntEnter(msg);
        }
        else{
            //aleatorio
            inputValue = Helper.generateRandomIntegerInRange(1, 3400);
            System.out.println("El numero generado fue: " + inputValue);
            //TODO random
        }
        valueToSize = String.valueOf(inputValue);
        // 3 ya que la cantidad de 1 y 0 que tiene el numero en binario es casi siempre es la cantidad de digitos x 3
        stack = new Stack<>(valueToSize.length()*3);
        stack = convertValue(inputValue, baseSelectedToMethod, stack);
        finalValue(stack, baseSelectedToMethod);
    }

    private static void finalValue(Stack<Integer> stack, int baseSelectedToMethod) {
        String msgFinalValue = "", msgBase = "";
        while(!stack.empty()){
            msgFinalValue += stack.pop();
        }
        msgBase = (baseSelectedToMethod == 2) ?  "binaria" : "octal";
        System.out.println("El valor convertido a base " + msgBase + ", es de: "+ msgFinalValue );
    }

    private static Stack<Integer> convertValue(int inputValue, int baseSelectedToMethod, Stack<Integer> stack) {
        int remainder;
        while(inputValue > 0){
            remainder = inputValue % baseSelectedToMethod;
            inputValue /= baseSelectedToMethod;
            stack.push(remainder);
        }
        return stack;
    }
}
