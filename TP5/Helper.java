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
}
