/*
 Se puede ver que la clave de cifrado se repite al finalizar la misma. Esa forma de reutilizar los valores de la
clave de cifrado se puede lograr con una estructura de datos que tenga comportamiento FIFO, o sea una
cola.
Teniendo en cuenta lo antes mencionado, deberá crear los métodos que permitan Codificar y Decodificar
una cadena de caracteres (mensaje) para una determinada clave (vector de valores).
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP3;

public class PT4v2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //region variables
        String msg, stringToEncrypt;
        int optionAction, keyCodeSize, optionGenerateValues;
        Queue_circular<Integer> keyCodeQueue;
        //end region variables

        //region eleccion codificar/decodificar cadena
        msg = "---------------MENU ELECCION ACCION PUNTO 4--------------- \n"
        +    "1- Codificar cadena \n"
        +    "2- Decodificar cadena \n"
        +    "***AVISO: Para decodificar cadenas aleatorias recomendamos elegir claves de cifrado [1,2,3] || [9,7,6,2] || [5,8]\n"
        +    " para mayor posibilidad de descubrir el mensaje oculto***";
        optionAction = Helper.menuTwoOptions(msg);
        //end region eleccion codificar/decodificar cadena


        //region manual random
        msg = "---------------MENU VALORES PARA CIFRADO PUNTO 4--------------- \n"
        +    "1- Crear valores manuales \n"
        +    "2- Crear valores aleatorios ";
        optionGenerateValues = Helper.menuTwoOptions(msg);

        
        msg = "Ingrese tamaño de la clave de cifrado: ";
        keyCodeSize = Helper.forcePositiveIntEnter(msg);

        if (optionGenerateValues == 1){
            if (optionAction == 1){
                keyCodeQueue = createKeyCode(keyCodeSize, true);

                msg = "Ingrese una cadena para cifrar: ";
                stringToEncrypt = Helper.getValidsString(msg);
            }
            else{
                
                keyCodeQueue = createKeyCode(keyCodeSize, false);

                //TODO random string
                stringToEncrypt = "";
            }
            System.out.println("La cadena: \n"
                            + stringToEncrypt
                            + " fue encriptada.");
            System.out.println("Cadena final:\n"
                            + encryptMethod(keyCodeQueue, stringToEncrypt));
        }
        else{
            if (optionAction == 1){
                keyCodeQueue = createKeyCode(keyCodeSize, true);

                msg = "Ingrese una cadena para cifrar: ";
                stringToEncrypt = Helper.getValidsString(msg);

            }
            else{
                keyCodeQueue = createKeyCode(keyCodeSize, false);

                //TODO random string
                stringToEncrypt = Helper.selectStringOfArray(true);
            }
            System.out.println("La cadena: \n"
                            + stringToEncrypt
                            + " fue desencriptada.");
            System.out.println("Cadena final:\n"
                            + desencryptMethod(keyCodeQueue, stringToEncrypt));
        }
        //end region manual random

    }

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static String desencryptMethod(Queue_circular<Integer> keyCodeQueue, String stringToEncrypt) {
        //region variables locales
        String auxString = "";
        int intQueueValue;
        //end region variables
        for (char charOfString : stringToEncrypt.toCharArray()) {
            intQueueValue = keyCodeQueue.pool();
            auxString += (char)((int)charOfString - intQueueValue);
            keyCodeQueue.add(intQueueValue);
        }
        return auxString;
    }

    private static String encryptMethod(Queue_circular<Integer> keyCodeQueue, String stringToEncrypt) {
        //region variables locales
        String auxString = "";
        int intQueueValue;
        //end region variables
        for (char charOfString : stringToEncrypt.toCharArray()) {
            intQueueValue = keyCodeQueue.pool();
            auxString += (char)((int)charOfString + intQueueValue);
            keyCodeQueue.add(intQueueValue);
        }
        return auxString;
    }

    private static Queue_circular<Integer> createKeyCode(int keyCodeSize, Boolean isManual) {
        //region variables locales
        Queue_circular<Integer> auxQueue = new Queue_circular<Integer>(keyCodeSize);
        int intValue;
        //end region variables
        for (int i = 0; i < keyCodeSize; i++) {
            if(isManual){
                String msg = "Ingrese valor numerico N° " + (i+1) +" de la clave:";
                intValue = Helper.forcePositiveIntEnter(msg);
            }
            else{
                intValue = Helper.generateRandomIntegerInRange(1, 9);
            }
            auxQueue.add(intValue);
        }
        return auxQueue;
    }
}
