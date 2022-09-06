/*
Escribir un programa que permita cargar, por la consola o teclado, dos arreglos de enteros con la misma
dimensión, la cual será indicada por el usuario. En uno de los arreglos se deben ingresar solamente
números ----deficientes---- y en el otro arreglo se deben ingresar solamente números ----compuestos----. El programa
debe calcular, en un tercer arreglo, la -----diferencia----- de los mismos. Además, se debe obtener la media del
arreglo diferencia; mostrar los valores del primer vector que resultan mayores a la media y mostrar los
valores del segundo vector que resultan menores a la media.
Definiciones:
Número compuesto es todo número natural mayor que 1 que no es primo. Por ejemplo: 4, 6, 10.
Número deficiente es todo número natural que cumple con que la suma de sus divisores propios es menor
que el propio número. Por ejemplo, 16 es un número deficiente ya que sus divisores propios son 1, 2, 4 y 8
y la suma de ellos (1+2+4+8=15) es menor que 16.
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
public class PT1 {
    public static void main(String[] args) {

        int[] deficientes; 
        int[] compuestos;
        int[] diferencia;
        int num;
        String msg = "Ingrese tamaño del arreglo a cargar";
        int arraySize = Helper.forcePositiveIntEnter(msg);
        deficientes = new int[arraySize];
        compuestos = new int[arraySize];
        diferencia = new int[arraySize];
        int option = Helper.menuManualRandom();
        switch(option){
            case 1:
                System.out.println("Ha elegido la opcion MANUAL.");
                System.out.println("****** CARGAR NUMEROS DEFICIENTES ******");
                for (int i = 0; i < arraySize ; i++){
                    msg = "Ingrese el numero para la posicion " + (i+1);
                    num = verifyDeficentNumber(msg);
                    System.out.println("Numero ingresado: '"+ num +"', añadido exitosamente.");
                    deficientes[i] = num;
                }
                System.out.println("****** CARGAR NUMEROS DEFICIENTES ******");
                for (int i = 0; i < arraySize ; i++){
                    msg = "Ingrese el numero para la posicion " + (i+1);
                    num = forceCompoundNumber(msg);
                    System.out.println("Numero ingresado: '"+ num +"', añadido exitosamente.");
                    compuestos[i] = num;
                }
                diferencia = createArrayDiferencia(diferencia, deficientes, compuestos, arraySize);
            break;
            case 2:
            /****************************************
                        FALTA PARTE AUTOMATICA
             *****************************************/
            break;
        }
        int ratio = calculateRatio(deficientes, arraySize);
        showArrays(compuestos, deficientes, ratio);
    }

    ////////////////////////METHODS//////////////////////////////
    

    private static int calculateRatio(int[] deficientes, int arraySize) {
        
        int ratio = calculateAll(deficientes) / arraySize;
        System.out.println("La media del arreglo con las diferencias es de: "+ ratio);
        return ratio;
    }

    private static void showArrays(int[] compuestos, int[] deficientes, int ratio) {
        
        String textBefore = "Se procederá a mostrar los datos del arreglo de DEFICIENTES mayores a la media: ";
        Helper.printOneNumericDimensionArrayWithNumberCondition(textBefore, deficientes, ratio, true);
        
        textBefore = "Se procederá a mostrar los datos del arreglo de COMPUESTOS menores a la media: ";
        Helper.printOneNumericDimensionArrayWithNumberCondition(textBefore, compuestos, ratio, false);
    }

    private static int calculateAll(int[] deficientes) {
        int sum = 0;
        for (int i : deficientes) {
            sum += i;
        }
        return sum;
    }

    private static int[] createArrayDiferencia(int[] diferencia, int[] deficientes, int[] compuestos, int arraySize) {
        for(int i = 0; i < arraySize; i++){
            diferencia[i] = deficientes[i] - compuestos[i];
        }
        return diferencia;
    }

    private static int forceCompoundNumber(String msg){
        int num = 0;
        num = Helper.forcePositiveIntEnter(msg);
        while(true){
            boolean isCompound = false;
            for (int i = 2; i <= num; i++){
                if (num % i == 0){ 
                    isCompound = true;
                    break;
                }
            }
            if (isCompound) return num;
            else{ 
                System.out.println("El numero ingresado NO es un numero compuesto.\n Volverá a cargar el numero para verificar");
                num = Helper.forcePositiveIntEnter(msg);
            }
        }
    }

    private static int verifyDeficentNumber(String msg) {
        int num;
        num = forceValidNumber(msg);
        while (true){
            int divSum = 0;
            for (int i = 1; i < num; i++){
                if(num % i == 0){
                    divSum += i;
                }
            }
            if ( divSum < num ) return num;
            else{
                System.out.println("El numero ingresado no es DEFICIENTE.\n Volverá a cargar el numero para verificar");
                num = forceValidNumber(msg);
            } 
        }
    }
    
    private static int forceValidNumber(String msg) {
        int isValidnum = 0;
        while (true){
            isValidnum = Helper.forcePositiveIntEnter(msg);
            if (isValidnum == 1) System.out.println("El numero 1 no es valido");
            else return isValidnum;
        }
    }
}