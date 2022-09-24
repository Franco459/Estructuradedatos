/*6) Un preventista de gaseosas debe recorrer una cantidad de N pueblos con el objetivo 
de concretar pedidos de su producto. 

El producto se vende por fardos de 6 unidades y el precio del fardo es “p”. (****Ignorar este dato****)

Cada vez que llega a un pueblo, el preventista toma el pedido de una cantidad de fardos para un 
solo negocio por pueblo y registra el importe de la deuda. (****Validar un solo pueblo****)

Tras visitar el último pueblo en el cual se encuentra una de las distribuidoras de la empresa
de gaseosas, el preventista confirma la información de las ventas realizadas y en función de ello
se prepara el camión de reparto. 

El repartidor deberá regresar por el mismo camino que hizo el preventista haciendo las entregas y 
realizando las cobranzas en base a lo registrado por su compañero.(***comportamiento de pila aqui***) 

Realice un programa que permita registrar la información de los pedidos realizados, es decir,
los pueblos visitados por el preventista, el nombre de los negocios cliente, la cantidad de fardos
de gaseosas vendidos en cada pueblo y la deuda a cobrar. 

Por otra parte, el programa deberá mostrar los pueblos visitados por el preventista 
(en el orden en que los visita), los nombres de los negocios cliente, la cantidad de fardos 
vendidos y el total de fardos a entregar. 

Asimismo, se deben presentar los pueblos que recorre el repartidor (en el orden en que los visita), 
el monto cobrado en cada pueblo y el total recaudado en concepto de las deudas cobradas.

***
 Para almacenar la información se puede usar objetos de la clase
PuntoDeEntrega, la cual tendrá los atributos: nombre del pueblo, nombre del negocio cliente, cantidad de
fardos de gaseosas, monto de la deuda y estado de la deuda (pendiente o pagado según corresponda).
***


Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
Nota: En el caso de la generación aleatoria de valores para los nombres de pueblos y negocios debe
asegurarse que los valores no se repitan.
*/
package TP2;


public class PT6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //definicion de variables

        Stack<PuntosDeEntrega> stackOfOrders;
        Stack<PuntosDeEntrega> auxStackOfOrders;
        float priceOfDebt = 0;
        int option, amountOfBales = 0, amountOfOrders = 0;
        String msg, nameCityValue = "", storeCityValue = "";

        //fin definicion de variables

            amountOfOrders = Helper.forcePositiveIntEnter("Ingrese cantidad totales de pedidos");
            auxStackOfOrders = new Stack<>(amountOfOrders);
            stackOfOrders = new Stack<>(amountOfOrders);
            /* Se considera que solo se pueden crear valores aleatorios para la carga de pedidos*/
            msg = "-----------MENU MANUAL/RANDOM----------- \n"
            +    "1- Cargar valores manuales \n"
            +    "2- Cargar valores aleatorios";
            option = Helper.menuTwoOptions(msg);

        for(int i = 0; i < amountOfOrders; i++){
            if (option == 1){
                //nombre ciudad
                nameCityValue = getValidString(false, "ciudad", stackOfOrders);
                //TODO - validar una sola ciudad                

                //nombre tienda
                storeCityValue = getValidString(true, "tienda", stackOfOrders);
                
                //cantidad
                msg = "Ingrese cantidad de fardos: ";
                amountOfBales = Helper.forcePositiveIntEnter(msg);
                
                //precio
                priceOfDebt = Helper.getFloat("Ingrese el precio de la deuda del negocio:");
                
                //estado de la deuda, automatico
            }
            else{
                //TODO random
            }
            //Create new store-DONE
            stackOfOrders.push(createNewOrder(nameCityValue, storeCityValue, amountOfBales, priceOfDebt));
            //DONE- show all
            showOrdersInStack(stackOfOrders);
        }
        /**********************************************************************************************************************/
        System.out.println("Se procederá a registrar los pagos del recorrido del camion de reparto.");
                
        while(!stackOfOrders.empty()){
            var statusChangeValue = showLastCity(stackOfOrders);
            //Cambiar estado x ciudad
            if(changeDebtStatus(statusChangeValue)){
                auxStackOfOrders = changeStatus(statusChangeValue, auxStackOfOrders);
            }
            else{
                auxStackOfOrders.push(statusChangeValue);
            }
        }
        System.out.println("Los estados de la deuda han sido cambiados");
        //stackOfOrders = reverseStack(auxStackOfOrders);
        showOrdersInStack(auxStackOfOrders);
    }
    
    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static boolean duplicateCity(String nameCityValue, Stack<PuntosDeEntrega> localStackOfOrders) {
        // System.out.println(localStackOfOrders.search(nameCityValue) != -1);
        //if(localStackOfOrders.search() != -1) return true;
        boolean isDuplicate = false;
       /* Stack<PuntosDeEntrega> localStack;
        if (localStackOfOrders.empty()) localStack = new Stack<>(10);
        else localStack = new Stack<>(localStackOfOrders.size());
        System.out.println("asasdsdasda");
        showOrdersInStack(localStackOfOrders);
        System.out.println("asasdsdasda");
        if (localStackOfOrders.search(nameCityValue.toUpperCase()) != -1)
            return true;
*/
        return isDuplicate;
    }

    private static Stack<PuntosDeEntrega> reverseStack(Stack<PuntosDeEntrega> stack) {
        Stack<PuntosDeEntrega> localStack;
        if (stack.empty()) localStack = new Stack<>(10);
        else localStack = new Stack<>(stack.size());
        while (!stack.empty()) {
            localStack.push(stack.pop());
        }
        return localStack;
    }

    private static boolean changeDebtStatus(PuntosDeEntrega statusChangeValue) {
        String msg = "La deuda por $" + statusChangeValue.getDebt_price() 
                        + ", de la tienda " + statusChangeValue.getName_store()
                        + ", ubicada en la ciudad: " + statusChangeValue.getName_city()
                        + " ha sido pagada? (s/S || n/N)";
        boolean valueContinue =  Helper.continueProgram(msg);
        return valueContinue;
    }

    private static void showOrdersInStack(Stack<PuntosDeEntrega> stackOfOrdersReceived) {
        System.out.println(stackOfOrdersReceived.toString());
    }


    private static PuntosDeEntrega createNewOrder(String nameCityValue, String storeCityValue, int amountOfBales, float priceOfDebt) {
        PuntosDeEntrega newOrder = new PuntosDeEntrega(nameCityValue, storeCityValue, amountOfBales, priceOfDebt, false);
        System.out.println("Se ha generado el pedido satisfactoriamente.");
        return newOrder;
    }

    private static PuntosDeEntrega showLastCity(Stack<PuntosDeEntrega> stackOfOrders) {
        System.out.println(stackOfOrders.peek().toString());
        return stackOfOrders.pop();
    }

    private static Stack<PuntosDeEntrega> changeStatus(PuntosDeEntrega statusChangeValue, Stack<PuntosDeEntrega> auxStackOfOrders) {
        statusChangeValue.setDebt_status(true);
        auxStackOfOrders.push(statusChangeValue);
        return auxStackOfOrders;
    }

    private static String getValidString(boolean allowNumbers, String selectedName, Stack<PuntosDeEntrega> stackOfOrders) {
        String returnValue;
        String msg = "Ingrese valor de la " + selectedName;
        if (!allowNumbers){
            while(true){
                try {
                    returnValue = Helper.getValidsString(msg).toUpperCase();
                    if (stringContainNumbers(returnValue)) throw new RuntimeException("El nombre de una ciudad no puede tener numeros.");
                    if(!stackOfOrders.empty()){ 
                        if (duplicateCity(returnValue, stackOfOrders) && !allowNumbers )  throw new RuntimeException("La ciudad ya existe en el sistema.");
                    }
                    return returnValue;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        else{
            returnValue = Helper.getValidsString(msg);
        }
        return returnValue;
    }

    private static boolean stringContainNumbers(String returnValue) {
        for(var i = 0; i < returnValue.length(); i++){
            if(Character.isDigit(returnValue.charAt(i))) return true;
        }
        return false;
    }
}
