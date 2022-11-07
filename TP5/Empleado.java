package TP5;

public class Empleado implements Comparable{
    public int legajo;
    public String apellido;
    public String nombre;
    public int departamento;
    public int sueldo;

    public Empleado(){}

    public Empleado(int legajo, String apellido, String nombre, int departamento, int sueldo) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }
    
    public int getLegajo() {
        return legajo;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDepartamento() {
        return departamento;
    }
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    public int getSueldo() {
        return sueldo;
    }
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public int compareTo(Object obj) {
        Empleado user = (Empleado) obj;
        return Integer.compare(this.getLegajo(), user.getLegajo());
    }

    @Override
    public String toString() {
        String departamento_String = (departamento == 1) ? "administracion" : (departamento == 2) ? "contabilidad" : "gerencia";
        return "Empleado [legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", departamento="
                + departamento_String + ", sueldo=" + sueldo + "]";
    }
}
