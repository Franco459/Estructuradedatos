package TP5;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    
    //region Static Objects
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //endregion

       //region Integer Helpers
       public static int forceInteger(String msg){
        int n = 0;
        while(true){
            System.out.println(msg);
            try{
                n = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS. "+e);
            }
        }
        return n;
    }
    //endregion
    
}
