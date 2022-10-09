package TP3;

import java.util.Random;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Helper {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

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

    public static int generateRandomIntegerInRange(int min, int max){
        return  min + (int)(Math.random() * max);
    }

    public static String getValidsString(String msg){
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                if (rtnString.length() == 0 || rtnString.charAt(0) == ' ') Integer.parseInt("s");
                return rtnString;
            }
            catch(Exception e){
                System.out.println("Ingrese una cadena valida. Sin espacios al comienzo.");
            }
        }
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

    public static String randomStringOfArray(){
        String[] arrayNonEncrypted = {"Hola", "HOLA QUE TAL", "Buen dia", "Copa del mundo", "Qatar 2022"};
        
        return arrayNonEncrypted[generateRandomIntegerInRange(0, 4)];
    }

    public static int menuOptions(String msg, int amountOfOptions) {
        while(true){
            try {
                int response = Helper.forcePositiveIntEnter(msg);
                for (int i = 1; i <= amountOfOptions; i++) {
                    if (i == response) return i;
                }
                throw new RuntimeException("La opcion ingresada no es valida");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //PT1
    public static char generateRandomChar(){
        return (char)(random.nextInt(26) + 'a');
    }

    public static Character getChar(String msg){
        String valueInput;
        while(true){
              try {
                System.out.println(msg);
                valueInput = entrada.nextLine();
                if (!(valueInput.matches("[a-zA-Z]+")) || (valueInput.length() != 1)){
                    throw new RuntimeException("Solo caracteres ALFABETICOS y longitud MAXIMA 1");
                }
                else{  
                    return Character.toLowerCase(valueInput.charAt(0));
                }
              } catch (Exception e) {
                    System.out.println("Solo caracteres ALFABETICOS y longitud MAXIMA 1");
              }
        }
    }
}
