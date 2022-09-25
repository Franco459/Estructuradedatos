package TP2;
/*
 *  la cual tendrá los atributos: nombre del pueblo, nombre del negocio 
 * cliente, cantidad de fardos de gaseosas, 
 * monto de la deuda y estado de la deuda 
 * (pendiente o pagado según corresponda).

 */
public class PuntosDeEntrega {
    String name_city;
    String name_store;
    int amount_bales;
    float debt_price;
    boolean debt_status;//1-true saldada *** 0-false pendiente

    
    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public String getName_store() {
        return name_store;
    }

    public void setName_store(String name_store) {
        this.name_store = name_store;
    }

    public int getAmount_bales() {
        return amount_bales;
    }

    public void setAmount_bales(int amount_bales) {
        this.amount_bales = amount_bales;
    }

    public float getDebt_price() {
        return debt_price;
    }

    public void setDebt_price(float debt_price) {
        this.debt_price = debt_price;
    }

    public boolean getDebt_status() {
        return debt_status;
    }

    public void setDebt_status(boolean debt_status) {
        this.debt_status = debt_status;
    }

    public PuntosDeEntrega(){

    }

    public PuntosDeEntrega(String name_city, String name_store, int amount_bales, float debt_price,
            boolean debt_status) {
        this.name_city = name_city;
        this.name_store = name_store;
        this.amount_bales = amount_bales;
        this.debt_price = debt_price;
        this.debt_status = debt_status;
    }

    @Override
    public String toString() {
        String status_debt = (getDebt_status() == true)? "Pagada"  : "Pendiente";
        return ("[Nombre de la ciudad: " + name_city + "\nNombre de la tienda: " +name_store + ", cantidad de fardos: " + amount_bales + ", precio de la deuda: " + String.format("%.2f", debt_price) + ", estado de la deuda: " + status_debt + "]\n");
    }
}
