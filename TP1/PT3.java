/* Escribir un programa que permita ingresar números a una matriz M x N, mostrar la matriz en la consola y
obtener su matriz transpuesta. Además, calcular el producto de los elementos de una fila o la suma de una
columna, efectuando los cálculos sobre la matriz o su transpuesta, todo a petición del usuario. Los valores
M y N son indicados por el usuario. Agregar los controles necesarios.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.
*/
package TP1;


/**
 *
 * @author FrancoGP
 */
public class PT3 {
    public static void main(String[] args) {
        
        int row, column, selectedRow = 0, selectedColumn = 0, resultOfAction = 0;
        int[][] matrix, transMatrix;
        String msg = "Ingrese cantidad de filas", textBefore, textAfter;
        row = Helper.forcePositiveIntEnter(msg);
        msg = "Ingrese cantidad de columnas";
        column = Helper.forcePositiveIntEnter(msg);
        matrix = new int[row][column];
        msg = "---------------MENU--------------- \n"
        +    "1- Ingresar valores manuales \n"
        +    "2- Ingresar valores aleatorios ";
        int option = Helper.menuTwoOptions(msg);
        switch(option){
            case 1:
                System.out.println("Ha elegido la opcion MANUAL.");
                matrix = createTwoDimensionArray(matrix, row, column, true);
            break;
            case 2:
                System.out.println("Ha elegido la opcion AUTOMATICA.");
                matrix = createTwoDimensionArray(matrix, row, column, false);
            break;
        }
        
        transMatrix = createTransposedMatrix(matrix, row, column);
        textBefore = "****MOSTRANDO MATRIZ COMUN****\n";
        textAfter = "\n*******************************\n";
        Helper.printTwoDimensionArray(textBefore, matrix, textAfter);
        textBefore = "****MOSTRANDO MATRIZ TRANSPUESTA****\n";
        textAfter = "\n*******************************\n";
        Helper.printTwoDimensionArray(textBefore, transMatrix, textAfter);
        while (true){
        int optionOne = actionMenu();
        int optionTwo = matrixMenu();
        //System.out.println(selectedColumn + "::::::::::::::::::::::::" + selectedRow);
        switch(optionOne){
            case 1: 
                msg ="Seleccione el numero de la columna";
                switch(optionTwo){
                    case 1:
                    
                        selectedColumn = selectRowOrColumn(transMatrix.length, msg);
                        resultOfAction = multiplyInArray(matrix, selectedColumn, row, true);
                    break;
                    case 2:
                        selectedColumn = selectRowOrColumn(matrix.length, msg);
                        resultOfAction = multiplyInArray(transMatrix, selectedColumn, column, true);
                    break;
                }
            break;
            case 2:
                msg ="Seleccione el numero de la fila";
                switch(optionTwo){
                    case 1:
                        selectedRow = selectRowOrColumn(matrix.length, msg);  
                        resultOfAction = multiplyInArray(matrix, selectedRow, column, false);
                    break;
                    case 2:
                        selectedRow = selectRowOrColumn(transMatrix.length, msg);
                        resultOfAction = multiplyInArray(transMatrix, selectedRow, row, false);
                    break;
                }
            break;
        }
        System.out.println("El resultado es: " + resultOfAction);
        //mostrar}
    }
    }

    ////////////////////////METHODS//////////////////////////////
    private static int selectRowOrColumn(int length, String msg) {
        int size = 0;
        while(true){
            try{
                size = Helper.forcePositiveIntEnter(msg);
                //forzamos error
                if (size > length) Integer.parseInt("s");
                return size;    
            }
            catch(Exception e){
                System.out.println("Debe ingresar un numero entre 1 y " + length);
            }
        }
    }

    private static int multiplyInArray(int[][] selectedMatrix, int selectedRowOrCol, int colOrRow, boolean isAdition) {
        int prod = 1;
        int sum = 0;
        for (int i = 0; i < colOrRow; i++){
            if (!isAdition) prod *= selectedMatrix[selectedRowOrCol-1][i];
            else sum += selectedMatrix[i][selectedRowOrCol-1];
        }
        return (sum == 0)? prod : sum;
    }

    private static int[][] createTransposedMatrix(int[][] matrix, int row, int column) {
        int[][] aux = new int[column][row];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                aux[j][i] = matrix[i][j];
            }
        }
        return aux;
    }

    private static int[][] createTwoDimensionArray(int[][] matrix, int row, int column, boolean manual) {
        String msgCreate = "Ingrese valor ENTERO para adicionar en la matriz";
        for (int[] is : matrix) {
            for(int k = 0; k < is.length; k++ ){
                //para que no sean muy grandes el limite
                if (!manual) is[k] = Helper.randomIntGenerator(3, 9);
                else is[k] = Helper.forceInteger(msgCreate);
            }
        }
        return matrix;
    }

    private static int actionMenu(){
            String msg = "******MENU DE ACCIONES****** \n"+
            "1- Realizar suma de una columna \n" +
            "2- Realizar multiplicación de una fila";
            return Helper.menuTwoOptions(msg);
    }

    private static int matrixMenu(){
        String msg = "******MENU DE MATRIZ****** \n"+
        "1- Realizar la accion sobre la matriz normal\n" +
        "2- Realizar la accion sobre la matriz transpuesta";
        return Helper.menuTwoOptions(msg);
    }
}
