package TP5;
public class AVLTree<ELEMENT extends Comparable<ELEMENT>> {
 
    protected class AVLNode<ELEMENT> {
        public ELEMENT item;
        public AVLNode<ELEMENT> left;
        public AVLNode<ELEMENT> right;
        public int balance;
 
        public AVLNode() {
            this(null, null, null, 0);
        }
        public AVLNode(ELEMENT item) {
            this(item, null, null, 0);
        }
        public AVLNode(ELEMENT item, AVLNode<ELEMENT> left, AVLNode<ELEMENT> right, int balance) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.balance = balance;
        }
 
        @Override
        public String toString() {
            return this.item.toString();
        }
 
        // Método para propósitos académicos
        public void Visit() {
            System.out.printf("%s ", this.item.toString());
        }
    }
 
 
 
    protected AVLNode<ELEMENT> root;
    // atributo para propositos académicos
    protected boolean verbose;
 
    public AVLTree() {
        this.root = null;
        this.verbose = false;
    }
 
    // método para propósitos académicos
    public boolean setVerbose(boolean verbose) {
        this.verbose = verbose;
        return this.verbose;
    }
 
 
    @Override
    public String toString() {
        return toString(this.root);
    }
    protected String toString(AVLNode<ELEMENT> root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.item.toString());
            //sb.append("[" + root.balance.toString() + "]");
            sb.append((root.balance < 0) ? "[-]" : (root.balance == 0) ? "[.]" : "[+]" );
            if (root.left != null) {
                sb.append("(" + toString(root.left));
                if (root.right != null) {
                    sb.append(", " + toString(root.right));
                }
                sb.append(")");
            } else {
                if (root.right != null) {
                    sb.append("(, " + toString(root.right) + ")");
                }
            }
        }
        return sb.toString();
    }
 
 
    //region Métodos para recorrer el árbol
    public void PreOrder() {
        PreOrder(this.root);
    }
    protected void PreOrder(AVLNode<ELEMENT> root) {
        if (root != null) {
            root.Visit();
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
 
    public void InOrder() {
        InOrder(this.root);
    }
    protected void InOrder(AVLNode<ELEMENT> root) {
        if (root != null) {
            InOrder(root.left);
            root.Visit();
            InOrder(root.right);
        }
    }
 
    public void PostOrder() {
        PostOrder(this.root);
    }
    protected void PostOrder(AVLNode<ELEMENT> root) {
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            root.Visit();
        }
    }
 
    public void DescendingOrder() {
        DescendingOrder(this.root);
    }
    protected void DescendingOrder(AVLNode<ELEMENT> root) {
        if (root != null) {
            DescendingOrder(root.right);
            root.Visit();
            DescendingOrder(root.left);
        }
    }
    //endregion
 
    //region Métodos para contar elementos del árbol
    public int NodeCount() {
        return NodeCount(this.root);
    }
    protected int NodeCount(AVLNode<ELEMENT> root) {
        if (root != null) {
            return 1 + NodeCount(root.left) + NodeCount(root.right);
        }
        return 0;
    }
 
 
    public int LeafCount() {
        return LeafCount(this.root);
    }
    protected int LeafCount(AVLNode<ELEMENT> root) {
        if (root != null) {
            if ( (root.left == null) && (root.right == null) ) {
                return 1;
            } else {
                return LeafCount(root.left) + LeafCount(root.right);
            }
        }
        return 0;
    }
 
 
    public int InternalCount() {
        return InternalCount(this.root);
    }
    protected int InternalCount(AVLNode<ELEMENT> root) {
        if (root != null) {
            if ( (root.left == null) && (root.right == null) ) {
                return 0;
            } else {
                return 1 + InternalCount(root.left) + InternalCount(root.right);
            }
        }
        return 0;
    }
 
 
    public int MaxLevel() {
        return MaxLevel(this.root);
    }
    protected int MaxLevel(AVLNode<ELEMENT> root) {
        if (root != null) {
            if ( (root.left != null) || (root.right != null) ) {
                int leftLevel = MaxLevel(root.left);
                int rightLevel = MaxLevel(root.right);
                return 1 + Math.max(leftLevel, rightLevel);
            }
            return 0;
        }
        return -1;
    }
 
    public int Height() {
        return MaxLevel() + 1;
    }
    //endregion
 
    //region Métodos para buscar
    public boolean contains(ELEMENT item) {
        return contains(this.root, item);
    }
    private boolean contains(AVLNode<ELEMENT> root, ELEMENT item) {
        if (root == null) {
            return false;
        }
        if (item.compareTo(root.item) < 0) {
            return contains(root.left, item);
        }
        if (item.compareTo(root.item) > 0) {
            return contains(root.right, item);
        }
        return true;
    }
    //endregion
 
    //region Métodos para agregar elementos al árbol
 
    public void add(ELEMENT item) {
        if (this.verbose) {
            System.out.printf("Agrega %s", item.toString());
        }
 
        boolean[] change = { false };
        this.root = addAVL(this.root, item, change);
 
        if (this.verbose) {
            System.out.printf("\t %s\n", this.toString());
        }
    }
 
    private AVLNode<ELEMENT> addAVL(AVLNode<ELEMENT> root, ELEMENT item, boolean[] change) {
        AVLNode<ELEMENT> n1;
 
        if (root == null) {
            root = new AVLNode<ELEMENT>(item);
            change[0] = true; // cambia el balance
            return root;
        }
 
        if (item.compareTo(root.item) < 0) { // el nuevo elemento es menor
            root.left = addAVL(root.left, item, change); // agrega por la izquierda
            if (change[0]) { // cambió el balance?
                switch (root.balance) { // balance = hD - hI
                    case 1: // antes izquierda < derecha
                        root.balance = 0; // después izquierda == derecha
                        change[0] = false; // balance ajustado
                        break;
                    case 0: // antes izquierda == derecha
                        root.balance = -1; // después izquierda > derecha
                        break;
                    case -1: // antes izquierda > derecha
                        n1 = root.left;
                        if (n1.balance == -1) { // izquierda izquierda es mayor
                            root = leftleftRotation(root, n1); // LR rotación doble
                        } else {
                            root = leftrightRotation(root, n1); // LL rotación simple
                        }
                        change[0] = false; // balance ajustado
                        break;
                }
            }
            return root;
        }
 
        if (item.compareTo(root.item) > 0) { // el nuevo elemento es mayor
            root.right = addAVL(root.right, item, change); // agregar por la derecha
            if (change[0]) { // cambió el balance?
                switch (root.balance) { // balance = hD - hI
                    case -1: // antes izquierda > derecha
                        root.balance = 0; // ahora izquierda == derecha
                        change[0] = false; // balance ajustado
                        break;
                    case 0: // antes izquierda == derecha
                        root.balance = 1; // ahora izquierda < derecha
                        break;
                    case 1: // antes izquierda < derecha
                        n1 = root.right;
                        if (n1.balance == 1) { // derecha derecha es mayor
                            root = rightrightRotation(root, n1); // RR rotación simple
                        } else {
                            root = rightleftRotation(root, n1); // RL rotación doble
                        }
                        change[0] = false; // balance ajustado
                        break;
                }
            }
            return root;
        }
        throw new RuntimeException("Claves repetidas");
    }
    //endregion
 
    //region Rotaciones LL LR RR RL
    private AVLNode<ELEMENT> leftleftRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" LL ");
        }
 
        n.left = n1.right;
        n1.right = n;
        if (n1.balance == -1) {
            n.balance = 0;
            n1.balance = 0;
        } else {
            n.balance = -1;
            n1.balance = 1;
        }
        return n1;
    }
 
    private AVLNode<ELEMENT> leftrightRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" LR ");
        }
 
        AVLNode<ELEMENT> n2;
        n2 = n1.right;
        n.left = n2.right;
        n2.right = n;
        n1.right = n2.left;
        n2.left = n1;
        n1.balance = (n2.balance == 1) ? -1 : 0;
        n.balance = (n2.balance == -1) ? 1 : 0;
        n2.balance = 0;
        return n2;
    }
 
    private AVLNode<ELEMENT> rightrightRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" RR ");
        }
 
        n.right = n1.left;
        n1.left = n;
        if (n1.balance == 1) {
            n.balance = 0;
            n1.balance = 0;
        } else {
            n.balance = 1;
            n1.balance = -1;
        }
        return n1;
    }
 
 
    private AVLNode<ELEMENT> rightleftRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" RL ");
        }
 
        AVLNode<ELEMENT> n2;
        n2 = n1.left;
        n.right = n2.left;
        n2.left = n;
        n1.left = n2.right;
        n2.right = n1;
        n.balance = (n2.balance == 1) ? -1: 0;
        n1.balance = (n2.balance == -1) ? 1 : 0;
        n2.balance = 0;
        return n2;
    }
    //endregion
 
    //region Métodos para remover elementos
 
    public void remove(ELEMENT item) {
        if (this.verbose) {
            System.out.printf("Extrae %s", item.toString());
        }
 
        boolean[] change = { false };
        this.root = removeAVL(this.root, item, change);
 
        if (this.verbose) {
            System.out.printf("\t %s\n", this.toString());
        }
    }
    private AVLNode<ELEMENT> removeAVL(AVLNode<ELEMENT> root, ELEMENT item, boolean[] change) {
 
        if (root == null) {
            throw new RuntimeException("No existe");
        }
 
        if (item.compareTo(root.item) < 0) { // el elemento es menor
            root.left = removeAVL(root.left, item, change); // borrar por la izquierda
            if (change[0]) { // cambió el balance?
                root = leftBalance(root, change); // ajustar el balance izquierdo
            }
            return root;
        }
 
        if (item.compareTo(root.item) > 0) { // el elemento es mayor
            root.right = removeAVL(root.right, item, change); // borrar por la derecha
            if (change[0]) { // cambió el balance?
                root = rightBalance(root, change); // ajustar el balance derecho
            }
            return root;
        }
 
 
        AVLNode<ELEMENT> q;
        q = root;
        if (q.left == null) { // no hay izquierda
            root = q.right; // un descendiente por la derecha u hoja
            change[0] = true; // cambia el balance
        } else {
            if (q.right == null) { // no hay derecha
                root = q.left; // un descendiente por la izquierda
                change[0] = true; // cambia el balance
            } else { // dos descendientes !!!
                root.left = eldestOfMinors(root, root.left, change); // mayor de los menores
                if (change[0]) { // cambió el balance?
                    root = leftBalance(root, change); // ajustar el balance izquierdo
                }
                q = null; // eliminar el nodo
            }
        }
        return root;
    }
 
    private AVLNode<ELEMENT> eldestOfMinors(AVLNode<ELEMENT> n, AVLNode<ELEMENT> eldest, boolean[] change) {
        if (eldest.right != null) { // hay algo a la derecha
            eldest.right = eldestOfMinors(n, eldest.right, change); // busca el mayor de los menores
            if (change[0]) { // cambió el balance?
                eldest = rightBalance(eldest, change); // ajustar el balance derecho
            }
        } else {
            n.item = eldest.item;
            n = eldest;
            eldest = eldest.left;
            n = null;
            change[0] = true;
        }
        return eldest;
    }
 
    private AVLNode<ELEMENT> leftBalance(AVLNode<ELEMENT> n, boolean[] change) {
        AVLNode<ELEMENT> n1;
        switch (n.balance) { // balance = hD - hI
            case -1 : // antes izquierda > derecha
                n.balance = 0; // ahora izquierda == derecha
                break;
            case 0 : // antes izquierda == derecha
                n.balance = 1; // ahora izquierda < derecha
                change[0] = false; // balance ajustado
                break;
            case 1 : // antes izquierda < derecha
                n1 = n.right;
                if (n1.balance >= 0) {
                    if (n1.balance == 0) {
                        change[0] = false; // balance ajustado
                    }
                    n = rightrightRotation(n, n1);
                } else {
                    n = rightleftRotation(n, n1);
                }
                break;
        }
        return n;
    }
 
    private AVLNode<ELEMENT> rightBalance(AVLNode<ELEMENT> n, boolean[] change) {
        AVLNode<ELEMENT> n1;
        switch (n.balance) { // balance = hD - hI
            case -1 : // antes izquiera > derecha
                n1 = n.left;
                if (n1.balance <= 0) {
                    if (n1.balance == 0) {
                        change[0] = false; // balance ajustado
                    }
                    n = leftleftRotation(n, n1);
                } else {
                    n = leftrightRotation(n, n1);
                }
                break;
            case 0 : // antes izquierda == derecha
                n.balance = -1; // ahora izquierda > derecha
                change[0] = false; // balance ajustado
                break;
            case 1 : // antes izquierda < derecha
                n.balance = 0;
                break;
        }
        return n;
    }
    //endregion
 
}