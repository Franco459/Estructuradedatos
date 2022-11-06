package TP5;

import java.time.LocalDate;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        LocalDate date2 = LocalDate.of(2018, 10, 30);
        Compra compra = new Compra(5, 23233223, 2.5, LocalDate.of(2018, 10, 30));
        Compra compra1 = new Compra(10, 234444323, 4.5, LocalDate.of(2010, 10, 30));
        Compra compra2 = new Compra(50, 111111111, 1.5, LocalDate.of(2010, 10, 30));
        Compra compra3 = new Compra(30, 222222299, 0.5, LocalDate.of(2010, 10, 30));
        Compra compra4 = new Compra(20, 233333333, 3.5, LocalDate.of(2018, 10, 30));
        Compra compra5 = new Compra(60, 5555555, 9.5, LocalDate.of(2010, 10, 30));
        Compra compra6 = new Compra(40, 66666699, 15.5, LocalDate.of(2010, 10, 30));
        

        //region variables
        AVLTree_pt4<Compra> buysTree = new AVLTree_pt4<Compra>();
        int inputNumber;
        String msg;
        boolean isManualInput;
        int buy_NumberTicket;
        //end region variables

        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);
        
        isManualInput = (option == 1) ? true : false;

        inputNumber = getNumber(isManualInput, "Ingrese la cantidad de compras a cargar");

        do{
            buy_NumberTicket = getNumberTicket(isManualInput, buysTree); 
        }while(inputNumber > 0);


        System.out.println(buysTree.toString());
        System.out.println("/************************/");
        buysTree.InOrder();
    }


    /////////////////////////////////////////////METHODS/////////////////////////////////////////////


    private static int getNumberTicket(boolean isManualInput, AVLTree_pt4<Compra> buysTree) {
        int inputNumber;
        while(true){
            inputNumber = getNumber(isManualInput, "Ingrese el nro de Factura");
            if (buysTree.NodeCount() == 0) return inputNumber;
            else{
                
            }
            return 0;
        }
    }


    private static int getNumber(boolean isManualInput,String msg) {
        return (isManualInput) ? Helper.forceInteger(msg) : Helper.generateRandomIntegerInRange(1, 99);
    }
}
