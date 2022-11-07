package TP5;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // region variables
        AVLTree_pt4<Compra> buysTree = new AVLTree_pt4<Compra>();
        ArrayList<Integer> ticketNumbers = new ArrayList<Integer>();
        int inputNumber;
        String msg;
        boolean isManualInput;
        int buy_NumberTicket, cuit_number;
        Double inputPrice;
        LocalDate inputDate;
        // end region variables

        msg = "---------------MENU--------------- \n"
                + "1- Ingresar valores manuales \n"
                + "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);

        isManualInput = (option == 1) ? true : false;

        inputNumber = getAmount(isManualInput, "Ingrese la cantidad de compras a cargar");
        do {
            buy_NumberTicket = getNumberTicket(isManualInput, buysTree, ticketNumbers);
            cuit_number = getNumber(isManualInput, "Ingrese el numero CUIT");
            inputPrice = getDouble(isManualInput, "Ingrese el importe");
            inputDate = getDate(isManualInput);
            Compra buy = new Compra(buy_NumberTicket, cuit_number, inputPrice, inputDate);
            buysTree.add(buy);
            inputNumber--;
        } while (inputNumber > 1);
        buysTree.InOrder();
    }

    ///////////////////////////////////////////// METHODS/////////////////////////////////////////////


    /*Para no superar el maximo generado en random */
    private static int getAmount(boolean isManualInput, String msg) {
        return (isManualInput) ? Helper.forceInteger(msg) : Helper.generateRandomIntegerInRange(3, 12);
    }

    private static LocalDate getDate(boolean isManualInput) {
        int day, month, year;
        while (true) {
            try {
                 day = (isManualInput) ? getNumber(isManualInput, "Ingrese dia:")
                        : Helper.generateRandomIntegerInRange(2, 27);
                if(day < 1 || day > 31) throw new RuntimeException("Dia no valido solo se acepta de 1 al 31");

                 month = (isManualInput) ? getNumber(isManualInput, "Ingrese mes:")
                        : Helper.generateRandomIntegerInRange(2, 12);
                if(month < 1 || month > 12) throw new RuntimeException("Mes no valido, solo se acepta del 1 al 12");

                 year = (isManualInput) ? getNumber(isManualInput, "Ingrese año:")
                        : Helper.generateRandomIntegerInRange(2018, 2022);

                if(year < 2010 || year > 2022) throw new RuntimeException("Año no valido, solo se permite desde 2010 hasta 2022");
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return LocalDate.of(year, month, day);
    }

    private static Double getDouble(boolean isManualInput, String msg) {
        return (isManualInput) ? Helper.getFloat(msg) : Helper.randomDoubleGenerator(1, 99);
    }

    private static int getNumberTicket(boolean isManualInput, AVLTree_pt4<Compra> buysTree, ArrayList<Integer> ticketNumbers) {
        int inputNumber;
        while (true) {
            try {
                inputNumber = getNumber(isManualInput, "Ingrese el nro de Factura");
                if (buysTree.NodeCount() == 0) {
                    ticketNumbers.add(inputNumber);
                    return inputNumber;
                } else {
                    if (!ticketNumbers.contains(inputNumber)) {
                        ticketNumbers.add(inputNumber);
                        return inputNumber;
                    } else if (isManualInput){
                        throw new RuntimeException("Numero de factura ya existente");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static int getNumber(boolean isManualInput, String msg) {
        return (isManualInput) ? Helper.forceInteger(msg) : Helper.generateRandomIntegerInRange(1, 19);
    }
}
