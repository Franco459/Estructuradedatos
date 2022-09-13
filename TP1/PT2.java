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
        int[] allNumbsArray;
        int[] upperNumberArray;
        int[] lowerNumberArray;
        String msg = "Ingrese tamaño deseado del arreglo";
        int arraySize = Helper.forcePositiveIntEnter(msg);
        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);
        allNumbsArray = new int[arraySize];
        switch(option){
            case 1:
                for(int i = 0; i < arraySize; i++){
                    int numberSelected = getCorrectNumber(true);
                    allNumbsArray[i] = numberSelected; 
                }
            break;
            case 2:
                for(int i = 0; i < arraySize; i++){
                    int numberSelected = getCorrectNumber(false);
                    allNumbsArray[i] = numberSelected; 
                }
            break;
        }
        //TODO :  Mostrar el array generado o ingresado manualmente arriba en el switch
        Helper.showArraySignature(allNumbsArray);
        
        msg = "Ingrese numero X para separar un arreglo con valores mayores a este.";
        int xNumber = Helper.forcePositiveIntEnter(msg);
        upperNumberArray = splitArrays(xNumber, true, allNumbsArray);
        msg = "Ingrese numero Y para separar un arreglo con valores menores a este.";
        int yNumber = Helper.forcePositiveIntEnter(msg);
        lowerNumberArray = splitArrays(yNumber, false, allNumbsArray);

        //TODO :  Mostrar los array generados upper y lower
        System.out.println("Arreglo generado con valores mayores a " + xNumber);       
        Helper.showArraySignature(upperNumberArray);    
        System.out.println("Arreglo generado con valores menores a " + yNumber);
        Helper.showArraySignature(lowerNumberArray);

        System.out.println("***Mostrando arreglos revertidos***");
        upperNumberArray = reverseArray(upperNumberArray);
        lowerNumberArray = reverseArray(lowerNumberArray);
        //TODO :  Mostrar los array revertidos upper y lower
        Helper.showArraySignature(upperNumberArray);    
        Helper.showArraySignature(lowerNumberArray);
    }

    ////////////////////////METHODS//////////////////////////////

    private static int[] reverseArray(int[] selectedArray) {
        int size = selectedArray.length;
        int[] auxArray = new int[size];
        int position = 0;
        for(int i = size-1; i >= 0; i--){
            auxArray[position] = selectedArray[i];
            position++;
        }
        return auxArray;
    }

    private static int[] splitArrays(int conditionalNumber, boolean createUpper, int[] allNumbsArray) {
        //createUpper es para saber si comparar con el signo de mayor que o menor que
        int size = allNumbsArray.length, position = 0;
        int[] auxArray = new int[size];
        for(int i = 0; i < size; i++){

            if(createUpper && allNumbsArray[i] > conditionalNumber){
                auxArray[position] = allNumbsArray[i];
                position++;
            }
            else if (allNumbsArray[i] < conditionalNumber) {
                auxArray[position] = allNumbsArray[i];
                position++;
            }
        }
        return auxArray;
    }

    private static int getCorrectNumber(boolean isManual) {
        String showMsg = "Ingrese un numero: ";
        int selectedValue;
        while(true){
            try {
                if (isManual) selectedValue = Helper.forcePositiveIntEnter(showMsg);
                else selectedValue = Helper.randomIntGenerator(1, 99);
                if (isPrimo(selectedValue)) return selectedValue; 
                else if (isManual) Integer.parseInt("s"); //forzar error para mostrar mensaje y pedir de nuevo ingreso
            } catch (Exception e) {
                System.out.println("El numero ingresado NO es primo. Cargará de nuevo un valor.");
            }
        }
    }

    private static boolean isPrimo(int value) {
        if (value == 1 || value == 4) return false;
        for (int i = 2 ; i < value; i++){
            if (value % i == 0){
                return false;
            }
        }
        return true;
    }
}
    ////////////////////////METHODS//////////////////////////////
/*

allNumsArray = new int[arraySize];
        switch (option){
            case 1:
                for (int i = 0; i < arraySize; i++){
                    int num = isPrimo(true);
                    allNumsArray[i] = num;
                }
                //showArrayNums(allNumsArray); FALTA
                msg = "Ingrese un numero X para dividir los numeros ya ingresados.";
                int numberX = Helper.forcePositiveIntEnter(msg);
                msg = "Ingrese un numero Y para dividir los numeros ya ingresados.";
                int numberY = Helper.forcePositiveIntEnter(msg);
                overNumArray = createLowerUpperNumberArray(numberX, allNumsArray, false);
                lowerNumArray = createLowerUpperNumberArray(numberY, allNumsArray, true);
               //lñlamar al del helper showAllArrays(overNumArray, lowerNumArray);
               //revertir
            break;
            case 2:
            break;
////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int[] createLowerUpperNumberArray(int number, int[] allNumsArray, boolean isLower) {
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
}*/
