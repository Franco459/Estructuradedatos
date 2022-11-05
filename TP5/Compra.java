package TP5;

import java.time.LocalDate;

public class Compra implements Comparable{

    int nro_factura;
    int cuit_comercio;
    Double importe;
    LocalDate date;

    public Compra(int nro_factura, int cuit_comercio, Double importe, LocalDate date) {
        this.nro_factura = nro_factura;
        this.cuit_comercio = cuit_comercio;
        this.importe = importe;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Compra [nro_factura=" + nro_factura + ", cuit_comercio=" + cuit_comercio + ", importe=" + String.format(java.util.Locale.US,"%.2f", importe)
                + ", date=" + date + "]";
    }

    public int getNro_factura() {
        return nro_factura;
    }
    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }
    public int getCuit_comercio() {
        return cuit_comercio;
    }
    public void setCuit_comercio(int cuit_comercio) {
        this.cuit_comercio = cuit_comercio;
    }
    public Double getImporte() {
        return importe;
    }
    public void setImporte(Double importe) {
        this.importe = importe;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public int compareTo(Object obj) {
        Compra user = (Compra) obj;
        return Double.compare(this.getImporte(), user.getImporte());
    }
}
