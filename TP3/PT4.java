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

public class PT4 {
   /**
 * @param args
 */
    public static void main(String[] args) {
        //region variables
        String msg, stringToEncrypt, encryptedString, desencryptedString;
        int keyCodeSize, optionGenerateValues;
        Queue_circular<Integer> keyCodeQueue;
        //end region variables

        msg = "---------------MENU CREAR CLAVE DE CIFRADO PUNTO 4--------------- \n"
        +    "1- Crear clave con valores manuales \n"
        +    "2- Crear clave con valores aleatorios ";
        optionGenerateValues = Helper.menuTwoOptions(msg);

        if (optionGenerateValues == 1){            
            msg = "Ingrese tamaño de la clave de cifrado: ";
            keyCodeSize = Helper.forcePositiveIntEnter(msg);

            keyCodeQueue = createKeyCode(keyCodeSize, true);

            msg = "Ingrese una cadena para cifrar: ";
            stringToEncrypt = Helper.getValidsString(msg);
        }
        else{
            keyCodeSize = Helper.generateRandomIntegerInRange(1, 9);
            System.out.println("La clave generada es de tamaño " + keyCodeSize);
            
            keyCodeQueue = createKeyCode(keyCodeSize, false);
            System.out.println("La clave generada es " + keyCodeQueue.toString());

            stringToEncrypt = Helper.randomStringOfArray();
            System.out.println("La cadena generada es " + stringToEncrypt);
        }
        
        encryptedString = encryptMethod(keyCodeQueue, stringToEncrypt);
        System.out.println("La cadena encriptada es: " + encryptedString);
        
        desencryptedString = desencryptMethod(keyCodeQueue, encryptedString);
        System.out.println("Desencriptando la cadena ingresada: " + desencryptedString);
    } 

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static String desencryptMethod(Queue_circular<Integer> localkeyCodeQueue, String stringToEncrypt) {
        //region variables locales
        String auxString = "";
        int intQueueValue, countMoves = 0;
        //end region variables
        for (char charOfString : stringToEncrypt.toCharArray()) {
            countMoves++;
            intQueueValue = localkeyCodeQueue.pool();
            auxString += (char)((int) charOfString - intQueueValue);
            localkeyCodeQueue.add(intQueueValue);
            if (countMoves == localkeyCodeQueue.size()) countMoves = 0;
        }

        localkeyCodeQueue = reOrderQueue(localkeyCodeQueue, countMoves);
        
        return auxString;
    }

    private static String encryptMethod(Queue_circular<Integer> localkeyCodeQueue, String stringToEncrypt) {
        //region variables locales
        String auxString = "";
        int intQueueValue, countMoves = 0;
        //end region variables
        for (char charOfString : stringToEncrypt.toCharArray()) {
            countMoves++;
            intQueueValue = localkeyCodeQueue.pool();
            auxString += (char)((int)charOfString + intQueueValue);
            localkeyCodeQueue.add(intQueueValue);
            if (countMoves == localkeyCodeQueue.size()) countMoves = 0;
        }

        localkeyCodeQueue = reOrderQueue(localkeyCodeQueue, countMoves);

        return auxString;
    }

    private static Queue_circular<Integer> reOrderQueue(Queue_circular<Integer> localkeyCodeQueue, int countMoves) {
        while(localkeyCodeQueue.size() > countMoves){

            localkeyCodeQueue.add(localkeyCodeQueue.pool());
            countMoves++;
        }
        return localkeyCodeQueue;
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
