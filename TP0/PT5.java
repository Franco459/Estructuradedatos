
/*
Encontrar el máximo común divisor de dos números enteros positivos (validados).
Definición: El máximo común divisor de dos o más números enteros es el mayor número entero que los
divide exactamente a todos, esto es sin dejar resto en cada división.
Solución: El algoritmo de Euclides transforma un par de enteros positivos en otro par, dividiendo
repetidamente el entero mayor por el menor y reemplazando el mayor por el menor y el menor por el
resto. Cuando el resto es 0, el número más pequeño distinto de cero de la pareja resultante será el máximo
común divisor de la pareja original.
Modifique el programa escrito de manera que cuente con una función, procedimiento o método que
realice lo solicitado mediante el uso de la consola y otra modalidad que haga exactamente lo mismo, pero
reemplazando el ingreso de valores por consola por un generador de valores aleatorio.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
También necesita del objeto random para generar valores de manera aleatoria.
 */
package TP0;

/**
 *
 * @author FrancoGP
 */
public class PT5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String msg = "Ingrese numero A";
        int a = Helper.forcePositiveIntEnter(msg);
        msg = "Ingrese numero B";
        int b = Helper.forcePositiveIntEnter(msg);
        euclideanAlgorithm(a,b);
        // System.out.println("El MCD entre los numeros" + a + " y " + b + " es: " + euclideanAlgorithm(a,b));
    }

    ////////////////////////METHODS//////////////////////////////
    private static void euclideanAlgorithm(int a, int b) {
        int i = a;
        int j = b;
        while(b>0){
           if(a > b) a-=b;
           else b-=a;
       }
        System.out.println("El MCD entre los numeros" + i + " y " + j + " es: " + a);
    }
    //Algoritmo de euclides recursivo
    /*
    private int euclideanAlgorithm(int p, int q) {
        if (q == 0) return p;
        else return EuclidesRecursivo(q, p % q);
    }
    */
}
