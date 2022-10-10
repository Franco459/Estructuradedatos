/*
 * Existe una técnica de cifrado conocida como DES Data Encryption Standard, que recibe un mensaje y una
clave y devuelve el mensaje codificado. Resulta que con las computadoras de hoy en día el DES es bastante
fácil de “romper” o descifrar, entonces lo que conviene utilizar es una técnica conocida como Triple-DES,
que utiliza tres claves; de manera que el mensaje original es cifrado tres veces, una vez con cada clave
haciendo bastante difícil la tarea de “romper” o descifrar el mensaje. Utilizando la técnica descripta en el
ejercicio anterior implemente una versión propia de Triple-DES, de manera que, como en el ejercicio 4,
deberá crear los métodos que permitan Codificar y Decodificar una cadena de caracteres aplicando en este
caso tres claves.
 */
package TP3;

public class PT5 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //region variables
        String msg, stringToEncrypt, encryptedString, desencryptedString;
        int keyCodeSize, optionGenerateValues;
        Queue_circular<Integer> first_keyCodeQueue, second_keyCodeQueue, third_keyCodeQueue;
        //end region variables

        msg = "---------------MENU CREAR CLAVE DE CIFRADO PUNTO 4--------------- \n"
        +    "1- Crear clave con valores manuales \n"
        +    "2- Crear clave con valores aleatorios ";
        optionGenerateValues = Helper.menuTwoOptions(msg);

        if(optionGenerateValues == 1){
            first_keyCodeQueue = initializeQueue(1);
            second_keyCodeQueue = initializeQueue(2);
            third_keyCodeQueue = initializeQueue(3);

            msg = "Ingrese una cadena para cifrar: ";
            stringToEncrypt = Helper.getValidsString(msg);
        }
        else{
            first_keyCodeQueue = initializeQueue(1);
            second_keyCodeQueue = initializeQueue(2);
            third_keyCodeQueue = initializeQueue(3);

            stringToEncrypt = Helper.randomStringOfArray();
            System.out.println("La cadena generada es " + stringToEncrypt);
        }
        System.out.println(first_keyCodeQueue);
        System.out.println(second_keyCodeQueue);
        System.out.println(third_keyCodeQueue);
        encryptedString = encryptMethod(first_keyCodeQueue, second_keyCodeQueue, third_keyCodeQueue, stringToEncrypt);
        System.out.println("La cadena encriptada es: " + encryptedString);
        
        desencryptedString = desencryptMethod(first_keyCodeQueue, second_keyCodeQueue, third_keyCodeQueue, encryptedString);
        System.out.println("Desencriptando la cadena ingresada: " + desencryptedString);
    }

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static String desencryptMethod(Queue_circular<Integer> firstKeyCodeQueue, Queue_circular<Integer> secondKeyCodeQueue, Queue_circular<Integer> thirdKeyCodeQueue, String stringToDesencrypt) {
        //region variables locales
        char charOfString;
        String auxString = "";
        int intQueueValue, firstQueueItem, secondQueueItem, thirdQueueItem;
        //end region variables

        for (int i = 0; i < stringToDesencrypt.length(); i++) {
            charOfString = stringToDesencrypt.charAt(i);
            firstQueueItem = firstKeyCodeQueue.pool();
            secondQueueItem = secondKeyCodeQueue.pool();
            thirdQueueItem = thirdKeyCodeQueue.pool();

            intQueueValue = firstQueueItem + secondQueueItem + thirdQueueItem;
            
            auxString += (char)((int) charOfString - intQueueValue);

            firstKeyCodeQueue.add(firstQueueItem);
            secondKeyCodeQueue.add(secondQueueItem);
            thirdKeyCodeQueue.add(thirdQueueItem);
            
        }

        return auxString;
    }

    private static String encryptMethod(Queue_circular<Integer> firstKeyCodeQueue, Queue_circular<Integer> secondKeyCodeQueue, Queue_circular<Integer> thirdKeyCodeQueue, String stringToEncrypt) {
        //region variables locales
        char charOfString;
        String auxString = "";
        int intQueueValue, countMovesFirstQueue = 0, countMovesSecondQueue = 0, countMovesThirdQueue = 0, firstQueueItem, secondQueueItem, thirdQueueItem;
        //end region variables

        //System.out.println(((int) charOfString + intQueueValue) + "/////" + ((int) charOfString) + "/////" + intQueueValue );
        
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            charOfString = stringToEncrypt.charAt(i);
            countMovesFirstQueue++;
            countMovesSecondQueue++;
            countMovesThirdQueue++;
            if (countMovesFirstQueue == firstKeyCodeQueue.size()) countMovesFirstQueue = 0;
            if (countMovesSecondQueue == secondKeyCodeQueue.size()) countMovesSecondQueue = 0;
            if (countMovesThirdQueue == thirdKeyCodeQueue.size()) countMovesThirdQueue = 0;
            firstQueueItem = firstKeyCodeQueue.pool();
            secondQueueItem = secondKeyCodeQueue.pool();
            thirdQueueItem = thirdKeyCodeQueue.pool();

            intQueueValue = firstQueueItem + secondQueueItem + thirdQueueItem;
            
            auxString += (char)((int) charOfString + intQueueValue);

            firstKeyCodeQueue.add(firstQueueItem);
            secondKeyCodeQueue.add(secondQueueItem);
            thirdKeyCodeQueue.add(thirdQueueItem);
            
        }

        firstKeyCodeQueue = reOrderQueue(firstKeyCodeQueue, countMovesFirstQueue);
        secondKeyCodeQueue = reOrderQueue(secondKeyCodeQueue, countMovesSecondQueue);
        thirdKeyCodeQueue = reOrderQueue(thirdKeyCodeQueue, countMovesThirdQueue);

        return auxString;
    }

    private static Queue_circular<Integer> reOrderQueue(Queue_circular<Integer> localkeyCodeQueue, int countMoves) {
        if(countMoves > 0){
            while(localkeyCodeQueue.size() > countMoves){

                localkeyCodeQueue.add(localkeyCodeQueue.pool());
                countMoves++;
            }
        }
        return localkeyCodeQueue;
    }

    private static Queue_circular<Integer> initializeQueue(int position) {

        Queue_circular<Integer> auxQueue;
        int size = 0;

        size = Helper.forcePositiveIntEnter("Ingrese tamaño deseado de la " + position + "° cola");
        auxQueue = new Queue_circular<>(size);
        for (int j = 0; j < size; j++) {
            auxQueue.add(Helper.forcePositiveIntEnter("Ingrese valor para la posicion " + (j+1) + " de la clave"));
        }
        return auxQueue;
    }
}
