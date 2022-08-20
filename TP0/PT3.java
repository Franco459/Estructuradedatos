/*
 Dado un número entero positivo, determinar si el mismo es perfecto, abundante o deficiente. Incluir la
validación pertinente para el ingreso del número.
Definiciones:
Número perfecto: es todo número natural que es igual a la suma de sus divisores propios (es decir, todos
sus divisores excepto el propio número). Por ejemplo, 6 es un número perfecto ya que sus divisores
propios son 1, 2, y 3 y se cumple 1+2+3=6.
Número abundante: es todo número natural que cumple con que la suma de sus divisores propios es
mayor que el propio número. Por ejemplo, 12 es abundante ya que sus divisores son 1, 2, 3, 4 y 6 y la suma
de ellos (1+2+3+4+6=16) es mayor que 12.
Número deficiente: es todo número natural que cumple con que la suma de sus divisores propios es menor
que el propio número. Por ejemplo, 16 es un número deficiente ya que sus divisores propios son 1, 2, 4 y 8
y la suma de ellos (1+2+4+8=15) es menor que 16.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
También necesita del objeto random para generar valores de manera aleatoria.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP0;


/**
 *
 * @author FrancoGP
 */
public class PT3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true){
            int op = Helper.menuManualRandom();
            int num = 0;
            switch(op){
                case 1:
                    String msg = "Ingrese el numero para comprobar";
                    num = Helper.forcePositiveIntEnter(msg);
                    break;
                case 2:
                    num = Helper.randomIntGenerator(1, 999);
                    System.out.println("El numero generado aleatoriamente fue: " + num);
                    break;
            }
            verifyNumberType(num);
            if (!Helper.continueProgram()) break;
        }
    }

    ////////////////////////METHODS//////////////////////////////
    
    private static void verifyNumberType(int num) {
        int divSum = 0;
        for (int i = 1; i < num; i++){
            if(num % i == 0){
                divSum += i;
            }
        }
        if ( divSum < num ) System.out.println("El numero es del tipo DEFICIENTE");
        if ( divSum == num ) System.out.println("El numero es del tipo PERFECTO");
        if ( divSum > num ) System.out.println("El numero es del tipo ABUNDANTE");
    }
}