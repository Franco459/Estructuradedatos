package TP4;

public class PT5 {
    public static void main(String [] args ){
        SimpleLinkedList<UsuarioDeServicio> listUsuarios = new SimpleLinkedList<>();
        int amountRandomUser = 0;
        String msg;
        String inputName, inputSurname, inputUser, inputPassword, inputMail, inputTypeAccount;
            //menu 2 opciones
        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);

        boolean isManualInput = (option == 1) ? true : false;

        if (!isManualInput) amountRandomUser = Helper.generateRandomIntegerInRange(3, 10);

        do{

            inputName = getName(isManualInput);
            inputSurname = getSurname(isManualInput);
            inputUser = getUser(isManualInput);
            inputPassword = getPassword(isManualInput);
            inputMail = getMail(isManualInput);
            inputTypeAccount = getTypeAccount(isManualInput);

            listUsuarios.addLast(new UsuarioDeServicio(inputName, inputSurname, inputUser, inputPassword, inputMail, inputTypeAccount));

        }while((isManualInput) ? Helper.continueProgram("Desea agregar otro usuario mas? (S/N||s/n)") : amountRandomUser > 0);
        
        System.out.println(listUsuarios.toString());

        System.out.println("-------------Buscar usuario por nombre y/o apellido---------");
        System.out.println(filterList(listUsuarios).toString());

        String opcion= (Helper.menuTwoOptions("Que lista desea ver? 1-Premium 2-Gratuita") == 1) ?  "Premium": "Gratuita";
        mostrarPremiGratu(listUsuarios, opcion);
    }

    private static String getTypeAccount(boolean isManualInput) {
        return (isManualInput) ? (Helper.menuTwoOptions("Desea cuenta premium o gratuita? 1-Premium 2-Gratuita") == 1) ?  "Premium": "Gratuita" : Helper.generateRandomTypeOfAccount();
    }

    private static String getMail(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidMail("Ingrese Mail: (Debe contener un solo símbolo @ que no puede ser ni el primer ni el último carácter de la cadena.) ") : Helper.generateRandomMail();
    }

    private static String getPassword(boolean isManualInput) {
        return (isManualInput) ? Helper.getValidPassword("Ingrese Contraseña: (Solo digitos, letras y símbolos especiales.) ") : Helper.generateRandomPassword();
    }

    private static String getUser(boolean isManualInput) {
        return (isManualInput) ? Helper.getStringOnlyLettersAndNumbers("Ingrese el Nombre de Usuario: (No se admiten caracteres especiales) ") : Helper.generateRandomUsernames();
    }

    private static String getSurname(boolean isManualInput) {
        return (isManualInput) ? Helper.getStringOnlyLetters("Ingrese el Apellido: (No se admiten numeros ni caracteres especiales) ") : Helper.generateRandomSurnames();
    }

    private static String getName(boolean isManualInput) {
        return (isManualInput) ? Helper.getStringOnlyLetters("Ingrese el Nombre: (No se admiten numeros ni caracteres especiales) ") : Helper.generateRandomNames();
    }
    
    private static SimpleLinkedList<UsuarioDeServicio> filterList( SimpleLinkedList<UsuarioDeServicio> list) {
        SimpleLinkedList<UsuarioDeServicio> localAuxList = new SimpleLinkedList<>();
        String inputFilter = Helper.getValidsString("Ingrese nombre o apellido: ");

        System.out.println("La palabra para filtrar es : " + inputFilter);
        for (UsuarioDeServicio each : list) {
            if(each.getApellido().toLowerCase().contains(inputFilter.toLowerCase()) || each.getApellido().toLowerCase().contains(inputFilter.toUpperCase()) || each.getApellido().toLowerCase().equalsIgnoreCase(inputFilter)){
                localAuxList.addInOrder(each);
            }else if(each.getNombre().toLowerCase().contains(inputFilter.toLowerCase()) || each.getNombre().toLowerCase().contains(inputFilter.toUpperCase()) || each.getNombre().toLowerCase().equalsIgnoreCase(inputFilter)){
                localAuxList.addInOrder(each);
            }

        }

        return localAuxList;
    }

    public static void mostrarPremiGratu(SimpleLinkedList<UsuarioDeServicio> list, String opcion){
        for(UsuarioDeServicio a: list){
            if(opcion == a.getTipo_de_cuenta()){
                System.out.println(a.toString());
            }
        }
    }
    
}
