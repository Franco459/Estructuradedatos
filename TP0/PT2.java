/*
Ingresar una cantidad de N ángulos (en grados) e indicar, por cada uno, si se trata de un ángulo agudo,
    recto, obtuso, llano u otro. Determinar la cantidad de ángulos obtusos y la cantidad de ángulos mayores a
    180° ingresados. Además, para cada ángulo obtuso determinar su suplemento y para cada ángulo agudo
    determinar su complemento. A los fines de simplificar la complejidad del problema, considere que los
    ángulos ingresados corresponden a valores enteros.

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
public class PT2 {
    ///////VARIABLES GLOBALS//////
    static int countOnehundredAngles, countObtuse;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String msg = "";
        countOnehundredAngles = 0; countObtuse = 0;
        while (true){
            int n = 0, ang = 0; 
            //menu
            int op = Helper.menuManualRandom();
            //mensaje y pedido de cantidad de angulos
            msg = "Coloque la cantidad de angulos que desea ingresar.";
            n = Helper.forcePositiveIntEnter(msg);
            //opciones
            switch (op){
                //manual
                case 1:
                    for (int i = 0; i < n ; i++){
                        msg = "Ingrese el valor del angulo N°: " + (i+1);
                        ang = Helper.forcePositiveIntegerWithZ(msg);
                        int type = determineAngleType(ang);
                        determineAction(type, ang);
                    }
                    break;
                    
                case 2: 
                    //aleatorio
                    for (int i = 0; i < n ; i++){
                        ang = Helper.randomIntGenerator(0, 363);
                        System.out.println("El angulo n°"+ (i+1)+" generado es de " + ang + " grados.");
                        int type = determineAngleType(ang);
                        determineAction(type, ang);
                    }
                    break;
            }
            if (!Helper.continueProgram()) break;
        }

        String finalMsg = createFinalMessage(countObtuse, countOnehundredAngles);
        Helper.showFinalResults(finalMsg);
    }
///////////////////////////////////////////METHODS///////////////////////////////////////////
    private static int determineAngleType(int ang) {
        //descubrir tipo de angulo por su valor
        int type = 0;
        String strType;
        if (ang == 0) {
            type = 0;
            strType = "nulo";
        }
        else if (ang < 90){
            type = 1;
            strType = "agudo";
        }
        else if (ang == 90){
            type = 0;
            strType = "recto";
        }
        else if (ang > 90 && ang < 180){
            type = 2;
            strType = "obtuso";
        }
        else if (ang == 180){
            type = 0;
            strType = "llano";
        }
        else if (ang > 180 && ang < 360 ){
            type = 3;
            strType = "concavo";
        }
        else if (ang == 360){
            type = 3;
            strType = "de giro completo";
        }
        else{
            type = 3;
            strType = "mas de un giro completo";
        }
        System.out.println("El angulo ingresado de " + ang + "°, pertenece a un angulo " + strType);
        return type;
    }

    private static void calculateComplement(int ang) {
        //calculo complemento al momento de mostrar mensaje
        System.out.println("El complemento del angulo de " + ang + " grados es: " + (90-ang));
    }

    private static void calculateSupplement(int ang) {
        //calculo de suplemento al momento de mostrar mensaje
        System.out.println("El suplemento del angulo de " + ang + " grados es: " + (180-ang));
    }

    private static void determineAction(int type, int ang) {
        switch (type){
            case 0:
                System.out.println("El angulo ingresado no es obtuso ni agudo. No se realizara calculo de suplemento/complemento del mismo.");
                break;
            case 1:
                calculateComplement(ang);
                break;
            case 2:
                countObtuse++;
                calculateSupplement(ang);
                break;
            case 3:
                System.out.println("El angulo ingresado no es obtuso ni agudo. No se realizara calculo de suplemento/complemento del mismo.");
                countOnehundredAngles++;
                break;
        }
    }

    private static String createFinalMessage(int countObtuse2, int countOnehundredAngles2) {
        //generacion de mensaje para mostrar resultados finales
        String rtrnMsg = "";
        if (countObtuse > 0) rtrnMsg += "La cantidad de angulos obtusos ingresados en el sistema fue de: " + countObtuse + "\n";
        else  rtrnMsg += "No hubieron angulos obtusos ingresados en el sistema.\n";
        
        if (countOnehundredAngles > 0) rtrnMsg +="La cantidad de angulos mayores a 180° cargados fue de: " + countOnehundredAngles;
        else rtrnMsg += "No hubieron angulos mayores a 180 grados cargados.";
        return rtrnMsg;
    }
}
