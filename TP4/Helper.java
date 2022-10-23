package TP4;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();


    // PT1.
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

    //PT
    public static int generateRandomIntegerInRange(int min, int max){
        return  min + (int)(Math.random() * max);
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


    //PT1
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

    public static String generateRandomAuthor() {
        String[] authors = {"J tentor", "Franco", "Alvaro99", "Leo", "Daniel_A", "Emma", "_Cesar_", "-Raul-"};
        return authors[generateRandomIntegerInRange(0, 8)].toString();
    }

    public static String generateRandomTitle() {
        String[] titles = {"Programacion orientada a objetos", "Mejores canciones de 2022", "2022 Remix", "Programacion web con Spring Boot e Hibernate", "Rock nacional - mejores canciones", "Programacion desde cero", "Mejores goles Messi 2007 - 2022", "Mejores jugadas Cristiano Ronaldo 2022"};
        return titles[generateRandomIntegerInRange(0, 8)].toString();
    }
}
