/*
 * Una empresa que desarrolla software a demanda (Software Factory) tiene una nómina con el detalle de
desarrolladores disponibles; los atributos básicos de cada desarrollador en esa nómina son 
Apellido,
Nombre, CUIT, especialidades; los valores para especialidades pueden ser “Administración de Sistemas”,
“Base de Datos”, “Infraestructura en la Nube”, “Ciencia de Datos”, “Back End”, “Front End”, “Interfaz de
Usuario”, “Pruebas”, entre otros; cada especialidad tiene asociado un rango cuyo valor puede estar entre 1
y 5, correspondiendo el 1 y 2 a junior, el 3 y 4 a semisenior y el 5 a senior. Cuando ingresa una tarea el jefe
de operaciones (COO) cuenta con una aplicación que le permite ingresar las especialidades de los
desarrolladores que necesita y la aplicación muestra los que cumplen con los criterios de selección.
Implementar y mostrar la ejecución de un algoritmo de selección que toma información de un
desarrollador de una cola de desarrolladores disponibles y encola en otra los que cumplan con el criterio de
selección dejando en la cola de desarrolladores disponibles los que no cumplen.
 */
package TP3;

import java.util.ArrayList;


public class PT6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //region variables
        String msg, developer_name, developer_surname, developer_CUIT;
        int optionGenerateValues, sizeOfQueue;
        Queue_circular<Desarrolladores> allDevelopers, selectedDevelopers;
        ArrayList<Especialidades> developer_Especialidades;
        boolean isManualInput;
        //end region variables

        msg = "---------------MENU CREAR CLAVE DE CIFRADO PUNTO 4--------------- \n"
        +    "1- Ejecucion con valores manuales \n"
        +    "2- Ejecucion con valores aleatorios ";
        optionGenerateValues = Helper.menuTwoOptions(msg);

        isManualInput = (optionGenerateValues == 1) ? true : false;
        
        sizeOfQueue = initializeQueue(isManualInput);
        allDevelopers = new Queue_circular<>(sizeOfQueue);
        
        for (int i = 0; i < sizeOfQueue; i++) {
            developer_name = getName(isManualInput);
            developer_surname = getSurname(isManualInput);
            developer_CUIT = getCUIT(isManualInput);
            developer_Especialidades = getEspecialidades(isManualInput);

            Desarrolladores desarrolladores = new Desarrolladores(developer_name, developer_surname, developer_CUIT, developer_Especialidades);

            allDevelopers.add(desarrolladores);
        }

        System.out.println("Los desarrolladores guardados son: \n" + allDevelopers.toString());

        selectedDevelopers = getDeveloperByEspeciality(allDevelopers, isManualInput);

        System.out.println("Los desarrolladores solicitados son : \n" + selectedDevelopers.toString() );

    }

    //////////////////////////////////////METHODS///////////////////////////////////////

    private static Queue_circular<Desarrolladores> getDeveloperByEspeciality(Queue_circular<Desarrolladores> allDevelopers, boolean isManual) {
        Queue_circular<Desarrolladores> filterQueue = new Queue_circular<>(allDevelopers.size());
        String inputEspecialidad;
        int inputNivel, size;
        System.out.println("*****MENU DE FILTRO*****");

            inputEspecialidad = getEspeciality(isManual);
            if(!isManual){
                System.out.println("Filtro de especialidad a aplicar: " + inputEspecialidad);
            }
            size = allDevelopers.size();
            for (int i = 0; i < size; i++) {
                if(allDevelopers.peek().getEspecialidades_Desarrolladores().get(i).getName_Especialidad().equalsIgnoreCase(inputEspecialidad)) {
                    filterQueue.add(allDevelopers.pool());
                }
                else{
                    allDevelopers.add(allDevelopers.pool());
                }
            }
        
        return filterQueue;
    }

    private static ArrayList<Especialidades> getEspecialidades(boolean isManual) {
        ArrayList<Especialidades> auxArrayList = new ArrayList<>();
        String especialityInput;
        int especialityExperience, especialityAmountRandom;
        boolean isValueInArray;
        if (isManual){
            do {
                try {
                    isValueInArray = false;
                    especialityInput = getEspeciality(isManual);
                    especialityExperience = getExperience(isManual);
                    Especialidades especialidades = new Especialidades(especialityInput,especialityExperience);
                    isValueInArray = searchValue(auxArrayList, especialidades);
                    
                    if(!isValueInArray) auxArrayList.add(especialidades);
                    else throw new RuntimeException("Especialidad ya existente para el desarrollador");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } while (Helper.continueProgram("Desea agregar otra especialidad? Opciones validas: (S/s || N/n)"));
        }
        else{
            especialityAmountRandom = Helper.generateRandomIntegerInRange(1, 5);
            for (int i = 0; i < especialityAmountRandom; i++) {
                isValueInArray = false;
                especialityInput = getEspeciality(isManual);
                especialityExperience = getExperience(isManual);
                Especialidades especialidades = new Especialidades(especialityInput,especialityExperience);
                if(!isValueInArray) auxArrayList.add(especialidades);
                else i--;
            }
        }
        return auxArrayList;
    }

    private static boolean searchValue(ArrayList<Especialidades> auxArrayList, Especialidades especialidades) {
        for (int i = 0; i < auxArrayList.size(); i++) {
            if(especialidades.name_Especialidad.equalsIgnoreCase(auxArrayList.get(i).getName_Especialidad())) {
                return true;
            }
        }
        return false;
    }

    private static int getExperience(boolean isManual) {
        String msg;
        int experienceInput;
        while(true){
            try {
                if (isManual){
                    msg =   "ESPECIALIDADES DISPONIBLES:\n" +
                            "1/2- Junior, 3/4- Semisenior, 5- Senior \n" +
                            "Ingrese el nivel de experiencia.";
                    experienceInput = Helper.forcePositiveIntEnter(msg);
                
                    if (experienceInput != 1 && experienceInput != 2 && experienceInput != 3
                    && experienceInput != 4 && experienceInput != 5) {
                        throw new RuntimeException("Nivel de experiencia no valido");
                    }
                    return experienceInput;
                }
                else{
                    return Helper.generateRandomIntegerInRange(1, 5);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static String getEspeciality(boolean isManual) {
        String[] especialities = { "Base de Datos", "Infraestructura en la Nube", "Ciencia de Datos", "Back End",
                "Front End", "Interfaz de usuario", "Pruebas", "Soporte IT" };
        String inputValue;

        if (isManual) {
            while (true) {
                try {
                    String msg = "ESPECIALIDADES DISPONIBLES:\n" +
                            "Base de Datos, Infraestructura en la Nube, Ciencia de Datos, Back End \n" +
                            ", Front End, Interfaz de Usuario, Pruebas, Soporte IT \n" +
                            "Ingrese nombre de la especialidad";
                    inputValue = Helper.getValidsString(msg);
                    for (String valueOfArray : especialities) {
                        if (valueOfArray.equalsIgnoreCase(inputValue))
                            return inputValue;
                    }
                    throw new RuntimeException(
                            "El valor " + inputValue + " no existe entre las especialidades disponibles.");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            return especialities[Helper.generateRandomIntegerInRange(0, 7)];
        }

    }

    private static String getCUIT(boolean isManual) {
        int prefix;
        String cuitString = "";

        if(isManual){
            while(true){
                try {
                    cuitString = Helper.getValidsString("Ingrese el CUIT con los 2 guiones (-)");   
                    if (verifyValidCuit(cuitString)) return cuitString;
                    else throw new RuntimeException("El cuit debe tener el formato XX-X...X-X");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        else{
            prefix = Helper.generateRandomIntegerInRange(1, 99);
            cuitString += ((prefix >= 1 && prefix <= 9) ? ("0"+ prefix) : prefix)  + "-";
            
            cuitString += Helper.generateRandomIntegerInRange(1000000, 55999999) + "-";

            cuitString += Helper.generateRandomIntegerInRange(0, 9);

            return cuitString;
        }
    }

    private static boolean verifyValidCuit(String cuitString) {
        for (int i = 0; i < cuitString.length(); i++) {
            if ((cuitString.charAt(i) == '-' && (i == 2 || i == cuitString.length()-1))) return false;
            if (!Character.isDigit(cuitString.charAt(i))) return false;
        }
        return true;
    }

    private static String getSurname(boolean isManual) {
        if (isManual) return Helper.getValidsString("Ingrese apellido del desarrollador/a: ");
        else return Helper.getRandomSurname();
    }

    private static String getName(boolean isManual) {
        if (isManual) return Helper.getValidsString("Ingrese nombre del desarrollador/a: ");
        else return Helper.getRandomName();
    }

    private static int initializeQueue(boolean isManual) {
        String msg;
        if (isManual){
            msg = "Ingrese cantidad de desarrolladores a cargar";
            return Helper.forcePositiveIntEnter(msg);
        }
        else{
            return Helper.generateRandomIntegerInRange(1, 9);
        }
    }
}
