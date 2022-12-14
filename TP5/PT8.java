/*
Realice manualmente la inserción de los siguientes valores en un árbol AVL de enteros inicialmente vacío: 1,
11, 2, 3, 4, 5, 6, 7, 15, 14, 13, 12, 10, 9, 8. Indique el tipo y cantidad de rotaciones hechas en caso de
haberlas realizado. Verifique con una aplicación.
 */
package TP5;

public class PT8 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        AVLTree_pt8_10<Integer> tree = new AVLTree_pt8_10<Integer>();

        for (int i = 1; i <= 15; i++) {
            tree.add(Helper.forceInteger("Ingrese el valor"));   
        }

        System.out.println("Se realizó " + tree.countSimpleRight + " rotacion simple a la derecha (RR).");
        System.out.println("Se realizó " + tree.countSimpleLeft + " rotacion simple a la izquieda (LL).");
        System.out.println("Se realizó " + tree.countDoubleRight + " rotacion doble a la derecha (RR RL).");
        System.out.println("Se realizó " + tree.countDoubleLeft + " rotacion doble a la izquierda (LR).");
        System.out.println(tree.toString());
    }
}
