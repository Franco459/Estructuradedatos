/*6) Un preventista de gaseosas debe recorrer una cantidad de N pueblos con el objetivo 
de concretar pedidos de su producto. 

El producto se vende por fardos de 6 unidades y el precio del fardo es “p”. (****Ignorar este dato****)

Cada vez que llega a un pueblo, el preventista toma el pedido de una cantidad de fardos para un 
solo negocio por pueblo y registra el importe de la deuda. (****Validar un solo pueblo****)

Tras visitar el último pueblo en el cual se encuentra una de las distribuidoras de la empresa
de gaseosas, el preventista confirma la información de las ventas  realizadas y en función de ello
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
        Stack<PuntosDeEntrega> stackOfOrders = new Stack<>();
        Stack<PuntosDeEntrega> auxStackOfOrders = new Stack<>();
        PuntosDeEntrega puntoDeEntrega;
        float priceOfDebt = 0;
        int firstOption, secondOption, amountOfBales = 0, amountOfOrders = 0;
        String msg, postFixOperation = "", nameCityValue = "", storeCityValue = "";
        //fin definicion de variables
        msg = "-----------MENU PROGRAMA CARGA VENTAS----------- \n"
        +    "1- Ingresar valores del pre-ventista \n"
        +    "2- Ingresar valores del repartidor ";
        firstOption = Helper.menuTwoOptions(msg);
        switch(firstOption){
            case 1:
                amountOfOrders = Helper.forcePositiveIntEnter("Ingrese cantidad totales de pedidos");
                stackOfOrders = new Stack<>(amountOfOrders);
                /* Se considera que solo se pueden crear valores aleatorios para la carga de pedidos*/
                msg = "-----------MENU MANUAL-RANDOM----------- \n"
                +    "1- Cargar valores manuales \n"
                +    "2- Cargar valores aleatorios";
                secondOption = Helper.menuTwoOptions(msg);
                if (secondOption == 1){
                    //nombre ciudad
                    nameCityValue = getValidsString(false, "ciudad");
                    //nombre tienda
                    storeCityValue = getValidsString(true, "tienda");
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
                //TODO-Create new store
                stackOfOrders.push(createNewOrder(nameCityValue, storeCityValue, amountOfBales, priceOfDebt));
                //TODO- show all
            break;
            case 2:
                while(!stackOfOrders.empty()){
                    //TODO- show last city
                    var statusChangeValue = showLastCity(stackOfOrders);
                    //Cambiar estado x ciudad
                    auxStackOfOrders = changeStatus(statusChangeValue, auxStackOfOrders);
                }
                System.out.println("Los estados de la deuda han sido cambiados");

            break;
        }
    
    }

    private static PuntosDeEntrega createNewOrder(String nameCityValue, String storeCityValue, int amountOfBales, float priceOfDebt) {
        PuntosDeEntrega newOrder = new PuntosDeEntrega(nameCityValue, storeCityValue, amountOfBales, priceOfDebt, true);
        System.out.println("Se ha generado el pedido satisfactoriamente.");
        return newOrder;
    }

    private static PuntosDeEntrega showLastCity(Stack<PuntosDeEntrega> stackOfOrders) {
        System.out.println(stackOfOrders.peek().toString());
        return stackOfOrders.pop();
    }

    private static Stack<PuntosDeEntrega> changeStatus(PuntosDeEntrega statusChangeValue, Stack<PuntosDeEntrega> auxStackOfOrders) {
        String showMsg = "Desea saldar la deuda de la ciudad mostrada anteriormente? (s/S || n/N)";
        if (Helper.continueProgram(showMsg)){
            statusChangeValue.setDebt_status(false);
            auxStackOfOrders.push(statusChangeValue);
        }
        return auxStackOfOrders;
    }

    private static String getValidsString(boolean allowNumbers, String selectedName) {
        String returnValue;
        String msg = "Ingrese valor de la " + selectedName;
        if (!allowNumbers){
            while(true){
                try {
                    returnValue = Helper.getValidsString(msg);
                    if (stringContainNumbers(returnValue)) throw new Exception("El nombre de una ciudad no puede tener numeros.");
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
