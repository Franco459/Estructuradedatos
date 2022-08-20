/*
Dadas las longitudes de los tres lados de un triángulo, determinar qué clasificación le corresponde
(Equilátero, Isósceles o Escaleno). Para ello, en primer lugar, se debe determinar si las medidas de los tres
lados forman un triángulo usando el teorema de la desigualdad del triángulo.
Teorema de la desigualdad del triángulo: La suma de las longitudes de cualquiera de los dos lados de un
triángulo es mayor que la longitud del tercer lado.
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
public class PT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int a = 0, b = 0, c = 0;
        while (true){
            try{
                int op = Helper.menuManualRandom();
                //seguir camino de la opcion elegida
                switch(op){
                    case 1:
                        a = Helper.forcePositiveIntEnter("Ingrese valor para el lado A");
                        b = Helper.forcePositiveIntEnter("Ingrese valor para el lado B");
                        c = Helper.forcePositiveIntEnter("Ingrese valor para el lado C");
                        break;
                    case 2:
                        a = Helper.randomIntGenerator(1, 999);
                        b = Helper.randomIntGenerator(1, 999);
                        c = Helper.randomIntGenerator(1, 999);
                        System.out.println("Los valores generados fueron: \n"
                                + "Valor lado A: " + a + "\n"
                                + "Valor lado B: " + b + "\n"
                                + "Valor lado C: " + c);
                        break;
                
                }
                if (verifyTriangle(a,b,c)) verifyType(a,b,c);
                else System.out.println("No son las medidas adecuadas para un triangulo.");
                
            }
            catch(Exception e){
                System.out.println("Error inesperado" + e);
            }
            if (!Helper.continueProgram()) break;  
        }
    }
    
    
///////////////////////METHODS////////////////////////////

    private static void verifyType(int a, int b, int c) {
        if ((a==b)&&(b==c)){
            System.out.println("Es un triangulo equilatero");
        }else if ((a!=b) && (b!=c) && (a!=c)){
            System.out.println("Es un triangulo escaleno");
        }else {
            System.out.println("Es un triangulo isoceles");
        }
    }

    private static boolean verifyTriangle(int a, int b, int c) {
        //realiza las operaciones logicas y devuelve un valor logico
        //teorema de desigualdad del triangulo
        boolean result = ((a+b>c) && (a+c>b) && (b+c>a));
        return result;
    }
}

