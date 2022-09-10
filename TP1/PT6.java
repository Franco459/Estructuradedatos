/*Modificar la implementación del tipo Libro de los ejercicios anteriores de manera que cada libro pueda
tener más de un autor y que además cuente con la información del género literario (n: narrativo, d:
dramático, l: lírico). Ingresar, almacenar y mostrar la información de N libros. El valor N será indicado por el
usuario.

indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.*/
package TP1;

import java.util.ArrayList;


public class PT6 {
    public static void main(String[] args) {
        ArrayList<LibroMod> libros = new ArrayList<>();
        String msg;
        //definimos variables con los atributos del libro
        ArrayList<String> authors;
        String titleName = "", editorial = "";
        int yearOfRelease = 0, option = 0, amountAuthors = 0;
        float price = 0;
        char literaryGenre = ' ';
        while(true){
            msg = "---------------MENU--------------- \n"
            +    "1- Ingresar valores manuales \n"
            +    "2- Ingresar valores aleatorios ";
            option = Helper.menuTwoOptions(msg);
            authors = new ArrayList<>();
            switch(option){
                case 1:
                    titleName = verifyName(1);
                    amountAuthors = getAmountAuthors(titleName);
                    for (int i = 0; i < amountAuthors; i++) authors.add(verifyName(2));
                    editorial = verifyName(3);
                    yearOfRelease = verifyYear();
                    price = verifyPrice(true);
                    literaryGenre = verifyGenre(true);
                break;
                case 2:
                    titleName = Helper.generateRandomNames(3);
                    amountAuthors = Helper.randomIntGenerator(1, 5);
                    for (int i = 0; i < amountAuthors; i++) authors.add(Helper.generateRandomNames(1));
                    editorial = Helper.generateRandomNames(2);
                    yearOfRelease = Helper.randomIntGenerator(1799, 2023);
                    price = verifyPrice(false);
                    literaryGenre = verifyGenre(false);
                break;
            }
            libros.add(createNewLibro(titleName, authors, editorial, yearOfRelease, price, literaryGenre));
            System.out.println(libros.toString());
            String showMsg = "Desea agregar/generar otro libro? (S/s || N/n)";
            if (!Helper.continueProgram(showMsg)) break;
        }
        showBooks(libros);
    }


    
    ////////////////////////METHODS//////////////////////////////

    private static void showBooks(ArrayList<LibroMod> libros) {
        while (true){
            try {
                String showMsg = "Cuantos libros desea que se muestren: ";
                int amount = Helper.forcePositiveIntEnter(showMsg);
                if(libros.size() < amount) Integer.parseInt("s");
                else {
                    for(int i = 0; i < amount; i++){
                        System.out.println(libros.get(i).toString());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("La cantidad solicitada ingresada es mayor a la que hay almacenada.");
            }
        }
    }

    private static LibroMod createNewLibro(String titleName, ArrayList<String> authors, String editorial, int yearOfRelease, float price, char literaryGenre) {
        LibroMod newLibro = new LibroMod(titleName, authors, editorial, String.valueOf(yearOfRelease), price, literaryGenre);
        System.out.println("Se ha generado el libro satisfactoriamente.");
        return newLibro;
    }

    private static char verifyGenre(boolean isManual) {
        char genreChar = ' ';
        while(true){
            try{
                if (isManual){
                    String msg = "Ingrese uno de los 3 generos (n: narrativo, d:dramático, l: lírico)";
                    String genreReceived = Helper.getValidsString(msg);
                    if (genreReceived.equalsIgnoreCase("narrativo") || genreReceived.equalsIgnoreCase("dramatico") || genreReceived.equalsIgnoreCase("lirico")){
                            genreChar = Character.toLowerCase(genreReceived.charAt(0));
                    }
                    else{
                        Integer.parseInt("s");
                    }
                }
                else{
                    genreChar = Character.toLowerCase( Helper.randomCharGenerator());
                }
                if (genreChar == ('d') || genreChar == ('l') || genreChar == ('n' )) return genreChar;
                Integer.parseInt("s"); //forzar error para conseguir resultado esperado
            }
            catch(Exception e){
                if (isManual) System.out.println("El genero ingresado no es valido.");
            }
        }
    }

    private static int getAmountAuthors(String titleName) {
        String msg = "Cuantos autores desea cargar para el libro '" + titleName + "'?";
        int rtnInt = Helper.forcePositiveIntEnter(msg);
        return rtnInt;
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

    private static float verifyPrice(boolean manual) {
        while(true){
             try{
                 String inputMsg = "Ingrese el precio del libro\n";
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
}
