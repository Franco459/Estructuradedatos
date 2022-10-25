package TP4;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public static int generateRandomNumbersInRange(int max, int min){
        return  -10 + (int) (Math.random() * ((10 - (-10)) + 1));
        
    }
    
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

    public static String generateRandomOperation() {
        String[] operations = {"{5[3+10-3]}", "{-4[-5(-12-7)]}", "10÷(5–3)", "-{45-28-(3-9)+(2+3)}", "4+28)(2+3)}", "(((4+28))(2/3)}", "4+9)", "{5*[4-(2*3))]}"};
        return operations[generateRandomIntegerInRange(0, 8)].toString();
    }

    public static Character getChar(String msg){
        String valueInput;
        while(true){
              try {
                System.out.println(msg);
                valueInput = entrada.nextLine();
                if ((valueInput.length() != 1)){
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

    public static String getStringOnlyLetters(String msg) {
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                for(int i=0; i<rtnString.length(); i++){
                    if(Character.isDigit(rtnString.charAt(i)))Integer.parseInt("s");
                }
                    if (rtnString.isEmpty() || rtnString.charAt(0) == ' ' || !rtnString.matches("[a-zA-Z \s+]+")) Integer.parseInt("s");
                return rtnString;
            }
            catch(Exception e){
                System.out.println("Ingrese una cadena valida. Sin espacios al comienzo y sin numeros.");
            }
        }
    }

    public static String generateRandomNames() {
        String[] nombres = {"Alvaro", "Franco Gabriel", "Marcos Eduardo", "Hugo Eduardo ", "Daniel Fernando", "Juan Raul", "Fede Alberto"};
        return nombres[generateRandomIntegerInRange(0, 7)];
    }

    public static String generateRandomSurnames() {
        String[] apellidos = {"Copa", "Pistone", "Mamani", "Vale ", "Gomez", "Blanco", "Fernandez"};
        return apellidos[generateRandomIntegerInRange(0, 7)];
    }

    public static String getStringOnlyLettersAndNumbers(String msg) {
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                if ((rtnString.matches("[a-zA-Z]+[0-9]+")) || rtnString.matches("[a-zA-Z]+")) return rtnString;
                else System.out.println("solo letras o letras y numeros");
            }
            catch(Exception e){
                System.out.println("Solo letras y numeros.");
            }
        }
    }

    public static String generateRandomUsernames() {
        String[] usuario = {"alvarocopa97", "fran99", "Usuario98", "usuario21", "9juan9", "hugo77", "87marco87"};
        return usuario[generateRandomIntegerInRange(0, 7)];
    }

    public static String getValidPassword(String msg) {
        String claveR = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
        "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
        "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
        "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
        "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
        "{8,32}$";
        Pattern pattern = Pattern.compile(claveR ); 
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                if (pattern.matcher(rtnString).matches() && rtnString.length() >= 8 && rtnString.length() <= 12) return rtnString;
                else System.out.println("La clave debe contener letras, símbolos especiales y dígitos.");
            }
            catch(Exception e){
                System.out.println("Ingrese una clave valida");
            }
        }
    }

    public static String generateRandomPassword() {
        String[] clave = {"12345$ra", "fran349#$%R", "marc3434#$", "danie3443#$# ", "%78alvaro", "juan1234#$%", "fede2342"};
        return clave[generateRandomIntegerInRange(0, 7)];
    }

    public static String getValidMail(String msg) {
        String emailREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-])+[a-zA-Z]";              
        Pattern pattern = Pattern.compile(emailREGEX); 
        while(true){
            try{
                System.out.println(msg);
                String rtnString = entrada.nextLine();
                if (pattern.matcher(rtnString).matches())return rtnString;
                else System.out.println("debe contener el unico simbolo @(no al final ni al principio)");
            }
            catch(Exception e){
                System.out.println("Ingrese una correo valido. Sin espacios al comienzo.");
            }
        }
    }

    public static String generateRandomMail() {
        String[] correo = {"usuario@hotmail.com", "carlosaguileram@hotmail.com", "paulifran@hotmail.com", "faraya@gmail.com", "alvaro@gmail.com", "juan@gmail.com", "fede@hotmail.com"};
        return correo[generateRandomIntegerInRange(0, 7)];
    }

    public static String generateRandomTypeOfAccount() {
        String[] cuenta = {"Premium", "Gratuita"};
        return cuenta[generateRandomIntegerInRange(0, 2)];
    }
}
