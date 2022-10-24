/*
 * Una persona aficionada a la programación desea organizar los videos tutoriales que consulta habitualmente
en una plataforma similar a Youtube. Para ello, se requiere crear diferentes listas de reproducción. Los
datos que caracterizan a un video son: identificador del video, título del video, creador de contenido y
duración en minutos. Realizar un programa que permita:
● Agregar videos a una lista principal. Para ello, se deben incluir las validaciones que considere
necesarias a fin de cargar correctamente los datos de un video. HECHO
● A partir de la lista principal, obtener diferentes listas de reproducción, a saber:
    ○ Lista de videos de un tema a elección, la cual debe estar ordenada alfabéticamente por
    título. Por ejemplo, si el tema es “objetos” y existen videos cuyo título contiene la
    palabra objetos como ser “Definición de clases y objetos” o “Instanciación de objetos
    en java”, ambos videos deben ser agregados a la lista.HECHO
    ○ Lista de videos que no superen una duración dada.HECHO
    ○ Lista de videos seleccionados aleatoriamente. HECHO
    ○ Lista de videos de un determinado creador de contenido. HECHO
● Informar la duración total (en minutos) de los videos correspondientes a un tema dado. HECHO
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
 */

package TP4;

public class PT6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //region variables

        SimpleLinkedList_pt6<Videos_pt6> allVideosList = new SimpleLinkedList_pt6<>();
        SimpleLinkedList_pt6<Videos_pt6> filterTopicVideosList = new SimpleLinkedList_pt6<>();
        SimpleLinkedList_pt6<Videos_pt6> filterTimeVideosList = new SimpleLinkedList_pt6<>();
        SimpleLinkedList_pt6<Videos_pt6> filterRandomVideosList = new SimpleLinkedList_pt6<>();
        SimpleLinkedList_pt6<Videos_pt6> filterAuthorVideosList = new SimpleLinkedList_pt6<>();

        int option, inputTime_Video, inputID_Video, totalDurationByFilter;
        String msg, inputTitle_Video, inputAuthor_Video;
        boolean isManualInput;

       //end region variables

        msg = "-----------MENU PROGRAMA CALCULA DE POSFIJA----------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;
        while (true){
        
            inputTitle_Video = getTitle(isManualInput);
            inputAuthor_Video = getAuthor(isManualInput);
            inputTime_Video = getVideoTime(isManualInput);
            inputID_Video = getID(allVideosList);

            Videos_pt6 video = new Videos_pt6(inputID_Video, inputTitle_Video, inputAuthor_Video, inputTime_Video);

            allVideosList.addLast(video);

            if (!Helper.continueProgram("")) break;
        }
        System.out.println("Todos los videos son: \n" + allVideosList.toString());
        
        filterTopicVideosList = filterListByTopic(isManualInput, allVideosList);
        if(filterTopicVideosList.count > 0) System.out.println("Todos los videos filtrados son: \n" + filterTopicVideosList.toString());
        else System.out.println("No hay videos con el filtro elegido");
        
        filterTimeVideosList = filterListByTime(isManualInput, allVideosList);
        if(filterTimeVideosList.count > 0) System.out.println("Todos los videos filtrados por el tiempo elegido anteriormente son: \n" + filterTimeVideosList.toString());
        else System.out.println("No hay videos con el filtro elegido");

        filterRandomVideosList = filterListByRandom(allVideosList);
        if(filterRandomVideosList.count > 0) System.out.println("Todos los videos filtrados anteriormente son: \n" + filterRandomVideosList.toString());
        else System.out.println("No hay videos con el filtro elegido");

        filterAuthorVideosList  = filterListByAuthor(isManualInput, allVideosList);
        if(filterAuthorVideosList.count > 0) System.out.println("Todos los videos filtrados anteriormente son: \n" + filterRandomVideosList.toString());
        else System.out.println("No hay videos con el filtro elegido");

        totalDurationByFilter = getTotalTime(isManualInput, allVideosList);
        if(totalDurationByFilter > 0) System.out.println("El total en minutos de los videos filtrados anteriormente es: \n" + totalDurationByFilter);
        else System.out.println("La duracion es 0, porque no hay videos con el filtro elegido");


    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static int getTotalTime(boolean isManualInput, SimpleLinkedList_pt6<Videos_pt6> allVideosList) {
        int totalSum = 0;
        String inputFilter = "";

        inputFilter = obtainStringFilter(isManualInput);

        for (Videos_pt6 eachVideo : allVideosList) {
            if(eachVideo.getVideo_Title().contains(inputFilter.toLowerCase()) || eachVideo.getVideo_Title().contains(inputFilter.toUpperCase()) || eachVideo.getVideo_Title().equalsIgnoreCase(inputFilter)){
                totalSum+= eachVideo.getVideo_Duration();
            }
        }

        return totalSum;
    }


    private static SimpleLinkedList_pt6<Videos_pt6> filterListByAuthor(boolean isManualInput, SimpleLinkedList_pt6<Videos_pt6> allVideosList) {
        
        SimpleLinkedList_pt6<Videos_pt6> localAuxList = new SimpleLinkedList_pt6<>(); 
        String inputFilter;

        inputFilter = (isManualInput) ? Helper.getValidsString("Ingrese nombre del autor para filtrar videos del mismo. (No distingue entre mayusculas y minisculas)") : Helper.generateRandomAuthor();

        System.out.println("Creador elegido para filtrar sus videos es: " + inputFilter);

        for (Videos_pt6 eachVideo : allVideosList) {
            if(eachVideo.getvideo_Author().equalsIgnoreCase(inputFilter)){
                localAuxList.addLast(eachVideo);
            }
        }

        return localAuxList;
    }


    private static SimpleLinkedList_pt6<Videos_pt6> filterListByRandom(SimpleLinkedList_pt6<Videos_pt6> allVideosList) {
        SimpleLinkedList_pt6<Videos_pt6> localAuxList = new SimpleLinkedList_pt6<>();

        for (Videos_pt6 eachVideo : allVideosList) {
            if (Helper.generateRandomIntegerInRange(1,2) == 1) localAuxList.addLast(eachVideo);
        }

        return localAuxList;
    }


    private static SimpleLinkedList_pt6<Videos_pt6> filterListByTime(boolean isManualInput, SimpleLinkedList_pt6<Videos_pt6> allVideosList) {
        SimpleLinkedList_pt6<Videos_pt6> localAuxList = new SimpleLinkedList_pt6<>();
        int inputFilter;

        inputFilter = (isManualInput) ? Helper.forcePositiveIntEnter("Ingrese valor numerico para filtrar videos con duracion MENOR") : Helper.generateRandomIntegerInRange(1 ,150);

        System.out.println("****El tiempo generado para filtrar videos de duracion menor es: " + inputFilter);

        for (Videos_pt6 eachVideo : allVideosList) {
            if(eachVideo.getVideo_Duration() < inputFilter){
                localAuxList.addLast(eachVideo);
            }
        }
        return localAuxList;
    }

    private static SimpleLinkedList_pt6<Videos_pt6> filterListByTopic(boolean isManualInput, SimpleLinkedList_pt6<Videos_pt6> allVideosList) {
        SimpleLinkedList_pt6<Videos_pt6> localAuxList = new SimpleLinkedList_pt6<>();
        String inputFilter = "";
        
        inputFilter = obtainStringFilter(isManualInput);

        System.out.println("La palabra para filtrar es : " + inputFilter);

        for (Videos_pt6 eachVideo : allVideosList) {
            if(eachVideo.getVideo_Title().contains(inputFilter.toLowerCase()) || eachVideo.getVideo_Title().contains(inputFilter.toUpperCase()) || eachVideo.getVideo_Title().equalsIgnoreCase(inputFilter)){
                localAuxList.addInOrder(eachVideo);
            }
        }

        return localAuxList;
    }

    private static String obtainStringFilter(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidsString("Ingrese cadena para filtrar videos por tema del video (No distingue entre mayusculas y minisculas)") : Helper.generateRandomTitle();
    }

    private static int getID(SimpleLinkedList_pt6<Videos_pt6> videosList) {
        return videosList.count + 1;
    }

    private static int getVideoTime(boolean isManualInput) {
        return (isManualInput) ? Helper.forcePositiveIntEnter("Ingrese la duracion en minutos del video (Valor entero)") : Helper.generateRandomIntegerInRange(1, 150) ;
    }

    private static String getAuthor(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidsString("Ingrese el nombre de usuario del creador del video.") : Helper.generateRandomAuthor() ;
    }

    private static String getTitle(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidsString("Ingrese el nombre del titulo del video.") : Helper.generateRandomTitle() ;
    }
    


}
