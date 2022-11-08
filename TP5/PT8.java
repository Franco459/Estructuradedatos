package TP5;

public class PT8 {
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
    }
}
