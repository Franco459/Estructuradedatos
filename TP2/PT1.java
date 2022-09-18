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
*/package TP2;


public class PT1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // definicion de variables 
        Stack<Character> stack;
        String msg;
        int stackSize, option; 
        Character actualValue, newValue;
        char charInput;
        // fin definicion de variables 

        msg = "Ingrese tamaño deseado del arreglo";
        stackSize = Helper.forcePositiveIntEnter(msg);

        stack = new Stack<>(stackSize);

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
        do{
            Helper.showCharStack(stack);

            msg = "Ingrese el valor a buscar para ser reemplazado.";
            actualValue = returnCharacter(msg);

            msg = "Ingrese el valor a reemplazar por el valor a buscar";
            newValue = returnCharacter(msg);

            createFinalStack(stack, newValue, actualValue);

            msg = "";
        }while(Helper.continueProgram(msg));

    }


    
    ////////////////////////METHODS//////////////////////////////



    private static void createFinalStack(Stack<Character> stack, Character newValue, Character actualValue) {
        Stack<Character> auxStack = new Stack<>(stack.size());
        int count = 0;


        auxStack = getRevertedCharStack(stack);
        while(!auxStack.empty()){
            if(Character.toLowerCase(auxStack.peek()) != Character.toLowerCase(actualValue)) stack.push(auxStack.pop());
            else{
                stack.push(newValue);
                count++;
                //perdemos el valor ahora inservible 
                auxStack.pop();
            }
        }
        String msg = "La cantidad de valores cambiados fue: " + count;
        if (count == 0) msg += ". No se cambió ningun elemento de la pila ya que no hubo valor coincidente al pretendido ('" +
        actualValue + "')";
        Helper.showCharStack(stack, msg);
    }



    private static Stack<Character> getRevertedCharStack(Stack<Character> stack) {
        Stack<Character> localStack = new Stack<>(stack.size());

        while(!stack.empty()){
            localStack.push(stack.pop());
        }

        return localStack;
    }



    private static char returnCharacter(String msg) {
        return Helper.getChar(msg);
    }
}
