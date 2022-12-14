/*
Dadas las longitudes de cuatro segmentos correspondientes a una figura geométrica, determinar si la
    misma se trata de un cuadrado, de un rectángulo o de otro polígono. Si la figura es un cuadrado, calcular su
    perímetro. Si es un rectángulo, calcular su superficie. La entrada de datos debe continuar en tanto los
    segmentos ingresados sean valores positivos. Determinar la mayor superficie y el menor perímetro
    calculados. Además, informar cuantas figuras de las dadas no corresponden ni a un cuadrado ni a un
    rectángulo.
Indicaciones:
**Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
    código controle los problemas que normalmente ocurren al operar con la consola o teclado.
**Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
    respecto del código que hace lo que se solicita en el ejercicio.
 */
package TP0;

/**
 *
 * @author FrancoGP
 */

public class PT1 {

    static int side1 = 0;
    static int side2 = 0;
    static int side3 = 0;
    static int side4 = 0;
    static int base = 0;
    static int height = 0;
    static int maxSup = 0;
    static int minPer = 0;
    static int countErrors = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true){
            //fuerza entrada de enteros para los 4 lados
            String msg = "Ingrese valor ENTERO POSITIVO para el tamaño del lado numero: ";
            side1 = Helper.forceInteger(msg + 1);
            if (side1 <= 0 ) break;
            side2 = Helper.forceInteger(msg + 2);
            if (side2 <= 0 ) break;
            side3 = Helper.forceInteger(msg + 3);
            if (side3 <= 0 ) break;
            side4 = Helper.forceInteger(msg + 4);
            if (side4 <= 0 ) break;
            //descubre tipo de figura geometrica
            int opt = discoverType(side1, side2, side3, side4);
            //dependiendo de la figura hace una calculo y muestra un mensaje
            switch(opt){
                case 0:
                    countErrors++;
                    System.out.println("Se trata de otro poligono o no es posible formar uno con dichas medidas.");
                    break;
                case 1:
                    System.out.println("El perimetro del cuadrado es: " + perimeter(side1)); 
                    break;
                case 2: 
                    System.out.println("La superficie del rectangulo es: " + superfice());
                    break;
            }
            //pregunta para continar el programa
            if (!Helper.continueProgram()) break;
        }
        //muestra resultados finales en caso de no querer continuar el programa
        String finalMsg = createFinalMessage(maxSup,minPer,countErrors);
        Helper.showFinalResults(finalMsg);
    }
    
    ////////////////////////METHODS//////////////////////////////
    

    //s es la abreviacion de "side"
    private static int discoverType(int s1, int s2, int s3, int s4) {
        if (s1 == s2 && s2 == s3 && s3 == s4){
            System.out.println("Los lados ingresados pertenecen a un cuadrado.");
            return 1;
        }
        else if ((s1 == s2 && s3 == s4) || (s1 == s4 && s2 == s3)){
            base = s1;
            height = s3;
            System.out.println("Con los valores ingresados se formaria un rectangulo.");
            return 2;
        }
        else if ((s1 == s3 && s2 == s4)){ 
            base = s1;
            height = s2;
            System.out.println("Con los valores ingresados se formaria un rectangulo.");
            return 2;
        }
        else return 0;
    }

    
    //llama a variables globales
    private static int perimeter(int sides) {
        sides*=4;
        if (minPer == 0) minPer = sides;
        else if (minPer > sides ) minPer = sides;
        return sides;
    }

    //llama a variables globales
    private static int superfice() {
        int sup = base*height;
        if (maxSup == 0) maxSup = sup;
        else if (maxSup < sup) maxSup = sup;
        return sup;
    }
    
    private static String createFinalMessage(int maxSup2, int minPer2, int countErrors2) {
        String rtMsg = "";
        if (minPer > 0) rtMsg += "El menor perimetro calculado fue de: " + minPer + "\n";
        else  rtMsg += "No hubieron perimetros calculados en la ejecucion.\n";
        
        if (maxSup > 0) rtMsg +="La mayor superficie calculada fue de: " + maxSup + "\n";
        else rtMsg +="No hubieron superficies calculadas en la ejecucion. \n" ;

        if (countErrors >0) rtMsg +="Las figuras que no pertenecen a un cuadrado o rectangulo fueron: "+ countErrors;
        else rtMsg += "No se ingresaron figuras que no pertenecen a un cuadrado o rectangulo.";

        return rtMsg;
    }
}

