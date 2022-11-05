package TP5;

public class PT5 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Empleado empleado = new Empleado(123, "Copa", "C", 2, 3);
        Empleado empleado2 = new Empleado(124, "Cop", "Cap", 3, 305);
        Empleado empleado3 = new Empleado(125, "Co", "Ca", 1, 30);
        Empleado empleado4 = new Empleado(110, "C", "C", 2, 3000);
         
        
        AVLTree<Empleado> employeerTree = new AVLTree<Empleado>();
        employeerTree.add(empleado);
        employeerTree.add(empleado2);
        employeerTree.add(empleado3);
        employeerTree.add(empleado4);
        System.out.println(employeerTree.toString());
        System.out.println("/************************/");
        employeerTree.InOrder();
    }
}
