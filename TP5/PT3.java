package TP5;

public class PT3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i < 3; i++) {
            BinaryTree<Integer> finalTree;
            finalTree = exec(i);
            System.out.print("Pre Orden.. ");
            finalTree.PreOrder();
            System.out.println();
            System.out.print("En Orden... ");
            finalTree.InOrder();
            System.out.println();
            System.out.print("Post Orden. ");
            finalTree.PostOrder();
            System.out.println();
            System.out.print("Descendente ");
            finalTree.DescendingOrder();
            System.out.println();
            System.out.printf("Arbol...... %s", finalTree.toString());
            System.out.println();
        }
    }

    public static BinaryTree<Integer> exec(int fig) {
        if (fig == 1){
            
            BinaryTree<Integer> leftSubTree1 = new BinaryTree<Integer>(2, new BinaryTree<Integer>(1), null);
            BinaryTree<Integer> leftSubTree2 = new BinaryTree<Integer>(3, leftSubTree1, new BinaryTree<Integer>(4));
            
            BinaryTree<Integer> rightSubTree1 = new BinaryTree<Integer>(7, new BinaryTree<Integer>(6), null);
            BinaryTree<Integer> rightSubTree2 = new BinaryTree<Integer>(10, new BinaryTree<Integer>(9), new BinaryTree<Integer>(11));
            BinaryTree<Integer> rightSubTree3 = new BinaryTree<Integer>(8, rightSubTree1, rightSubTree2);

            return new BinaryTree<Integer>(5, leftSubTree2, rightSubTree3);
        }
        else{
            BinaryTree<Integer> leftSubTree1 = new BinaryTree<Integer>(10, new BinaryTree<Integer>(5), null);
            BinaryTree<Integer> leftSubTree2 = new BinaryTree<Integer>(20, leftSubTree1, new BinaryTree<Integer>(25));
            BinaryTree<Integer> leftSubTree3 = new BinaryTree<Integer>(35, new BinaryTree<Integer>(32) , null);
            BinaryTree<Integer> leftSubTree4 = new BinaryTree<Integer>(30, leftSubTree2, leftSubTree3);

            BinaryTree<Integer> rightSubTree1 = new BinaryTree<Integer>(45, new BinaryTree<Integer>(42), null);
            BinaryTree<Integer> rightSubTree2 = new BinaryTree<Integer>(50, rightSubTree1, new BinaryTree<Integer>(55));
            
            return new BinaryTree<Integer>(40, leftSubTree4, rightSubTree2);
        }
    }
}
