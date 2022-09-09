/*
 * Escribir un programa que permita ingresar y almacenar la información de muchos libros de acuerdo a la
implementación del caso ejemplo c); luego el usuario podrá indicar un autor o una editorial y el programa
deberá mostrar los libros cuyo autor o editorial correspondan a los indicados. Además, se deberá informar
la cantidad de libros guardados que tienen un precio menor a un valor X dado.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */
package TP1;

import java.util.ArrayList;


public class PT5 {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        String msg;
        //definimos variables con los atributos del libro
        String titleName = "", author= "", editorial= "";
        int yearOfRelease= 0, option = 0;
        float price = 0;
        while(true){
            msg = "---------------MENU--------------- \n"
            +    "1- Ingresar valores manuales \n"
            +    "2- Ingresar valores aleatorios ";
            option = Helper.menuTwoOptions(msg);
            switch(option){
                case 1:
                    titleName = verifyName(1);
                    author = verifyName(2);
                    editorial = verifyName(3);
                    yearOfRelease = verifyYear();
                    price = verifyPrice(true);
                break;
                case 2:
                    titleName = Helper.generateRandomNames(3);
                    author = Helper.generateRandomNames(1);
                    editorial = Helper.generateRandomNames(2);
                    yearOfRelease = Helper.randomIntGenerator(1799, 2023);
                    price = verifyPrice(false);
                break;
            }
            libros.add(createNewLibro(titleName, author, editorial, yearOfRelease, price));
            System.out.println(libros.toString());
            if (!Helper.continueProgram()) break;
        }
        /*luego el usuario podrá indicar un autor o una editorial y el programa
deberá mostrar los libros cuyo autor o editorial correspondan a los indicados. */
        msg = "---------------MENU--------------- \n"
        +    "1- Buscar libros por editorial \n"
        +    "2- Buscar libros por autor ";
        option = Helper.menuTwoOptions(msg);
        switch(option){
            case 1:
                String editorialSearch = verifyName(3);
                searchByEditorial(libros, editorialSearch);
            break;
            case 2:
                String authorSearch = verifyName(2);
                searchByAuthor(libros, authorSearch);
            break;
        }
        /*Además, se deberá informar
        la cantidad de libros guardados que tienen un precio menor a un valor X dado. */
        showAmountLowerPrice(libros);
    }


    
    ////////////////////////METHODS//////////////////////////////


    private static void showAmountLowerPrice(ArrayList<Libro> libros) {
        int count = 0;
        float priceSelected = verifyPrice(true);
        for (Libro eachLibro : libros) {
            if(eachLibro.getPrice() < (priceSelected)) count+=1;
        }
        if(count == 0) System.out.println("No se han encontrado libros con un precio menor al elegido.");
        else System.out.println("La cantidad de libros menores al precio ingresado (" + priceSelected + ") son: " + count);
    }



    private static void searchByAuthor(ArrayList<Libro> libros, String authorSearch) {
        boolean found = false;
        for (Libro eachLibro : libros) {
            if(eachLibro.getAuthor().equalsIgnoreCase(authorSearch)) {
                found = true;
                System.out.println(eachLibro.toString());   
            }
        }
        if(!found) System.out.println("No se han encontrado libros con el autor elegido.");
    }



    private static void searchByEditorial(ArrayList<Libro> libros, String editorialSearch) {
        boolean found = false;
        for (Libro eachLibro : libros) {
            if(eachLibro.getEditorial().equalsIgnoreCase(editorialSearch)) {
                found = true;
                System.out.println(eachLibro.toString());   
            }
        }
        if(!found) System.out.println("No se han encontrado libros con la editorial elegida.");
    }



    private static Libro createNewLibro(String titleName, String author, String editorial, int yearOfRelease, float price) {
        Libro newLibro = new Libro(titleName, author, editorial, String.valueOf(yearOfRelease), price);
        System.out.println("Se ha generado el libro satisfactoriamente.");
        return newLibro;
    }



    private static float verifyPrice(boolean manual) {
       while(true){
        try{
            String inputMsg = "Ingrese el precio del libro";
            float rtnPrice;
            if (manual) rtnPrice = Helper.getFloat(inputMsg);
            else rtnPrice = Helper.generateRandomFloatInRange(1, 100000);
            //forzar error en caso de no cumplir la condicion
            if (rtnPrice <= 0) Integer.parseInt("a");
            return rtnPrice;
        }
        catch(Exception e){
            System.out.println("El numero ingresado debe ser mayor que 0");
        }
       }
    }

    private static int verifyYear() {
        while(true){
            try{
                String inputMsg = "Ingrese el año de lanzamiento";
                int year = Helper.forceInteger(inputMsg);
                if (year < 1799 || year > 2022) Integer.parseInt("s"); 
                return year;
            }
            catch(Exception e){
                System.out.println("El valor del año ingresado permitido es entre 1900 y 2022 incluidos.");
            }
        }
    }

    private static String verifyName(int op) {
        String msg = "";

        switch (op){
            case 1: msg = "Ingrese nombre del titulo.";break;
            case 2: msg = "Ingrese nombre del autor.";break;
            case 3: msg = "Ingrese nombre de la editorial.";break;
        }
        String name = Helper.getValidsString(msg);
        return name;
    }
    
}
