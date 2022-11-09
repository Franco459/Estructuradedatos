package TP5;

public class PT2 {
    public static void main(String[] args) {
        exec();
    }

    public static void exec() {
        System.out.println("Ejercicio 2 - Arbol Binario");
 
        BinaryTree<Character> rightSubTree1 = new BinaryTree<Character>('W', null, new BinaryTree<Character>('Z'));
        BinaryTree<Character> rightSubTree2 = new BinaryTree<Character>('P', new BinaryTree<Character>('Q'), new BinaryTree<Character>('R'));
        BinaryTree<Character> rightSubTree3 = new BinaryTree<Character>('L', rightSubTree2, rightSubTree1);

        BinaryTree<Character> leftSubTree1 = new BinaryTree<Character>('F', new BinaryTree<Character>('G'), new BinaryTree<Character>('H'));
        BinaryTree<Character> leftSubTree2 = new BinaryTree<Character>('D', leftSubTree1 ,new BinaryTree<Character>('K'));

        BinaryTree<Character> finalTree = new BinaryTree<>('A', leftSubTree2, rightSubTree3);

 
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
