package TP3;

import java.util.ArrayList;

public class Desarrolladores {
    String surname_Desarrolladores;
    String name_Desarrolladores;
    String CUIT_Desarrolladores;
    ArrayList<Especialidades> especialidades_Desarrolladores;
    
    @Override
    public String toString() {
        return "Desarrollador: [Apellido: " + surname_Desarrolladores + ", nombre: "
                + name_Desarrolladores + ", CUIT: " + CUIT_Desarrolladores
                + ", Especialidades:" + especialidades_Desarrolladores + "]\n";
    }
    
    public String getSurname_Desarrolladores() {
        return surname_Desarrolladores;
    }
    public void setSurname_Desarrolladores(String surname_Desarrolladores) {
        this.surname_Desarrolladores = surname_Desarrolladores;
    }
    public String getName_Desarrolladores() {
        return name_Desarrolladores;
    }
    public void setName_Desarrolladores(String name_Desarrolladores) {
        this.name_Desarrolladores = name_Desarrolladores;
    }
    public String getCUIT_Desarrolladores() {
        return CUIT_Desarrolladores;
    }
    public void setCUIT_Desarrolladores(String cUIT_Desarrolladores) {
        CUIT_Desarrolladores = cUIT_Desarrolladores;
    }
    public ArrayList<Especialidades> getEspecialidades_Desarrolladores() {
        return especialidades_Desarrolladores;
    }
    public void setEspecialidades_Desarrolladores(ArrayList<Especialidades> especialidades_Desarrolladores) {
        this.especialidades_Desarrolladores = especialidades_Desarrolladores;
    }
    
    public Desarrolladores() {
    }
    
    public Desarrolladores(String surname_Desarrolladores, String name_Desarrolladores, String cUIT_Desarrolladores,
            ArrayList<Especialidades> especialidades_Desarrolladores) {
        this.surname_Desarrolladores = surname_Desarrolladores;
        this.name_Desarrolladores = name_Desarrolladores;
        CUIT_Desarrolladores = cUIT_Desarrolladores;
        this.especialidades_Desarrolladores = especialidades_Desarrolladores;
    }
}
