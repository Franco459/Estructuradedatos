package TP5;

public class Empleado {
    int legajo;
    int apellido;
    int nombre;
    int departamento;
    float sueldo;

    @Override
    public String toString() {
        String departamento_String = (departamento == 1) ? "administracion" : (departamento == 2) ? "contabilidad" : "gerencia";
        return "Empleado [legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", departamento="
                + departamento_String + ", sueldo=" + sueldo + "]";
    }

    public Empleado(int legajo, int apellido, int nombre, int departamento, float sueldo) {
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
    public int getApellido() {
        return apellido;
    }
    public void setApellido(int apellido) {
        this.apellido = apellido;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getDepartamento() {
        return departamento;
    }
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
