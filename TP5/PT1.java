package TP5;

public class PT1 {
    public static void main(String[] args) {
        exec();
    }

    public static void exec() {
        System.out.println("Ejercicio Propuesto 1 - Arbol Binario");
 
        BinaryTree<Character> rightSubTree1 = new BinaryTree<Character>('J', null, new BinaryTree<Character>('K'));
        BinaryTree<Character> rightSubTree2 = new BinaryTree<Character>('F', rightSubTree1, null);
        BinaryTree<Character> rightSubTree3 = new BinaryTree<Character>('C', null, rightSubTree2);

        BinaryTree<Character> leftSubTree1 = new BinaryTree<Character>('D', new BinaryTree<Character>('G'), null);
        BinaryTree<Character> leftSubTree2 = new BinaryTree<Character>('F', new BinaryTree<Character>('H'), new BinaryTree<Character>('I'));
        BinaryTree<Character> leftSubTree3 = new BinaryTree<Character>('B', leftSubTree1, leftSubTree2);

        BinaryTree<Character> finalTree = new BinaryTree<>('A', leftSubTree3, rightSubTree3);

 
        System.out.print("Pre Orden.. ");
        finalTree.PreOrder();
        System.out.println();
        System.out.print("En Orden... ");
        finalTree.InOrder();
        System.out.println();
        System.out.print("Post Orden. ");
        finalTree.PostOrder();
        System.out.println();
 
        System.out.printf("Cantidad de Nodos %s\n", finalTree.NodeCount());
        System.out.printf("Cantidad de Hojas %s\n", finalTree.LeafCount());
        System.out.printf("Nodos Internos    %s\n", finalTree.InternalCount());
        System.out.printf("Máximo Nivel      %s\n", finalTree.MaxLevel());
        System.out.printf("Altura            %s\n", finalTree.Height());
        
        System.out.println();
        System.out.print("Descendente ");
        finalTree.DescendingOrder();
        System.out.println();

        
        System.out.printf("Arbol...... %s", finalTree.toString());
        System.out.println();


 
    }
}
