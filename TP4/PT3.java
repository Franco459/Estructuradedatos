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
        Character inputChar;
        boolean isManualInput;
        //end region variables

    
        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;

        if (isManualInput){
            do{
                inputChar = getInputChar(isManualInput);	
                listCaracteres.addFirst(inputChar);
                System.out.println(listCaracteres.toString());
            }while(Helper.continueProgram(""));
        }    
        else{
            int amountOfChar = Helper.generateRandomIntegerInRange(5, 20);
            for (int j = 0; j < amountOfChar; j++) {
                inputChar = getInputChar(isManualInput);
                System.out.println(inputChar);
                listCaracteres.addFirst(inputChar);
            }
        }
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
            }else if ((letra >= 'a' && letra <= 'z')){
                    listConsonantes.addFirst(letra);
            }else listSobrantes.addFirst(letra);
        }
    }

    private static boolean isVowel(Character letra) {
        return (letra == 'a' || letra == 'e' || letra== 'i' || letra == 'o' || letra == 'u');
    }

    public static void readList(SimpleLinkedList<Character> listVocales, String string){
        System.out.println("La lista con "+ string +" es:" + listVocales.toString());
    }

}
