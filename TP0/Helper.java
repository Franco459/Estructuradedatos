/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public static int forceInteger(String msg){
        int N = 0;
        while(true){
            System.out.println(msg);
            try{
                N = Integer.parseInt(entrada.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.println("SOLAMENTE VALIDOS NUMEROS ENTEROS. "+e);
            }
        }
        return N;
    }
    public static void showFinalResults(String msg) {
        System.out.println("************FIN DE EJECUCION************");
        System.out.println("Se mostraran resultados finales: ");
        System.out.println(msg);
        System.out.println("******************FIN******************");
    }
}