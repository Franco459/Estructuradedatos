/*
Implementar una función, módulo o subprograma que determine si un número entero positivo (validado)
es un número compuesto.
Definición: Número compuesto es todo número natural mayor que 1 que no es primo. Por ejemplo: 4, 6,
10.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
 */
package TP0;
/**
 *
 * @author FrancoGP
 */
public class PT4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true){
            String msg = "Ingrese un numero ENTERO POSITIVO";
            int num = Helper.forcePositiveIntEnter(msg);
            if (num != 1) verifyCompoundNumber(num);
            else System.out.println("El numero ingresado (1) no es valido para determinar si es un numero compuesto");
            if (!Helper.continueProgram()) break;            
        }
    }

///////////////////////////////////////////METHODS///////////////////////////////////////////
    private static void verifyCompoundNumber(int num) {
        boolean isCompound = false;
        for (int i = 2; i < num; i++){
            if (num % i == 0){ 
                isCompound = true;
                break;
            }
        }
        if (isCompound) System.out.println("El numero ingresado SI es un numero compuesto");
        else System.out.println("El numero ingresado NO es un numero compuesto");
    }  
}