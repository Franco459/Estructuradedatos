/*
 MADE BY FRANCO PISTONE 2022
 */
package TP0;

import java.util.Scanner;


/**
 *
 * @author FrancoGP
 */
public class Helper {
    
    static Scanner entrada = new Scanner(System.in);
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
    
    public static int forceIntegerWithoutZ(String msg){
        int n = 0;
        while(true){
            System.out.println(msg);
            try{
                n = Integer.parseInt(entrada.nextLine());
                if (n != 0) break;
                else System.out.println("Ingrese un numero mayor a 0");
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS. "+e);
            }
        }
        return n;
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

    public static int forcePositiveIntegerWithZ(String msg){
        int n = 0;
        while(true){
            System.out.println(msg);
            try{
                n = Integer.parseInt(entrada.nextLine());
                if (n >=0) break;
                else System.out.println("Ingrese un numero mayor o igual a 0");
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS. "+e);
            }
        }
        return n;
    }

    public static void showFinalResults(String msg) {
        System.out.println("************FIN DE EJECUCION************");
        System.out.println("Se mostraran resultados finales: ");
        System.out.println(msg);
        System.out.println("******************FIN******************");
    }

    public static int menuManualRandom() {
        int option = 0;
        while (true){
            try{
                //mostrar e ingresar valores para el menu
                System.out.println("---------------MENU---------------");
                System.out.println("1- Ingresar valores manuales");
                System.out.println("2- Ingresar valores aleatorios");
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

    public static int randomIntGenerator(int min, int max) {
        int x = (int) ((int)(Math.random()*((max-min)+1))+min);
	return x;
    }
    
    public static boolean continueProgram(){
        while (true){
            System.out.println("Desea continuar con la ejecucion del programa? Opciones validas: (S/s || N/n)");
            String resp = entrada.nextLine();
            if ("s".equals(resp.toLowerCase()) || "n".equals(resp.toLowerCase())) return ("s".equals(resp.toLowerCase()));
            else  System.out.println("Opcion no valida");
        }
    }
}
/*
 MADE BY FRANCO PISTONE 2022
 */