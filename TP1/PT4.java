/*
Escribir un programa que permita generar los términos de la serie Fibonacci y guardarlos, hasta que el
usuario decida no continuar. El programa debe calcular y mostrar la suma de los números pares, la cantidad
de los impares, el promedio de los términos generados y la cantidad de términos mayores a dicho
promedio.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
 */
package TP1;

import java.util.ArrayList;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> fibonacciArray = new ArrayList<>();
        fibonacciArray = fibonacciMethod();
        showFinalResults(fibonacciArray);
    }

    
    
    ////////////////////////METHODS//////////////////////////////


    private static void showFinalResults(ArrayList<Integer> fibonacciArray) {
        System.out.println("La suma de los numeros pares es: " + showPairNumbersSum(fibonacciArray));
        System.out.println("La cantidad de numeros impares es: " + showAmountOdd(fibonacciArray));
        double ratio = ratioArray(fibonacciArray);
        System.out.println("El promedio de los terminos es: " + ratio);
        showOverRatio(fibonacciArray, ratio);
    }

    private static void showOverRatio(ArrayList<Integer> fibonacciArray, double ratio) {
        ArrayList<Integer> auxArray = new ArrayList<>();
        for (Integer in : fibonacciArray) {
            if (in > ratio) auxArray.add(in);
        }
        String msg = "Mostrando elementos mayores a la media: " + ratio;
        Helper.printArrayList(auxArray, msg);
    }

    private static double ratioArray(ArrayList<Integer> fibonacciArray) {
        int ratio = 0;
        for (Integer in : fibonacciArray) {
            ratio += in;
        }
        return ratio / fibonacciArray.size();
    }

    private static int showAmountOdd(ArrayList<Integer> fibonacciArray) {
        int count = 0;
        for (Integer in : fibonacciArray) {
            if (in % 2 != 0) count += 1;
        }
        return count;
    }

    private static int showPairNumbersSum(ArrayList<Integer> fibonacciArray) {
        int sum = 0;
        for (Integer in : fibonacciArray) {
            if (in % 2 == 0) sum += in;
        }
        return sum;
    }

    private static ArrayList<Integer> fibonacciMethod() {
        ArrayList<Integer> auxArray = new ArrayList<>();
        int itemCount = 2, first, second;

        auxArray = initializeArray();
        while (true){
            if (stopProgram(itemCount)) break;
            first = auxArray.get(itemCount-1);
            second = auxArray.get(itemCount-2);
            auxArray.add(first + second);
            itemCount++;
            
            String msg = "Mostrando elementos generados hasta el momento";
            Helper.printArrayList(auxArray, msg);
        }

        return auxArray;
    }

    private static ArrayList<Integer> initializeArray() {
        ArrayList<Integer> toInitialize = new ArrayList<>();
        int first = 0, second = 1;
        toInitialize.add(first);
        toInitialize.add(second);
        System.out.println("Array inicializado con los elementos " + first +", " + second);
        return toInitialize;
    }

    private static boolean stopProgram(int itemsC) {
        System.out.println("Cantidad de items generados y almacenados hasta el momento: " + itemsC);
        String showMsg = "Desea generar y almacenar mas items?";
        return  (Helper.continueProgram(showMsg))? false : true;
    }
    
}
