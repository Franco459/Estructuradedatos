package TP5;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    
    //region Static Objects
    static Random random = new Random();
    static Scanner entrada = new Scanner(System.in);
    //endregion

       //region Integer Helpers
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
    //endregion
    

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
    
    public static int generateRandomIntegerInRange(int min, int max){
        return  random.nextInt((max - min) + 1) + min;
    }


    public static Double randomDoubleGenerator(int rangeMin, int rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }

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
        return getFloat(entrada, inputMessage, errorMessage);
    }
    public static Float getFloat(String inputMessage) {
        return getFloat(entrada, inputMessage, "Ingrese un número válido\n");
    }
}
