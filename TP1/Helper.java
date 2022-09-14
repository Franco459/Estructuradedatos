package TP1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    
    static Scanner entrada = new Scanner(System.in);
    static Random rnd = new Random();
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

    public static boolean continueProgram(String msg){
        while (true){
            if (msg.isEmpty()) msg = "Desea continuar con la ejecucion del programa? Opciones validas: (S/s || N/n)";
            System.out.println(msg);
            String resp = entrada.nextLine();
            if ("s".equalsIgnoreCase(resp) || "n".equalsIgnoreCase(resp)) return ("s".equalsIgnoreCase(resp));
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
    static void printTwoDimensionArray(String textBefore, int[][] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[[" + array[0][0]);
        for (int j = 1; j < array[0].length; ++j) {
            System.out.print("," + array[0][j]);
        }
        System.out.print("]");
 
        for (int i = 1; i < array.length; ++i) {
            System.out.print("\n[" + array[i][0]);
            for (int j = 1; j < array[i].length; ++j) {
                System.out.print("," + array[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.print(textAfter);
    }

    //PT4
    public static void printArrayList(ArrayList<Integer> auxArray, String msg) {
        System.out.println(msg);
        String itemsArrayList = "";
        boolean firstItem = true;
        for (Integer in : auxArray) {
            if (firstItem){
                itemsArrayList += in;
                firstItem = false;
            }
            else itemsArrayList += ", " + in;
            
        }
        System.out.println("[" + itemsArrayList + "]");
    }
    
    // PT5 Y 6
    public static Float getFloat(Scanner entrada, String inputMessage, String errorMessage) {
        Float floatValuer = 0f;
        while (true) {
            try {
                System.out.print(inputMessage);
                floatValuer = Float.parseFloat(entrada.nextLine());
                return ((int) ((floatValuer + 0.005f) * 100)) / 100f;
            }
            catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }
    public static Float getFloat(Scanner entrada, String inputMessage) {
        return getFloat(entrada, inputMessage, "Ingrese un número válido\n");
    }
    public static Float getFloat(String inputMessage, String errorMessage) {
        return getFloat(Helper.entrada, inputMessage, errorMessage);
    }
    public static Float getFloat(String inputMessage) {
        return getFloat(Helper.entrada, inputMessage, "Ingrese un número válido\n");
    }

    // PT5 Y 6
    public static String getValidsString(String msg){
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                if (rtnString.isEmpty() || rtnString.charAt(0) == ' ') Integer.parseInt("s");
                return rtnString;
            }
            catch(Exception e){
                System.out.println("Ingrese una cadena valida. Sin espacios al comienzo.");
            }
        }
    }
    
    // PT5 Y 6
    public static String generateRandomNames(int op){
        String[] authors = {"Luis Borges", "J. K. Rowling", "Julio Cortazar", "Stephen King", "Charles Bukowski"};
        String[] editorials = {"Mansalva", "Utopía", "The scotts", "For fun", "Dior"};
        String[] titles = {"Sicko mode", "Harry Potter", "Garfield", "IT", "La maquina de hacer pajaros"};
        if (op == 1) return authors[randomIntGenerator(0, 4)].toString();
        else if (op == 2) return editorials[randomIntGenerator(0, 4)].toString();
        else return titles[randomIntGenerator(0, 4)].toString();
    }

    //PT5 Y 6
    public static float generateRandomFloatInRange(int min, int max){
        return  min + rnd.nextFloat() * (max - min);
    }

    public static char randomCharGenerator() {
        char c = (char)(rnd.nextInt(26) + 'a');
        return c;
    }

    ///////////////////////////signature show array///////////////////////////

    //se recibe solamente el array y se manda mensaje previo
    public static String showArraySignature(int[] selectedArray){
        return showArraySignature(selectedArray, "Mostrando los datos del arreglo: \n");
    }

    //se recibe el array y el mensaje previo, se crea un posible mensaje de error para mostrar
    private static String showArraySignature(int[] selectedArray, String previousMsg) {
        return showArraySignature(selectedArray, previousMsg, "****El arreglo esta vacio****");
    }

    //recibe todos los parametros y hace la eleccion de que mensaje mostrar dependiendo del arreglo y su contenido
    private static String showArraySignature(int[] selectedArray, String previousMsg, String errorEmptyArray) {
        
        Boolean varIsEmpty = true;
        String arrayMsg = "[" + selectedArray[0];
        //Un solo recorrido para saber si esta vacio y si no lo está que vaya concatenando para el retorno final del metodo
        for (int i = 0; i < selectedArray.length; i ++) {
            if (selectedArray[i] != 0){
                if(varIsEmpty) varIsEmpty = false;
                if (i != 0) arrayMsg += ", " + selectedArray[i];
            }
        }
        
        if(!varIsEmpty) return (previousMsg + arrayMsg + "]");
        else return errorEmptyArray;
    }
}
