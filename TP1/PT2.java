/*
 Escribir un programa que permita ingresar el tamaño de un arreglo de números enteros y luego ingresar los
elementos del mismo, los cuales deben ser números primos. El programa debe mostrar el arreglo original y
a partir de él generar dos arreglos más: uno que contendrá los valores mayores a X (dado por el usuario) y
el otro que guardará los menores a Y (también dado por el usuario). Luego debe mostrar los arreglos
generados y revertir (dar vuelta) los valores de los mismos para mostrarlos nuevamente.
El ejercicio debe realizarse mediante la codificación de un método, función o subprograma que permita
mostrar cualquier tipo de arreglo; realice la especificación del método (precondiciones, postcondiciones y
firma).
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP1;
/**
 *
 * @author FrancoGP
 */
public class PT2 {
    public static void main(String[] args) {
        int[] allNumsArray;
        int[] overNumArray;
        int[] lowerNumArray;
        String msg = "Ingrese tamaño deseado del arreglo";
        int arraySize = Helper.forcePositiveIntEnter(msg);
        int option = Helper.menuManualRandom();
        allNumsArray = new int[arraySize];
        switch (option){
            case 1:
                for (int i = 0; i < arraySize; i++){
                    int num = isPrimo(true);
                    allNumsArray[i] = num;
                }
                //showArrayNums(allNumsArray); FALTA
                msg = "Ingrese numero para dividir los numeros ya ingresados.";
                int numberX = Helper.forcePositiveIntEnter(msg);
                msg = "Ingrese numero para dividir los numeros ya ingresados.";
                int numberY = Helper.forcePositiveIntEnter(msg);
                overNumArray = createLowerNumberArray(numberX, allNumsArray, false);
                lowerNumArray = createLowerNumberArray(numberY, allNumsArray, true);
                showAllArrays(overNumArray, lowerNumArray);
            break;
            case 2:
            break;
        }
    }
    ////////////////////////METHODS//////////////////////////////

    private static void showAllArrays(int[] overNumArray, int[] lowerNumArray) {
        
    }

    private static int[] createLowerNumberArray(int number, int[] allNumsArray, boolean isLower) {
        int[] aux = new int[allNumsArray.length];
        int j = 0;
        for (int i = 0; i < allNumsArray.length; i++){
            if (isLower){
                if(allNumsArray[i] < number){
                    aux[j] = allNumsArray[i];
            }
            else{
                if(allNumsArray[i] > number){
                    aux[j] = allNumsArray[i];
                }
            }
            j++;
            }
        }
        return aux;
    }

    private static int isPrimo(boolean manual) {
        boolean numPrimo = true;
        int value;
        String msg = "Ingrese el numero: ";;
        while (true){
            try{
                if (manual){
                    value = Helper.forceInteger(msg);
                    //forzamos error en caso de no cumplir la condicion
                    if (value <= 0) Integer.parseInt("a");
                }
                else value = Helper.randomIntGenerator(3, 999);
            for (int i = 2 ; i < value; i++){
                if (value % 2 == 0){
                    numPrimo = false;
                    break;
                }
            }
            if (!numPrimo) System.out.println("El numero ingresado NO ES PRIMO. Volverá a cargar un numero.");
            else return value;
            }
            catch(Exception e){
                System.out.println("Debe ser un numero ENTERO POSITIVO mayor que 0.\n Volverá a cargar el numero para verificar");
            }
        }
    }
}
