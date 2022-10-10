package TP3;

public class Especialidades {
    String name_Especialidad;
    int value_Especialidad;

    public Especialidades() { }

    @Override
    public String toString() {
        return "[Especialidad: " + name_Especialidad + ", experiencia: " + value_Especialidad
                + "]";
    }

    public Especialidades(String name_Especialidad, int value_Especialidad) {
        this.name_Especialidad = name_Especialidad;
        this.value_Especialidad = value_Especialidad;
    }
    
    public String getName_Especialidad() {
        return name_Especialidad;
    }
    public void setName_Especialidad(String name_Especialidad) {
        this.name_Especialidad = name_Especialidad;
    }
    public int getValue_Especialidad() {
        return value_Especialidad;
    }
    public void setValue_Especialidad(int value_Especialidad) {
        this.value_Especialidad = value_Especialidad;
    }

}
