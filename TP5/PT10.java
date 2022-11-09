/*
 Realice manualmente la inserción de los siguientes valores en un árbol AVL de enteros inicialmente vacío: 5,
10, 20, 30, 40, 50, 60. Indique el tipo y cantidad de rotaciones hechas en caso de haberlas realizado.
Verifique con una aplicación.
 */
package TP5;

public class PT10 {
   /**
     * @param args
     */
    public static void main(String[] args) {
        AVLTree_pt8_10<Integer> tree = new AVLTree_pt8_10<Integer>();

        for (int i = 0; i < 7; i++) {
            tree.add(Helper.forceInteger("Ingrese el valor"));   
        }

        System.out.println("Se realizó " + tree.countSimpleRight + " rotacion simple a la derecha (RR).");
        System.out.println("Se realizó " + tree.countSimpleLeft + " rotacion simple a la izquieda (LL).");
        System.out.println("Se realizó " + tree.countDoubleRight + " rotacion doble a la derecha (RR RL).");
        System.out.println("Se realizó " + tree.countDoubleLeft + " rotacion doble a la izquierda (LR).");
        System.out.println(tree.toString());
    } 
}
