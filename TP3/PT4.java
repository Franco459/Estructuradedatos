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

import javax.naming.AuthenticationException;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //region variables
        Boolean continueExcecution = false;
        String msg, stringToEncrypt, encryptedString;
        int optionAction, keyCodeSize, secondSizeSelected, optionGenerateValues;
        Queue_circular<Integer> keyCodeQueue;
        //end region variables

        msg = "---------------MENU ELECCION ACCION PUNTO 4--------------- \n"
        +    "1- Codificar cadena \n"
        +    "2- Decodificar cadena ";
        optionAction = Helper.menuTwoOptions(msg);

        msg = "Ingrese tamaño de la clave de cifrado: ";
        keyCodeSize = Helper.forcePositiveIntEnter(msg);
        
        switch(optionAction){
            case 1:
                msg = "---------------MENU CIFRAR CADENA PUNTO 4--------------- \n"
                +    "1- Ingresar valores manuales \n"
                +    "2- Ingresar valores aleatorios ";
                optionGenerateValues = Helper.menuTwoOptions(msg);

                if (optionGenerateValues == 1){
                    msg = "Ingrese una cadena para cifrar: ";
                    keyCodeQueue = createKeyCode(keyCodeSize, true);
                    System.out.println("La clave de cifrado a utilizar será: " + keyCodeQueue.toString());
        
                    stringToEncrypt = Helper.getValidsString(msg);
                }
                else{
                    keyCodeQueue = createKeyCode(keyCodeSize, false);
                    System.out.println("La clave de cifrado a utilizar será: " + keyCodeQueue.toString());
        
                    stringToEncrypt = "";
                }
                
                encryptedString = encryptMethod(keyCodeQueue, stringToEncrypt);
                System.out.println("La cadena codificada es: " + encryptedString);
                msg = "Desea decodificar la cadena generada? (s/S || n/N)";
                if (!Helper.continueProgram(msg)) break;
                else continueExcecution = true;
            case 2:

            break;
        }
       /* 
        
        
        msg = "---------------MENU CIFRAR CADENA PUNTO 4--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        optionGenerateValues = Helper.menuTwoOptions(msg);


        if (optionGenerateValues == 1){
            msg = "Ingrese una cadena para cifrar: ";
            keyCodeQueue = createKeyCode(keyCodeSize, true);
            System.out.println("La clave de cifrado a utilizar será: " + keyCodeQueue.toString());

            stringToEncrypt = Helper.getValidsString(msg);
        }
        else{
            keyCodeQueue = createKeyCode(keyCodeSize, false);
            System.out.println("La clave de cifrado a utilizar será: " + keyCodeQueue.toString());

            stringToEncrypt = "";
        }
        
        encryptedString = encryptMethod(keyCodeQueue, stringToEncrypt);
        System.out.println("La cadena codificada es: " + encryptedString);

        msg = "Desea de" //" ha sido pagada? (s/S || n/N)"; */
    }

    //////////////////////////////////////METHODS///////////////////////////////////////

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
                String msg = "Ingrese valor numerico para posicion " + (i+1) +" de la clave:";
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
