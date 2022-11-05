package TP5;

import java.time.LocalDate;

public class PT4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        LocalDate date2 = LocalDate.of(2018, 10, 30);
        Compra compra = new Compra(5, 23233223, 2.5, LocalDate.of(2018, 10, 30));
        Compra compra1 = new Compra(10, 234444323, 4.5, LocalDate.of(2010, 10, 30));
        Compra compra2 = new Compra(50, 111111111, 1.5, LocalDate.of(2010, 10, 30));
        Compra compra3 = new Compra(30, 222222299, 0.5, LocalDate.of(2010, 10, 30));
        Compra compra4 = new Compra(20, 233333333, 3.5, LocalDate.of(2018, 10, 30));
        Compra compra5 = new Compra(60, 5555555, 9.5, LocalDate.of(2010, 10, 30));
        Compra compra6 = new Compra(40, 66666699, 15.5, LocalDate.of(2010, 10, 30));
        
        AVLTree_pt4<Compra> buyTree = new AVLTree_pt4<Compra>();
        buyTree.add(compra);
        buyTree.add(compra1);
        buyTree.add(compra2);
        buyTree.add(compra3);
        buyTree.add(compra4);
        buyTree.add(compra5);
        buyTree.add(compra6);
        System.out.println(buyTree.toString());
        System.out.println("/************************/");
        buyTree.InOrder();
    }
}
