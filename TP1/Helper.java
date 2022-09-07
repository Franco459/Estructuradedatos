package TP1;

import java.util.Scanner;

public class Helper {
    
    static Scanner entrada = new Scanner(System.in);

    ///////////Methods///////////

    //USADO EN: PT1
    public static int forcePositiveIntEnter(String msg) {
        int size = 0;
        while(true){
            System.out.println(msg);
            try{
                size = Integer.parseInt(entrada.nextLine());
                if (size > 0) break;
                else System.out.println("Validos numeros mayores que 0");
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS POSITIVOS. "+e);
            }
        }
        return size;
    }
    //USADO EN PT2
    public static int forceInteger(String msg){
        int n = 0;
        while(true){
            System.out.println(msg);
            try{
                n = Integer.parseInt(entrada.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS. "+e);
            }
        }
        return n;
    }

    public static boolean continueProgram(){
        while (true){
            System.out.println("Desea continuar con la ejecucion del programa? Opciones validas: (S/s || N/n)");
            String resp = entrada.nextLine();
            if ("s".equals(resp.toLowerCase()) || "n".equals(resp.toLowerCase())) return ("s".equals(resp.toLowerCase()));
            else  System.out.println("Opcion no valida");
        }
    }

    //USADO EN PT1
    public static int menuTwoOptions(String msg) {
        int option = 0;
        while (true){
            try{
                //mostrar e ingresar valores para el menu
                System.out.println(msg);
                option = Integer.parseInt(entrada.nextLine());
                //corroborar si es correcta la opcion elegida
                if (option != 1 && option != 2) System.out.println("Valor no contemplado en las opciones del menu");
                else return option;
            }
            catch (NumberFormatException e){
                System.out.println("Ingrese valor NUMERICO valido" + e);
            }
        }
    }

    //USADO EN PT1
    public static int randomIntGenerator(int min, int max) {
        int x = (int) ((int)(Math.random()*((max-min)+1))+min);
	    return x;
    }

    //USADO EN PT1
    static void printOneDimensionArray(String textBefore, int[] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; ++i) {
            System.out.print("," + array[i]);
        }
        System.out.print("]");
        System.out.print(textAfter);
    }

    //USADO EN PT1
    static void printArrayWithNumberCondition(String textBefore, int[] array, int condition, Boolean isOverCondition) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        if (isOverCondition) {
            for (int i = 1; i < array.length; ++i) {
                if (array[i] > condition) System.out.print("," + array[i]);
            }
        }
        else{
            for (int i = 1; i < array.length; ++i) {
                if (array[i] < condition) System.out.print("," + array[i]);
            }
        }
        System.out.print("]");
        
    }

    //PT3
    static void printTwoDimensionArray(String textBefore, Object[][] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[[" + array[0][0]);
        for (int j = 1; j < array[0].length; ++j) {
            System.out.print("," + array[0][j]);
        }
        System.out.print("]");
 
        for (int i = 1; i < array.length; ++i) {
            System.out.print(",[" + array[i][0]);
            for (int j = 1; j < array[i].length; ++j) {
                System.out.print("," + array[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.print(textAfter);
    }
    
}
