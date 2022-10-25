/*
 * Escribir un programa y todo lo necesario para guardar una cantidad N de caracteres en una lista. A partir de
dicha lista se deben obtener tres nuevas listas de manera que, en la primera de ellas se agreguen las
vocales, en la segunda las consonantes y en la tercera los símbolos restantes.
 */
package TP4;

import java.util.Scanner;

public class PT3 {
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args ){

        //region variables
        SimpleLinkedList<Character> listCaracteres = new SimpleLinkedList<Character>();
        SimpleLinkedList<Character> listVocales = new SimpleLinkedList<Character>();
        SimpleLinkedList<Character> listConsonantes = new SimpleLinkedList<Character>();
        SimpleLinkedList<Character> listSobrantes = new SimpleLinkedList<Character>();
        String msg;
        int amountOfChar;
        Character inputChar;
        boolean isManualInput;
        //end region variables

    
        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;

        amountOfChar =  (!isManualInput) ? Helper.generateRandomIntegerInRange(5, 20) : Helper.forcePositiveIntEnter("Ingrese cantidad de caracteres a cargar");

        do{
            inputChar = getInputChar(isManualInput);
            listCaracteres.addFirst(inputChar);
            if (isManualInput) System.out.println("Items dentro de la lista : " + listCaracteres.toString());
            amountOfChar--;
        }while(amountOfChar > 0);

        readList(listCaracteres, "todos los caracteres");
        
        vowelConsonantOther(listCaracteres,listVocales,listConsonantes,listSobrantes);

        readList(listVocales,"vocales");
        readList(listConsonantes,"consonantes");
        readList(listSobrantes,"sobrantes");
    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static Character getInputChar(boolean isManualInput) {
        return (isManualInput) ? Helper.getChar("Ingrese un caracter (Longitud maxima 1)") : (char) Helper.generateRandomIntegerInRange(33, 126);
        
    }

    public static void vowelConsonantOther(SimpleLinkedList<Character> list, SimpleLinkedList<Character> listVocales,SimpleLinkedList<Character> listConsonantes, SimpleLinkedList<Character> listSobrantes){
        Character letra;
        while(list.size()!=0){
            letra=list.removeLast();
            if(isVowel(letra)) {
                listVocales.addFirst(letra);
            }else if ((letra >= 'a' && letra <= 'z' || letra >= 'A' && letra <= 'Z')){
                    listConsonantes.addFirst(letra);
            }else listSobrantes.addFirst(letra);
        }
    }

    private static boolean isVowel(Character letra) {
        return (Character.toLowerCase(letra) == 'a' || Character.toLowerCase(letra) == 'e' || Character.toLowerCase(letra) == 'i' || Character.toLowerCase(letra) == 'o' || Character.toLowerCase(letra) == 'u');
    }

    public static void readList(SimpleLinkedList<Character> receivedList, String string){
        if(receivedList.count == 0) System.out.println("La lista con "+ string +", no obtuvo ningun valor valido para almacenarse");
        else System.out.println("La lista con "+ string +" es:" + receivedList.toString());
    }

}
