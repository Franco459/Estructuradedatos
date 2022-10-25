package TP4;

public class Factorizacion {
    private Integer factor;
    private Integer exponente;

    
    public Factorizacion(Integer factor, Integer exponente) {
        this.factor = factor;
        this.exponente = exponente;
    }
    public Integer getFactor() {
        return factor;
    }
    public void setFactor(Integer factor) {
        this.factor = factor;
    }
    public Integer getExponente() {
        return exponente;
    }
    public void setExponente(Integer exponente) {
        this.exponente = exponente;
    }
    @Override
    public String toString() {
        return "[Factor=" + factor + ", exponente=" + exponente + "]\n";
    }

    
}