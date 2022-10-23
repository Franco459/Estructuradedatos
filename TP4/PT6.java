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
    en java”, ambos videos deben ser agregados a la lista.
    ○ Lista de videos que no superen una duración dada.
    ○ Lista de videos seleccionados aleatoriamente.
    ○ Lista de videos de un determinado creador de contenido.
● Informar la duración total (en minutos) de los videos correspondientes a un tema dado.
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
        
        //definicion de variables

        SimpleLinkedList<Videos_pt6> allVideosList = new SimpleLinkedList<>();
        SimpleLinkedList<Videos_pt6> filterTopicVideosList = new SimpleLinkedList<>();
        SimpleLinkedList<Videos_pt6> filterTimeVideosList = new SimpleLinkedList<>();
        SimpleLinkedList<Videos_pt6> filterRandomVideosList = new SimpleLinkedList<>();
        SimpleLinkedList<Videos_pt6> filterAuthorVideosList = new SimpleLinkedList<>();

        int option, inputTime_Video, inputID_Video;
        String msg, inputTitle_Video, inputAuthor_Video;
        boolean isManualInput;

       //definicion de variables

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
        System.out.println("Todos los videos: \n" + allVideosList.toString());
        filterTopicVideosList = filterListByTopic(isManualInput, allVideosList);
        System.out.println("Todos los videos filtrados: \n" + filterTopicVideosList.toString());

    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static SimpleLinkedList<Videos_pt6> filterListByTopic(boolean isManualInput, SimpleLinkedList<Videos_pt6> allVideosList) {
        SimpleLinkedList<Videos_pt6> localAuxList = new SimpleLinkedList<>();
        String inputFilter = "";
        
        inputFilter = (isManualInput) ? Helper.getValidsString("Ingrese cadena para filtrar videos por tema del video (No distingue entre mayusculas y minisculas)") : Helper.generateRandomTitle();

        System.out.println("La palabra para filtrar es : " + inputFilter);

        for (Videos_pt6 eachVideo : allVideosList) {
            if(eachVideo.getVideo_Title().contains(inputFilter.toLowerCase()) || eachVideo.getVideo_Title().contains(inputFilter.toUpperCase()) || eachVideo.getVideo_Title().equalsIgnoreCase(inputFilter)){
                localAuxList.addLast(eachVideo);
            }
        }

        return localAuxList;
    }


    private static int getID(SimpleLinkedList<Videos_pt6> videosList) {
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
