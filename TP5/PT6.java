/*Dado un árbol equilibrado (AVL) de enteros, inicialmente vacío, realice (manualmente) la inserción de los
siguientes valores: 6, 51, 11, 31, 7, 8, 3, 21, 10, 5, 4. Indique cuándo se debe hacer rotaciones y qué tipo.
Verifique con una aplicación. */
package TP5;

public class PT6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        AVLTree_pt8_10<Integer> tree = new AVLTree_pt8_10<Integer>();

        for (int i = 0; i < 14; i++) {
            tree.add(Helper.forceInteger("Ingrese el valor"));   
        }

        System.out.println("Se realizó " + tree.countSimpleRight + " rotacion simple a la derecha (RR).");
        System.out.println("Se realizó " + tree.countSimpleLeft + " rotacion simple a la izquieda (LL).");
        System.out.println("Se realizó " + tree.countDoubleRight + " rotacion doble a la derecha (RR RL).");
        System.out.println("Se realizó " + tree.countDoubleLeft + " rotacion doble a la izquierda (LR).");
        System.out.println(tree.toString());
    }
}
